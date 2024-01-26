package com.codegym.shopbuyservice.dto.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCategoryRequest {
   private Long categoryId;
}
