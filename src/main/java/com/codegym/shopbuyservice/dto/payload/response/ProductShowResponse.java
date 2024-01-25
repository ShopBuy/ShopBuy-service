package com.codegym.shopbuyservice.dto.payload.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductShowResponse {
   private long id;

   private String name;

   private double price;

   private int stock;

   private String description;

   private int star;

   private CategoryShowResponse category;

   private SubCategoryShowResponse subCategory;

   private List<ProductImageShowResponse> imageProductList ;

//   private List<ReviewShowResponse> reviews ;

   private List<VariantShowResponse> variantList;
}
