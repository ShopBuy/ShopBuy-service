package com.codegym.shopbuyservice.service;

import com.codegym.shopbuyservice.dto.payload.request.RegisterRequest;
import com.codegym.shopbuyservice.dto.payload.response.RegisterResponse;

public interface IUserService {
    RegisterResponse registerUser(RegisterRequest request) ;
}
