package com.codegym.shopbuyservice.converter.ipml;

import com.codegym.shopbuyservice.entity.SubCategory;
import com.codegym.shopbuyservice.dto.payload.response.SubCategoryShowResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubCategoryShowConverter {
   private final CategoryShowConverter categoryConverter;

   public SubCategoryShowConverter(CategoryShowConverter categoryConverter) {
      this.categoryConverter = categoryConverter;
   }

   public SubCategoryShowResponse subCategoryToSubCategoryResponse(SubCategory subCategory) {
      return SubCategoryShowResponse.builder()
              .id(subCategory.getId())
              .name(subCategory.getName())
              .category(categoryConverter.toCategoryDto(subCategory.getCategory()))
              .build();
   }
   public List<SubCategoryShowResponse> listSubCategoryToListSubCategoryResponse(List<SubCategory> subCategoryList) {
      List<SubCategoryShowResponse> list = new ArrayList<>();
      for (SubCategory subCategory : subCategoryList) {
         list.add(subCategoryToSubCategoryResponse(subCategory));
      }
      return list;
   }

}
