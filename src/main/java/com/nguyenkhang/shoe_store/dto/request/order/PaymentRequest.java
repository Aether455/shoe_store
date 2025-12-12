package com.nguyenkhang.shoe_store.dto.request.order;

import com.nguyenkhang.shoe_store.enums.PaymentMethod;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentRequest {
    PaymentMethod method;
}
