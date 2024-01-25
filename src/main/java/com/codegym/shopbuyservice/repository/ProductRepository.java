package com.codegym.shopbuyservice.repository;

import com.codegym.shopbuyservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

//   List<Product> findProductByCategoryId(long categoryId);

   List<Product> findProductBySubCategoryId(long subCategoryId);

}
