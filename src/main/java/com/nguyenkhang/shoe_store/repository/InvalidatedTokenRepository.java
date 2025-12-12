package com.nguyenkhang.shoe_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.nguyenkhang.shoe_store.entity.InvalidatedToken;

@Repository
public interface InvalidatedTokenRepository
        extends JpaRepository<InvalidatedToken, String>, JpaSpecificationExecutor<InvalidatedToken> {}
