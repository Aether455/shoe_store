package com.nguyenkhang.mobile_store.entity;

import java.util.List;

import jakarta.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(indexName = "products")
public class ProductDocument {
    @Id
    Long id;

    @Field(type = FieldType.Text, analyzer = "standard")
    String name;

    @Field(type = FieldType.Text, analyzer = "standard")
    String description;

    @Field(type = FieldType.Keyword)
    String mainImageUrl;

    @Field(type = FieldType.Keyword)
    String brandName;

    @Field(type = FieldType.Keyword)
    String categoryName;

    @Field(type = FieldType.Double)
    Double minPrice;

    @Field(type = FieldType.Double)
    Double maxPrice;

    @Field(type = FieldType.Keyword)
    List<String> variantAttributes;
}
