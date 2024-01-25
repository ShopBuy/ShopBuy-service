package com.codegym.shopbuyservice.controller;

import com.codegym.shopbuyservice.dto.payload.CommonResponse;
import com.codegym.shopbuyservice.service.SubCategoryShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/subCategories")
@CrossOrigin("*")
@RequiredArgsConstructor
public class SubCategoryShowController {
   private final SubCategoryShowService subCategoryService;

   @GetMapping()
   private ResponseEntity<CommonResponse> getAllSubCategory() {
      CommonResponse commonResponse = subCategoryService.findAll();
      return new ResponseEntity<>(commonResponse, HttpStatus.OK);
   }

   @GetMapping("/{categoryId}")
   public ResponseEntity<CommonResponse> getSubCategoryByCategoryId (@PathVariable("categoryId") long categoryId) {
      CommonResponse commonResponse = subCategoryService.getSubCategoryByCategoryId(categoryId);
      return new ResponseEntity<>(commonResponse, HttpStatus.OK);
   }
}
