package com.nguyenkhang.shoe_store.mapper;

import org.mapstruct.Mapper;

import com.nguyenkhang.shoe_store.dto.response.statistic.DailyReportResponse;
import com.nguyenkhang.shoe_store.entity.DailyReport;

@Mapper(componentModel = "spring")
public interface DailyReportMapper {
    DailyReportResponse toDailyReportResponse(DailyReport dailyReport);
}
