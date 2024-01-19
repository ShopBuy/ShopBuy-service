package com.codegym.shopbuyservice.converter;

import com.codegym.shopbuyservice.dto.CategoryDto;
import com.codegym.shopbuyservice.dto.ProductDto;
import com.codegym.shopbuyservice.entity.Category;
import com.codegym.shopbuyservice.entity.Product;

import java.util.List;

public interface IProductListConverter {
    ProductDto convertToDto(Product product);

    List<ProductDto> convertToListDto (List<Product> categoryList);
}
