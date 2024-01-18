package com.codegym.shopbuyservice.dto.payload.response;

import com.codegym.shopbuyservice.dto.PagingProductResponseDto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PagingProductResponse {
    private PagingProductResponseDto data;
    private String message;
    private int statusCode;
}
