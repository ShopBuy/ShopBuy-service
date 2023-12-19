package com.codegym.shopbuyservice.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "GENDER", unique = true, nullable = false)
    private String gender;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;


    @Column(name="IS_DELETED")
    private boolean isDeleted;


    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Address> addressList ;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID")
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Review> reviews ;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> orderList ;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;

}