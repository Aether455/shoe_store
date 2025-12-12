package com.nguyenkhang.shoe_store.controller.user;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.nguyenkhang.shoe_store.dto.ApiResponseDTO;
import com.nguyenkhang.shoe_store.dto.response.category.CategoryResponseForCustomer;
import com.nguyenkhang.shoe_store.service.CategoryService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/user/categories")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserCategoryController {

    CategoryService categoryService;

    @GetMapping
    public ApiResponseDTO<List<CategoryResponseForCustomer>> getCategories() {
        return ApiResponseDTO.<List<CategoryResponseForCustomer>>builder()
                .result(categoryService.getCategoriesForUser())
                .build();
    }
}
