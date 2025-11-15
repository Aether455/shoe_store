package com.nguyenkhang.mobile_store.dto.response.product;

import java.util.List;

import com.nguyenkhang.mobile_store.dto.response.brand.BrandResponse;
import com.nguyenkhang.mobile_store.dto.response.category.CategoryResponse;
import com.nguyenkhang.mobile_store.dto.response.product_variant.ProductVariantResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponseForCustomer {

    Long id;

    String name;

    String description;

    String mainImageUrl;

    List<ProductVariantResponse> productVariants;

    CategoryResponse category;

    BrandResponse brand;
}
