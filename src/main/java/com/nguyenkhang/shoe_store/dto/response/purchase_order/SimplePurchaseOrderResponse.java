package com.nguyenkhang.shoe_store.dto.response.purchase_order;

import java.time.LocalDateTime;

import com.nguyenkhang.shoe_store.dto.response.supplier.SimpleSupplierResponse;
import com.nguyenkhang.shoe_store.dto.response.user.SimpleUserResponse;
import com.nguyenkhang.shoe_store.dto.response.warehouse.SimpleWarehouseResponse;
import com.nguyenkhang.shoe_store.enums.PurchaseOrderStatus;

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

    SimpleSupplierResponse supplier;

    SimpleWarehouseResponse warehouse;

    PurchaseOrderStatus status;
    double totalAmount;

    SimpleUserResponse createBy;

    LocalDateTime createAt;
}
