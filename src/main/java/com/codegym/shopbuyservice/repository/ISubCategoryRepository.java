package com.codegym.shopbuyservice.repository;


import com.codegym.shopbuyservice.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubCategoryRepository extends JpaRepository<SubCategory,Long> {
}
