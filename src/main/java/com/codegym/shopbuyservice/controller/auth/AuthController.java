package com.codegym.shopbuyservice.controller.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")

public class AuthController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResponseEntity<?> Login(@Validated @RequestBody LoginRequest loginRequest) {
        try{
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = tokenProvider.generateToken(authentication);
//            String name  = userService.login(loginRequest);
            UserDto userDto = userService.login(loginRequest);
            LoginResponse loginResponse = new LoginResponse();
//            UserDto userDto = new UserDto();
//            userDto.setId(userDto.getId());
//            userDto.setEmail(SecurityContextHolder.getContext().getAuthentication().getName());
            userDto.setToken(token);
//            userDto.setName(userDto.getName());
//            userDto.setMember(userDto.isMember());
            loginResponse.setData(userDto);
            loginResponse.setStatusCode(200);
            loginResponse.setMessage("login success");
            return ResponseEntity.ok(loginResponse);
        }catch (Exception ex) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setMessage("Lỗi");
            return ResponseEntity.ok(loginResponse);
        }
    }
}
