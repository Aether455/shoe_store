package com.nguyenkhang.mobile_store.mapper;

import org.mapstruct.Mapper;

import com.nguyenkhang.mobile_store.dto.response.statistic.DailyReportResponse;
import com.nguyenkhang.mobile_store.entity.DailyReport;

@Mapper(componentModel = "spring")
public interface DailyReportMapper {
    DailyReportResponse toDailyReportResponse(DailyReport dailyReport);
}
