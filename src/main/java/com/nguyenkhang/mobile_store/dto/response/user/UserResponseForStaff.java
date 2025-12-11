package com.nguyenkhang.mobile_store.dto.response.user;

import java.time.LocalDate;

import com.nguyenkhang.mobile_store.dto.response.staff.StaffResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseForStaff {
    String id;
    String username;
    String email;

    LocalDate createAt;

    StaffResponse staff;
}
