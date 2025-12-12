package com.nguyenkhang.shoe_store.dto.response.inventory;

import java.time.LocalDateTime;

import com.nguyenkhang.shoe_store.dto.response.user.SimpleUserResponse;
import com.nguyenkhang.shoe_store.dto.response.warehouse.WarehouseResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimpleInventoryResponse {

    Long id;

    WarehouseResponse warehouse;

    int quantity;

    SimpleUserResponse createBy;

    SimpleUserResponse updateBy;

    LocalDateTime createAt;
    LocalDateTime updateAt;
}
