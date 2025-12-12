package com.nguyenkhang.shoe_store.dto.response;

import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AddressResponse {

    Long id;

    String address;

    String province;

    String district;

    String ward;

    LocalDateTime createAt;
}
