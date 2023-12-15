package com.codegym.shopbuyservice.service.impl;

import com.codegym.shopbuyservice.converter.IUserConverter;
import com.codegym.shopbuyservice.dto.UserDto;
import com.codegym.shopbuyservice.dto.payload.request.RegisterRequest;
import com.codegym.shopbuyservice.dto.payload.response.RegisterResponse;
import com.codegym.shopbuyservice.entity.User;
import com.codegym.shopbuyservice.repository.IUserRepository;
import com.codegym.shopbuyservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IUserConverter iUserConverter;
    @Override
    public RegisterResponse registerUser(RegisterRequest request) {
        try {
            User newUser = iUserConverter.convertToEntity(request);
            newUser.setPassword(request.getPassword());
            iUserRepository.save(newUser);
            UserDto userDto = iUserConverter.convertToDto(newUser);
            RegisterResponse response = new RegisterResponse();
            response.setData(userDto);
            response.setMessage("Registration successful!");
            response.setStatusCode(HttpStatus.OK.value());
            return response;
        } catch (DataAccessException e) {
            RegisterResponse response = new RegisterResponse();
            response.setMessage("Error during registration: " + e.getMessage());
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return response;
        } catch (Exception e) {
            RegisterResponse response = new RegisterResponse();
            response.setMessage("An unknown error occurred: " + e.getMessage());
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return response;
        }
    }
}
