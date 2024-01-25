package com.codegym.shopbuyservice.controller;

import com.codegym.shopbuyservice.dto.payload.CommonResponse;
import com.codegym.shopbuyservice.service.ProductShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ProductShowController {
   private final ProductShowService productService;
   @GetMapping("/subCategory/{subCategoryId}")
   public ResponseEntity<CommonResponse> getProductBySubCategoryId(@PathVariable("subCategoryId") long subCategoryId) {
      CommonResponse commonResponse = productService.getProductBySubCategoryId(subCategoryId);
      return new ResponseEntity<>(commonResponse, HttpStatus.OK);
   }

   @GetMapping("")
   public ResponseEntity<CommonResponse> getAll() {
      CommonResponse commonResponse = productService.findAll();
      return new ResponseEntity<>(commonResponse, HttpStatus.OK);
   }




}
