package com.nguyenkhang.shoe_store.dto.response.statistic;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DailyReportResponse {

    Long id;

    LocalDate reportDate;

    BigDecimal totalRevenue;

    int totalOrders;

    BigDecimal avgOrderValue;

    int totalItemsSold;

    int newCustomersCount;

    BigDecimal totalDiscountAmount;
}
