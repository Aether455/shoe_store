package com.nguyenkhang.mobile_store.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenkhang.mobile_store.dto.ApiResponseDTO;
import com.nguyenkhang.mobile_store.dto.request.DailyReportCriteria;
import com.nguyenkhang.mobile_store.dto.response.statistic.DailyReportResponse;
import com.nguyenkhang.mobile_store.dto.response.statistic.RevenueReportResponse;
import com.nguyenkhang.mobile_store.dto.response.order.SimpleOrderResponse;
import com.nguyenkhang.mobile_store.dto.response.statistic.BrandRevenueResponse;
import com.nguyenkhang.mobile_store.dto.response.statistic.CategoryRevenueResponse;
import com.nguyenkhang.mobile_store.dto.response.statistic.ProductRevenueResponse;
import com.nguyenkhang.mobile_store.dto.response.statistic.SellingProductResponse;
import com.nguyenkhang.mobile_store.service.DailyReportService;
import com.nguyenkhang.mobile_store.service.StatisticService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/statistics")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class StatisticController {
    DailyReportService dailyReportService;
    StatisticService statisticService;

    @GetMapping("/daily-reports")
    public ApiResponseDTO<Page<DailyReportResponse>> get(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ApiResponseDTO.<Page<DailyReportResponse>>builder()
                .result(dailyReportService.get(page, size, sortBy))
                .build();
    }

    @GetMapping("/daily-reports/filter")
    public ApiResponseDTO<Page<DailyReportResponse>> filter(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            DailyReportCriteria criteria) {
        return ApiResponseDTO.<Page<DailyReportResponse>>builder()
                .result(dailyReportService.filter(page, size, sortBy, criteria))
                .build();
    }

    @GetMapping("/new-orders")
    public ApiResponseDTO<Page<SimpleOrderResponse>> getNewOrder(
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ApiResponseDTO.<Page<SimpleOrderResponse>>builder()
                .result(statisticService.getNewOrder(page, size))
                .build();
    }

    @GetMapping("/revenue-by-month")
    public ApiResponseDTO<List<RevenueReportResponse>> getRevenueByMonthAndYear() {
        return ApiResponseDTO.<List<RevenueReportResponse>>builder()
                .result(statisticService.getRevenueByMonthAndYear())
                .build();
    }

    @GetMapping("/total-revenue")
    public ApiResponseDTO<BigDecimal> getTotalRevenue() {
        return ApiResponseDTO.<BigDecimal>builder()
                .result(statisticService.getTotalRevenue())
                .build();
    }

    @GetMapping("/revenue-by-product")
    public ApiResponseDTO<List<ProductRevenueResponse>> getRevenueByProduct() {
        return ApiResponseDTO.<List<ProductRevenueResponse>>builder()
                .result(statisticService.getRevenueByProduct())
                .build();
    }

    @GetMapping("/revenue-by-category")
    public ApiResponseDTO<List<CategoryRevenueResponse>> getRevenueByCategory() {
        return ApiResponseDTO.<List<CategoryRevenueResponse>>builder()
                .result(statisticService.getRevenueByCategory())
                .build();
    }

    @GetMapping("/revenue-by-brand")
    public ApiResponseDTO<List<BrandRevenueResponse>> getRevenueByBrand() {
        return ApiResponseDTO.<List<BrandRevenueResponse>>builder()
                .result(statisticService.getRevenueByBrand())
                .build();
    }

    @GetMapping("/top-selling-products")
    public ApiResponseDTO<List<SellingProductResponse>> getTopSellingProducts() {
        return ApiResponseDTO.<List<SellingProductResponse>>builder()
                .result(statisticService.getTopSellingProductsByQuantity())
                .build();
    }

    @GetMapping("/top-revenue-products")
    public ApiResponseDTO<Page<ProductRevenueResponse>> getTopRevenueProducts() {
        return ApiResponseDTO.<Page<ProductRevenueResponse>>builder()
                .result(statisticService.getTopRevenueProducts())
                .build();
    }
}
