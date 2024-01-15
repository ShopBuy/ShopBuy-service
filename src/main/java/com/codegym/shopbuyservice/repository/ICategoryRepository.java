package com.codegym.shopbuyservice.repository;

import com.codegym.shopbuyservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Long > {
}
