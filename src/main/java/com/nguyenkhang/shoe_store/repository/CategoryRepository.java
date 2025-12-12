package com.nguyenkhang.shoe_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyenkhang.shoe_store.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {}
