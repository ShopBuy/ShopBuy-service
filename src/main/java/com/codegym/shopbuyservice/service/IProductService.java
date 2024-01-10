package com.codegym.shopbuyservice.service;


import com.codegym.shopbuyservice.dto.ProductDetailDto;
import com.codegym.shopbuyservice.dto.ProductDto;
import com.codegym.shopbuyservice.dto.payload.request.NewProductRequest;
import com.codegym.shopbuyservice.dto.payload.response.PagingProductResponse;
import com.codegym.shopbuyservice.dto.payload.response.ProductResponseDto;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Optional<ProductDto>> findProductByName(String nameProduct);

    ProductDto findByName(String nameProduct);

    ProductDetailDto detailProduct(Long productId) throws Exception;

    PagingProductResponse findAll(int pageNumber, int pageSize);

    ProductResponseDto create(NewProductRequest productDto) throws Exception;

    ProductResponseDto updateProduct(Long id, NewProductRequest productDto) throws Exception;

    void deleteProduct(Long id) throws Exception;
}
