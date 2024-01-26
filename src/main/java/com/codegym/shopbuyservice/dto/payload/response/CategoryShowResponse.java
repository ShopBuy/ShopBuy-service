package com.codegym.shopbuyservice.dto.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryShowResponse {
   private long id;
   private String name;
   private String gender;
   private boolean isShown;
}
