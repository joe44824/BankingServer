package com.oop.banking.backend.controller;

import com.oop.banking.backend.entity.Account;
import com.oop.banking.backend.entity.Customer;
import com.oop.banking.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping("/account/{customerId}")
    public ResponseEntity<Account> createAccount(@PathVariable String customerId, @RequestBody Account account){
        return new ResponseEntity<>(service.createAccount(account, customerId), HttpStatus.OK);
    }

    @GetMapping("/account/{customerId}/all")
    public ResponseEntity<List<Account>> getAccounts(@PathVariable String customerId) {
        return new ResponseEntity<>(service.getAccountsByCustomerId(customerId), HttpStatus.OK);
    }

    @GetMapping("/account/{accId}")
    public ResponseEntity<Account> getAccount(@PathVariable int accId) {
        return new ResponseEntity<>(service.getAccount(accId), HttpStatus.OK);
    }

    @DeleteMapping("/account/{accId}")
    public ResponseEntity<String> deleteAccount(@PathVariable int accId) {
        return new ResponseEntity<>(service.deleteAccount(accId), HttpStatus.OK);
    }
}
