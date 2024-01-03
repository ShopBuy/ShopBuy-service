package com.codegym.shopbuyservice.converter.ipml;

import com.codegym.shopbuyservice.converter.IProductConvect;
import com.codegym.shopbuyservice.dto.*;
import com.codegym.shopbuyservice.entity.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConverter implements IProductConvect {


    @Override
    public ProductDto convertToDTO(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        List<ImageProductDto> imageProductDtos = convertImageProductListToDto(product.getImageProductList());
        productDto.setImageProductListDto(imageProductDtos);
        List<VariantDto> variantDtos = convertVariantListToDto(product.getVariantList());
        productDto.setVariantListDto(variantDtos);
        return productDto;
    }

    @Override
    public List<ProductDto> convertToListDTO(List<Product> products) {
        List<ProductDto> listdto = new ArrayList<>();
        for (Product product : products
        ) {
            listdto.add(convertToDTO(product));
        }
        return listdto;
    }

    @Override
    public ProductDetailDto convertToDTOs(Product product) {
        ProductDetailDto dto = new ProductDetailDto();
        BeanUtils.copyProperties(product, dto);
        List<ImageProductDto> imageProductDtos = convertImageProductListToDto(product.getImageProductList());
        dto.setImageProductListDto(imageProductDtos);
        List<VariantDto> variantDtos = convertVariantListToDto(product.getVariantList());
        dto.setVariantListDto(variantDtos);
        return dto;
    }

    @Override
    public List<ImageProductDto> convertImageProductListToDto(List<ImageProduct> imageProducts) {
        List<ImageProductDto> imageProductDtos = new ArrayList<>();
        for (ImageProduct imageProduct : imageProducts) {
            imageProductDtos.add(ImageProductDto.builder()
                    .id(imageProduct.getId())
                    .url(imageProduct.getUrl())
                    .build());
        }
        return imageProductDtos;
    }

    @Override
    public List<VariantDto> convertVariantListToDto(List<Variant> variants) {
        List<VariantDto> variantDtos = new ArrayList<>();
        for (Variant variant : variants) {
            variantDtos.add(VariantDto.builder()
                    .id(variant.getId())
                    .colorDto(convertColorDto(variant.getColor()))
                    .sizeDto(convertSizeDto(variant.getSize()))
                    .build());
        }
        return variantDtos;
    }

    @Override
    public ColorDto convertColorDto(Color color) {
        ColorDto colorDto = new ColorDto();
        BeanUtils.copyProperties(color, colorDto);
        return colorDto;
    }

    @Override
    public SizeDto convertSizeDto(Size size) {
        SizeDto sizeDto = new SizeDto();
        BeanUtils.copyProperties(size, sizeDto);
        return sizeDto;
    }


}
