package com.nguyenkhang.shoe_store.specification;

import jakarta.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.nguyenkhang.shoe_store.entity.Supplier;

public class SupplierSpecification {
    public static Specification<Supplier> createSpecification(String keyword) {
        return ((root, query, criteriaBuilder) -> {
            if (!StringUtils.hasText(keyword)) return criteriaBuilder.conjunction(); // = where 1=1

            String likePattern = "%" + keyword + "%";

            Predicate phoneLike = criteriaBuilder.like(root.get("phoneNumber"), likePattern);
            Predicate nameLike = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), likePattern);
            Predicate positionLike = criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), likePattern);

            return criteriaBuilder.or(phoneLike, nameLike, positionLike);
        });
    }
}
