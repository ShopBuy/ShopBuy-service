package com.shopbuyservice.repository;

import com.shopbuyservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    User findUserByEmail(String email);
}
