package com.nguyenkhang.shoe_store.dto.response.product;

import java.time.LocalDateTime;
import java.util.List;

import com.nguyenkhang.shoe_store.dto.response.brand.SimpleBrandResponse;
import com.nguyenkhang.shoe_store.dto.response.category.SimpleCategoryResponse;
import com.nguyenkhang.shoe_store.dto.response.product_variant.ProductVariantResponse;
import com.nguyenkhang.shoe_store.dto.response.user.SimpleUserResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {

    Long id;

    String name;

    String description;

    String mainImageUrl;

    List<ProductVariantResponse> productVariants;

    SimpleCategoryResponse category;

    SimpleBrandResponse brand;

    SimpleUserResponse createBy;

    SimpleUserResponse updateBy;

    LocalDateTime createAt;

    LocalDateTime updateAt;
}
