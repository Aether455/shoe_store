package com.nguyenkhang.shoe_store.dto.response.warehouse;

import java.time.LocalDateTime;

import com.nguyenkhang.shoe_store.dto.response.user.SimpleUserResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WarehouseResponse {

    Long id;

    String name;
    String address;

    String description;
    String province;
    String district;
    String ward;

    SimpleUserResponse createBy;

    SimpleUserResponse updateBy;

    LocalDateTime createAt;
    LocalDateTime updateAt;
}
