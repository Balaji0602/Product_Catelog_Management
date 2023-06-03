package com.productManagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.productManagement.Model.Category;
import com.productManagement.repository.CategoryRepo;
import com.productManagement.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private final CategoryRepo categoryRepo;

	public CategoryServiceImpl(CategoryRepo categoryRepo) {
		this.categoryRepo = categoryRepo;
	}

	@Override
	public Category addCategory(Category categoryDetails) {
		return categoryRepo.save(categoryDetails);
	}

	@Override
	public Category updateCategory(Category categoryDetails) {
		Category existingCategory = categoryRepo.findById(categoryDetails.getCategoryid()).orElse(null);
        if (existingCategory == null) {
            throw new RuntimeException("Category not found");
        }
        existingCategory.setCategoryName(categoryDetails.getCategoryName());
        
		return categoryRepo.save(existingCategory);
	}

	@Override
	public List<Category> viewCategories() {
		return categoryRepo.findAll();
	}

	@Override
	public void deleteCategory(long categoryId) {
		Optional<Category> category = categoryRepo.findById(categoryId);
		if(category.isPresent()) {
			categoryRepo.deleteById(categoryId);
		}
		else {
			throw new IllegalArgumentException("Category is Not Available");
		}
		
	}

}
