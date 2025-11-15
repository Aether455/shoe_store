package com.nguyenkhang.mobile_store.dto.response.order;

import java.time.LocalDateTime;

import com.nguyenkhang.mobile_store.dto.response.user.SimpleUserResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimpleOrderResponse {

    Long id;

    String orderCode;

    String phoneNumber;

    String shippingAddress;

    String status;

    String note;

    String receiverName;

    double reducedAmount;

    double totalAmount;

    double finalAmount;

    LocalDateTime createAt;
    LocalDateTime updateAt;
    SimpleUserResponse createBy;
    SimpleUserResponse updateBy;
}
