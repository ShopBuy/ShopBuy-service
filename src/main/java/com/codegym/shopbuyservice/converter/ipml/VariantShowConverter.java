package com.codegym.shopbuyservice.converter.ipml;

import com.codegym.shopbuyservice.dto.payload.response.VariantShowResponse;
import com.codegym.shopbuyservice.entity.Variant;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VariantShowConverter {
   private final ColorShowConverter colorConverter;
   private final SizeShowConverter sizeConverter;

   public VariantShowConverter(ColorShowConverter colorConverter, SizeShowConverter sizeConverter) {
      this.colorConverter = colorConverter;
      this.sizeConverter = sizeConverter;
   }
   public VariantShowResponse variantToVariantResponse(Variant variant) {
      return VariantShowResponse.builder()
              .id(variant.getId())
              .colorShowResponse(colorConverter.colorToColorResponse(variant.getColor()))
              .sizeShowResponse(sizeConverter.sizeToSizeResponse(variant.getSize()))
              .build();
   }
   public List<VariantShowResponse> listVariantToListVariantResponse(List<Variant> variantList) {
      List<VariantShowResponse> list = new ArrayList<>();
      for (Variant variant : variantList) {
         list.add(variantToVariantResponse(variant));
      }
      return list;
   }
}
