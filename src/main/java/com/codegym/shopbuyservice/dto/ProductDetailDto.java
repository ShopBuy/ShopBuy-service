package com.codegym.shopbuyservice.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetailDto {
    private String name;
    private double price;
    private List<ImageProductDto> imageProductListDto ;
    private List<VariantDto> variantListDto;
}
