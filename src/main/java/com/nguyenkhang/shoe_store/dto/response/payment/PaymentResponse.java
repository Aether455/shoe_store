package com.nguyenkhang.shoe_store.dto.response.payment;

import java.time.LocalDateTime;

import com.nguyenkhang.shoe_store.enums.PaymentMethod;
import com.nguyenkhang.shoe_store.enums.PaymentStatus;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentResponse {

    Long id;

    double amount;

    PaymentMethod method;

    PaymentStatus status;

    LocalDateTime createAt;
}
