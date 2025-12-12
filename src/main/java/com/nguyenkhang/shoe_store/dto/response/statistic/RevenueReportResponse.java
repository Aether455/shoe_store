package com.nguyenkhang.shoe_store.dto.response.statistic;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RevenueReportResponse {
    String month;
    Double totalRevenue;
}
