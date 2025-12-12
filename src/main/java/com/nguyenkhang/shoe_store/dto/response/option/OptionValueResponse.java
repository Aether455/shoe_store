package com.nguyenkhang.shoe_store.dto.response.option;

import java.time.LocalDateTime;

import com.nguyenkhang.shoe_store.dto.response.user.UserResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OptionValueResponse {

    Long id;

    String value;

    UserResponse createBy;

    UserResponse updateBy;

    LocalDateTime createAt;

    LocalDateTime updateAt;
}
