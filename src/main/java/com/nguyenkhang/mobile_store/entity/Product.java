package com.nguyenkhang.mobile_store.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.nguyenkhang.mobile_store.listener.ProductEntityListener;
import jakarta.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@EntityListeners(ProductEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(columnDefinition = "TEXT")
    String description;

    @Column(columnDefinition = "TEXT")
    String mainImageUrl;

    String imagePublicId;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ProductVariant> productVariants;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    Brand brand;

    @ManyToOne
    @JoinColumn(name = "create_by")
    User createBy;

    @ManyToOne
    @JoinColumn(name = "update_by")
    User updateBy;

    @CreationTimestamp
    LocalDateTime createAt;

    @UpdateTimestamp
    LocalDateTime updateAt;
}
