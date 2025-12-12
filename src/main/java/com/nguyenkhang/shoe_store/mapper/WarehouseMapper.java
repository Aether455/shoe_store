package com.nguyenkhang.shoe_store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.nguyenkhang.shoe_store.dto.request.warehouse.WarehouseRequest;
import com.nguyenkhang.shoe_store.dto.response.warehouse.WarehouseResponse;
import com.nguyenkhang.shoe_store.entity.Warehouse;

@Mapper(componentModel = "spring")
public interface WarehouseMapper {
    Warehouse toWarehouse(WarehouseRequest request);

    WarehouseResponse toWarehouseResponse(Warehouse warehouse);

    void update(@MappingTarget Warehouse warehouse, WarehouseRequest request);
}
