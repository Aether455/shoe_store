package com.nguyenkhang.mobile_store.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.nguyenkhang.mobile_store.dto.ApiResponseDTO;
import com.nguyenkhang.mobile_store.dto.request.inventory.InventoryCriteria;
import com.nguyenkhang.mobile_store.dto.response.inventory.InventoryResponse;
import com.nguyenkhang.mobile_store.service.InventoryService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/inventories")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InventoryController {
    InventoryService inventoryService;

    @GetMapping
    public ApiResponseDTO<Page<InventoryResponse>> get(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ApiResponseDTO.<Page<InventoryResponse>>builder()
                .result(inventoryService.get(page, size, sortBy))
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponseDTO<InventoryResponse> getById(@PathVariable long id) {
        return ApiResponseDTO.<InventoryResponse>builder()
                .result(inventoryService.getById(id))
                .build();
    }

    @GetMapping("/search")
    public ApiResponseDTO<Page<InventoryResponse>> search(
            InventoryCriteria criteria,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return ApiResponseDTO.<Page<InventoryResponse>>builder()
                .result(inventoryService.search(criteria, page, size))
                .build();
    }
}
