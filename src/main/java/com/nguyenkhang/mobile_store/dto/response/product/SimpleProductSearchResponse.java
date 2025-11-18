package com.nguyenkhang.mobile_store.dto.response.product;

import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

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
