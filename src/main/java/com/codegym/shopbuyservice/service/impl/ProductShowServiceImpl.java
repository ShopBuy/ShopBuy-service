package com.codegym.shopbuyservice.service.impl;

import com.codegym.shopbuyservice.converter.ipml.ProductShowConverter;
import com.codegym.shopbuyservice.dto.payload.CommonResponse;
import com.codegym.shopbuyservice.dto.payload.response.ProductShowResponse;
import com.codegym.shopbuyservice.entity.Product;
import com.codegym.shopbuyservice.repository.ProductRepository;
import com.codegym.shopbuyservice.service.ProductShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductShowServiceImpl implements ProductShowService {
   private final ProductRepository productRepository;
   private final ProductShowConverter productConverter;

   @Override
   public CommonResponse findAll() {
      CommonResponse commonResponse = new CommonResponse();
      List<Product> productList = productRepository.findAll();
      if(productList.isEmpty()) {
         commonResponse.setData(null);
         commonResponse.setMessage("Products not found");
         commonResponse.setStatusCode(HttpStatus.NOT_FOUND);
      }
      else {
         List<ProductShowResponse> productResponseList = productConverter.listProductToListProductResponse(productList);
         commonResponse.setData(productResponseList);
         commonResponse.setMessage("Accessed the products successfully");
         commonResponse.setStatusCode(HttpStatus.OK);
      }
      return commonResponse;
   }

   @Override
   public CommonResponse getProductBySubCategoryId(long subCategoryId) {
      CommonResponse commonResponse = new CommonResponse();
      List<Product> productList = productRepository.findProductBySubCategoryId(subCategoryId);
      if(productList.isEmpty()) {
         commonResponse.setData(null);
         commonResponse.setMessage("Products not found");
         commonResponse.setStatusCode(HttpStatus.NOT_FOUND);
      }
      else {
         List<ProductShowResponse> productResponseList = productConverter.listProductToListProductResponse(productList);
         commonResponse.setData(productResponseList);
         commonResponse.setMessage("Accessed the products successfully");
         commonResponse.setStatusCode(HttpStatus.OK);
      }
      return commonResponse;
   }
}
