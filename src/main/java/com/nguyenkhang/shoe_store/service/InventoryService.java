package com.nguyenkhang.shoe_store.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.nguyenkhang.shoe_store.dto.request.inventory.InventoryCriteria;
import com.nguyenkhang.shoe_store.dto.response.inventory.InventoryResponse;
import com.nguyenkhang.shoe_store.exception.AppException;
import com.nguyenkhang.shoe_store.exception.ErrorCode;
import com.nguyenkhang.shoe_store.mapper.InventoryMapper;
import com.nguyenkhang.shoe_store.repository.InventoryRepository;
import com.nguyenkhang.shoe_store.specification.InventorySpecification;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InventoryService {
    InventoryRepository inventoryRepository;
    InventoryMapper inventoryMapper;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public Page<InventoryResponse> get(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());

        var inventories = inventoryRepository.findAll(pageable);

        return inventories.map(inventoryMapper::toInventoryResponse);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public InventoryResponse getById(long id) {
        var inventory =
                inventoryRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.INVENTORY_NOT_EXISTED));
        return inventoryMapper.toInventoryResponse(inventory);
    }

    public Page<InventoryResponse> search(InventoryCriteria criteria, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        var spec = InventorySpecification.createSpecification(criteria);

        var products = inventoryRepository.findAll(spec, pageable);

        return products.map(inventoryMapper::toInventoryResponse);
    }
}
