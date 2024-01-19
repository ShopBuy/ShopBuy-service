package com.codegym.shopbuyservice.repository;


import com.codegym.shopbuyservice.entity.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVariantRepository extends JpaRepository<Variant,Long> {
}
