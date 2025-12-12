package com.nguyenkhang.shoe_store.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.nguyenkhang.shoe_store.dto.ApiResponseDTO;
import com.nguyenkhang.shoe_store.dto.request.category.CategoryCreationRequest;
import com.nguyenkhang.shoe_store.dto.request.category.CategoryUpdateRequest;
import com.nguyenkhang.shoe_store.dto.response.category.CategoryResponse;
import com.nguyenkhang.shoe_store.service.CategoryService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryController {

    CategoryService categoryService;

    @PostMapping
    public ApiResponseDTO<CategoryResponse> create(@RequestBody CategoryCreationRequest request) {
        var result = categoryService.create(request);

        return ApiResponseDTO.<CategoryResponse>builder().result(result).build();
    }

    @GetMapping
    public ApiResponseDTO<List<CategoryResponse>> getCategories() {
        return ApiResponseDTO.<List<CategoryResponse>>builder()
                .result(categoryService.getCategories())
                .build();
    }

    @PutMapping("/{categoryId}")
    public ApiResponseDTO<CategoryResponse> update(
            @PathVariable long categoryId, @RequestBody CategoryUpdateRequest request) {
        var category = categoryService.update(categoryId, request);
        return ApiResponseDTO.<CategoryResponse>builder().result(category).build();
    }

    @DeleteMapping("/{categoryId}")
    public ApiResponseDTO<String> delete(@PathVariable long categoryId) {
        categoryService.delete(categoryId);
        return ApiResponseDTO.<String>builder()
                .message("Success!")
                .result("Category has been deleted!")
                .build();
    }
}
