package com.codegym.shopbuyservice.service;

import com.codegym.shopbuyservice.dto.payload.response.CategoryListResponse;
import com.codegym.shopbuyservice.dto.payload.response.CategoryResponseDto;
import com.codegym.shopbuyservice.entity.Category;

import java.util.List;

public interface ICategoryService {
    CategoryListResponse getAll() throws Exception;

    Category createCategory(Category category);

    Category getCategoryById(Long id);

    Category updateCategory(Long id, Category category);

    void deleteCategory(Long id);
}
