package com.shopbuyservice.repository;

import com.shopbuyservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long > {

}
