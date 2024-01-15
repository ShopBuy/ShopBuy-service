package com.codegym.shopbuyservice.dto.payload.response;

import com.codegym.shopbuyservice.dto.CategoryDto;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryListResponse {
    private List<CategoryDto> data;
    private String message;
    private int statusCode;
}
