package com.nguyenkhang.mobile_store.dto.response.order;

import jakarta.persistence.*;

import com.nguyenkhang.mobile_store.dto.response.product.SimpleProductResponse;
import com.nguyenkhang.mobile_store.dto.response.product_variant.SimpleProductVariantResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderItemResponse {

    Long id;

    SimpleProductResponse product;

    SimpleProductVariantResponse productVariant;

    int quantity;

    double pricePerUnit;

    double totalPrice;
}
