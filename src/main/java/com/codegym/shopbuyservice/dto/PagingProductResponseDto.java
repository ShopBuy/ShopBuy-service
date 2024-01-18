package com.codegym.shopbuyservice.dto;

import com.codegym.shopbuyservice.dto.ProductDto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PagingProductResponseDto {
    private int pageNumber;
    private int size;
    private long totalElements;
    private int totalPages;
    private List<ProductDto> data;
}
