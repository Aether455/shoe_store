package com.nguyenkhang.mobile_store.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.nguyenkhang.mobile_store.dto.ApiResponseDTO;
import com.nguyenkhang.mobile_store.dto.request.option.OptionRequest;
import com.nguyenkhang.mobile_store.dto.response.option.OptionResponse;
import com.nguyenkhang.mobile_store.service.OptionService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/options")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OptionController {
    OptionService optionService;

    @GetMapping
    public ApiResponseDTO<List<OptionResponse>> getAll() {
        return ApiResponseDTO.<List<OptionResponse>>builder()
                .result(optionService.getAll())
                .build();
    }

    @PostMapping
    public ApiResponseDTO<OptionResponse> create(@RequestBody OptionRequest request) {
        return ApiResponseDTO.<OptionResponse>builder()
                .result(optionService.create(request))
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponseDTO<OptionResponse> getById(@PathVariable long id) {
        return ApiResponseDTO.<OptionResponse>builder()
                .result(optionService.getById(id))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponseDTO<String> delete(@PathVariable long id) {
        optionService.delete(id);
        return ApiResponseDTO.<String>builder()
                .result("Option has been deleted")
                .build();
    }
}
