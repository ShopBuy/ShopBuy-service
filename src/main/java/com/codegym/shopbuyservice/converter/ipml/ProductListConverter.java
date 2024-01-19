package com.codegym.shopbuyservice.converter.ipml;

import com.codegym.shopbuyservice.converter.IProductListConverter;
import com.codegym.shopbuyservice.dto.ProductDto;
import com.codegym.shopbuyservice.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public class ProductListConverter implements IProductListConverter {
    @Override
    public ProductDto convertToDto(Product product) {
        return null;
    }

    @Override
    public List<ProductDto> convertToListDto(List<Product> categoryList) {
        return null;
    }
}
