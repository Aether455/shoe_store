package com.nguyenkhang.shoe_store.listener;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.nguyenkhang.shoe_store.service.ProductService;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component
public class BeanUtil {

    @NonFinal
    static BeanUtil instance;

    ProductService productService;

    public static ProductService getProductService() {
        return instance.productService;
    }

    @PostConstruct
    public void registerInstance() {
        instance = this;
    }
}
