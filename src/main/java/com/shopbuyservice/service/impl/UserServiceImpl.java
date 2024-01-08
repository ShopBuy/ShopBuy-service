package com.shopbuyservice.service.impl;

import com.shopbuyservice.converter.IUserConverter;
import com.shopbuyservice.converter.ipml.UserDetailConverter;
import com.shopbuyservice.dto.UserDto;
import com.shopbuyservice.dto.payload.request.LoginResquest;
import com.shopbuyservice.dto.payload.request.RegisterRequest;
import com.shopbuyservice.dto.payload.response.RegisterResponse;
import com.shopbuyservice.dto.payload.response.UserDetailResponse;
import com.shopbuyservice.entity.Role;
import com.shopbuyservice.entity.User;
import com.shopbuyservice.repository.IRoleRepository;
import com.shopbuyservice.repository.IUserRepository;
import com.shopbuyservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
   private UserDetailConverter userDetailConverter;

   @Override
   public RegisterResponse registerUser(RegisterRequest request, Long id) {
      try {
         User newUser = iUserConverter.convertToEntity(request);
         String encodedPassword = passwordEncoder.encode(request.getPassword());
         newUser.setPassword(encodedPassword);
         //có thể tinh chỉnh role để thêm chức năng register theo role
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
   public UserDetailResponse getUserByEmail(String email) throws Exception {
      User user = iUserRepository.findUserByEmail(email);
      if (user == null) {
         throw new Exception("User not found");
      }
      return userDetailConverter.toDto(user);
   }
}
