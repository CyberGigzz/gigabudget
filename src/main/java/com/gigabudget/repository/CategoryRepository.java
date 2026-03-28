package com.gigabudget.repository;

import java.util.List;
import java.util.Optional;

import com.gigabudget.model.Category;

public interface CategoryRepository {

    Category save(Category category);

    Optional<Category> findById(Long id);

    List<Category> findByUserId(Long userId);

    List<Category> findAll();

    void deleteById(Long id);

}
