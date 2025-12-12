package com.nguyenkhang.shoe_store.dto.request.products;

import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductSearchCriteria {

    String productName;
    Long categoryId;
    Long brandId;

    String sku;
    Double minPrice;
    Double maxPrice;
    Integer minQuantity;

    LocalDateTime createAtStart;
    LocalDateTime createAtEnd;
}
