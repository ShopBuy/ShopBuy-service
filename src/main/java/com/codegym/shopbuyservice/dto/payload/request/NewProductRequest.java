package com.codegym.shopbuyservice.dto.payload.request;

import com.codegym.shopbuyservice.dto.CategoryDto;
import com.codegym.shopbuyservice.dto.ImageProductDto;
import com.codegym.shopbuyservice.dto.SubCategoryDto;
import com.codegym.shopbuyservice.dto.VariantDto;
import com.codegym.shopbuyservice.entity.Category;
import com.codegym.shopbuyservice.entity.ImageProduct;
import com.codegym.shopbuyservice.entity.SubCategory;
import com.codegym.shopbuyservice.entity.Variant;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewProductRequest {
    private String name;

    private double price;

    private int stock;

    private String description;

    private int star;

    private boolean isDeleted;

    private CategoryDto categoryDto ;

    private SubCategoryDto subCategoryDto;

    private List<ImageProductDto> imageProductListDto ;

    private List<VariantDto> variantListDto;

}
