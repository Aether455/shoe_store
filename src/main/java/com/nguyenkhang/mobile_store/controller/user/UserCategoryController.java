package com.nguyenkhang.mobile_store.controller.user;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.nguyenkhang.mobile_store.dto.ApiResponse;
import com.nguyenkhang.mobile_store.dto.response.category.CategoryResponseForCustomer;
import com.nguyenkhang.mobile_store.service.CategoryService;

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
    public ApiResponse<List<CategoryResponseForCustomer>> getCategories() {
        return ApiResponse.<List<CategoryResponseForCustomer>>builder()
                .result(categoryService.getCategoriesForUser())
                .build();
    }
}
