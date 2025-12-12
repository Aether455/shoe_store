package com.nguyenkhang.shoe_store.mapper;

import org.mapstruct.Mapper;

import com.nguyenkhang.shoe_store.dto.response.inventory.InventoryTransactionResponse;
import com.nguyenkhang.shoe_store.entity.InventoryTransaction;

@Mapper(componentModel = "spring")
public interface InventoryTransactionMapper {
    InventoryTransactionResponse toInventoryTransactionResponse(InventoryTransaction inventoryTransaction);
}
