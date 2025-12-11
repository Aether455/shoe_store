package com.nguyenkhang.mobile_store.dto.request.inventory;

import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class InventoryCriteria {

    String keyword;
    Long warehouseId;

    LocalDateTime createAtStart;
    LocalDateTime createAtEnd;
}
