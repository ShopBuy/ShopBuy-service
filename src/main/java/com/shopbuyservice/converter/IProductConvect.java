package com.shopbuyservice.converter;

import com.shopbuyservice.dto.ProductDto;
import com.shopbuyservice.entity.Product;

import java.util.List;

public interface IProductConvect {
    ProductDto convertToDTO(Product product);
    List<ProductDto> convertToListDTO(List<Product> products);
}
