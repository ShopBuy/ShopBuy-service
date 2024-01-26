package com.codegym.shopbuyservice.converter.ipml;

import com.codegym.shopbuyservice.dto.payload.request.UpdateCategoryRequest;
import com.codegym.shopbuyservice.dto.payload.response.CategoryShowResponse;
import com.codegym.shopbuyservice.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class UpdateCategoryConverter {public Category toEntity(UpdateCategoryRequest dto) {
   Category category = new Category();
   category.setId(dto.getId());
   category.setName(dto.getName());
   category.setGender(dto.getGender());
   category.setShown(dto.isShown());
   // Các trường khác cần thiết
   return category;
}

   public CategoryShowResponse toDto(Category entity) {
      return CategoryShowResponse.builder()
              .id(entity.getId())
              .name(entity.getName())
              .gender(entity.getGender())
              .isShown(entity.isShown())
              // Các trường khác cần thiết
              .build();
   }
}