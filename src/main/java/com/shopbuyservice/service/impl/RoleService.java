package com.shopbuyservice.service.impl;

import com.shopbuyservice.entity.Role;
import com.shopbuyservice.repository.IRoleRepository;
import com.shopbuyservice.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service


public class RoleService implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;
    @Override
    public Role findRoleById(Long roleId) {
        return roleRepository.findById(roleId).orElse(null);
    }
}
