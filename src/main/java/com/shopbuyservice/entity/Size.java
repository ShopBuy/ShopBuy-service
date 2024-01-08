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
@Table(name = "SIZE")
@Where(clause = "IS_DELETED = 0")
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IS_DELETED")
    private boolean isDeleted;

    @OneToMany(mappedBy = "size",fetch = FetchType.LAZY)
    private List<Variant> variantList;
}
