package com.gigabudget.model;

public class Category {

    private Long id;
    private Long userId;
    private String name;
    private TransactionType type;

    public Category() {
    }

    public Category(Long id, Long userId, String name, TransactionType type) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.type = type;
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

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
