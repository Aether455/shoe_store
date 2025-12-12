package com.nguyenkhang.shoe_store.mapper;

import org.mapstruct.Mapper;

import com.nguyenkhang.shoe_store.dto.response.inventory.InventoryResponse;
import com.nguyenkhang.shoe_store.entity.Inventory;

@Mapper(componentModel = "spring")
public interface InventoryMapper {
    InventoryResponse toInventoryResponse(Inventory inventory);
}
