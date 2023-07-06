package com.productManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productManagement.Model.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{

}
