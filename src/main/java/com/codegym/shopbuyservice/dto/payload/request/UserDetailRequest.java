package com.codegym.shopbuyservice.dto.payload.request;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
public class UserDetailRequest {
   @NotBlank(message = "Gender is required")    //loại cả khoảng trắng (NotEmpty)
   private String gender;

   @NotBlank(message = "Full name is required")
   @Size(min = 5, message = "Full name must be at least 5 characters")
   @Pattern(regexp = "^[^\\d]+$", message = "Full name must not contain numbers")
   private String fullName;

   @NotNull(message = "Date of birth is required")
   @Past(message = "Date of birth must be in the past")
   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
   private Date dateOfBirth;

   @NotBlank(message = "Phone number is required")
   @Pattern(regexp = "^\\d{10}$", message = "Phone number must be a 10-digit number")
   private String phoneNumber;

   private String profileImageUrl;
}
