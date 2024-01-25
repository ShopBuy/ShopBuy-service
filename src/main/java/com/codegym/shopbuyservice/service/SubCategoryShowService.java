package com.codegym.shopbuyservice.service;

import com.codegym.shopbuyservice.dto.payload.CommonResponse;

public interface SubCategoryShowService {
   CommonResponse findAll();
   CommonResponse getSubCategoryByCategoryId(long categoryId);

}
