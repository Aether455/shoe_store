package com.nguyenkhang.mobile_store.controller;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.nguyenkhang.mobile_store.dto.ApiResponseDTO;
import com.nguyenkhang.mobile_store.dto.request.SupplierRequest;
import com.nguyenkhang.mobile_store.dto.response.SupplierResponse;
import com.nguyenkhang.mobile_store.service.SupplierService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/suppliers")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SupplierController {
    SupplierService supplierService;

    @GetMapping
    public ApiResponseDTO<Page<SupplierResponse>> get(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ApiResponseDTO.<Page<SupplierResponse>>builder()
                .result(supplierService.get(page, size, sortBy))
                .build();
    }

    @PostMapping
    public ApiResponseDTO<SupplierResponse> create(@RequestBody @Valid SupplierRequest request) {
        return ApiResponseDTO.<SupplierResponse>builder()
                .result(supplierService.create(request))
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponseDTO<SupplierResponse> getById(@PathVariable long id) {
        return ApiResponseDTO.<SupplierResponse>builder()
                .result(supplierService.getById(id))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponseDTO<SupplierResponse> update(@RequestBody @Valid SupplierRequest request, @PathVariable long id) {
        return ApiResponseDTO.<SupplierResponse>builder()
                .result(supplierService.update(id, request))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponseDTO<String> delete(@PathVariable long id) {
        supplierService.delete(id);

        return ApiResponseDTO.<String>builder()
                .result("Supplier has been deleted")
                .build();
    }

    @GetMapping("/search")
    public ApiResponseDTO<Page<SupplierResponse>> searchSupplier(
            @RequestParam(defaultValue = "0") int page, @RequestParam String keyword) {
        return ApiResponseDTO.<Page<SupplierResponse>>builder()
                .result(supplierService.searchSupplier(keyword, page))
                .build();
    }
}
