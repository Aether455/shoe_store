package com.nguyenkhang.mobile_store.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.nguyenkhang.mobile_store.dto.ApiResponse;
import com.nguyenkhang.mobile_store.dto.request.option.OptionValueRequest;
import com.nguyenkhang.mobile_store.dto.response.option.OptionValueResponse;
import com.nguyenkhang.mobile_store.service.OptionValueService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/option_values")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OptionValueController {
    OptionValueService optionValueService;

    @GetMapping("/{optionId}")
    public ApiResponse<List<OptionValueResponse>> getByOptionId(@PathVariable long optionId) {
        return ApiResponse.<List<OptionValueResponse>>builder()
                .result(optionValueService.getByOptionId(optionId))
                .build();
    }

    @PostMapping
    public ApiResponse<OptionValueResponse> create(@RequestBody @Valid OptionValueRequest request) {
        return ApiResponse.<OptionValueResponse>builder()
                .result(optionValueService.create(request))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable long id) {
        optionValueService.delete(id);
        return ApiResponse.<String>builder()
                .result("Option value has been deleted")
                .build();
    }
}
