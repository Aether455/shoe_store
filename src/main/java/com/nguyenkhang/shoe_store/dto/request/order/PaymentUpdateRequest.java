package com.nguyenkhang.shoe_store.dto.request.order;

import com.nguyenkhang.shoe_store.enums.PaymentStatus;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentUpdateRequest {
    PaymentStatus status;
}
