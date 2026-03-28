package com.gigabudget.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import com.gigabudget.model.Category;

public class InMemoryCategoryRepository implements CategoryRepository {

    private Map<Long, Category> map = new HashMap<>();
    private AtomicLong nextId = new AtomicLong(1);

    @Override
    public Category save(Category category) {
        if (category.getId() == null) {
            category.setId(nextId.getAndIncrement());
        }
        map.put(category.getId(), category);
        return category;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public List<Category> findByUserId(Long userId) {
        return map.values().stream()
            .filter(category -> category.getUserId().equals(userId))
            .toList();
    }

    @Override
    public List<Category> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void deleteById(Long id) {
        map.remove(id);
    }
}
