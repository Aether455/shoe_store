package com.nguyenkhang.shoe_store.dto.response.product;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(indexName = "products")
public class SimpleProductSearchResponse {
    Long id;

    String name;

    String description;

    String mainImageUrl;

    String brandName;
    String categoryName;

    Double minPrice;
    Double maxPrice;
}
