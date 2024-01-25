package com.codegym.shopbuyservice.service.impl;

import com.codegym.shopbuyservice.converter.ICategoryConverter;
import com.codegym.shopbuyservice.dto.CategoryDto;
import com.codegym.shopbuyservice.dto.payload.response.CategoryResponseDto;
import com.codegym.shopbuyservice.entity.Category;
import com.codegym.shopbuyservice.repository.ICategoryRepository;
import com.codegym.shopbuyservice.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
   @Autowired
   private ICategoryRepository categoryRepository;
   @Autowired
   private ICategoryConverter categoryConverter;

   @Override
   public CategoryResponseDto fillAll() {
      List<Category> categoryList = categoryRepository.findAll();
      List<CategoryDto> categoryDtoList = categoryConverter.convertToListDto(categoryList);
      return CategoryResponseDto.builder()
              .data(categoryDtoList)
              .message("Get All Categories Success")
              .statusCode(HttpStatus.OK)
              .build();
   }
}
