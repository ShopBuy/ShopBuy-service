package com.codegym.shopbuyservice.service.impl;

import com.codegym.shopbuyservice.converter.ipml.CategoryShowConverter;
import com.codegym.shopbuyservice.converter.ipml.UpdateCategoryConverter;
import com.codegym.shopbuyservice.dto.payload.CommonResponse;
import com.codegym.shopbuyservice.dto.payload.request.CategoryShowRequest;
import com.codegym.shopbuyservice.dto.payload.request.GetCategoryRequest;
import com.codegym.shopbuyservice.dto.payload.request.UpdateCategoryRequest;
import com.codegym.shopbuyservice.dto.payload.response.CategoryShowResponse;
import com.codegym.shopbuyservice.dto.payload.response.ProductShowResponse;
import com.codegym.shopbuyservice.entity.Category;
import com.codegym.shopbuyservice.entity.Product;
import com.codegym.shopbuyservice.repository.ICategoryRepository;
import com.codegym.shopbuyservice.service.CategoryServiceShow;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceShowImpl implements CategoryServiceShow {
   private final CategoryShowConverter categoryConverter;
   private final ICategoryRepository categoryRepository;
   private final UpdateCategoryConverter updateCategoryConverter;
   @Override
   public CommonResponse findAll() {
      CommonResponse commonResponse = new CommonResponse();
      List<Category> categoryList = categoryRepository.findAll();
      if(categoryList.isEmpty()) {
         commonResponse.setData(null);
         commonResponse.setMessage("Categories not found");
         commonResponse.setStatusCode(HttpStatus.NOT_FOUND);
      }
      else {
         List<CategoryShowResponse> categoryShowResponseList = categoryConverter.toListCategoryDto(categoryList);
         commonResponse.setData(categoryShowResponseList);
         commonResponse.setMessage("Accessed the categories successfully");
         commonResponse.setStatusCode(HttpStatus.OK);
      }
      return commonResponse;
   }

   @Override
   public CommonResponse addCategory(CategoryShowRequest request) {
      Category category = categoryConverter.toEntity(request);
      categoryRepository.save(category);

      CategoryShowResponse  categoryResponse = categoryConverter.toDto(category);

      return CommonResponse.builder()
              .data(categoryResponse)
              .message("Add category successfully")
              .statusCode(HttpStatus.CREATED)
              .build();
   }

   @Override
   public CommonResponse updateCategory(UpdateCategoryRequest request) {
      try {
         Category existingCategory = categoryRepository.findById(request.getId())
                 .orElseThrow(() -> new RuntimeException("Category not found"));

         Category updatedCategory = updateCategoryConverter.toEntity(request);
         existingCategory.setName(updatedCategory.getName());
         existingCategory.setGender(updatedCategory.getGender());
         existingCategory.setShown(updatedCategory.isShown());

         categoryRepository.save(existingCategory);

         return CommonResponse.builder()
                 .data(updateCategoryConverter.toDto(existingCategory))
                 .message("Category updated successfully")
                 .statusCode(HttpStatus.OK)
                 .build();
      } catch (Exception e) {
         return CommonResponse.builder()
                 .data(null)
                 .message("Error updating category: " + e.getMessage())
                 .statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                 .build();
      }
   }



   @Override
   public CommonResponse   getCategoryById(GetCategoryRequest request) {
      try {
         Optional<Category> optionalCategory = categoryRepository.findById(request.getCategoryId());

         if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            CategoryShowResponse categoryShowResponse = categoryConverter.toDto(category);

            return CommonResponse.builder()
                    .data(categoryShowResponse)
                    .message("Category retrieved successfully")
                    .statusCode(HttpStatus.OK)
                    .build();
         } else {
            return CommonResponse.builder()
                    .data(null)
                    .message("Category not found")
                    .statusCode(HttpStatus.NOT_FOUND)
                    .build();
         }
      } catch (Exception e) {
         return CommonResponse.builder()
                 .data(null)
                 .message("Error retrieving category: " + e.getMessage())
                 .statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                 .build();
      }
   }


   @Override
   @Transactional
   public void deleteCategory(Long id) throws Exception {
      Category category = categoryRepository.findById(id)
              .orElseThrow(() -> new Exception("Category not found with id: " + id));
      categoryRepository.delete(category);
   }


}




