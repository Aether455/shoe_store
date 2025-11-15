package com.nguyenkhang.mobile_store.dto.response.option;

import java.util.List;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimpleOptionResponse {
    Long id;

    String name;

    List<SimpleOptionValueResponse> optionValues;
}
