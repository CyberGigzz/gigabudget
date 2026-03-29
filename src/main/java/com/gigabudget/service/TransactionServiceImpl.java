package com.gigabudget.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.gigabudget.model.Account;
import com.gigabudget.model.Transaction;
import com.gigabudget.model.TransactionType;
import com.gigabudget.repository.TransactionRepository;

public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountService accountService;

    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
    }

    @Override
    public Transaction addTransaction(Transaction transaction) {
        if (transaction.getAmount() == null || transaction.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transaction amount must be positive");
        }

        Account account = accountService.getAccountById(transaction.getAccountId());

        if (transaction.getType() == TransactionType.INCOME) {
            account.setBalance(account.getBalance().add(transaction.getAmount()));
        } else {
            if (account.getBalance().compareTo(transaction.getAmount()) < 0) {
                throw new IllegalArgumentException("Insufficient balance in account: " + account.getName());
            }
            account.setBalance(account.getBalance().subtract(transaction.getAmount()));
        }

        transaction.setCreatedAt(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Transaction not found with id: " + id));
    }

    @Override
    public List<Transaction> getTransactionsByUserId(Long userId) {
        return transactionRepository.findByUserId(userId);
    }

    @Override
    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

    @Override
    public void deleteTransaction(Long id) {
        getTransactionById(id);
        transactionRepository.deleteById(id);
    }
}
