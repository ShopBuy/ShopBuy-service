package com.codegym.shopbuyservice.converter.ipml;

import com.codegym.shopbuyservice.converter.ICategoryConverter;
import com.codegym.shopbuyservice.dto.CategoryDto;
import com.codegym.shopbuyservice.dto.SubCategoryDto;
import com.codegym.shopbuyservice.entity.Category;
import com.codegym.shopbuyservice.entity.SubCategory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CategoryConverter implements ICategoryConverter {
    @Override
    public List<CategoryDto> convertToListDto(List<Category> categoryList) {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : categoryList){
            categoryDtoList.add(convertToDto(category));
        }
        return categoryDtoList;
    }
    @Override
    public CategoryDto convertToDto(Category category) {
        CategoryDto categoryDto = CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .gender(category.getGender())
//                .subCategories(category.getSubCategories())
                .build();
        List <SubCategoryDto> subCategoryDtoList = new ArrayList<>();
        for (SubCategory subCategory : category.getSubCategories()){
            SubCategoryDto subCategoryDto = SubCategoryDto.builder()
                    .id(subCategory.getId())
                    .name(subCategory.getName())
                    .build();
            subCategoryDtoList.add(subCategoryDto);
        }
        categoryDto.setSubCategories(subCategoryDtoList);
        return categoryDto;
    }

}
