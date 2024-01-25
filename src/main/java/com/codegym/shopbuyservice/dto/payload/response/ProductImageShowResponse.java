package com.codegym.shopbuyservice.dto.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductImageShowResponse {
   private long id;

   private String url;
}
