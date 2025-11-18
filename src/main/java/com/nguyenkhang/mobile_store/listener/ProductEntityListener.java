package com.nguyenkhang.mobile_store.listener;

import com.nguyenkhang.mobile_store.entity.Product;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@FieldDefaults(level = AccessLevel.PUBLIC)
public class ProductEntityListener {
    @PostPersist
    @PostUpdate
    public void onSaveOrUpdate(Product product){
        BeanUtil.getProductService().syncProductToElasticSearch(product);
    }

    @PostRemove
    public void onRemove(Product product){
        BeanUtil.getProductService().removeProductFromElastic(product.getId());
    }
}
