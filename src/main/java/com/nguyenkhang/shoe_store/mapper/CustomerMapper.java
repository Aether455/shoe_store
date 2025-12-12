package com.nguyenkhang.shoe_store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.nguyenkhang.shoe_store.dto.request.customer.CustomerCreationRequest;
import com.nguyenkhang.shoe_store.dto.request.customer.CustomerUpdateRequest;
import com.nguyenkhang.shoe_store.dto.response.customer.CustomerResponse;
import com.nguyenkhang.shoe_store.dto.response.customer.CustomerResponseForUser;
import com.nguyenkhang.shoe_store.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "addresses", ignore = true)
    Customer toCustomer(CustomerCreationRequest request);

    CustomerResponse toCustomerResponse(Customer customer);

    CustomerResponseForUser toCustomerResponseForUser(Customer customer);

    void updateCustomer(@MappingTarget Customer customer, CustomerUpdateRequest request);
}
