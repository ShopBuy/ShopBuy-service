package com.codegym.shopbuyservice.controller;

import com.codegym.shopbuyservice.dto.ProductDto;
import com.codegym.shopbuyservice.dto.payload.response.FindProductReponse;
import com.codegym.shopbuyservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
            FindProductReponse response;
            if (!product.isEmpty()) {
                response = FindProductReponse.builder()
                        .data(product)
                        .statusCode(HttpStatus.OK.value())
                        .message("Success")
                        .build();
            } else {
                response = FindProductReponse.builder()
                        .statusCode(HttpStatus.NOT_FOUND.value())
                        .message("Not found Movies")
                        .build();
            }
            return ResponseEntity.ok(response);
        } else {
            ProductDto productDto = iProductService.findByName(nameProduct);
            FindProductReponse response;
            if (productDto != null) {
                response = FindProductReponse.builder()
                        .data((List<Optional<ProductDto>>) productDto)
                        .statusCode(HttpStatus.OK.value())
                        .message("Success")
                        .build();
            } else {
                response = FindProductReponse.builder()
                        .statusCode(HttpStatus.NOT_FOUND.value())
                        .message("Not found Movie")
                        .build();
            }
            return ResponseEntity.ok(response);
        }
    }

}
