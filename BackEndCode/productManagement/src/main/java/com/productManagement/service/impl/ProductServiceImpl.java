package com.productManagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productManagement.Model.ProductModel;
import com.productManagement.repository.ProductRepository;
import com.productManagement.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	
	 private final ProductRepository productRepository;

	    @Autowired
	    public ProductServiceImpl(ProductRepository productRepository) {
	        this.productRepository = productRepository;
	    }

	    public ProductModel addProduct(ProductModel product) {
	    	return productRepository.save(product);
	    }

		@Override
		public ProductModel updateProduct(ProductModel updatedProduct) {
			ProductModel existingProduct = productRepository.findById(updatedProduct.getProductId()).orElse(null);
	        if (existingProduct == null) {
	            throw new RuntimeException("Product not found");
	        }
	        existingProduct.setCategoryId(updatedProduct.getCategoryId());
	        existingProduct.setProduct_name(updatedProduct.getProduct_name());
	        existingProduct.setMRP(updatedProduct.getMRP());
	        existingProduct.setActual_price(updatedProduct.getActual_price());
	        existingProduct.setQuantity(updatedProduct.getQuantity());
	        existingProduct.setBrand(updatedProduct.getBrand());
	        existingProduct.setDescription(updatedProduct.getDescription());
	        existingProduct.setAvailabilityStatus(updatedProduct.getAvailabilityStatus());

	        return productRepository.save(existingProduct);
		}

		@Override
		public ProductModel viewProductById(long productId) {
		    Optional<ProductModel> product = productRepository.findById(productId);
		    if(product.isPresent()) {
		    	return product.get();
		    }
		    else {
		    	throw new IllegalArgumentException("Product is Not Available"); 
		    }
		}

		@Override
		public List<ProductModel> viewProducts() {
		    return productRepository.findAll();
		}

		@Override
		public void deleteproduct(long productId) {
			Optional<ProductModel> product = productRepository.findById(productId);
		    if(product.isPresent()) {
		    	productRepository.deleteById(productId);;
		    }
		    else {
		    	throw new IllegalArgumentException("Product is Not Available"); 
		    }
		}
}
