package com.codegym.shopbuyservice.converter.ipml;

import com.codegym.shopbuyservice.dto.payload.request.UserDetailRequest;
import com.codegym.shopbuyservice.dto.payload.response.UserDetailResponse;
import com.codegym.shopbuyservice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDetailConverter {
   public User toEntity(UserDetailRequest dto) {
      User user = new User();
//      user.setEmail(dto.getEmail());
//      user.setGender(dto.getGender());
//      user.setFullName((dto.getFullName()));
//      user.setDateOfBirth((dto.getDateOfBirth()));
//      user.setPhoneNumber((dto.getPhoneNumber()));
//      user.setRole(dto.getRole());
      return user;
   }


   public UserDetailResponse toDto(User entity) {
      UserDetailResponse dto = new UserDetailResponse();
      dto.setId(entity.getId());
      dto.setEmail(entity.getEmail());
      dto.setGender(entity.getGender());
      dto.setFullName(entity.getFullName());
      dto.setDateOfBirth((entity.getDateOfBirth()));
      dto.setPhoneNumber((entity.getPhoneNumber()));
//      dto.setRole(entity.getRole());
      return dto;
   }
}
