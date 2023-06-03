package com.productManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productManagement.Model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long>{

}
