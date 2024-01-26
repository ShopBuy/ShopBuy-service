package com.codegym.shopbuyservice.dto.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class GetCategoryRequest {
   private Long categoryId;
}
