package com.codegym.shopbuyservice.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetailDto {
    private Long id;
    private String name;
    private double price;
    private CategoryDto categoryDto ;
    private SubCategoryDto subCategoryDto;
    private List<ImageProductDto> imageProductListDto ;
    private List<VariantDto> variantListDto;
}
