package com.nguyenkhang.shoe_store.dto.response.option;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimpleOptionValueResponse {

    Long id;

    String value;
}
