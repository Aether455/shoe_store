package com.nguyenkhang.mobile_store.controller;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.nguyenkhang.mobile_store.dto.ApiResponseDTO;
import com.nguyenkhang.mobile_store.dto.request.products.ProductAndVariantsCreationRequest;
import com.nguyenkhang.mobile_store.dto.request.products.ProductRequest;
import com.nguyenkhang.mobile_store.dto.request.products.ProductSearchCriteria;
import com.nguyenkhang.mobile_store.dto.request.products.ProductVariantUpdateRequest;
import com.nguyenkhang.mobile_store.dto.request.products.VariantCreationOneRequest;
import com.nguyenkhang.mobile_store.dto.response.product.ProductResponse;
import com.nguyenkhang.mobile_store.dto.response.product.SimpleProductResponse;
import com.nguyenkhang.mobile_store.dto.response.product_variant.ProductVariantResponse;
import com.nguyenkhang.mobile_store.service.ProductService;
import com.nguyenkhang.mobile_store.service.ProductVariantService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {
    ProductService productService;
    ProductVariantService variantService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponseDTO<ProductResponse> create(@ModelAttribute @Valid ProductAndVariantsCreationRequest request) {
        return ApiResponseDTO.<ProductResponse>builder()
                .message("Success!")
                .result(productService.createProductAndVariants(request))
                .build();
    }

    @GetMapping
    public ApiResponseDTO<Page<SimpleProductResponse>> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ApiResponseDTO.<Page<SimpleProductResponse>>builder()
                .result(productService.getProducts(page, size, sortBy))
                .build();
    }

    @GetMapping("/search")
    public ApiResponseDTO<Page<SimpleProductResponse>> searchProducts(
            ProductSearchCriteria criteria,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return ApiResponseDTO.<Page<SimpleProductResponse>>builder()
                .result(productService.searchProductsForAdmin(criteria, page, size))
                .build();
    }

    @GetMapping("/{productId}")
    public ApiResponseDTO<ProductResponse> getProductById(@PathVariable long productId) {
        return ApiResponseDTO.<ProductResponse>builder()
                .result(productService.getById(productId))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponseDTO<ProductResponse> update(
            @PathVariable long id, @ModelAttribute @Valid ProductRequest request) {
        return ApiResponseDTO.<ProductResponse>builder()
                .result(productService.update(id, request))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponseDTO<String> delete(@PathVariable long id) {
        productService.delete(id);
        return ApiResponseDTO.<String>builder()
                .result("Product has been deleted")
                .build();
    }

    @PostMapping(value = "/variants", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponseDTO<ProductVariantResponse> createVariant(
            @ModelAttribute @Valid VariantCreationOneRequest request) {
        return ApiResponseDTO.<ProductVariantResponse>builder()
                .result(variantService.createOne(request))
                .build();
    }

    @PutMapping(value = "/variants/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponseDTO<ProductVariantResponse> updateVariant(
            @PathVariable long id, @ModelAttribute @Valid ProductVariantUpdateRequest request) {
        return ApiResponseDTO.<ProductVariantResponse>builder()
                .result(variantService.update(id, request))
                .build();
    }

    @DeleteMapping("/variants/{id}")
    public ApiResponseDTO<String> deleteVariant(@PathVariable long id) {
        variantService.delete(id);
        return ApiResponseDTO.<String>builder()
                .result("Product has been deleted")
                .build();
    }
}
