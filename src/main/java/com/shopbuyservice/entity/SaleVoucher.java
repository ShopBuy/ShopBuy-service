package com.shopbuyservice.entity;

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
@Table(name = "SALE_VOUCHER")
@Where(clause = "IS_DELETED = 0")
public class SaleVoucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "DISCOUNT")
    private double discount;

    @Column(name = "IS_DELETED")
    private boolean isDeleted;

    @OneToMany(mappedBy = "saleVoucher", fetch = FetchType.LAZY)
    private List<Order> orderList;
}
