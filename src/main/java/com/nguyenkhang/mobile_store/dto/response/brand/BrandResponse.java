package com.nguyenkhang.mobile_store.dto.response.brand;

import java.time.LocalDate;

import com.nguyenkhang.mobile_store.dto.response.user.SimpleUserResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BrandResponse {

    String id;
    String name;
    String description;

    SimpleUserResponse createBy;

    SimpleUserResponse updateBy;

    LocalDate createAt;

    LocalDate updateAt;
}
