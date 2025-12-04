package com.nguyenkhang.mobile_store.dto.request.products;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductFilterCriteria {

    Long categoryId;
    Long brandId;

    Double minPrice;
    Double maxPrice;
}
