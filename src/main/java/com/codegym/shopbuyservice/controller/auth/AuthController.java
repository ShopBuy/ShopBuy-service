package com.codegym.shopbuyservice.controller.auth;

import com.codegym.shopbuyservice.dto.UserDto;
import com.codegym.shopbuyservice.dto.payload.request.LoginResquest;
import com.codegym.shopbuyservice.dto.payload.request.RegisterRequest;
import com.codegym.shopbuyservice.dto.payload.response.LoginResponse;
import com.codegym.shopbuyservice.dto.payload.response.RegisterResponse;
import com.codegym.shopbuyservice.security.JwtTokenProvider;
import com.codegym.shopbuyservice.service.IUserService;
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
    private IUserService iUserService;
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> registerUser(@RequestBody RegisterRequest request) {
        try{
            RegisterResponse response = iUserService.registerUser(request,1L);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (Exception e){
            RegisterResponse Response = new RegisterResponse();
           Response.setMessage("Lỗi" + e);
            return ResponseEntity.ok(Response);
        }}
    @PostMapping("/login")
    public ResponseEntity<?> Login(@Validated @RequestBody LoginResquest loginRequest) {
        try{
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = tokenProvider.generateToken(authentication);
            UserDto userDto = iUserService.login(loginRequest);
            LoginResponse loginResponse = new LoginResponse();
            userDto.setToken(token);
            loginResponse.setData(userDto);
            loginResponse.setStatusCode(200);
            loginResponse.setMessage("login success");
            return ResponseEntity.ok(loginResponse);
        }catch (Exception ex) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setMessage("Lỗi" + ex);
            return ResponseEntity.ok(loginResponse);
        }
    }
}
