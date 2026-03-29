package com.gigabudget.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

    private Long id;
    private Long userId;
    private Long accountId;
    private Long categoryId;
    private BigDecimal amount;
    private TransactionType type;
    private String description;
    private LocalDateTime transactionDate;
    private LocalDateTime createdAt;

    public Transaction() {
    }

    public Transaction(Long id, Long userId, Long accountId, Long categoryId, BigDecimal amount,
                       TransactionType type, String description, LocalDateTime transactionDate,
                       LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.accountId = accountId;
        this.categoryId = categoryId;
        this.amount = amount;
        this.type = type;
        this.description = description;
        this.transactionDate = transactionDate;
        this.createdAt = createdAt;
    }

    public Transaction(Long userId, Long accountId, Long categoryId, BigDecimal amount,
                       TransactionType type, String description, LocalDateTime transactionDate) {
        this.userId = userId;
        this.accountId = accountId;
        this.categoryId = categoryId;
        this.amount = amount;
        this.type = type;
        this.description = description;
        this.transactionDate = transactionDate;
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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", userId=" + userId +
                ", accountId=" + accountId +
                ", categoryId=" + categoryId +
                ", amount=" + amount +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", transactionDate=" + transactionDate +
                ", createdAt=" + createdAt +
                '}';
    }
}
