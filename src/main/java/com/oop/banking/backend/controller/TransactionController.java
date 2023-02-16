package com.oop.banking.backend.controller;

import com.oop.banking.backend.entity.Customer;
import com.oop.banking.backend.entity.Transaction;
import com.oop.banking.backend.repository.TransactionRepository;
import com.oop.banking.backend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping("/transaction/{accId}")
    public ResponseEntity<Transaction> createTransaction(@PathVariable int accId, @RequestBody Transaction transaction){
        return new ResponseEntity<>(service.createTransaction(accId, transaction), HttpStatus.CREATED);
    }

    @GetMapping("/transaction/{accId}/all")
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable int accId) {
        return new ResponseEntity<>(service.getAllTransactionsByAccId(accId), HttpStatus.OK);
    }


}
