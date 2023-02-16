package com.oop.banking.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "memo")
    private String memo;


    @Column(name="amount")
    private Double amount;

    @Column(name = "time_stamp")
    private LocalDateTime timeStamp;

    @Column(name="receiver_id")
    private int receiverAccId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    public Transaction() {
        this.timeStamp = LocalDateTime.now();
    }


}
