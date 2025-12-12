package com.nguyenkhang.shoe_store.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.nguyenkhang.shoe_store.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    Page<Product> findAllByCategoryId(long categoryId, Pageable pageable);

    Page<Product> findAllByBrandId(long brandId, Pageable pageable);
}
