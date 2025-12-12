package com.nguyenkhang.shoe_store.dto.response.staff;

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
public class StaffResponse {

    Long id;

    SimpleUserResponse user;

    String fullName;

    String phoneNumber;

    String position;

    String gender;

    LocalDateTime hireDate;

    double salary;

    SimpleUserResponse createBy;

    SimpleUserResponse updateBy;

    LocalDateTime createAt;

    LocalDateTime updateAt;
}
