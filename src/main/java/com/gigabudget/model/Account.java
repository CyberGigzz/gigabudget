package com.gigabudget.model;

import java.math.BigDecimal;

public class Account {

    private Long id;
    private Long userId;
    private String name;
    private AccountType type;
    private BigDecimal balance;

    public Account() {
    }

    public Account(Long id, Long userId, String name, AccountType type, BigDecimal balance) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.type = type;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", balance=" + balance +
                '}';
    }
}
