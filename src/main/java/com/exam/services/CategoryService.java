package com.exam.services;

import java.util.Set;

import com.exam.models.exam.Category;

public interface CategoryService {
public Category addCategory(Category category) throws Exception;
public Category updateCategory(Category category) throws Exception;
public Set<Category> getAllCategories();
public Category getCategoryById(Long categoryId);
public void deleteCategory(Long categoryId);
}
