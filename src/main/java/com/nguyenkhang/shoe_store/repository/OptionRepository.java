package com.nguyenkhang.shoe_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyenkhang.shoe_store.entity.Option;

public interface OptionRepository extends JpaRepository<Option, Long> {
    boolean existsByName(String name);
}
