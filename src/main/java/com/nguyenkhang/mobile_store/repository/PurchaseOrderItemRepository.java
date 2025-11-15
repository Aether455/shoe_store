package com.nguyenkhang.mobile_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyenkhang.mobile_store.entity.PurchaseOrderItem;

@Repository
public interface PurchaseOrderItemRepository extends JpaRepository<PurchaseOrderItem, Long> {}
