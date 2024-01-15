package com.codegym.shopbuyservice.converter.ipml;

import com.codegym.shopbuyservice.converter.ICategoryConverter;
import com.codegym.shopbuyservice.dto.CategoryDto;
import com.codegym.shopbuyservice.dto.SubCategoryDto;
import com.codegym.shopbuyservice.entity.Category;
import com.codegym.shopbuyservice.entity.Product;
import com.codegym.shopbuyservice.entity.SubCategory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryConverter implements ICategoryConverter {

    @Override
    public CategoryDto convertToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        mapCategoryToDto(category, categoryDto);
        return categoryDto;
    }

    @Override
    public List<CategoryDto> convertToListDto(List<Category> categoryList) {
        return categoryList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private void mapCategoryToDto(Category category, CategoryDto categoryDto) {
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setGender(category.getGender());
        categoryDto.setShown(category.isShown());
        categoryDto.setSubCategories(convertSubCategoryListToDto(category.getSubCategories()));
        categoryDto.setProductList(convertProductListToDto(category.getProductList()));
    }

    private List<SubCategoryDto> convertSubCategoryListToDto(List<SubCategory> subCategoryList) {
        return subCategoryList.stream()
                .map(this::convertSubCategoryToDto)
                .collect(Collectors.toList());
    }

    private SubCategoryDto convertSubCategoryToDto(SubCategory subCategory) {
        SubCategoryDto subCategoryDto = new SubCategoryDto();
        subCategoryDto.setId(subCategory.getId());
        subCategoryDto.setName(subCategory.getName());
        subCategoryDto.setShown(subCategory.isShown());
        subCategoryDto.setCategoryId(subCategory.getCategory().getId());
        subCategoryDto.setProductListIds(convertProductListToDto(subCategory.getProductList()));
        return subCategoryDto;
    }

    private List<Long> convertProductListToDto(List<Product> productList) {
        if (productList == null) {
            return null;
        }

        return productList.stream()
                .map(Product::getId)
                .collect(Collectors.toList());
    }

}