package com.codegym.shopbuyservice.converter.ipml;

import com.codegym.shopbuyservice.dto.payload.CommonResponse;
import com.codegym.shopbuyservice.dto.payload.request.CategoryShowRequest;
import com.codegym.shopbuyservice.dto.payload.request.DeleteCategoryRequest;
import com.codegym.shopbuyservice.dto.payload.response.CategoryShowResponse;
import com.codegym.shopbuyservice.dto.payload.response.DeleteCategoryResponse;
import com.codegym.shopbuyservice.entity.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryShowConverter {
   public CategoryShowResponse toCategoryDto(Category category) {
      return CategoryShowResponse.builder()
              .id(category.getId())
              .name(category.getName())
              .gender(category.getGender())
              .build();
   }
   public List<CategoryShowResponse> toListCategoryDto(List<Category> categoryList) {
      List<CategoryShowResponse> list = new ArrayList<>();
      for (Category category : categoryList) {
         list.add(toCategoryDto(category));
      }
      return list;
   }

   public Category toEntity(CategoryShowRequest dto) {
      Category category = new Category();
      category.setName(dto.getName());
      category.setGender(dto.getGender());
      category.setShown(dto.isShown());

      return category;
   }

   public CategoryShowResponse toDto(Category entity) {
      return CategoryShowResponse.builder()
              .id(entity.getId())
              .name(entity.getName())
              .gender(entity.getGender())
              .isShown(entity.isShown())
              .build();
   }




}
