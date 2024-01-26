package com.codegym.shopbuyservice.dto.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryShowRequest {
   private Long id;
   private String name;
   private String gender;
   private boolean isShown;
}
