package com.codegym.shopbuyservice.controller;

import com.codegym.shopbuyservice.dto.payload.CommonResponse;
import com.codegym.shopbuyservice.dto.payload.request.CategoryShowRequest;
import com.codegym.shopbuyservice.dto.payload.request.GetCategoryRequest;
import com.codegym.shopbuyservice.dto.payload.request.UpdateCategoryRequest;
import com.codegym.shopbuyservice.service.CategoryServiceShow;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/categories")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CategoryShowController {
   private final CategoryServiceShow categoryService;

   @GetMapping()
   public ResponseEntity<CommonResponse> getAllCategory() {
      CommonResponse commonResponse = categoryService.findAll();
      return new ResponseEntity<>(commonResponse, HttpStatus.OK);
   }

   @GetMapping("/{categoryId}")
   public CommonResponse getCategoryById(@PathVariable Long categoryId) {
      GetCategoryRequest request = new GetCategoryRequest(categoryId);
      return categoryService.getCategoryById(request);
   }
}
