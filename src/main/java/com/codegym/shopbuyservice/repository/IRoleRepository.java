package com.codegym.shopbuyservice.repository;

import com.codegym.shopbuyservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface IRoleRepository extends JpaRepository<Role, Long> {

}
