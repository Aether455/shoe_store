package com.nguyenkhang.shoe_store.dto.response.category;

import java.time.LocalDate;

import com.nguyenkhang.shoe_store.dto.response.user.SimpleUserResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryResponse {

    String id;
    String name;
    String description;
    LocalDate createAt;
    LocalDate updateAt;
    SimpleUserResponse createBy;

    SimpleUserResponse updateBy;
}
