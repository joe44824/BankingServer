package com.oop.banking.backend.service;

import com.oop.banking.backend.entity.Account;
import com.oop.banking.backend.entity.Customer;
import com.oop.banking.backend.entity.Transaction;
import com.oop.banking.backend.repository.AccountRepository;
import com.oop.banking.backend.repository.CustomerRepository;
import com.oop.banking.backend.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Transaction createTransaction( int accId, Transaction transaction) {

        double senderBalance = accountRepository
                .findById(accId)
                .get()
                .getBalance();

        double receiverBalance = accountRepository
                .findById(transaction.getReceiverAccId())
                .get()
                .getBalance();

        Account account = accountRepository
                .findById(accId)
                .get();

                accountRepository
                .findById(accId).get()
                .setBalance(senderBalance- transaction.getAmount());
        accountRepository
                .findById(transaction.getReceiverAccId()).get()
                .setBalance(receiverBalance + transaction.getAmount());

        transaction.setAccount(account);
        return transactionRepository.save(transaction);
    }



    @Override
    public List<Transaction> getAllTransactionsByAccId(int accId) {
        return transactionRepository.findByAccountId(accId);
    }

}
