package com.codegym.shopbuyservice.service;


import com.codegym.shopbuyservice.dto.ProductDetailDto;
import com.codegym.shopbuyservice.dto.ProductDto;
import com.codegym.shopbuyservice.dto.payload.response.ProductListResponseDto;
import com.codegym.shopbuyservice.dto.payload.request.NewProductRequest;
import com.codegym.shopbuyservice.dto.payload.response.PagingProductResponse;
import com.codegym.shopbuyservice.dto.payload.response.ProductResponseDto;
import com.codegym.shopbuyservice.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Optional<ProductDto>> findProductByName(String nameProduct);

    ProductDto findByName(String nameProduct);

    ProductDetailDto detailProduct(Long productId) throws Exception;

    Product updateProduct(Long id, Product product);

    ProductListResponseDto getAllProducts() throws Exception;

    Product createProduct(Product product);

    Product getProductById(Long id);
    PagingProductResponse findAll(int pageNumber, int pageSize);

    ProductResponseDto create(NewProductRequest productDto) throws Exception;

    ProductResponseDto updateProduct(Long id, NewProductRequest productDto) throws Exception;

    void deleteProduct(Long id) throws Exception;
}
