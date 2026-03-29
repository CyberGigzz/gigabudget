package com.gigabudget.service;

import java.util.List;

import com.gigabudget.model.User;

public interface UserService {

    User createUser(User user);

    User getUserById(Long id);

    User getUserByEmail(String email);

    List<User> getAllUsers();

    void deleteUser(Long id);

}
