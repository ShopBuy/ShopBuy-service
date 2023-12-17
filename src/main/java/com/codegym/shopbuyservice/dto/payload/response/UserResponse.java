package com.codegym.shopbuyservice.dto.payload.response;

import com.codegym.shopbuyservice.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {
    private UserDto data;
    private int statusCode;
    private String message;
}
