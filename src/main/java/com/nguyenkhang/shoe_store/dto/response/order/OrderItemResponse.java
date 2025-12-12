package com.nguyenkhang.shoe_store.dto.response.order;

import com.nguyenkhang.shoe_store.dto.response.product.SimpleProductResponseForUsing;
import com.nguyenkhang.shoe_store.dto.response.product_variant.SimpleProductVariantResponse;

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

    SimpleProductResponseForUsing product;

    SimpleProductVariantResponse productVariant;

    int quantity;

    double pricePerUnit;

    double totalPrice;
}
