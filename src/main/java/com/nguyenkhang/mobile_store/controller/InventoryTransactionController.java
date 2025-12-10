package com.nguyenkhang.mobile_store.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.nguyenkhang.mobile_store.dto.ApiResponseDTO;
import com.nguyenkhang.mobile_store.dto.response.InventoryTransactionResponse;
import com.nguyenkhang.mobile_store.service.InventoryTransactionService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/inventory-transactions")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InventoryTransactionController {
    InventoryTransactionService transactionService;

    @GetMapping
    public ApiResponseDTO<Page<InventoryTransactionResponse>> getTransactions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ApiResponseDTO.<Page<InventoryTransactionResponse>>builder()
                .result(transactionService.get(page, size, sortBy))
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponseDTO<InventoryTransactionResponse> getTransactionById(@PathVariable long id) {
        return ApiResponseDTO.<InventoryTransactionResponse>builder()
                .result(transactionService.getById(id))
                .build();
    }

    @GetMapping("/search")
    public ApiResponseDTO<Page<InventoryTransactionResponse>> searchInventoryTransactions(
            @RequestParam(defaultValue = "0") int page, @RequestParam String keyword) {
        return ApiResponseDTO.<Page<InventoryTransactionResponse>>builder()
                .result(transactionService.searchInventoryTransactions(keyword, page))
                .build();
    }
}
