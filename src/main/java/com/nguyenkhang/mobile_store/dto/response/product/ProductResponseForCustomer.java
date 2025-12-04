package com.nguyenkhang.mobile_store.dto.response.product;

import java.util.List;

import com.nguyenkhang.mobile_store.dto.response.brand.SimpleBrandResponse;
import com.nguyenkhang.mobile_store.dto.response.category.SimpleCategoryResponse;
import com.nguyenkhang.mobile_store.dto.response.product_variant.ProductVariantResponseForCustomer;

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

    List<ProductVariantResponseForCustomer> productVariants;

    SimpleCategoryResponse category;

    SimpleBrandResponse brand;
}
