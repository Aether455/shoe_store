package com.nguyenkhang.mobile_store.init;

import com.nguyenkhang.mobile_store.entity.OptionValue;
import com.nguyenkhang.mobile_store.entity.Product;
import com.nguyenkhang.mobile_store.entity.ProductDocument;
import com.nguyenkhang.mobile_store.entity.ProductVariant;
import com.nguyenkhang.mobile_store.repository.ProductDocumentRepository;
import com.nguyenkhang.mobile_store.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class DataInitializer implements CommandLineRunner {
    ProductDocumentRepository productDocumentRepository;
    ProductRepository productRepository;



    ProductDocument mapToDocument(Product product){
        Double minPrice = null;
        Double maxPrice = null;

        var variants = product.getProductVariants();

        if (variants != null && !variants.isEmpty()){
            minPrice = product.getProductVariants().stream().mapToDouble(ProductVariant::getPrice).min().getAsDouble();
            maxPrice = product.getProductVariants().stream().mapToDouble(ProductVariant::getPrice).max().getAsDouble();
        }

        List<String> attributes = variants.stream()
                .flatMap(productVariant -> productVariant.getOptionValues()
                        .stream()).map(OptionValue::getValue)
                .distinct()
                .toList();

        return ProductDocument.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .mainImageUrl(product.getMainImageUrl())
                .brandName(product.getBrand() != null ? product.getBrand().getName() : null)
                .categoryName(product.getCategory() != null ? product.getCategory().getName() : null)
                .minPrice(minPrice)
                .maxPrice(maxPrice)
                .variantAttributes(attributes)
                .build();
    }


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        log.info("Start syncing data with Elasticsearch...");

        productDocumentRepository.deleteAll();
        List<Product> allProducts = productRepository.findAll();
        List<ProductDocument> documents = allProducts.stream().map(this::mapToDocument).toList();

        productDocumentRepository.saveAll(documents);

        log.info("Đồng bộ hoàn tất! Tổng cộng {} sản phẩm.", documents.size());
    }
}
