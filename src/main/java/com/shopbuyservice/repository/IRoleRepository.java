package com.shopbuyservice.repository;

import com.shopbuyservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IRoleRepository extends JpaRepository<Role, Long> {

}
