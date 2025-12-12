package com.nguyenkhang.shoe_store.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "options")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Long id;

    @Column(unique = true, nullable = false)
    String name;

    @OneToMany(mappedBy = "option", cascade = CascadeType.ALL)
    List<OptionValue> optionValues;

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
