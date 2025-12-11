package com.nguyenkhang.mobile_store.controller;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.nguyenkhang.mobile_store.dto.ApiResponseDTO;
import com.nguyenkhang.mobile_store.dto.request.voucher.VoucherRequest;
import com.nguyenkhang.mobile_store.dto.response.vouchers.VoucherResponse;
import com.nguyenkhang.mobile_store.service.VoucherService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/vouchers")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class VoucherController {
    VoucherService voucherService;

    @GetMapping
    public ApiResponseDTO<Page<VoucherResponse>> getVouchers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ApiResponseDTO.<Page<VoucherResponse>>builder()
                .result(voucherService.getVouchers(page, size, sortBy))
                .build();
    }

    @PostMapping
    public ApiResponseDTO<VoucherResponse> create(@RequestBody @Valid VoucherRequest request) {
        return ApiResponseDTO.<VoucherResponse>builder()
                .result(voucherService.create(request))
                .build();
    }

    @GetMapping("/{voucherId}")
    public ApiResponseDTO<VoucherResponse> getVoucherById(@PathVariable long voucherId) {
        return ApiResponseDTO.<VoucherResponse>builder()
                .result(voucherService.getVoucherById(voucherId))
                .build();
    }

    @PutMapping("/{voucherId}")
    public ApiResponseDTO<VoucherResponse> update(
            @PathVariable long voucherId, @RequestBody @Valid VoucherRequest request) {
        return ApiResponseDTO.<VoucherResponse>builder()
                .result(voucherService.updateVoucher(voucherId, request))
                .build();
    }

    @DeleteMapping("/{voucherId}")
    ApiResponseDTO<String> delete(@PathVariable long voucherId) {
        voucherService.delete(voucherId);
        return ApiResponseDTO.<String>builder()
                .result("Voucher has been deleted")
                .build();
    }

    @GetMapping("/search")
    public ApiResponseDTO<Page<VoucherResponse>> searchVouchers(
            @RequestParam(defaultValue = "0") int page, @RequestParam String keyword) {
        return ApiResponseDTO.<Page<VoucherResponse>>builder()
                .result(voucherService.searchVouchers(keyword, page))
                .build();
    }
}
