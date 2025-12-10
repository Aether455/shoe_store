package com.nguyenkhang.mobile_store.controller;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.nguyenkhang.mobile_store.dto.ApiResponseDTO;
import com.nguyenkhang.mobile_store.dto.request.user.*;
import com.nguyenkhang.mobile_store.dto.response.user.*;
import com.nguyenkhang.mobile_store.service.UserService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/users")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserController {
    UserService userService;

    @PostMapping
    public ApiResponseDTO<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {

        return ApiResponseDTO.<UserResponse>builder()
                .result(userService.createUser(request))
                .build();
    }

    @PostMapping("/customers") // dành cho customer
    public ApiResponseDTO<UserResponseForCustomer> createUserForCustomer(
            @RequestBody @Valid UserCreationRequestForCustomer request) {

        return ApiResponseDTO.<UserResponseForCustomer>builder()
                .result(userService.createUserForCustomer(request))
                .build();
    }

    @PostMapping("/staffs") // dành cho trang quản lý nhân viên
    public ApiResponseDTO<UserResponse> createUserForStaff(@RequestBody @Valid UserCreationRequestForStaff request) {

        return ApiResponseDTO.<UserResponse>builder()
                .result(userService.createUserForStaff(request))
                .build();
    }

    @GetMapping
    public ApiResponseDTO<Page<UserResponse>> getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return ApiResponseDTO.<Page<UserResponse>>builder()
                .result(userService.getUsers(page, size, sortBy))
                .build();
    }

    @GetMapping("/{userId}") // detail
    public ApiResponseDTO<UserResponse> getUserById(@PathVariable("userId") long userId) {
        return ApiResponseDTO.<UserResponse>builder()
                .result(userService.getUserById(userId))
                .build();
    }

    @PutMapping("/{userId}")
    public ApiResponseDTO<UserResponse> updateUser(
            @PathVariable("userId") long userId, @RequestBody @Valid UserUpdateRequest request) {

        return ApiResponseDTO.<UserResponse>builder()
                .result(userService.updateUser(userId, request))
                .build();
    }

    @DeleteMapping("/{userId}")
    ApiResponseDTO<String> deleteUser(@PathVariable long userId) {
        userService.deleteUser(userId);
        return ApiResponseDTO.<String>builder().result("User has been deleted").build();
    }

    @PutMapping("/change-password")
    ApiResponseDTO<SimpleUserResponse> changePassword(@RequestBody UserChangePasswordRequest request) {
        return ApiResponseDTO.<SimpleUserResponse>builder()
                .result(userService.changePassword(request))
                .build();
    }

    @GetMapping("/search")
    public ApiResponseDTO<Page<UserResponse>> searchUsers(
            @RequestParam(defaultValue = "0") int page, @RequestParam String keyword) {
        return ApiResponseDTO.<Page<UserResponse>>builder()
                .result(userService.searchUser(keyword, page))
                .build();
    }

    @GetMapping("/me") // dành cho customer
    public ApiResponseDTO<SimpleUserInfoResponse> getMyInfo() {
        return ApiResponseDTO.<SimpleUserInfoResponse>builder()
                .result(userService.getMyInfo())
                .build();
    }
}
