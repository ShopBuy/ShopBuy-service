package com.codegym.shopbuyservice.dto;

import com.codegym.shopbuyservice.entity.Variant;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColorDto {

    private long id;


    private String name;


    private String code;


    private String acronym;


    private boolean isDeleted;


    private List<VariantDto> variantListDto;
}
