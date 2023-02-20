package com.oop.banking.backend.repository;

import com.oop.banking.backend.entity.Account;
import com.oop.banking.backend.entity.Bank;
import com.oop.banking.backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BankRepository extends JpaRepository<Bank, Integer> {
}
