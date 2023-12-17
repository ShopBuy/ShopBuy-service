package com.codegym.shopbuyservice.repository;

import com.codegym.shopbuyservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {
}
