package com.productManagement.service;

import java.util.List;

import com.productManagement.Model.Category;

public interface CategoryService {
	Category addCategory(Category categoryDetails);
	Category updateCategory(Category categoryDetails);
	List<Category> viewCategories();
	void deleteCategory(long categoryId);
}
