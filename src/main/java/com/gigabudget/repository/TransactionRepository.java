package com.gigabudget.repository;

import java.util.List;
import java.util.Optional;

import com.gigabudget.model.Transaction;

public interface TransactionRepository {

    Transaction save(Transaction transaction);

    Optional<Transaction> findById(Long id);

    List<Transaction> findByUserId(Long userId);

    List<Transaction> findByAccountId(Long accountId);

    List<Transaction> findAll();

    void deleteById(Long id);

}
