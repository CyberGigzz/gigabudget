package com.gigabudget.service;

import java.util.List;

import com.gigabudget.model.Account;

public interface AccountService {

    Account createAccount(Account account);

    Account getAccountById(Long id);

    List<Account> getAccountsByUserId(Long userId);

    void deleteAccount(Long id);

}
