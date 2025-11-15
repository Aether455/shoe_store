package com.nguyenkhang.mobile_store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyenkhang.mobile_store.entity.OptionValue;

@Repository
public interface OptionValueRepository extends JpaRepository<OptionValue, Long> {
    boolean existsByValue(String value);

    List<OptionValue> findAllByOptionId(long optionId);
}
