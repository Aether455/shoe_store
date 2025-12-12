package com.nguyenkhang.shoe_store.dto.response.inventory;

import java.time.LocalDateTime;

import com.nguyenkhang.shoe_store.dto.response.product_variant.SimpleProductVariantResponse;
import com.nguyenkhang.shoe_store.dto.response.user.SimpleUserResponse;
import com.nguyenkhang.shoe_store.dto.response.warehouse.SimpleWarehouseResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InventoryResponse {

    Long id;

    SimpleWarehouseResponse warehouse;

    SimpleProductVariantResponse productVariant;

    int quantity;

    SimpleUserResponse createBy;

    SimpleUserResponse updateBy;

    LocalDateTime createAt;
    LocalDateTime updateAt;
}
