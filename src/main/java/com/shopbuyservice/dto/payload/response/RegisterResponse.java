package com.shopbuyservice.dto.payload.response;

import com.shopbuyservice.dto.UserDto;
import lombok.Data;

@Data
public class RegisterResponse {
    private UserDto data;
    private String message;
    private int statusCode;
}
