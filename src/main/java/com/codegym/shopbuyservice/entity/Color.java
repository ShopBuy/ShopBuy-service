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
@Table(name = "COLOR")
@Where(clause = "IS_DELETED = 0")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CODE")
    private String code;

    @Column(name = "ACRONYM")
    private String acronym;

    @Column(name = "IS_DELETED")
    private boolean isDeleted;

    @OneToMany(mappedBy = "color",fetch = FetchType.LAZY)
    private List<Variant> variantList;
}


