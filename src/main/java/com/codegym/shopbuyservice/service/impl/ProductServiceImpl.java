package com.codegym.shopbuyservice.service.impl;

import com.codegym.shopbuyservice.converter.IProductConvect;
import com.codegym.shopbuyservice.dto.*;

import com.codegym.shopbuyservice.dto.payload.request.NewProductRequest;
import com.codegym.shopbuyservice.dto.payload.response.PagingProductResponse;
import com.codegym.shopbuyservice.dto.payload.response.ProductResponseDto;
import com.codegym.shopbuyservice.entity.*;
import com.codegym.shopbuyservice.repository.*;
import com.codegym.shopbuyservice.service.INameNormalizationService;
import com.codegym.shopbuyservice.service.IProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;
    @Autowired
    private INameNormalizationService iNameNormalizationService;
    @Autowired
    private IProductConvect iProductConvect;
    @Autowired
    private IProductPagingRepository iProductPagingRepository;

    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private IColorRepository colorRepository;
    @Autowired
    private ISizeRepository sizeRepository;
    @Autowired
    private ISubCategoryRepository subCategoryRepository;
    @Autowired
    private IImageProductRepository imageProductRepository;
    @Autowired
    IVariantRepository variantRepository;


    @Override
    public List<Optional<ProductDto>> findProductByName(String nameProduct) {
        nameProduct = iNameNormalizationService.normalizeName(nameProduct);
        List<Product> products = iProductRepository.findAll();
        List<ProductDto> productDtos = iProductConvect.convertToListDTO(products);
        List<Optional<ProductDto>> ProductDtoNew = new ArrayList<>();
        for (var item : productDtos) {
            if (ProductDtoNew.size() == 10)
                break;
            String movieName = iNameNormalizationService.normalizeName(item.getName());
            if (movieName.contains(nameProduct)) {
                ProductDtoNew.add(Optional.of(item));
            }
        }
        return ProductDtoNew;
    }

    @Override
    public ProductDto findByName(String nameProduct) {
        nameProduct = iNameNormalizationService.normalizeName(nameProduct);
        List<Product> movies = iProductRepository.findAll();
        Optional<Product> movie = Optional.empty();
        for (var item : movies) {
            String movieName = iNameNormalizationService.normalizeName(item.getName());
            if (movieName.equalsIgnoreCase(nameProduct)) {
                movie = Optional.of(item);
            }
        }
        return movie.map(value -> iProductConvect.convertToDTO(value)).orElse(null);
    }

    @Override
    public ProductDetailDto detailProduct(Long productId) throws Exception {
        Product product = iProductRepository.findProductById(productId).orElseThrow(() -> new Exception("Sản phẩm không tồn tại"));
        ProductDetailDto productDetailDto = iProductConvect.convertToDTOs(product);
        CategoryDto categoryDto = CategoryDto.builder()
                .id(product.getCategory().getId())
                .name(product.getCategory().getName())
                .gender(product.getCategory().getGender())
//                .subCategories(product.getCategory().getSubCategories())
                .build();
        SubCategoryDto subCategoryDto = SubCategoryDto.builder()
                .id(product.getSubCategory().getId())
                .name(product.getSubCategory().getName())
                .build();
        productDetailDto.setCategoryDto(categoryDto);
        productDetailDto.setSubCategoryDto(subCategoryDto);
        return productDetailDto;
    }

    @Override
    public PagingProductResponse findAll(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page<Product> productPage = iProductPagingRepository.findAll(pageRequest);
        List<Product> productList = productPage.getContent();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : productList) {
            ProductDto productDto = iProductConvect.convertToDTO(product);
            productDtoList.add(productDto);
        }
        PagingProductResponseDto response = PagingProductResponseDto.builder()
                .totalPages(productPage.getTotalPages())
                .totalElements(productPage.getTotalElements())
                .pageNumber(productPage.getNumber())
                .size(productPage.getSize())
                .data(productDtoList)
                .build();
        return PagingProductResponse.builder()
                .data(response)
                .message("Get movie page number " + pageNumber + " success")
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    @Override
    public ProductResponseDto create(NewProductRequest productDto) throws Exception {
        Product newProduct = Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .stock(productDto.getStock())
                .description(productDto.getDescription())
                .star(productDto.getStar())
                .isDeleted(productDto.isDeleted())
                .category(categoryRepository.findById(productDto.getCategoryDto().getId())
                        .orElseThrow(() -> new Exception("Category not found")))
                .subCategory(subCategoryRepository.findById(productDto.getSubCategoryDto().getId())
                        .orElseThrow(() -> new Exception("SubCategory not found")))
                .build();
        newProduct = iProductRepository.save(newProduct);
        List<ImageProduct> imageProducts = new ArrayList<>();
        for (ImageProductDto imageProductDto : productDto.getImageProductListDto()) {
            ImageProduct imageProduct = ImageProduct.builder()
                    .url(imageProductDto.getUrl())
                    .product(newProduct)
                    .build();
            imageProducts.add(imageProduct);
            imageProductRepository.save(imageProduct);
        }
        newProduct.setImageProductList(imageProducts);

        List<Variant> variants = new ArrayList<>();
        for (VariantDto variantDto : productDto.getVariantListDto()) {
            Color color = colorRepository.findById(variantDto.getColorDto().getId())
                    .orElseThrow(() -> new Exception("Color not found"));
            Size size = sizeRepository.findById(variantDto.getSizeDto().getId())
                    .orElseThrow(() -> new Exception("Size not found"));
            Variant variant = Variant.builder()
                    .color(color)
                    .size(size)
                    .product(newProduct)
                    .build();
            variantRepository.save(variant);
            variants.add(variant);
        }
        newProduct.setVariantList(variants);

        Product savedProduct = iProductRepository.save(newProduct);
        ProductResponseDto response = ProductResponseDto.builder()
                .data(iProductConvect.convertToDTO(savedProduct))
                .statusCode(200)
                .message("Product created successfully")
                .build();

        return response;
    }

    @Override
    public ProductResponseDto updateProduct(Long id, NewProductRequest productDto) throws Exception {
        // Tìm kiếm sản phẩm dựa trên tên
        Product product = iProductRepository.findById(id)
                .orElseThrow(() -> new Exception("Product not found with id: " + id));

        // Cập nhật các thuộc tính của sản phẩm
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setDescription(productDto.getDescription());
        product.setStar(productDto.getStar());
        Category category = categoryRepository.findById(productDto.getCategoryDto().getId())
                .orElseThrow(() -> new Exception("Category not found"));
        SubCategory subCategory = subCategoryRepository.findById(productDto.getSubCategoryDto().getId())
                .orElseThrow(() -> new Exception("SubCategory not found"));
        product.setCategory(category);
        product.setSubCategory(subCategory);
        Product updatedProduct = iProductRepository.save(product);
        ProductResponseDto response = ProductResponseDto.builder()
                .data(iProductConvect.convertToDTO(updatedProduct))
                .statusCode(200)
                .message("Product updated successfully")
                .build();
        return response;
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) throws Exception {
        Product product = iProductRepository.findById(id)
                .orElseThrow(() -> new Exception("Product not found with id: " + id));
        iProductRepository.delete(product);
    }
}
