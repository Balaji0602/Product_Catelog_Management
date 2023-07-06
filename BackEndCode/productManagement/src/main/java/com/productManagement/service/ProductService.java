package com.productManagement.service;

import java.util.List;

import com.productManagement.Model.ProductModel;

public interface ProductService {
	ProductModel addProduct(ProductModel productDetails);
	ProductModel updateProduct(ProductModel productDetails);
	ProductModel viewProductById(long productId);
	List<ProductModel> viewProducts();
	void deleteproduct(long product_id);
}
