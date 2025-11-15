package com.nguyenkhang.mobile_store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.nguyenkhang.mobile_store.dto.request.products.ProductVariantUpdateRequest;
import com.nguyenkhang.mobile_store.dto.request.products.VariantCreationOneRequest;
import com.nguyenkhang.mobile_store.dto.request.products.VariantCreationRequest;
import com.nguyenkhang.mobile_store.dto.response.product_variant.ProductVariantResponse;
import com.nguyenkhang.mobile_store.entity.ProductVariant;

@Mapper(componentModel = "spring")
public interface ProductVariantMapper {
    @Mapping(target = "optionValues", ignore = true)
    @Mapping(target = "product", ignore = true)
    ProductVariant toVariantCreateOne(VariantCreationOneRequest request);

    @Mapping(target = "optionValues", ignore = true)
    @Mapping(target = "product", ignore = true)
    ProductVariant toVariantCreateMany(VariantCreationRequest request);

    ProductVariantResponse toProductVariantResponse(ProductVariant productVariant);

    @Mapping(target = "optionValues", ignore = true)
    @Mapping(target = "product", ignore = true)
    void updateProductVariant(@MappingTarget ProductVariant productVariant, ProductVariantUpdateRequest request);
}
