package com.nguyenkhang.shoe_store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyenkhang.shoe_store.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUserId(long userId);
}
