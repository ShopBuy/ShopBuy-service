package com.codegym.shopbuyservice.repository;

import com.codegym.shopbuyservice.entity.Product;
import com.codegym.shopbuyservice.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product,Long > {
  Product findProductByName (String name);
  Optional<Product> findProductById(Long id);
  List<Product> findProductBySubCategoryAndId (SubCategory subCategory, long id );
}
