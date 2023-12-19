package com.codegym.shopbuyservice.service.impl;

import com.codegym.shopbuyservice.entity.Role;
import com.codegym.shopbuyservice.repository.IRoleRepository;
import com.codegym.shopbuyservice.service.IRoleService;
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
