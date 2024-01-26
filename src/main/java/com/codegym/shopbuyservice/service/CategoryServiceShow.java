package com.codegym.shopbuyservice.service;

import com.codegym.shopbuyservice.dto.payload.CommonResponse;
import com.codegym.shopbuyservice.dto.payload.request.CategoryShowRequest;
import com.codegym.shopbuyservice.dto.payload.request.GetCategoryRequest;
import com.codegym.shopbuyservice.dto.payload.request.UpdateCategoryRequest;
import com.codegym.shopbuyservice.dto.payload.response.CategoryShowResponse;
import com.codegym.shopbuyservice.entity.Category;

import java.util.Optional;

public interface CategoryServiceShow {
   CommonResponse findAll();
   CommonResponse addCategory(CategoryShowRequest request);

   CommonResponse updateCategory(UpdateCategoryRequest request);

   CommonResponse getCategoryById(GetCategoryRequest request);

   void deleteCategory(Long id)throws Exception;

}
