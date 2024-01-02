package com.codegym.shopbuyservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VariantDto {

    private long id;

    private boolean isDeleted;

    private ColorDto colorDto;

    private SizeDto sizeDto;

    private ProductDto productDto;
}
