package com.oop.banking.backend.repository;

import com.oop.banking.backend.entity.Account;
import com.oop.banking.backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    List<Account> findByCustomerId(int customerId);

    Account findByCustomerIdAndAccountType(int customerId, String accountType);

}
