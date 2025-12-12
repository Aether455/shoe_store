package com.nguyenkhang.shoe_store.dto.response.order;

import java.time.LocalDateTime;

import com.nguyenkhang.shoe_store.enums.OrderStatus;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimpleOrderResponseForCustomer {

    Long id;

    String orderCode;

    String phoneNumber;

    String shippingAddress;
    String province;
    String district;
    String ward;
    OrderStatus status;

    String note;

    String receiverName;

    double reducedAmount;

    double totalAmount;

    double finalAmount;

    LocalDateTime createAt;
}
