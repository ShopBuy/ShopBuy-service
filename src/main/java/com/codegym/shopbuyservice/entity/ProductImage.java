package com.codegym.shopbuyservice.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "IMAGE_PRODUCT")
@Where(clause = "IS_DELETED = 0")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "URL")
    private String url;

    @Column(name = "IS_DELETED")
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}
