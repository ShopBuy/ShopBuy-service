package com.shopbuyservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private long id;


    private String name;


    private double price;


    private int stock;


    private String description;


    private int star;

    private boolean isDeleted;


}
