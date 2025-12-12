package com.nguyenkhang.shoe_store.dto.request;

import jakarta.validation.constraints.NotBlank;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AddressRequest {

    // @NotNull(message = "CUSTOMER_ID_REQUIRED")
    long customerId;

    @NotBlank(message = "ADDRESS_REQUIRED")
    String address;

    @NotBlank(message = "PROVINCE_REQUIRED")
    String province;

    @NotBlank(message = "DISTRICT_REQUIRED")
    String district;

    @NotBlank(message = "WARD_REQUIRED")
    String ward;
}
