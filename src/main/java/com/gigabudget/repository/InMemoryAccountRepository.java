package com.gigabudget.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import com.gigabudget.model.Account;

public class InMemoryAccountRepository implements AccountRepository {

    private Map<Long, Account> map = new HashMap<>();
    private AtomicLong nextId = new AtomicLong(1);

    @Override
    public Account save(Account account) {
        if (account.getId() == null) {
            account.setId(nextId.getAndIncrement());
        }
        map.put(account.getId(), account);
        return account;
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public List<Account> findByUserId(Long userId) {
        return map.values().stream()
            .filter(account -> account.getUserId().equals(userId))
            .toList();
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void deleteById(Long id) {
        map.remove(id);
    }
}
