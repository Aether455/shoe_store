package com.nguyenkhang.shoe_store.specification;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.nguyenkhang.shoe_store.dto.request.DailyReportCriteria;
import com.nguyenkhang.shoe_store.entity.DailyReport;

public class DailyReportSpecification {
    public static Specification<DailyReport> createSpecification(DailyReportCriteria criteria) {
        return ((root, query, criteriaBuilder) -> {
            if (criteria == null) {
                return null;
            }
            List<Predicate> predicates = new ArrayList<>();

            if (criteria.getReportDateStart() != null) {
                predicates.add(
                        criteriaBuilder.greaterThanOrEqualTo(root.get("reportDate"), criteria.getReportDateStart()));
            }
            if (criteria.getReportDateEnd() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("reportDate"), criteria.getReportDateEnd()));
            }

            if (criteria.getTotalRevenueStart() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(
                        root.get("totalRevenue"), criteria.getTotalRevenueStart()));
            }
            if (criteria.getTotalRevenueEnd() != null) {
                predicates.add(
                        criteriaBuilder.lessThanOrEqualTo(root.get("totalRevenue"), criteria.getTotalRevenueEnd()));
            }

            if (criteria.getAvgOrderValueStart() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(
                        root.get("avgOrderValue"), criteria.getAvgOrderValueStart()));
            }
            if (criteria.getAvgOrderValueEnd() != null) {
                predicates.add(
                        criteriaBuilder.lessThanOrEqualTo(root.get("avgOrderValue"), criteria.getAvgOrderValueEnd()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
