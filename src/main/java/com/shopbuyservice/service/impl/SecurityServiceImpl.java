package com.shopbuyservice.service.impl;

import com.shopbuyservice.security.JwtTokenProvider;
import com.shopbuyservice.service.SecurityService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

public class SecurityServiceImpl implements SecurityService {
    private JwtTokenProvider jwtTokenProvider;

    public SecurityServiceImpl(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public SecurityServiceImpl() {
    }

    @Override
    public boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null
                || AnonymousAuthenticationToken.class.isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }

    @Override
    public boolean isValidToken(String authToken) {
        String jwt = jwtTokenProvider.getJwtFromBearerToken(authToken);
        if (StringUtils.hasText(jwt) && jwtTokenProvider.validateToken(authToken)) {
            return true;
        }
        return false;
    }
}
