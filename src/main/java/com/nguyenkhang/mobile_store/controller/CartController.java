package com.nguyenkhang.mobile_store.controller;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.nguyenkhang.mobile_store.dto.ApiResponse;
import com.nguyenkhang.mobile_store.dto.request.CartItemRequest;
import com.nguyenkhang.mobile_store.dto.request.CartItemUpdateQuantityRequest;
import com.nguyenkhang.mobile_store.dto.response.cart.CartItemResponse;
import com.nguyenkhang.mobile_store.dto.response.cart.CartResponse;
import com.nguyenkhang.mobile_store.service.CartService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CartController {
    CartService cartService;

    @PostMapping
    ApiResponse<CartItemResponse> addToCart(@RequestBody @Valid CartItemRequest request) {
        return ApiResponse.<CartItemResponse>builder()
                .result(cartService.addToCart(request))
                .build();
    }

    @GetMapping("/me")
    ApiResponse<CartResponse> getMyCart() {
        return ApiResponse.<CartResponse>builder()
                .result(cartService.getMyCart())
                .build();
    }

    @PutMapping("/quantity")
    ApiResponse<CartItemResponse> updateQuantity(@RequestBody @Valid CartItemUpdateQuantityRequest request) {
        return ApiResponse.<CartItemResponse>builder()
                .result(cartService.updateQuantity(request))
                .build();
    }

    @DeleteMapping("/cartItem/{cartItemId}")
    ApiResponse<String> deleteCartItem(@PathVariable long cartItemId) {
        cartService.deleteCartItem(cartItemId);
        return ApiResponse.<String>builder()
                .result("Cart item has been deleted")
                .build();
    }

    @DeleteMapping("/clear")
    ApiResponse<String> clearMyCart() {
        cartService.clearMyCart();
        return ApiResponse.<String>builder()
                .result("Cart has been deleted")
                .build();
    }
}
