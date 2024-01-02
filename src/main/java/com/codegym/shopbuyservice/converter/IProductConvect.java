package com.codegym.shopbuyservice.converter;

import com.codegym.shopbuyservice.dto.ProductDetailDto;
import com.codegym.shopbuyservice.dto.ProductDto;
import com.codegym.shopbuyservice.entity.Product;

import java.util.List;

public interface IProductConvect {
    ProductDto convertToDTO(Product product);
    List<ProductDto> convertToListDTO(List<Product> products);

   ProductDetailDto convertToDTOs (Product product) ;
}
