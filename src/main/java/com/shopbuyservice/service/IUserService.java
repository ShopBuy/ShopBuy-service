package com.shopbuyservice.service;

import com.shopbuyservice.dto.UserDto;
import com.shopbuyservice.dto.payload.request.LoginResquest;
import com.shopbuyservice.dto.payload.request.RegisterRequest;
import com.shopbuyservice.dto.payload.response.RegisterResponse;
import com.shopbuyservice.dto.payload.response.UserDetailResponse;

public interface IUserService {
    RegisterResponse registerUser(RegisterRequest request,Long Id) ;

    UserDto login(LoginResquest loginRequest);

    UserDetailResponse getUserByEmail(String email) throws Exception;

}
