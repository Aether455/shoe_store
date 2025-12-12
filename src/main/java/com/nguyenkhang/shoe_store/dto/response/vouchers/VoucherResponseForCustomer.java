package com.nguyenkhang.shoe_store.dto.response.vouchers;

import java.time.LocalDateTime;

import com.nguyenkhang.shoe_store.enums.VoucherStatus;
import com.nguyenkhang.shoe_store.enums.VoucherType;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VoucherResponseForCustomer {

    String id;
    String name;
    String voucherCode;

    VoucherType type;
    VoucherStatus status;

    double discountValue;

    double minApplicablePrice;
    double maxDiscountAmount;

    LocalDateTime startDate;
    LocalDateTime endDate;
}
