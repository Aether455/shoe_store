package com.nguyenkhang.mobile_store.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.nguyenkhang.mobile_store.dto.ApiResponseDTO;
import com.nguyenkhang.mobile_store.dto.request.StaffRequest;
import com.nguyenkhang.mobile_store.dto.request.StaffUpdateRequest;
import com.nguyenkhang.mobile_store.dto.response.StaffResponse;
import com.nguyenkhang.mobile_store.service.StaffService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/staffs")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class StaffController {
    StaffService staffService;

    @PostMapping // bỏ qua
    public ApiResponseDTO<StaffResponse> create(@RequestBody StaffRequest request) {
        var response = staffService.create(request);
        return ApiResponseDTO.<StaffResponse>builder().result(response).build();
    }

    @GetMapping
    public ApiResponseDTO<Page<StaffResponse>> getStaffs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        var response = staffService.getStaffs(page, size, sortBy);
        return ApiResponseDTO.<Page<StaffResponse>>builder().result(response).build();
    }

    @GetMapping("/{staffId}")
    public ApiResponseDTO<StaffResponse> getById(@PathVariable long staffId) {
        var response = staffService.getStaffById(staffId);
        return ApiResponseDTO.<StaffResponse>builder().result(response).build();
    }

    @PutMapping("/{staffId}")
    public ApiResponseDTO<StaffResponse> update(@PathVariable long staffId, @RequestBody StaffUpdateRequest request) {
        var response = staffService.update(staffId, request);
        return ApiResponseDTO.<StaffResponse>builder().result(response).build();
    }

    @DeleteMapping("/{staffId}")
    public ApiResponseDTO<String> delete(@PathVariable long staffId) {
        staffService.delete(staffId);
        return ApiResponseDTO.<String>builder().result("Staff has been deleted").build();
    }

    @GetMapping("/search")
    public ApiResponseDTO<Page<StaffResponse>> searchStaffs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam String keyword) {
        return ApiResponseDTO.<Page<StaffResponse>>builder()
                .result(staffService.searchStaffs(keyword, page, size))
                .build();
    }
}
