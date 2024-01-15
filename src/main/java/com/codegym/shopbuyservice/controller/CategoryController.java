package com.codegym.shopbuyservice.controller;

import com.codegym.shopbuyservice.dto.payload.response.CategoryListResponse;
import com.codegym.shopbuyservice.dto.payload.response.ErrorResponse;
import com.codegym.shopbuyservice.entity.Category;
import com.codegym.shopbuyservice.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/categories")
public class CategoryController {


        @Autowired
        private CategoryServiceImpl categoryService;

        @GetMapping
        public ResponseEntity<?> getAllCategories() {
            try {
                CategoryListResponse response = categoryService.getAll();
                return new ResponseEntity<>(response, HttpStatus.OK);

            } catch (Exception e) {
                ErrorResponse response = new ErrorResponse();
                response.setMessage(e.getMessage());
                response.setStatusCode(400);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        }

        @PostMapping
        public ResponseEntity<Category> createCategory(@RequestBody Category category) {
            Category newCategory = categoryService.createCategory(category);
            return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
            Category category = categoryService.getCategoryById(id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
            Category updatedCategory = categoryService.updateCategory(id, category);
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id) {
            categoryService.deleteCategory(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

