package com.nguyenkhang.mobile_store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.nguyenkhang.mobile_store.dto.request.products.ProductAndVariantsCreationRequest;
import com.nguyenkhang.mobile_store.dto.request.products.ProductRequest;
import com.nguyenkhang.mobile_store.dto.response.product.*;
import com.nguyenkhang.mobile_store.entity.Product;
import com.nguyenkhang.mobile_store.entity.ProductDocument;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "category", ignore = true)
    @Mapping(target = "brand", ignore = true)
    Product toProduct(ProductAndVariantsCreationRequest request);

    ProductResponse toProductResponse(Product product);

    SimpleProductResponse toSimpleProductResponse(Product product);

    ProductResponseForCustomer toProductResponseForCustomer(Product product);

    SimpleProductResponseForCustomer toSimpleProductResponseForCustomer(Product product);

    SimpleProductSearchResponse toSimpleProductSearchResponse(ProductDocument document);

    @Mapping(target = "category", ignore = true)
    @Mapping(target = "brand", ignore = true)
    void updateProduct(@MappingTarget Product product, ProductRequest request);
}
