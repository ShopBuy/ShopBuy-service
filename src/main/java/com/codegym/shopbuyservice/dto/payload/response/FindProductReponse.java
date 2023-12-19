package com.codegym.shopbuyservice.dto.payload.response;

import com.codegym.shopbuyservice.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FindProductReponse {
    List<Optional<ProductDto>> data;
    private int statusCode;
    private String message;
}
