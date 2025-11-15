package com.nguyenkhang.mobile_store.specification;

import java.util.Date;

import jakarta.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.nguyenkhang.mobile_store.entity.InvalidatedToken;

public class InvalidatedTokenSpecification {
    public static Specification<InvalidatedToken> createSpecification(Date nowDate) {
        return ((root, query, criteriaBuilder) -> {
            Predicate expiryTime = criteriaBuilder.lessThan(root.get("expiryTime"), nowDate);

            return criteriaBuilder.or(expiryTime);
        });
    }
}
