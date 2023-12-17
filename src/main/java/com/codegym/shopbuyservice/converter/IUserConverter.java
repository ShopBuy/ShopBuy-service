package com.codegym.shopbuyservice.converter;

import com.codegym.shopbuyservice.dto.UserDto;
import com.codegym.shopbuyservice.dto.payload.request.RegisterRequest;
import com.codegym.shopbuyservice.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface IUserConverter {
    UserDto convertToDto(User user);
    User convertToEntity(RegisterRequest request);
}
