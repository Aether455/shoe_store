package com.nguyenkhang.shoe_store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.nguyenkhang.shoe_store.dto.request.staff.StaffRequest;
import com.nguyenkhang.shoe_store.dto.request.staff.StaffUpdateRequest;
import com.nguyenkhang.shoe_store.dto.response.staff.StaffResponse;
import com.nguyenkhang.shoe_store.entity.Staff;

@Mapper(componentModel = "spring")
public interface StaffMapper {

    Staff toStaff(StaffRequest request);

    StaffResponse toStaffResponse(Staff staff);

    void updateStaff(@MappingTarget Staff staff, StaffUpdateRequest request);
}
