package com.nguyenkhang.shoe_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyenkhang.shoe_store.entity.ProductVariant;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {}
