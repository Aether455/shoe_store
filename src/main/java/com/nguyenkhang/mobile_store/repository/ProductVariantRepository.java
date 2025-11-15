package com.nguyenkhang.mobile_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyenkhang.mobile_store.entity.ProductVariant;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {}
