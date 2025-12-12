package com.nguyenkhang.shoe_store.specification;

import jakarta.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.nguyenkhang.shoe_store.entity.Warehouse;

public class WarehouseSpecification {
    public static Specification<Warehouse> createSpecification(String keyword) {
        return ((root, query, criteriaBuilder) -> {
            if (!StringUtils.hasText(keyword)) return criteriaBuilder.conjunction(); // = where 1=1

            String likePattern = "%" + keyword + "%";

            Predicate nameLike = criteriaBuilder.like(root.get("name"), likePattern);
            Predicate descriptionLike =
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), likePattern);

            return criteriaBuilder.or(descriptionLike, nameLike);
        });
    }
}
