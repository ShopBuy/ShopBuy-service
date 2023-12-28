package com.codegym.shopbuyservice.dto.payload.response;

import com.codegym.shopbuyservice.dto.ProductDetailDto;
import com.codegym.shopbuyservice.dto.ProductDto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductResponseDto {
    private ProductDto data;
    private int statusCode;
    private String message;
}
