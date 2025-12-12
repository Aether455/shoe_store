package com.nguyenkhang.shoe_store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.nguyenkhang.shoe_store.entity.Voucher;

public interface VoucherRepository extends JpaRepository<Voucher, Long>, JpaSpecificationExecutor<Voucher> {
    Optional<Voucher> findByVoucherCode(String voucherCode);
}
