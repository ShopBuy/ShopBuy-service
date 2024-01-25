package com.codegym.shopbuyservice.converter.ipml;

import com.codegym.shopbuyservice.dto.payload.response.ColorShowResponse;
import com.codegym.shopbuyservice.entity.Color;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ColorShowConverter {
   public ColorShowResponse convertToColorResponseDto(Color color) {
      ColorShowResponse colorResponse = new ColorShowResponse();

      colorResponse.setId(color.getId());
      colorResponse.setName(color.getName());
      return colorResponse;
   }

   public List<ColorShowResponse> convertToColorResponsesDto (List<Color> colors) {

      List<ColorShowResponse> colorResponseList = new ArrayList<>();

      for (Color color : colors) {
         colorResponseList.add(convertToColorResponseDto(color));
      }
      return colorResponseList;
   }


   public ColorShowResponse colorToColorResponse(Color color) {
      return ColorShowResponse.builder()
              .id(color.getId())
              .name(color.getName())
              .code(color.getCode())
              .acronym(color.getAcronym())
              .build();
   }
}
