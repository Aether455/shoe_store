package com.nguyenkhang.mobile_store.dto.response;

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
public class SimplePurchaseOrderResponse {

    Long id;

    SupplierResponse supplier;

    WarehouseResponse warehouse;

    double totalAmount;

    SimpleUserResponse createBy;

    LocalDateTime createAt;
}
