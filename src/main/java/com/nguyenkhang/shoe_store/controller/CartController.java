package com.nguyenkhang.shoe_store.controller;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.nguyenkhang.shoe_store.dto.ApiResponseDTO;
import com.nguyenkhang.shoe_store.dto.request.cart.CartItemRequest;
import com.nguyenkhang.shoe_store.dto.request.cart.CartItemUpdateQuantityRequest;
import com.nguyenkhang.shoe_store.dto.response.cart.CartItemResponse;
import com.nguyenkhang.shoe_store.dto.response.cart.CartResponse;
import com.nguyenkhang.shoe_store.service.CartService;

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
    ApiResponseDTO<CartItemResponse> addToCart(@RequestBody @Valid CartItemRequest request) {
        return ApiResponseDTO.<CartItemResponse>builder()
                .result(cartService.addToCart(request))
                .build();
    }

    @GetMapping("/me")
    ApiResponseDTO<CartResponse> getMyCart() {
        return ApiResponseDTO.<CartResponse>builder()
                .result(cartService.getMyCart())
                .build();
    }

    @PutMapping("/quantity")
    ApiResponseDTO<CartItemResponse> updateQuantity(@RequestBody @Valid CartItemUpdateQuantityRequest request) {
        return ApiResponseDTO.<CartItemResponse>builder()
                .result(cartService.updateQuantity(request))
                .build();
    }

    @DeleteMapping("/cartItem/{cartItemId}")
    ApiResponseDTO<String> deleteCartItem(@PathVariable long cartItemId) {
        cartService.deleteCartItem(cartItemId);
        return ApiResponseDTO.<String>builder()
                .result("Cart item has been deleted")
                .build();
    }

    @DeleteMapping("/clear")
    ApiResponseDTO<String> clearMyCart() {
        cartService.clearMyCart();
        return ApiResponseDTO.<String>builder().result("Cart has been deleted").build();
    }
}
