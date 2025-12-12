package com.nguyenkhang.shoe_store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.nguyenkhang.shoe_store.dto.request.supplier.SupplierRequest;
import com.nguyenkhang.shoe_store.dto.response.supplier.SupplierResponse;
import com.nguyenkhang.shoe_store.entity.Supplier;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    Supplier toSupplier(SupplierRequest request);

    SupplierResponse toSupplierResponse(Supplier supplier);

    void update(@MappingTarget Supplier supplier, SupplierRequest request);
}
