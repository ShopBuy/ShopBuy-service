package com.codegym.shopbuyservice.repository;

import com.codegym.shopbuyservice.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISizeRepository extends JpaRepository<Size, Long> {
}
