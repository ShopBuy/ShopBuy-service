package com.codegym.shopbuyservice.service.impl;

import com.codegym.shopbuyservice.converter.IUserConverter;
import com.codegym.shopbuyservice.converter.ipml.UserDetailConverter;
import com.codegym.shopbuyservice.dto.UserDto;
import com.codegym.shopbuyservice.dto.payload.request.LoginGoogleRequest;
import com.codegym.shopbuyservice.dto.payload.request.LoginResquest;
import com.codegym.shopbuyservice.dto.payload.request.RegisterRequest;
import com.codegym.shopbuyservice.dto.payload.request.UserDetailRequest;
import com.codegym.shopbuyservice.dto.payload.response.RegisterResponse;
import com.codegym.shopbuyservice.dto.payload.response.UserDetailResponse;
import com.codegym.shopbuyservice.entity.Role;
import com.codegym.shopbuyservice.entity.User;
import com.codegym.shopbuyservice.repository.IRoleRepository;
import com.codegym.shopbuyservice.repository.IUserRepository;
import com.codegym.shopbuyservice.security.JwtTokenProvider;
import com.codegym.shopbuyservice.service.IUserService;
import com.google.api.client.http.HttpTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.headers.HttpStrictTransportSecurityDsl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.util.Collections;


@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IUserConverter iUserConverter;
    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private UserDetailConverter userDetailConverter;

    @Override
    public RegisterResponse registerUser(RegisterRequest request, Long id) {
        try {
            User newUser = iUserConverter.convertToEntity(request);
            String encodedPassword = passwordEncoder.encode(request.getPassword());
            newUser.setPassword(encodedPassword);

            Role role = roleRepository.findById(2L).orElse(null);
            newUser.setRole(role);
            iUserRepository.save(newUser);

            UserDto userDto = iUserConverter.convertToDto(newUser);
            userDto.setRoleId(role.getId());

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

    @Override
    public UserDto login(LoginResquest loginRequest) {
        User user = iUserRepository.findUserByEmail(loginRequest.getEmail());
        return iUserConverter.convertToDto(user);
    }

    @Override
    public UserDto loginGoogle(LoginGoogleRequest loginGoogleRequest) {
        UserDto userDto = null;
        HttpTransport transport = new NetHttpTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList("888292015768-rbgpdu4t3nelm7rbr1s6loubq4h9uaqf.apps.googleusercontent.com"))
                .build();
        try {
            GoogleIdToken idToken = verifier.verify(loginGoogleRequest.getCredential());
            if (idToken != null) {
                GoogleIdToken.Payload payload = idToken.getPayload();
                String email = payload.getEmail();
                String name = (String) payload.get("name");
                User user = iUserRepository.findUserByEmail(email);

                if (user == null) {
                    Role role = roleRepository.findById(2L).orElseThrow(() -> new RuntimeException("Role not found"));
                    user = User.builder()
                            .email(email)
                            .fullName(name)
                            .role(role)

                            .build();
                    iUserRepository.save(user);
                }

                String token = jwtTokenProvider.generateToken(email);
                userDto = iUserConverter.convertToDto(user);
                userDto.setToken(token);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDto;
    }

    @Override
    public UserDetailResponse getUserByEmail(String email) throws Exception {
        User user = iUserRepository.findUserByEmail(email);
        if (user == null) {
            throw new Exception("User not found");
        }
        return userDetailConverter.toDto(user);
    }

    @Override
    public UserDetailResponse updateUserByEmail(String email, UserDetailRequest userDetailRequest) throws Exception {
        User currentUser = iUserRepository.findUserByEmail(email);
        if (currentUser == null) {
            throw new Exception("User not found");
        }
        currentUser.setFullName(userDetailRequest.getFullName());
        currentUser.setDateOfBirth(userDetailRequest.getDateOfBirth());
        currentUser.setGender(userDetailRequest.getGender());
        currentUser.setPhoneNumber(userDetailRequest.getPhoneNumber());

        User user = iUserRepository.save(currentUser);
        UserDetailResponse response = userDetailConverter.toDto(user);
        return response;
    }
}
