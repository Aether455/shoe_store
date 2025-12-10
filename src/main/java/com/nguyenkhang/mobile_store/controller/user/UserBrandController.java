package com.nguyenkhang.mobile_store.controller.user;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.nguyenkhang.mobile_store.dto.ApiResponseDTO;
import com.nguyenkhang.mobile_store.dto.response.brand.BrandResponseForCustomer;
import com.nguyenkhang.mobile_store.service.BrandService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/user/brands")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserBrandController {

    BrandService brandService;

    @GetMapping
    public ApiResponseDTO<List<BrandResponseForCustomer>> getBrands() {
        return ApiResponseDTO.<List<BrandResponseForCustomer>>builder()
                .result(brandService.getBrandsForUser())
                .build();
    }
}
