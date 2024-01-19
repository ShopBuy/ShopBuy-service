package com.codegym.shopbuyservice.dto.payload.response;

import com.codegym.shopbuyservice.dto.CategoryDto;
import com.codegym.shopbuyservice.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductListResponseDto {
    private List<ProductDto> data;
    private String message;
    private int statusCode;
}
