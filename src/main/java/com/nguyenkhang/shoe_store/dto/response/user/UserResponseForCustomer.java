package com.nguyenkhang.shoe_store.dto.response.user;

import java.time.LocalDate;

import com.nguyenkhang.shoe_store.dto.response.customer.CustomerResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseForCustomer {
    String id;
    String username;
    String email;

    LocalDate createAt;

    CustomerResponse customer;
}
