package com.nguyenkhang.mobile_store.dto.response.payment;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import com.nguyenkhang.mobile_store.enums.PaymentMethod;
import com.nguyenkhang.mobile_store.enums.PaymentStatus;

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
