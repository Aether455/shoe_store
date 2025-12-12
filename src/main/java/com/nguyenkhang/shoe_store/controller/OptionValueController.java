package com.nguyenkhang.shoe_store.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.nguyenkhang.shoe_store.dto.ApiResponseDTO;
import com.nguyenkhang.shoe_store.dto.request.option.OptionValueRequest;
import com.nguyenkhang.shoe_store.dto.response.option.OptionValueResponse;
import com.nguyenkhang.shoe_store.service.OptionValueService;

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
    public ApiResponseDTO<List<OptionValueResponse>> getByOptionId(@PathVariable long optionId) {
        return ApiResponseDTO.<List<OptionValueResponse>>builder()
                .result(optionValueService.getByOptionId(optionId))
                .build();
    }

    @PostMapping
    public ApiResponseDTO<OptionValueResponse> create(@RequestBody @Valid OptionValueRequest request) {
        return ApiResponseDTO.<OptionValueResponse>builder()
                .result(optionValueService.create(request))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponseDTO<String> delete(@PathVariable long id) {
        optionValueService.delete(id);
        return ApiResponseDTO.<String>builder()
                .result("Option value has been deleted")
                .build();
    }
}
