package com.nguyenkhang.mobile_store.mapper;

import org.mapstruct.Mapper;

import com.nguyenkhang.mobile_store.dto.response.inventory.InventoryResponse;
import com.nguyenkhang.mobile_store.entity.Inventory;

@Mapper(componentModel = "spring")
public interface InventoryMapper {
    InventoryResponse toInventoryResponse(Inventory inventory);
}
