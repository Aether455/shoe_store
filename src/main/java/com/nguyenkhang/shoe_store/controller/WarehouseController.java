package com.nguyenkhang.shoe_store.controller;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.nguyenkhang.shoe_store.dto.ApiResponseDTO;
import com.nguyenkhang.shoe_store.dto.request.warehouse.WarehouseRequest;
import com.nguyenkhang.shoe_store.dto.response.warehouse.WarehouseResponse;
import com.nguyenkhang.shoe_store.service.WarehouseService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/warehouses")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WarehouseController {
    WarehouseService warehouseService;

    @GetMapping
    public ApiResponseDTO<Page<WarehouseResponse>> get(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ApiResponseDTO.<Page<WarehouseResponse>>builder()
                .result(warehouseService.get(page, size, sortBy))
                .build();
    }

    @PostMapping
    public ApiResponseDTO<WarehouseResponse> create(@RequestBody @Valid WarehouseRequest request) {
        return ApiResponseDTO.<WarehouseResponse>builder()
                .result(warehouseService.create(request))
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponseDTO<WarehouseResponse> getById(@PathVariable long id) {
        return ApiResponseDTO.<WarehouseResponse>builder()
                .result(warehouseService.getById(id))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponseDTO<WarehouseResponse> update(
            @RequestBody @Valid WarehouseRequest request, @PathVariable long id) {
        return ApiResponseDTO.<WarehouseResponse>builder()
                .result(warehouseService.update(id, request))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponseDTO<String> delete(@PathVariable long id) {
        warehouseService.delete(id);

        return ApiResponseDTO.<String>builder()
                .result("Warehouse has been deleted")
                .build();
    }

    @GetMapping("/search")
    public ApiResponseDTO<Page<WarehouseResponse>> searchWarehouse(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ApiResponseDTO.<Page<WarehouseResponse>>builder()
                .result(warehouseService.searchWarehouse(keyword, page, size))
                .build();
    }
}
