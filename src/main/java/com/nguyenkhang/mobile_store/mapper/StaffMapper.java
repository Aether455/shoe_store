package com.nguyenkhang.mobile_store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.nguyenkhang.mobile_store.dto.request.staff.StaffRequest;
import com.nguyenkhang.mobile_store.dto.request.staff.StaffUpdateRequest;
import com.nguyenkhang.mobile_store.dto.response.staff.StaffResponse;
import com.nguyenkhang.mobile_store.entity.Staff;

@Mapper(componentModel = "spring")
public interface StaffMapper {

    Staff toStaff(StaffRequest request);

    StaffResponse toStaffResponse(Staff staff);

    void updateStaff(@MappingTarget Staff staff, StaffUpdateRequest request);
}
