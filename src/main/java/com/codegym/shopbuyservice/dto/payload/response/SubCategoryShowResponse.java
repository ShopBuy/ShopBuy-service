package com.codegym.shopbuyservice.dto.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubCategoryShowResponse {
   private long id;
   private String name;
   private CategoryShowResponse category;
}
