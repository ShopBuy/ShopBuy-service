package com.codegym.shopbuyservice.dto.payload.response;

import com.codegym.shopbuyservice.dto.CategoryDto;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryResponseDto {
    private List<CategoryDto> data;
    private HttpStatus statusCode;
    private String message;
}
