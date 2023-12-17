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
//        if (user == null) {
//            return null;
//        }
//        UserDto userDTO = new UserDto();
//       BeanUtils.copyProperties(user, userDTO);
//        userDTO.setId(user.getId());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setName(user.getFullName());
//        userDTO.setRole(user.getRole());
//        return userDTO;
    }
    @Override
    public User convertToEntity(RegisterRequest request) {
        User user = new User();
        BeanUtils.copyProperties(request,user);
        return user;
    }
}
