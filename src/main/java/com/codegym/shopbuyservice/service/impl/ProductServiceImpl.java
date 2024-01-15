package com.codegym.shopbuyservice.service.impl;

import com.codegym.shopbuyservice.converter.IProductConvect;
import com.codegym.shopbuyservice.dto.ProductDetailDto;
import com.codegym.shopbuyservice.dto.ProductDto;
import com.codegym.shopbuyservice.entity.Product;
import com.codegym.shopbuyservice.entity.Variant;
import com.codegym.shopbuyservice.repository.IProductRepository;
import com.codegym.shopbuyservice.service.INameNormalizationService;
import com.codegym.shopbuyservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;
    @Autowired
    private INameNormalizationService iNameNormalizationService;
    @Autowired
    private IProductConvect iProductConvect;

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
        return productDetailDto ;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }
}
