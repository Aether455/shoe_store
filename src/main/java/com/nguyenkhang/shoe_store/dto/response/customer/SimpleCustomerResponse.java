package com.nguyenkhang.shoe_store.dto.response.customer;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SimpleCustomerResponse {

    Long id;

    String fullName;

    String phoneNumber;
}
