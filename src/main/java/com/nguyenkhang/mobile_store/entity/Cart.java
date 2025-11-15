package com.nguyenkhang.mobile_store.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    List<CartItem> cartItems;

    @CreationTimestamp
    LocalDateTime createAt;
}
