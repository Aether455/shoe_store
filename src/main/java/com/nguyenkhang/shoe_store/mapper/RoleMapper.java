package com.nguyenkhang.shoe_store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.nguyenkhang.shoe_store.dto.request.RoleRequest;
import com.nguyenkhang.shoe_store.dto.response.auth.RoleResponse;
import com.nguyenkhang.shoe_store.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "createAt", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
