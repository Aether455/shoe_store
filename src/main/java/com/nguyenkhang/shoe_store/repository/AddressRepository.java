package com.nguyenkhang.shoe_store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyenkhang.shoe_store.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAllByCustomerId(long customerId);
}
