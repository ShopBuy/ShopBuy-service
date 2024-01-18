package com.codegym.shopbuyservice.repository;

import com.codegym.shopbuyservice.entity.Product;
import com.codegym.shopbuyservice.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductsListRepository extends JpaRepository<Product,Long> {

}
