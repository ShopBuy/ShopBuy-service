package com.codegym.shopbuyservice.converter.ipml;

import java.util.ArrayList;
import java.util.List;

import com.codegym.shopbuyservice.dto.payload.response.SizeShowResponse;
import com.codegym.shopbuyservice.entity.Size;
import org.springframework.stereotype.Component;

@Component
public class SizeShowConverter {
   public SizeShowResponse convertToSizeResponseDto(Size size) {
      SizeShowResponse sizeResponse = new SizeShowResponse();

      sizeResponse.setId(size.getId());
      sizeResponse.setName(size.getName());
      return sizeResponse;
   }

   public List<SizeShowResponse> convertToSizeResponsesDto (List<Size> sizes) {

      List<SizeShowResponse> sizeResponseList = new ArrayList<>();

      for (Size size : sizes) {
         sizeResponseList.add(convertToSizeResponseDto(size));
      }
      return sizeResponseList;
   }

   public SizeShowResponse sizeToSizeResponse(Size size) {
      return SizeShowResponse.builder()
              .id(size.getId())
              .name(size.getName())
              .build();
   }
}
