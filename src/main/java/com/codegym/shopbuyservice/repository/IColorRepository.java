package com.codegym.shopbuyservice.repository;

import com.codegym.shopbuyservice.entity.Category;
import com.codegym.shopbuyservice.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IColorRepository extends JpaRepository<Color,Long> {
}
