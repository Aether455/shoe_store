package com.nguyenkhang.shoe_store.dto.response.cart;

import java.util.Set;

import com.nguyenkhang.shoe_store.dto.response.option.SimpleOptionValueResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItemResponse {
    long id;

    long productId;
    String productName;

    String sku;
    double price;
    Set<SimpleOptionValueResponse> optionValues;

    long productVariantId;

    String productImageUrl;

    int quantity;

    double totalPrice;
}
