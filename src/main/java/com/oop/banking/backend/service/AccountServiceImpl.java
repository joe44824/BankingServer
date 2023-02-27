package com.oop.banking.backend.service;

import com.oop.banking.backend.entity.Account;
import com.oop.banking.backend.entity.Customer;
import com.oop.banking.backend.repository.AccountRepository;
import com.oop.banking.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Account createAccount(Account account, String customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        account.setCustomer(customer);
        return accountRepository.save(account);
    }

    @Override
    public Account getAccount(int id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public List<Account> getAccountsByCustomerId(String customerId) {
        return accountRepository.findByCustomerId(customerId);
    }


    @Override
    public String deleteAccount(int id) {

        String customerId = accountRepository.findById(id).get().getCustomer().getId();

        Double existingBalance = accountRepository.findById(id).get().getBalance();

        // METHOD 1
//        Account mainAccount = customerRepository.findById(customerId).get().getAccounts().get(0);

        Account mainAccount = accountRepository.findByCustomerIdAndAccountType(customerId, "MAIN");

        // Transfer balance from account to MAIN account
        mainAccount.setBalance(mainAccount.getBalance() + existingBalance);

        accountRepository.deleteById(id);
        return "Account (" + id + ") removed";
    }


}
