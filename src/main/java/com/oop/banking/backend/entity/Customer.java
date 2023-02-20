package com.oop.banking.backend.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oop.banking.backend.util.Helper;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @NonNull
    @Column(name = "id", nullable = false)
    private int id;


    @NonNull
    @Column(name = "first_name" , nullable = false)
    private String firstName;


    @NonNull
    @Column(name = "last_name", nullable = false)
    private String lastName;


    @NonNull
    @Column(name = "hashed_pin", nullable = false)
    private long hashedPin;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Account> accounts;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    private Bank bank;

}


