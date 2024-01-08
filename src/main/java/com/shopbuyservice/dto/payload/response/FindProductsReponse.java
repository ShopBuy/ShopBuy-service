package com.shopbuyservice.dto.payload.response;

import com.shopbuyservice.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FindProductsReponse {
    List<Optional<ProductDto>> data;

    private int statusCode;

    private String message;
}
