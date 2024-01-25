package com.codegym.shopbuyservice.controller;

import com.codegym.shopbuyservice.dto.payload.CommonResponse;
import com.codegym.shopbuyservice.dto.payload.request.UserDetailRequest;
import com.codegym.shopbuyservice.dto.payload.response.UserDetailResponse;
import com.codegym.shopbuyservice.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserShowController {
   private final IUserService userService;

   @GetMapping("/profile")
   public ResponseEntity<?> getProfile() {
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

   @PutMapping("/update-profile")
   public ResponseEntity<?> updateProfileByEmail(@Valid @RequestBody UserDetailRequest userDetailRequest
   ) {
      try {
         String username = SecurityContextHolder.getContext().getAuthentication().getName();

         UserDetailResponse updatedUser = userService.updateUserByEmail(
                 username,
                 userDetailRequest);

         CommonResponse commonResponse = new CommonResponse();
         commonResponse.setData(updatedUser);
         commonResponse.setMessage("Update profile for user success !");
         commonResponse.setStatusCode(HttpStatus.OK);

         return new ResponseEntity<>(commonResponse, HttpStatus.OK);
      } catch (Exception e) {
         CommonResponse commonResponse = new CommonResponse();
         commonResponse.setData(null);
         commonResponse.setMessage("Update profile for user fail !");
         commonResponse.setStatusCode(HttpStatus.NOT_FOUND);

         return new ResponseEntity<>(commonResponse, HttpStatus.NOT_FOUND);

      }
   }

}
