package com.codegym.shopbuyservice.dto;

import lombok.Data;

import java.util.Date;
@Data
public class UserDto {
    private String email;
    private String password;
    private String fullName;
    private String phoneNumber;
    private Date dateOfBirth;
}
