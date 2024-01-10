package com.codegym.shopbuyservice.dto;

import com.codegym.shopbuyservice.entity.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {
    private Long id;
    private String email;
    private String fullName ;
    private String token;
    private long roleId;
}

