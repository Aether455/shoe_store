package com.nguyenkhang.mobile_store.dto.response.user;

import java.util.Set;

import com.nguyenkhang.mobile_store.dto.response.RoleResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimpleUserInfoResponse {
    String id;
    String username;
    String email;
    Set<RoleResponse> roles;
}
