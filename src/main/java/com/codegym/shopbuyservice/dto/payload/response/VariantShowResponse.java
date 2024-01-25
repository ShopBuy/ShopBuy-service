package com.codegym.shopbuyservice.dto.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VariantShowResponse {
   private long id;
   private ColorShowResponse colorShowResponse;
   private SizeShowResponse sizeShowResponse;
}
