package com.nguyenkhang.shoe_store.dto.request.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LogoutRequest {
    @Schema(description = "Chuỗi JWT Access Token sẽ đưa vào black list", example = "eyJhbGciOiJIUzI1NiJ9...")
    String token;
}
