package com.oop.banking.backend.service;

import com.oop.banking.backend.entity.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account, String customerId);

    Account getAccount(int id);


    List<Account> getAccountsByCustomerId(String customerId);

    String deleteAccount(int id);


}
