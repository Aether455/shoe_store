package com.nguyenkhang.shoe_store.dto.response.option;

import java.time.LocalDateTime;
import java.util.List;

import com.nguyenkhang.shoe_store.dto.response.user.UserResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OptionResponse {
    Long id;

    String name;

    List<OptionValueResponse> optionValues;

    UserResponse createBy;

    UserResponse updateBy;

    LocalDateTime createAt;

    LocalDateTime updateAt;
}
