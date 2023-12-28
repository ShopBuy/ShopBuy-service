package com.codegym.shopbuyservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageProductDto {

    private long id;
    private String url;
    private boolean isDeleted;
    private ProductDto productDto;
}
