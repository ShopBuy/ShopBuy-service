package com.shopbuyservice.converter;

import com.shopbuyservice.dto.UserDto;
import com.shopbuyservice.dto.payload.request.RegisterRequest;
import com.shopbuyservice.entity.User;

public interface IUserConverter {
    UserDto convertToDto(User user);
    User convertToEntity(RegisterRequest request);
}
