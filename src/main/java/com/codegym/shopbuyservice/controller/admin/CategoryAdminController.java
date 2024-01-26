package com.codegym.shopbuyservice.controller.admin;

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
@RequestMapping("api/admin/categories")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CategoryAdminController {
   private final CategoryServiceShow categoryService;

   @PostMapping()
   public ResponseEntity<CommonResponse> addCategory(@RequestBody CategoryShowRequest categoryRequest) {
      CommonResponse commonResponse = categoryService.addCategory(categoryRequest);
      return new ResponseEntity<>(commonResponse, HttpStatus.CREATED);
   }

   @PutMapping("/{id}")
   public ResponseEntity<CommonResponse> updateCategory(@PathVariable Long id, @RequestBody UpdateCategoryRequest request) {
      request.setId(id);
      CommonResponse commonResponse = categoryService.updateCategory(request);
      return new ResponseEntity<>(commonResponse, commonResponse.getStatusCode());
   }



   @DeleteMapping("/{categoryId}")
   public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId) {
      try {
         categoryService.deleteCategory(categoryId);
         return ResponseEntity.ok().body("Category deleted successfully");
      } catch (Exception e) {
         return ResponseEntity.badRequest().body(e.getMessage());
      }
   }

}
