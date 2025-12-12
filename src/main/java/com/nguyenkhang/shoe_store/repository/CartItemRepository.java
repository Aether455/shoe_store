package com.nguyenkhang.shoe_store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyenkhang.shoe_store.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByCartIdAndProductVariantId(long cartId, long productVariantId);

    void deleteAllByCartId(long cartId);
}
