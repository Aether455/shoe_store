package com.nguyenkhang.shoe_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyenkhang.shoe_store.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {}
