package com.codegym.shopbuyservice.repository;

import com.codegym.shopbuyservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long > {

}
