package com.codegym.shopbuyservice.service.impl;

import com.codegym.shopbuyservice.converter.ipml.CategoryShowConverter;
import com.codegym.shopbuyservice.dto.payload.CommonResponse;
import com.codegym.shopbuyservice.dto.payload.response.CategoryShowResponse;
import com.codegym.shopbuyservice.entity.Category;
import com.codegym.shopbuyservice.repository.ICategoryRepository;
import com.codegym.shopbuyservice.service.CategoryServiceShow;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceShowImpl implements CategoryServiceShow {
   private final CategoryShowConverter categoryConverter;
   private final ICategoryRepository categoryRepository;
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
         List<CategoryShowResponse> categoryShowResponseList = categoryConverter.listCategoryToListCategoryResponse(categoryList);
         commonResponse.setData(categoryShowResponseList);
         commonResponse.setMessage("Accessed the categories successfully");
         commonResponse.setStatusCode(HttpStatus.OK);
      }
      return commonResponse;
   }
}
