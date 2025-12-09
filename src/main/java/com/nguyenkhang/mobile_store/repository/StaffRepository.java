package com.nguyenkhang.mobile_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenkhang.mobile_store.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long>, JpaSpecificationExecutor<Staff> {
    boolean existsByPhoneNumber(String phoneNUmber);

    @Modifying
    @Transactional
    @Query("DELETE FROM Staff s WHERE s.id = :id")
    void deleteStaffByIdCustom(@Param("id") Long id);
}
