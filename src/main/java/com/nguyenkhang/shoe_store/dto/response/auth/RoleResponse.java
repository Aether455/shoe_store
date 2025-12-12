package com.nguyenkhang.shoe_store.dto.response.auth;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder // tao mot builder pattern
@FieldDefaults(level = AccessLevel.PRIVATE)
// tat ca field trong class se mac dinh la private va khong can dung private truoc cac field nua
public class RoleResponse {
    String name;
    String description;
}
