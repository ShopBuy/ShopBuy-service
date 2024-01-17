package com.codegym.shopbuyservice.service;

import com.codegym.shopbuyservice.dto.UserDto;
import com.codegym.shopbuyservice.dto.payload.request.LoginGoogleRequest;
import com.codegym.shopbuyservice.dto.payload.request.LoginResquest;
import com.codegym.shopbuyservice.dto.payload.request.RegisterRequest;
import com.codegym.shopbuyservice.dto.payload.request.UserDetailRequest;
import com.codegym.shopbuyservice.dto.payload.response.RegisterResponse;
import com.codegym.shopbuyservice.dto.payload.response.UserDetailResponse;

public interface IUserService {
   RegisterResponse registerUser(RegisterRequest request, Long Id);

   UserDto login(LoginResquest loginRequest);

   UserDto loginGoogle(LoginGoogleRequest loginGoogleRequest);

   UserDetailResponse getUserByEmail(String email) throws Exception;

   UserDetailResponse updateUserByEmail(String email,
                                        UserDetailRequest userDetailRequest) throws Exception;
}
