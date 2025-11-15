package com.nguyenkhang.mobile_store.dto.response.product_variant;

import java.time.LocalDateTime;
import java.util.Set;

import com.nguyenkhang.mobile_store.dto.response.option.SimpleOptionValueResponse;
import com.nguyenkhang.mobile_store.dto.response.user.SimpleUserResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductVariantResponse {

    Long id;

    String productVariantImageUrl;
    String imagePublicId;

    Set<SimpleOptionValueResponse> optionValues;

    double price;

    int quantity;

    SimpleUserResponse createBy;

    SimpleUserResponse updateBy;

    LocalDateTime createAt;

    LocalDateTime updateAt;
}
