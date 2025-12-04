package com.nguyenkhang.mobile_store.dto.response.user;

import java.time.LocalDateTime;
import java.util.Set;

import com.nguyenkhang.mobile_store.dto.response.RoleResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;
    String username;
    String email;
    LocalDateTime createAt;
    LocalDateTime updateAt;

    Set<RoleResponse> roles;
}
