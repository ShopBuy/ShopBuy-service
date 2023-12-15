package com.codegym.shopbuyservice.entity;


import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCT")
@Where(clause = "IS_DELETED = 0")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "STOCK")
    private int stock;

//    @Column(name = "GENDEREDCLOTHING")    //đã có trong category
//    private String genderedClothing;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STAR")
    private int star;

    @Column(name = "IS_DELETED")
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "SUB_CATEGORY_ID")
    private SubCategory subCategory;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ImageProduct> imageProductList ;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Review> reviews ;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<CartItem> cartProductList ;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<OrderLine> orderLineList ;

    @OneToMany(mappedBy = "product")
    private List<Variant> variantList;
}
