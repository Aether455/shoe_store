package com.nguyenkhang.shoe_store.mapper;

import org.mapstruct.Mapper;

import com.nguyenkhang.shoe_store.dto.request.option.OptionRequest;
import com.nguyenkhang.shoe_store.dto.response.option.OptionResponse;
import com.nguyenkhang.shoe_store.dto.response.option.SimpleOptionResponse;
import com.nguyenkhang.shoe_store.entity.Option;

@Mapper(componentModel = "spring")
public interface OptionMapper {
    Option toOption(OptionRequest request);

    OptionResponse toOptionResponse(Option option);

    SimpleOptionResponse toSimpleOptionResponse(Option option);
}
