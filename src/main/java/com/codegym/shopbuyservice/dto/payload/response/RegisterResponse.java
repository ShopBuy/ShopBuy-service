package com.codegym.shopbuyservice.dto.payload.response;

import com.codegym.shopbuyservice.dto.UserDto;
import lombok.Data;

@Data
public class RegisterResponse {
    private UserDto data;
    private String message;
    private int statusCode;
}
