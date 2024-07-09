package com.ayna.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayna.category.entity.Category;
import com.ayna.category.service.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryCtrl {
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/addcategory")
	public Category  saveCategory(@RequestBody Category category) {
		return categoryService.saveCategory(category);
	}
	
	@GetMapping("/allcategories")
	public List<Category> fetchAllCategories(){
		return categoryService.getAllCategories();
	}
	@DeleteMapping("/deletecategory/{categoryId}")
	public void deleteCategoryById(@PathVariable("categoryId") Long cid) {
		categoryService.deleteCategory(cid);
		
	}

}
