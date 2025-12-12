package com.nguyenkhang.shoe_store.mapper;

import org.mapstruct.Mapper;

import com.nguyenkhang.shoe_store.dto.response.purchase_order.PurchaseOrderResponse;
import com.nguyenkhang.shoe_store.dto.response.purchase_order.SimplePurchaseOrderResponse;
import com.nguyenkhang.shoe_store.entity.PurchaseOrder;

@Mapper(componentModel = "spring")
public interface PurchaseOrderMapper {
    PurchaseOrderResponse toPurchaseOrderResponse(PurchaseOrder purchaseOrder);

    SimplePurchaseOrderResponse toSimplePurchaseOrderResponse(PurchaseOrder purchaseOrder);
}
