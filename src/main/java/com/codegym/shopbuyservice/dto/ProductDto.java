package com.codegym.shopbuyservice.dto;

import com.codegym.shopbuyservice.entity.Category;
import com.codegym.shopbuyservice.entity.SubCategory;
import lombok.Data;

@Data
public class ProductDto {
    private long id;


    private String name;


    private double price;


    private int stock;


    private String description;


    private int star;


    private boolean isDeleted;


    private Category category;


    private SubCategory subCategory;
}
