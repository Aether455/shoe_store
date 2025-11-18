package com.nguyenkhang.mobile_store.repository;

import com.nguyenkhang.mobile_store.entity.ProductDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDocumentRepository extends ElasticsearchRepository<ProductDocument, Long> {
    List<ProductDocument> findByNameContaining(String keyword);

    @Query("{\"multi_match\":{\"query\":\"?0\"," +
                    "\"fields\":[\"name^3\",\"description\",\"brandName\",\"categoryName\",\"variantAttributes\"]," +
                    " \"fuzziness\": \"AUTO\"}}")
    Page<ProductDocument> searchByMultiMatch(String keyword, Pageable pageable);
}
