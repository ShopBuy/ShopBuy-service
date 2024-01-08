package com.shopbuyservice.converter.ipml;

import com.shopbuyservice.converter.IUserConverter;
import com.shopbuyservice.dto.UserDto;
import com.shopbuyservice.dto.payload.request.RegisterRequest;
import com.shopbuyservice.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
@Component
public class UserConverter implements IUserConverter {

    @Override
    public UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);
        userDto.setRoleId(user.getRole().getId());
        return userDto;
    }
    @Override
    public User convertToEntity(RegisterRequest request) {
        User user = new User();
        BeanUtils.copyProperties(request,user);
        return user;
    }
}
