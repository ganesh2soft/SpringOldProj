package com.ayna.category.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayna.category.entity.Category;
import com.ayna.category.repo.CategoryRepo;


@Service
public class CategoryServiceImpl implements CategoryService {

	
	@Autowired
	CategoryRepo categoryRepo;

	public Category saveCategory(Category category) {
		
		return categoryRepo.save(category);
	}

	public List<Category> getAllCategories() {
		
		return categoryRepo.findAll();
	}
	public void deleteCategory(Long categoryId) {
		categoryRepo.deleteById(categoryId);
	}
	
}
