package com.codegym.shopbuyservice.dto.payload.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

@Data
public class UserDetailRequest {
   private String email;
   private String gender;
   private String fullName;
   private Date dateOfBirth;
   private String phoneNumber;
   private String role;
   private String profileImageUrl;
}
