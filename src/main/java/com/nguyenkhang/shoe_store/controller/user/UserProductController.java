package com.nguyenkhang.shoe_store.controller.user;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.nguyenkhang.shoe_store.dto.ApiResponseDTO;
import com.nguyenkhang.shoe_store.dto.request.products.ProductFilterCriteria;
import com.nguyenkhang.shoe_store.dto.response.product.ProductResponseForCustomer;
import com.nguyenkhang.shoe_store.dto.response.product.SimpleProductResponseForCustomer;
import com.nguyenkhang.shoe_store.dto.response.product.SimpleProductSearchResponse;
import com.nguyenkhang.shoe_store.service.ProductService;
import com.nguyenkhang.shoe_store.service.ProductVariantService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/user/products")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProductController {
    ProductService productService;
    ProductVariantService variantService;

    @GetMapping
    public ApiResponseDTO<Page<SimpleProductResponseForCustomer>> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ApiResponseDTO.<Page<SimpleProductResponseForCustomer>>builder()
                .result(productService.getProductsForUser(page, size, sortBy))
                .build();
    }

    @GetMapping("/{productId}")
    public ApiResponseDTO<ProductResponseForCustomer> getProductById(@PathVariable long productId) {
        return ApiResponseDTO.<ProductResponseForCustomer>builder()
                .result(productService.getByIdForUser(productId))
                .build();
    }

    @GetMapping("/category/{categoryId}")
    public ApiResponseDTO<Page<SimpleProductResponseForCustomer>> getProductsByCategory(
            @PathVariable long categoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ApiResponseDTO.<Page<SimpleProductResponseForCustomer>>builder()
                .result(productService.getProductsByCategory(categoryId, page, size, sortBy))
                .build();
    }

    @GetMapping("/brand/{brandId}")
    public ApiResponseDTO<Page<SimpleProductResponseForCustomer>> getProductsByBrand(
            @PathVariable long brandId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ApiResponseDTO.<Page<SimpleProductResponseForCustomer>>builder()
                .result(productService.getProductsByBrand(brandId, page, size, sortBy))
                .build();
    }

    @GetMapping("/search")
    public ApiResponseDTO<Page<SimpleProductSearchResponse>> searchProducts(
            @RequestParam String keyword, @RequestParam(defaultValue = "20") int page) {
        return ApiResponseDTO.<Page<SimpleProductSearchResponse>>builder()
                .result(productService.searchProducts(keyword, page))
                .build();
    }

    @GetMapping("/filter")
    public ApiResponseDTO<Page<SimpleProductResponseForCustomer>> filterProduct(
            ProductFilterCriteria criteria,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ApiResponseDTO.<Page<SimpleProductResponseForCustomer>>builder()
                .result(productService.filterProduct(criteria, page, size))
                .build();
    }
}
