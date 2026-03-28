package com.gigabudget.repository;

import java.util.List;
import java.util.Optional;

import com.gigabudget.model.Account;

public interface AccountRepository {

    Account save(Account account);

    Optional<Account> findById(Long id);

    List<Account> findByUserId(Long userId);

    List<Account> findAll();

    void deleteById(Long id);

}