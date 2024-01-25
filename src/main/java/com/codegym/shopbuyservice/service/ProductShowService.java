package com.codegym.shopbuyservice.service;

import com.codegym.shopbuyservice.dto.payload.CommonResponse;

public interface ProductShowService {
   CommonResponse findAll();
//   CommonResponse getProductByCategoryId(long categoryId);

   CommonResponse getProductBySubCategoryId(long subCategoryId);
}
