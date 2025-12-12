package com.nguyenkhang.shoe_store.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.nguyenkhang.shoe_store.dto.response.order.SimpleOrderResponse;
import com.nguyenkhang.shoe_store.dto.response.statistic.BrandRevenueResponse;
import com.nguyenkhang.shoe_store.dto.response.statistic.CategoryRevenueResponse;
import com.nguyenkhang.shoe_store.dto.response.statistic.ProductRevenueResponse;
import com.nguyenkhang.shoe_store.dto.response.statistic.RevenueReportResponse;
import com.nguyenkhang.shoe_store.dto.response.statistic.SellingProductResponse;
import com.nguyenkhang.shoe_store.enums.OrderStatus;
import com.nguyenkhang.shoe_store.mapper.OrderMapper;
import com.nguyenkhang.shoe_store.repository.CustomerRepository;
import com.nguyenkhang.shoe_store.repository.DailyReportRepository;
import com.nguyenkhang.shoe_store.repository.OrderItemRepository;
import com.nguyenkhang.shoe_store.repository.OrderRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StatisticService {
    DailyReportRepository dailyReportRepository;
    OrderRepository orderRepository;
    OrderItemRepository orderItemRepository;
    CustomerRepository customerRepository;
    OrderMapper orderMapper;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public List<RevenueReportResponse> getRevenueByMonthAndYear() {
        return orderRepository.reportRevenueByMonth(OrderStatus.COMPLETED);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public BigDecimal getTotalRevenue() {
        return orderRepository.getTotalRevenue(OrderStatus.COMPLETED);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public Page<SimpleOrderResponse> getNewOrder(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createAt").descending());
        return orderRepository.findAllByCreateAt(LocalDate.now(), pageable).map(orderMapper::toSimpleOrderResponse);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public List<ProductRevenueResponse> getRevenueByProduct() {
        return orderItemRepository.findRevenueByProduct();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public List<CategoryRevenueResponse> getRevenueByCategory() {
        return orderItemRepository.findRevenueByCategory();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public List<BrandRevenueResponse> getRevenueByBrand() {
        return orderItemRepository.findRevenueByBrand();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public List<SellingProductResponse> getTopSellingProductsByQuantity() {

        return orderItemRepository.findTopSellingProductsByQuantity();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public Page<ProductRevenueResponse> getTopRevenueProducts() {
        Pageable pageable = PageRequest.of(0, 10);
        return orderItemRepository.findTopRevenueProducts(pageable);
    }
}
