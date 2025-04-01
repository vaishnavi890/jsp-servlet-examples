package com.vaishnavi.practice.servlet.service;

import com.vaishnavi.practice.servlet.model.Transaction;
import com.vaishnavi.practice.servlet.repository.TransactionRepository;
import java.util.List;

public class TransactionService {
    private final TransactionRepository repository = new TransactionRepository();

    public void processTransaction(Transaction transaction) {
        // Business logic: Check balance, validate amount, update status
        if (transaction.getAmount() > 0) {
            transaction.setStatus("SUCCESS");
            repository.saveTransaction(transaction);
        } else {
            transaction.setStatus("FAILED");
        }
    }

    public Transaction getTransaction(int transactionId) {
        return repository.getTransactionById(transactionId);
    }

    public List<Transaction> getAllTransactions() {
        return repository.getAllTransactions();
    }
}



