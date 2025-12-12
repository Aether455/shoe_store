package com.nguyenkhang.shoe_store.controller.user;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.nguyenkhang.shoe_store.dto.ApiResponseDTO;
import com.nguyenkhang.shoe_store.dto.response.vouchers.VoucherResponseForCustomer;
import com.nguyenkhang.shoe_store.service.VoucherService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/user/vouchers")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserVoucherController {
    VoucherService voucherService;

    @GetMapping("/{voucherCode}")
    public ApiResponseDTO<VoucherResponseForCustomer> getByVoucherCode(@PathVariable String voucherCode) {
        return ApiResponseDTO.<VoucherResponseForCustomer>builder()
                .result(voucherService.findByVoucherCode(voucherCode))
                .build();
    }

    @GetMapping("/search")
    public ApiResponseDTO<Page<VoucherResponseForCustomer>> searchVouchers(
            @RequestParam(defaultValue = "0") int page, @RequestParam String keyword) {
        return ApiResponseDTO.<Page<VoucherResponseForCustomer>>builder()
                .result(voucherService.searchVouchersForUser(keyword, page))
                .build();
    }
}
