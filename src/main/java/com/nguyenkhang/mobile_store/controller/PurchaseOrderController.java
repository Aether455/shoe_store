package com.nguyenkhang.mobile_store.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.nguyenkhang.mobile_store.dto.ApiResponseDTO;
import com.nguyenkhang.mobile_store.dto.request.PurchaseOrderRequest;
import com.nguyenkhang.mobile_store.dto.response.SimplePurchaseOrderResponse;
import com.nguyenkhang.mobile_store.dto.response.purchase_order.PurchaseOrderReportResponse;
import com.nguyenkhang.mobile_store.dto.response.purchase_order.PurchaseOrderResponse;
import com.nguyenkhang.mobile_store.service.PurchaseOrderService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/purchase-orders")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PurchaseOrderController {
    PurchaseOrderService purchaseOrderService;

    @PostMapping
    public ApiResponseDTO<SimplePurchaseOrderResponse> create(@RequestBody PurchaseOrderRequest request) {
        return ApiResponseDTO.<SimplePurchaseOrderResponse>builder()
                .result(purchaseOrderService.create(request))
                .build();
    }

    @PatchMapping("/{id}/approve")
    public ApiResponseDTO<PurchaseOrderResponse> approve(@PathVariable long id) {
        return ApiResponseDTO.<PurchaseOrderResponse>builder()
                .result(purchaseOrderService.approve(id))
                .build();
    }

    @PatchMapping("/{id}/cancel")
    public ApiResponseDTO<PurchaseOrderResponse> cancel(@PathVariable long id) {
        return ApiResponseDTO.<PurchaseOrderResponse>builder()
                .result(purchaseOrderService.cancel(id))
                .build();
    }

    @GetMapping
    public ApiResponseDTO<Page<SimplePurchaseOrderResponse>> get(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ApiResponseDTO.<Page<SimplePurchaseOrderResponse>>builder()
                .result(purchaseOrderService.get(page, size, sortBy))
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponseDTO<PurchaseOrderResponse> getById(@PathVariable long id) {
        return ApiResponseDTO.<PurchaseOrderResponse>builder()
                .result(purchaseOrderService.getById(id))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponseDTO<String> delete(@PathVariable long id) {
        return ApiResponseDTO.<String>builder()
                .result(purchaseOrderService.delete(id))
                .build();
    }

    @GetMapping("/reports")
    public ApiResponseDTO<List<PurchaseOrderReportResponse>> reports(
            @RequestParam LocalDate start, @RequestParam LocalDate end, @RequestParam String groupBy) {
        LocalDateTime startDate = start.atStartOfDay();
        LocalDateTime endDate = end.atTime(23, 59, 59);
        return ApiResponseDTO.<List<PurchaseOrderReportResponse>>builder()
                .result(purchaseOrderService.report(startDate, endDate, groupBy))
                .build();
    }

    @GetMapping("/search")
    public ApiResponseDTO<Page<SimplePurchaseOrderResponse>> searchSupplier(
            @RequestParam(defaultValue = "0") int page, @RequestParam String keyword) {
        return ApiResponseDTO.<Page<SimplePurchaseOrderResponse>>builder()
                .result(purchaseOrderService.searchPurchaseOrder(keyword, page))
                .build();
    }
}
