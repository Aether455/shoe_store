package com.nguyenkhang.shoe_store.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.nguyenkhang.shoe_store.dto.ApiResponseDTO;
import com.nguyenkhang.shoe_store.dto.request.AddressRequest;
import com.nguyenkhang.shoe_store.dto.response.AddressResponse;
import com.nguyenkhang.shoe_store.service.AddressService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/addresses")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AddressController {
    AddressService addressService;

    @PostMapping
    public ApiResponseDTO<AddressResponse> create(@RequestBody @Valid AddressRequest request) {
        var response = addressService.create(request);
        return ApiResponseDTO.<AddressResponse>builder()
                .message("Success!")
                .result(response)
                .build();
    }

    @GetMapping
    public ApiResponseDTO<List<AddressResponse>> getAddresses() {
        var response = addressService.getAddresses();
        return ApiResponseDTO.<List<AddressResponse>>builder()
                .message("Success!")
                .result(response)
                .build();
    }

    @GetMapping("/{customerId}")
    public ApiResponseDTO<List<AddressResponse>> getAddressesByCustomerId(@PathVariable long customerId) {
        var response = addressService.getAllByCustomerId(customerId);
        return ApiResponseDTO.<List<AddressResponse>>builder()
                .message("Success!")
                .result(response)
                .build();
    }

    @DeleteMapping("/{addressId}")
    public ApiResponseDTO<String> delete(@PathVariable long addressId) {
        addressService.delete(addressId);
        return ApiResponseDTO.<String>builder()
                .message("Success!")
                .result("Address has been deleted")
                .build();
    }
}
