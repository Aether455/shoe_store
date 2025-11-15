package com.nguyenkhang.mobile_store.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimpleWarehouseResponse {

    Long id;

    String name;
    String address;

    String description;
}
