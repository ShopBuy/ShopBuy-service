package com.codegym.shopbuyservice.converter;

import com.codegym.shopbuyservice.dto.*;
import com.codegym.shopbuyservice.entity.*;

import java.util.List;

public interface IProductConvect {
    ProductDto convertToDTO(Product product);
    List<ProductDto> convertToListDTO(List<Product> products);

   ProductDetailDto convertToDTOs (Product product) ;
    List<ImageProductDto> convertImageProductListToDto(List<ImageProduct> imageProducts);
    List<VariantDto> convertVariantListToDto(List<Variant> variants);

    ColorDto convertColorDto(Color color);
    SizeDto convertSizeDto(Size size);
}
