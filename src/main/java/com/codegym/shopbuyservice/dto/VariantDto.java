package com.codegym.shopbuyservice.dto;

import com.codegym.shopbuyservice.entity.Color;
import com.codegym.shopbuyservice.entity.Size;
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

}
