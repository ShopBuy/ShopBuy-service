package com.codegym.shopbuyservice.repository;


import com.codegym.shopbuyservice.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISubCategoryRepository extends JpaRepository<SubCategory,Long> {
   List<SubCategory> findSubCategoryByCategoryId(long categoryId);
}
