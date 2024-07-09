package com.ayna.category.service;

import java.util.List;

import com.ayna.category.entity.Category;

public interface CategoryService {
	public Category saveCategory(Category category);
	public List<Category> getAllCategories();
	public void deleteCategory(Long categoryId);
}
