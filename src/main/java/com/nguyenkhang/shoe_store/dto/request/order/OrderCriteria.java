package com.nguyenkhang.shoe_store.dto.request.order;

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
public class OrderCriteria {
    String keyword;

    OrderStatus status;

    Double minFinalAmount;
    Double maxFinalAmount;

    LocalDateTime createAtBegin;
    LocalDateTime createAtEnd;
}
