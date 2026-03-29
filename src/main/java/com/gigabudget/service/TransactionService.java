package com.gigabudget.service;

import java.util.List;

import com.gigabudget.model.Transaction;

public interface TransactionService {

    Transaction addTransaction(Transaction transaction);

    Transaction getTransactionById(Long id);

    List<Transaction> getTransactionsByUserId(Long userId);

    List<Transaction> getTransactionsByAccountId(Long accountId);

    void deleteTransaction(Long id);

}
