package com.codegym.shopbuyservice.converter;

import com.codegym.shopbuyservice.dto.CategoryDto;
import com.codegym.shopbuyservice.entity.Category;

import java.util.List;

public interface ICategoryConverter {
    CategoryDto convertToDto(Category category);
    List<CategoryDto> convertToListDto (List<Category> categoryList);
}
