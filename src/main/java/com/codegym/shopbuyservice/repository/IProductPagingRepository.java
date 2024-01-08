package com.codegym.shopbuyservice.repository;

import com.codegym.shopbuyservice.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductPagingRepository extends PagingAndSortingRepository<Product,Long> {
    Page<Product> findAll(Pageable pageable);
}
