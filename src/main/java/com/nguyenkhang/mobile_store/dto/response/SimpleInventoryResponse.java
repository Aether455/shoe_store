package com.nguyenkhang.mobile_store.dto.response;

import java.time.LocalDateTime;

import com.nguyenkhang.mobile_store.dto.response.user.SimpleUserResponse;

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
