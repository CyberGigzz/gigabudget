package com.gigabudget.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import com.gigabudget.model.Transaction;

public class InMemoryTransactionRepository implements TransactionRepository {

    private Map<Long, Transaction> map = new HashMap<>();
    private AtomicLong nextId = new AtomicLong(1);

    @Override
    public Transaction save(Transaction transaction) {
        if (transaction.getId() == null) {
            transaction.setId(nextId.getAndIncrement());
        }
        map.put(transaction.getId(), transaction);
        return transaction;
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public List<Transaction> findByUserId(Long userId) {
        return map.values().stream()
            .filter(transaction -> transaction.getUserId().equals(userId))
            .toList();
    }

    @Override
    public List<Transaction> findByAccountId(Long accountId) {
        return map.values().stream()
            .filter(transaction -> transaction.getAccountId().equals(accountId))
            .toList();
    }

    @Override
    public List<Transaction> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void deleteById(Long id) {
        map.remove(id);
    }
}
