package com.nguyenkhang.mobile_store.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RefreshRequest {
    @Schema(description = "Chuỗi JWT Token dùng để refresh", example = "eyJhbGciOiJIUzI1NiJ9...")
    String token;
}
