package com.nguyenkhang.mobile_store.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyenkhang.mobile_store.entity.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    Page<Product> findAllByCategoryId(long categoryId, Pageable pageable);

    Page<Product> findAllByBrandId(long brandId, Pageable pageable);
}
