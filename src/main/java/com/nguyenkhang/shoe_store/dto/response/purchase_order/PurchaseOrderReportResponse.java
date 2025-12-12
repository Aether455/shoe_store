package com.nguyenkhang.shoe_store.dto.response.purchase_order;

import java.math.BigDecimal;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PurchaseOrderReportResponse {
    String label;
    BigDecimal totalAmount;
    Long orderCount;
}
