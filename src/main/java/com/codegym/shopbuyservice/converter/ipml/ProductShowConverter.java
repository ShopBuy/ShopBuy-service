package com.codegym.shopbuyservice.converter.ipml;

import com.codegym.shopbuyservice.dto.payload.response.ProductShowResponse;
import com.codegym.shopbuyservice.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductShowConverter {
   private final CategoryShowConverter categoryConverter;
   private final SubCategoryShowConverter subCategoryConverter;
   private final ProductImageShowConverter productImageConverter;
//   private final ReviewShowConverter reviewShowConverter;
   private final VariantShowConverter variantConverter;

//   public ProductConverter(CategoryShowConverter categoryConverter, SubCategoryShowConverter subCategoryConverter, ProductImageShowConverter productImageConverter, ReviewConverter reviewConverter, VariantShowConverter variantConverter)

   public ProductShowConverter(CategoryShowConverter categoryConverter, SubCategoryShowConverter subCategoryConverter, ProductImageShowConverter productImageConverter, VariantShowConverter variantConverter)
   {
      this.categoryConverter = categoryConverter;
      this.subCategoryConverter = subCategoryConverter;
      this.productImageConverter = productImageConverter;
//      this.reviewConverter = reviewConverter;
      this.variantConverter = variantConverter;
   }
   public ProductShowResponse productToProductResponse(Product product) {
      return ProductShowResponse.builder()
              .id(product.getId())
              .name(product.getName())
              .price(product.getPrice())
              .stock(product.getStock())
              .description(product.getDescription())
              .star(product.getStar())
              .category(categoryConverter.categoryToCategoryResponse(product.getCategory()))
              .subCategory(subCategoryConverter.subCategoryToSubCategoryResponse(product.getSubCategory()))
              .imageProductList(productImageConverter.listProductImageToListProductImageResponse(product.getImageProductList()))
//              .reviews(reviewConverter.listReviewToListReviewResponse(product.getReviews()))
              .variantList(variantConverter.listVariantToListVariantResponse(product.getVariantList()))
              .build();
   }
   public List<ProductShowResponse> listProductToListProductResponse(List<Product> productList) {
      List<ProductShowResponse> list = new ArrayList<>();
      for (Product product : productList) {
         list.add(productToProductResponse(product));
      }
      return list;
   }
}
