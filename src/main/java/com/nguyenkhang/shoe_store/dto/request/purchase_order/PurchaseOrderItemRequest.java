package com.nguyenkhang.shoe_store.dto.request.purchase_order;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PurchaseOrderItemRequest {

    @NotNull(message = "PRODUCT_VARIANT_REQUIRED")
    Long productVariantId;

    @PositiveOrZero(message = "QUANTITY_INVALID")
    @NotNull(message = "QUANTITY_REQUIRED")
    int quantity;

    @Positive(message = "PRICE_INVALID")
    @NotNull(message = "PRICE_REQUIRED")
    BigDecimal pricePerUnit;

    @Positive(message = "TOTAL_PRICE_INVALID")
    @NotNull(message = "TOTAL_PRICE_REQUIRED")
    BigDecimal total;
}
