package com.nguyenkhang.mobile_store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.nguyenkhang.mobile_store.dto.request.AddressRequest;
import com.nguyenkhang.mobile_store.dto.response.AddressResponse;
import com.nguyenkhang.mobile_store.entity.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toAddress(AddressRequest request);

    AddressResponse toAddressResponse(Address address);

    @Mapping(target = "customer", ignore = true)
    void updateAddress(@MappingTarget Address address, AddressRequest request);
}
