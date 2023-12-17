package com.codegym.shopbuyservice.dto.payload.request;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginResquest {
    @Email(message = "Email should be valid")
    private String email;
    private String password;
}
