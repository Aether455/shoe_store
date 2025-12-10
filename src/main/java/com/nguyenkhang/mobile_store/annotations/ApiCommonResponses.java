package com.nguyenkhang.mobile_store.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.nguyenkhang.mobile_store.dto.ApiResponseDTO;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses({
    @ApiResponse(responseCode = "200", description = "Xử lý thành công"),
    @ApiResponse(
            responseCode = "400",
            description = "Lỗi Validation (Dữ liệu không hợp lệ)",
            content =
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiResponseDTO.class) // Trỏ về class ApiResponse của bạn
                            )),
    @ApiResponse(
            responseCode = "500",
            description = "Lỗi hệ thống (Internal Server Error)",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseDTO.class)))
})
public @interface ApiCommonResponses {}
