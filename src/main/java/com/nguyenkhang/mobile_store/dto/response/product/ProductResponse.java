package com.nguyenkhang.mobile_store.dto.response.product;

import java.time.LocalDateTime;
import java.util.List;

import com.nguyenkhang.mobile_store.dto.response.brand.BrandResponse;
import com.nguyenkhang.mobile_store.dto.response.category.CategoryResponse;
import com.nguyenkhang.mobile_store.dto.response.product_variant.ProductVariantResponse;
import com.nguyenkhang.mobile_store.dto.response.user.SimpleUserResponse;

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

    CategoryResponse category;

    BrandResponse brand;

    SimpleUserResponse createBy;

    SimpleUserResponse updateBy;

    LocalDateTime createAt;

    LocalDateTime updateAt;
}
