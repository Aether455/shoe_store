package com.nguyenkhang.mobile_store.mapper;

import org.mapstruct.Mapper;

import com.nguyenkhang.mobile_store.dto.response.InventoryTransactionResponse;
import com.nguyenkhang.mobile_store.entity.InventoryTransaction;

@Mapper(componentModel = "spring")
public interface InventoryTransactionMapper {
    InventoryTransactionResponse toInventoryTransactionResponse(InventoryTransaction inventoryTransaction);
}
