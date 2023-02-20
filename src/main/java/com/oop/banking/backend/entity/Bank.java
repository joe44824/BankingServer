package com.oop.banking.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @NonNull
    @Column(name = "id")
    private int id;

    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    @NonNull
    @Column(name = "local", nullable = false)
    private boolean local;

//    @JsonIgnore
//    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
//    private List<Customer> customers;


}
