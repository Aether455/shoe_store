package com.nguyenkhang.shoe_store.dto.response.product;

import com.nguyenkhang.shoe_store.dto.response.brand.SimpleBrandResponse;
import com.nguyenkhang.shoe_store.dto.response.category.SimpleCategoryResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimpleProductResponseForCustomer {

    Long id;

    String name;

    String mainImageUrl;

    SimpleCategoryResponse category;

    SimpleBrandResponse brand;
}
