package com.codegym.shopbuyservice.service.impl;

import com.codegym.shopbuyservice.converter.ipml.SubCategoryShowConverter;
import com.codegym.shopbuyservice.dto.payload.CommonResponse;
import com.codegym.shopbuyservice.dto.payload.response.SubCategoryShowResponse;
import com.codegym.shopbuyservice.entity.SubCategory;
import com.codegym.shopbuyservice.repository.ISubCategoryRepository;
import com.codegym.shopbuyservice.service.SubCategoryShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubCategoryShowServiceImpl  implements SubCategoryShowService {
   private final ISubCategoryRepository subCategoryRepository;

   private final SubCategoryShowConverter subCategoryConverter;

   @Override
   public CommonResponse findAll() {
      CommonResponse commonResponse = new CommonResponse();
      List<SubCategory> subCategoryList = subCategoryRepository.findAll();
      if(subCategoryList.isEmpty()) {
         commonResponse.setData(null);
         commonResponse.setMessage("SubCategories not found");
         commonResponse.setStatusCode(HttpStatus.NOT_FOUND);
      }
      else {
         List<SubCategoryShowResponse> subCategoryResponseList = subCategoryConverter.listSubCategoryToListSubCategoryResponse(subCategoryList);
         commonResponse.setData(subCategoryResponseList);
         commonResponse.setMessage("Accessed the subCategories successfully");
         commonResponse.setStatusCode(HttpStatus.OK);
      }
      return commonResponse;
   }

   @Override
   public CommonResponse getSubCategoryByCategoryId(long categoryId) {
      CommonResponse commonResponse = new CommonResponse();
      List<SubCategory> subCategoryList = subCategoryRepository.findSubCategoryByCategoryId(categoryId);
      if(subCategoryList.isEmpty()) {
         commonResponse.setData(null);
         commonResponse.setMessage("SubCategories not found");
         commonResponse.setStatusCode(HttpStatus.NOT_FOUND);
      }
      else {
         List<SubCategoryShowResponse> subCategoryShowResponseList = subCategoryConverter.listSubCategoryToListSubCategoryResponse(subCategoryList);
         commonResponse.setData(subCategoryShowResponseList);
         commonResponse.setMessage("SubCategories successfully");
         commonResponse.setStatusCode(HttpStatus.OK);
      }
      return commonResponse;
   }
}
