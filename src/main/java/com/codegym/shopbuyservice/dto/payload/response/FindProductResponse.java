package com.codegym.shopbuyservice.dto.payload.response;

import com.codegym.shopbuyservice.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FindProductResponse {
    ProductDto data;

    private int statusCode;

    private String message;
}
