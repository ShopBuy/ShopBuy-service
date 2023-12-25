package com.codegym.shopbuyservice.dto.payload.response;

import com.codegym.shopbuyservice.dto.ProductDetailDto;
import com.codegym.shopbuyservice.dto.UserDto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductDetailResponseDto {
    private ProductDetailDto data;
    private int statusCode;
    private String message;
}
