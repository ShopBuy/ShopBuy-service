package com.codegym.shopbuyservice.controller;

import com.codegym.shopbuyservice.dto.ProductDto;
import com.codegym.shopbuyservice.dto.payload.request.RegisterRequest;
import com.codegym.shopbuyservice.dto.payload.response.FindProductResponse;
import com.codegym.shopbuyservice.dto.payload.response.FindProductsReponse;
import com.codegym.shopbuyservice.dto.payload.response.RegisterResponse;
import com.codegym.shopbuyservice.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    private IProductService iProductService;
    @GetMapping("/search")
    public ResponseEntity<?> getByName (@RequestParam(value = "name", required = true) String nameProduct, @RequestParam(value = "type", required = false) String type){
        if ("all".equals(type)) {
            List<Optional<ProductDto>> product = iProductService.findProductByName(nameProduct);
            FindProductsReponse response;
            if (!product.isEmpty()) {
                response = FindProductsReponse.builder()
                        .data(product)
                        .statusCode(HttpStatus.OK.value())
                        .message("Success")
                        .build();
            } else {
                response = FindProductsReponse.builder()
                        .statusCode(HttpStatus.NOT_FOUND.value())
                        .message("Not found Movies")
                        .build();
            }
            return ResponseEntity.ok(response);
        } else {
            ProductDto productDto = iProductService.findByName(nameProduct);
            FindProductResponse response;
            if (productDto != null) {
                response = FindProductResponse.builder()
                        .data(productDto)
                        .statusCode(HttpStatus.OK.value())
                        .message("Success")
                        .build();
            } else {
                response = FindProductResponse.builder()
                        .statusCode(HttpStatus.NOT_FOUND.value())
                        .message("Not found Movie")
                        .build();
            }
            return ResponseEntity.ok(response);
        }
    }
    @GetMapping("/cartList")
    public ResponseEntity<?> showListCart (@RequestBody @Valid RegisterRequest request, BindingResult bindingResult) {



    }
