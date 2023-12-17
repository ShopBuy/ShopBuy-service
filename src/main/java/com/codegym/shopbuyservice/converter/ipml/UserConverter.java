package com.codegym.shopbuyservice.converter.ipml;

import com.codegym.shopbuyservice.converter.IUserConverter;
import com.codegym.shopbuyservice.dto.UserDto;
import com.codegym.shopbuyservice.dto.payload.request.RegisterRequest;
import com.codegym.shopbuyservice.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
@Component
public class UserConverter implements IUserConverter {

    @Override
    public UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }
    @Override
    public User convertToEntity(RegisterRequest request) {
        User user = new User();
        BeanUtils.copyProperties(request,user);
        return user;
    }
}
