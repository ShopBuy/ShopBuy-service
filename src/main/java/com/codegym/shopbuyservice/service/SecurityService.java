package com.codegym.shopbuyservice.service;

public interface SecurityService {
    boolean isAuthenticated();
    boolean isValidToken(String token);
}
