package com.shopbuyservice.controller;
import com.shopbuyservice.dto.payload.CommonResponse;

import com.shopbuyservice.dto.payload.response.UserDetailResponse;
import com.shopbuyservice.repository.IUserRepository;
import com.shopbuyservice.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
@RequiredArgsConstructor
public class  UserController {
   private final IUserService userService;
   @GetMapping("/profile")
   public ResponseEntity<?> getProfileUser() {
      try {
         String username = SecurityContextHolder.getContext().getAuthentication().getName();
         UserDetailResponse updatedUser = userService.getUserByEmail(username);

         CommonResponse commonResponse = new CommonResponse();
         commonResponse.setData(updatedUser);
         commonResponse.setMessage("Get profile for user success !");
         commonResponse.setStatusCode(HttpStatus.OK);
         return new ResponseEntity<>(commonResponse, HttpStatus.OK);
      } catch (Exception e) {
         CommonResponse commonResponse = new CommonResponse();
         commonResponse.setData(null);
         commonResponse.setMessage("Get profile for user fail");
         commonResponse.setStatusCode(HttpStatus.NOT_FOUND);
         return new ResponseEntity<>(commonResponse, HttpStatus.NOT_FOUND);
      }
   }
}
