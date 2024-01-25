package com.codegym.shopbuyservice.converter.ipml;

import com.codegym.shopbuyservice.dto.payload.response.ProductImageShowResponse;
import com.codegym.shopbuyservice.entity.ImageProduct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductImageShowConverter {
   public ProductImageShowResponse productImageToProductImageResponse(ImageProduct productImage) {
      return ProductImageShowResponse.builder()
              .id(productImage.getId())
              .url(productImage.getUrl())
              .build();
   }
   public List<ProductImageShowResponse> listProductImageToListProductImageResponse(List<ImageProduct> productImageList) {
      List<ProductImageShowResponse> list = new ArrayList<>();
      for (ImageProduct productImage : productImageList) {
         list.add(productImageToProductImageResponse(productImage));
      }
      return list;
   }
}
