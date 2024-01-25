package com.codegym.shopbuyservice.dto.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SizeShowResponse {
   private long id;
   private String name;
}
