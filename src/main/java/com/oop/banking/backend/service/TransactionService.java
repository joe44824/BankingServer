package com.oop.banking.backend.service;

import com.oop.banking.backend.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TransactionService {

    Transaction createTransaction(int accId, Transaction transaction);
    List<Transaction> getAllTransactionsByAccId(int accId);

}
