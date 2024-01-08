package com.shopbuyservice.service;

public interface SecurityService {
    boolean isAuthenticated();
    boolean isValidToken(String token);
}
