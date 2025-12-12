package com.nguyenkhang.shoe_store.dto.response.customer;

import java.time.LocalDateTime;
import java.util.List;

import com.nguyenkhang.shoe_store.dto.response.AddressResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerResponseForUser {

    Long id;

    String fullName;

    String phoneNumber;

    List<AddressResponse> addresses;

    LocalDateTime createAt;
}
