package com.gigabudget.service;

import java.math.BigDecimal;
import java.util.List;

import com.gigabudget.model.Account;
import com.gigabudget.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(Account account) {
        if (account.getBalance() == null) {
            account.setBalance(BigDecimal.ZERO);
        }
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Account not found with id: " + id));
    }

    @Override
    public List<Account> getAccountsByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    @Override
    public void deleteAccount(Long id) {
        getAccountById(id);
        accountRepository.deleteById(id);
    }
}
