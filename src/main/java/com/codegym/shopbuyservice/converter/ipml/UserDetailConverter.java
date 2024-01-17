package com.codegym.shopbuyservice.converter.ipml;

import com.codegym.shopbuyservice.dto.payload.request.UserDetailRequest;
import com.codegym.shopbuyservice.dto.payload.response.UserDetailResponse;
import com.codegym.shopbuyservice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDetailConverter {
   public User toEntity(UserDetailRequest dto) {
      User user = new User();
      user.setEmail(dto.getEmail());
      user.setFullName((dto.getFullName()));
      user.setDateOfBirth((dto.getDateOfBirth()));
      user.setGender(dto.getGender());
      user.setPhoneNumber((dto.getPhoneNumber()));
//      user.setRole(dto.getRole());
      user.setProfileImageUrl(dto.getProfileImageUrl());
      return user;
   }


   public UserDetailResponse toDto(User entity) {
      UserDetailResponse dto = new UserDetailResponse();
      dto.setId(entity.getId());
      dto.setEmail(entity.getEmail());
      dto.setFullName(entity.getFullName());
      dto.setDateOfBirth((entity.getDateOfBirth()));
      dto.setGender(entity.getGender());
      dto.setPhoneNumber((entity.getPhoneNumber()));
//      dto.setRole(entity.getRole());
      dto.setProfileImageUrl(entity.getProfileImageUrl());
      return dto;
   }
}
