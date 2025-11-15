package com.nguyenkhang.mobile_store.dto.response.cart;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartResponse {

    Long id;

    List<CartItemResponse> cartItems;

    double totalAmount;

    LocalDateTime createAt;
}
