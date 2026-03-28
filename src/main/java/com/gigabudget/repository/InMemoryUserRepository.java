package com.gigabudget.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import com.gigabudget.model.User;

public class InMemoryUserRepository implements UserRepository {

    private Map<Long, User> map = new HashMap<>();
    private AtomicLong nextId = new AtomicLong(1);

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(nextId.getAndIncrement());
        }
        map.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public List<User> findAll() {
        
        return new ArrayList<>(map.values());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        
        return map.values().stream().
            filter(user -> user.getEmail().equals(email)).findFirst();
    }

    @Override
    public void deleteById(Long id) {
        map.remove(id);
        
    }
}
