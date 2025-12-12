package com.nguyenkhang.shoe_store.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.nguyenkhang.shoe_store.enums.VoucherStatus;
import com.nguyenkhang.shoe_store.enums.VoucherType;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Long id;

    String name;

    @Column(unique = true)
    String voucherCode;

    @Enumerated(value = EnumType.STRING)
    VoucherType type;

    @Enumerated(value = EnumType.STRING)
    VoucherStatus status;

    double discountValue;

    double minApplicablePrice;
    double maxDiscountAmount;

    LocalDateTime startDate;
    LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "create_by")
    User createBy;

    @ManyToOne
    @JoinColumn(name = "update_by")
    User updateBy;

    @CreationTimestamp
    LocalDateTime createAt;

    @UpdateTimestamp
    LocalDateTime updateAt;
}
