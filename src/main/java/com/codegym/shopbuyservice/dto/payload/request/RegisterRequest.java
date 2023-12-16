package com.codegym.shopbuyservice.dto.payload.request;

import lombok.Data;

import java.util.Date;
@Data

public class RegisterRequest {
    private String email;
    private String password;
    private String gender;
    private String phoneNumber;
    private String fullName;
    private Date dateOfBirth;
}
