package com.nguyenkhang.mobile_store.listener;

import com.nguyenkhang.mobile_store.service.ProductService;
import jakarta.annotation.PostConstruct;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Component
public class BeanUtil {

    @NonFinal
    static BeanUtil instance;

    ProductService productService;

    public static ProductService getProductService() {
        return instance.productService;
    }



    @PostConstruct
    public void registerInstance(){
        instance=this;
    }



}
