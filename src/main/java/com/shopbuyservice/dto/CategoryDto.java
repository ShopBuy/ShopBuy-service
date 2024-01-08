package com.shopbuyservice.dto;

import com.shopbuyservice.entity.Product;
import com.shopbuyservice.entity.SubCategory;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDto {
    private long id;


    private String name;

    private String gender;

    private boolean isShown;

    private List<SubCategory> subCategories ;

    private List<Product> productList ;
}
