package com.codegym.shopbuyservice.dto.payload.request;

import com.codegym.shopbuyservice.entity.Role;
import lombok.*;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterRequest {
    private String email;
    private String password;
    private String gender;
    private String phoneNumber;
    private String fullName;
    private Date dateOfBirth;
}
