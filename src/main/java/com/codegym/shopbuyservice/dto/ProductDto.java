package com.codegym.shopbuyservice.dto;

import com.codegym.shopbuyservice.entity.Category;
import com.codegym.shopbuyservice.entity.ImageProduct;
import com.codegym.shopbuyservice.entity.SubCategory;
import com.codegym.shopbuyservice.entity.Variant;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private long id;

    private String name;

    @Min(value = 0)
    private double price;

    @Min(value = 0)
    private int stock;

    private String description;

    @Min(value = 0)
    private int star;

    private boolean isDeleted;

    private CategoryDto categoryDto ;

    private SubCategoryDto subCategoryDto;

    private List<ImageProductDto> imageProductListDto ;

    private List<VariantDto> variantListDto;

}
