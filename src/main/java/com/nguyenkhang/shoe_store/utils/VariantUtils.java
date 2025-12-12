package com.nguyenkhang.shoe_store.utils;

import java.util.Set;
import java.util.stream.Collectors;

import com.nguyenkhang.shoe_store.entity.OptionValue;
import com.nguyenkhang.shoe_store.exception.AppException;
import com.nguyenkhang.shoe_store.exception.ErrorCode;

public class VariantUtils {
    public static String createVariantSignature(Set<OptionValue> optionValues) {
        if (optionValues == null || optionValues.isEmpty()) {
            throw new AppException(ErrorCode.OPTION_VALUE_EMPTY);
        }

        return optionValues.stream()
                .map((value) -> value.getId().toString())
                .sorted()
                .collect(Collectors.joining("_"));
    }
}
