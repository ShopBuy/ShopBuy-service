package com.codegym.shopbuyservice.dto;


import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
    public class SubCategoryDto {

    private long id;
    private String name;
    private boolean isShown;
    private Long categoryId;
    private List<Long> productListIds;


}