package com.nguyenkhang.mobile_store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.nguyenkhang.mobile_store.dto.request.option.OptionValueRequest;
import com.nguyenkhang.mobile_store.dto.response.option.OptionValueResponse;
import com.nguyenkhang.mobile_store.entity.OptionValue;

@Mapper(componentModel = "spring")
public interface OptionValueMapper {
    @Mapping(target = "option", ignore = true)
    OptionValue toOptionValue(OptionValueRequest request);

    OptionValueResponse toOptionValueResponse(OptionValue optionValue);
}
