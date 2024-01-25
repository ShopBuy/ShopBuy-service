package com.codegym.shopbuyservice.converter.ipml;

import com.codegym.shopbuyservice.dto.payload.response.CategoryShowResponse;
import com.codegym.shopbuyservice.entity.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryShowConverter {
   public CategoryShowResponse categoryToCategoryResponse(Category category) {
      return CategoryShowResponse.builder()
              .id(category.getId())
              .name(category.getName())
              .gender(category.getGender())
              .build();
   }
   public List<CategoryShowResponse> listCategoryToListCategoryResponse(List<Category> categoryList) {
      List<CategoryShowResponse> list = new ArrayList<>();
      for (Category category : categoryList) {
         list.add(categoryToCategoryResponse(category));
      }
      return list;
   }
}
