package com.codegym.shopbuyservice.dto;

import lombok.Data;

import java.util.Date;
@Data
public class UserDto {
    private Long id ;
    private String username;
    private String password;
    private String email;
    private String gender;
    private String fullName;
    private Date dateOfBirth;
}
