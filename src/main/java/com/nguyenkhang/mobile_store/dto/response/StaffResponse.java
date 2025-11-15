package com.nguyenkhang.mobile_store.dto.response;

import java.time.LocalDateTime;

import com.nguyenkhang.mobile_store.dto.response.user.UserResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StaffResponse {

    Long id;

    UserResponse user;

    String phoneNumber;

    String position;

    LocalDateTime hireDate;

    double salary;

    UserResponse createBy;

    UserResponse updateBy;

    LocalDateTime createAt;

    LocalDateTime updateAt;
}
