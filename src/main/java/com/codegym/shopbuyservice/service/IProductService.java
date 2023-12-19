package com.codegym.shopbuyservice.service;

import com.codegym.shopbuyservice.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface IProductService {
List<Optional<ProductDto>> findProductByName (String nameProduct);
    ProductDto findByName(String nameProduct);
}
