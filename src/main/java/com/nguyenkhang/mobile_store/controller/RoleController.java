package com.nguyenkhang.mobile_store.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.nguyenkhang.mobile_store.dto.ApiResponseDTO;
import com.nguyenkhang.mobile_store.dto.request.RoleRequest;
import com.nguyenkhang.mobile_store.dto.response.auth.RoleResponse;
import com.nguyenkhang.mobile_store.service.RoleService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleController {
    RoleService roleService;

    @PostMapping
    public ApiResponseDTO<RoleResponse> createRole(@RequestBody RoleRequest request) {
        return ApiResponseDTO.<RoleResponse>builder()
                .result(roleService.createRole(request))
                .message("Success!")
                .build();
    }

    @GetMapping
    ApiResponseDTO<List<RoleResponse>> getAll() {
        return ApiResponseDTO.<List<RoleResponse>>builder()
                .result(roleService.getAll())
                .build();
    }

    @DeleteMapping("/{role}")
    ApiResponseDTO<String> delete(@PathVariable String role) {
        roleService.delete(role);
        return ApiResponseDTO.<String>builder()
                .message("Success!")
                .result("Role has been deleted")
                .build();
    }
}
