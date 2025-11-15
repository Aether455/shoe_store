package com.nguyenkhang.mobile_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.nguyenkhang.mobile_store.entity.InventoryTransaction;

public interface InventoryTransactionRepository
        extends JpaRepository<InventoryTransaction, Long>, JpaSpecificationExecutor<InventoryTransaction> {}
