package com.gigabudget.service;

import java.util.List;

import com.gigabudget.model.Category;

public interface CategoryService {

    Category createCategory(Category category);

    Category getCategoryById(Long id);

    List<Category> getCategoriesByUserId(Long userId);

    void deleteCategory(Long id);

}
