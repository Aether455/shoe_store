package com.nguyenkhang.shoe_store.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderStatusHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    Order order;

    String oldStatus;
    String newStatus;

    @ManyToOne
    @JoinColumn(name = "change_by")
    User changeBy;

    @CreationTimestamp
    LocalDateTime changeAt;
}
