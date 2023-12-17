package com.codegym.shopbuyservice.dto.payload.resquest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public class UserResquest {
    @Email(message = "Email should be valid")
    private String email;
    private String password;
}
