package com.nguyenkhang.mobile_store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.nguyenkhang.mobile_store.dto.request.supplier.SupplierRequest;
import com.nguyenkhang.mobile_store.dto.response.supplier.SupplierResponse;
import com.nguyenkhang.mobile_store.entity.Supplier;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    Supplier toSupplier(SupplierRequest request);

    SupplierResponse toSupplierResponse(Supplier supplier);

    void update(@MappingTarget Supplier supplier, SupplierRequest request);
}
