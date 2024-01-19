package com.codegym.shopbuyservice.controller;

import com.codegym.shopbuyservice.dto.payload.response.CategoryListResponse;
import com.codegym.shopbuyservice.dto.payload.response.ErrorResponse;
import com.codegym.shopbuyservice.dto.payload.response.ProductListResponseDto;
import com.codegym.shopbuyservice.entity.Category;
import com.codegym.shopbuyservice.entity.Product;
import com.codegym.shopbuyservice.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping
    public ResponseEntity<?> getAllProducts() throws Exception {
        try {
            ProductListResponseDto response = productService.getAllProducts();
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            ErrorResponse response = new ErrorResponse();
            response.setMessage(e.getMessage());
            response.setStatusCode(400);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product newProduct = productService.createProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    // Xem chi tiết một sản phẩm
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // Cập nhật thông tin một sản phẩm
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    // Xóa một sản phẩm
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
