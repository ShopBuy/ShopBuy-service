package com.codegym.shopbuyservice.dto;

import com.codegym.shopbuyservice.entity.Product;
import com.codegym.shopbuyservice.entity.SubCategory;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
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
