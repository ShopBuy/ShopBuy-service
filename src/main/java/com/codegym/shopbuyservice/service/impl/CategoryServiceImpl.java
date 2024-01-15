package com.codegym.shopbuyservice.service.impl;

import com.codegym.shopbuyservice.converter.ICategoryConverter;
import com.codegym.shopbuyservice.dto.CategoryDto;
import com.codegym.shopbuyservice.dto.payload.response.CategoryListResponse;
import com.codegym.shopbuyservice.entity.Category;
import com.codegym.shopbuyservice.repository.ICategoryRepository;
import com.codegym.shopbuyservice.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private ICategoryConverter categoryConverter;

    @Override
    public CategoryListResponse getAll() throws Exception{
        List<Category> categoryList = categoryRepository.findAll();
        if(categoryList.isEmpty()){
            throw new Exception("Cannot get all categories");
        }
        List<CategoryDto> categoryDtoList = categoryConverter.convertToListDto(categoryList);
        return CategoryListResponse.builder()
                .data(categoryDtoList)
                .message("Get All Categories Success")
                .statusCode(200)
                .build();    }

    @Override
    public Category createCategory(Category category) {
        return null;
    }

    @Override
    public Category getCategoryById(Long id) {
        return null;
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {

    }
}
