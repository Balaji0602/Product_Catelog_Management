package com.productManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productManagement.Model.Attributes;
import com.productManagement.Model.Category;
import com.productManagement.Model.ProductModel;
import com.productManagement.service.AttributeService;
import com.productManagement.service.CategoryService;
import com.productManagement.service.ProductService;

@RestController
public class ProductController {
	
	private ProductService productServ;
	private AttributeService attributeServ;
	private CategoryService categoryServ;
	
	@Autowired
	public ProductController(ProductService productServ, CategoryService categoryServ,AttributeService attributeServ) {
		this.productServ = productServ;
		this.categoryServ = categoryServ;
		this.attributeServ = attributeServ;
	}
	
	@PostMapping("/addProduct")
	public ResponseEntity<ProductModel> addProduct(@RequestBody ProductModel product) {
        ProductModel savedProduct = productServ.addProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
	
	@PutMapping("/updateProduct")
	public ResponseEntity<ProductModel> updateProduct(@RequestBody ProductModel product) {
        ProductModel updatedProduct = productServ.updateProduct(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
	
	@GetMapping("/viewProductById/{productId}")
	public ResponseEntity<ProductModel> viewProductById(@PathVariable("productId") long productId) {
        ProductModel viewProductById = productServ.viewProductById(productId);
        return new ResponseEntity<>(viewProductById, HttpStatus.OK);
    }
	
	@GetMapping("/viewProducts")
	public List<ProductModel> viewProducts() {
		List<ProductModel> viewProducts = productServ.viewProducts();
        return viewProducts;
    }
	
	@DeleteMapping("/deleteProduct/{product_id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("product_id") long id){
		productServ.deleteproduct(id);
		return new ResponseEntity<String>("Product Deleted Sucessfully", HttpStatus.OK);
	}
	
	//For this category
	
	@PostMapping("/addCategory")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		Category savedCategory = categoryServ.addCategory(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }
	
	@PutMapping("/updateCategory")
	public ResponseEntity<Category> updateCategory(@RequestBody Category categoryDetails) {
		Category updatedCategory = categoryServ.updateCategory(categoryDetails);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }
	
	@GetMapping("/viewCategories")
	public List<Category> viewCategories(){
		return categoryServ.viewCategories();
	}
	
	@DeleteMapping("/deleteCategory/{category_id}")
	public ResponseEntity<String> deleteCategory(@PathVariable("category_id") long id){
		categoryServ.deleteCategory(id);
		return new ResponseEntity<String>("Category Deleted Sucessfully", HttpStatus.OK);
	}
	
	//this one is for attributes
	
	@PostMapping("/addAttribute")
    public Attributes createAttribute(@RequestBody Attributes attribute) {
        return attributeServ.createAttribute(attribute);
    }

    @GetMapping("viewAttributes/{attributeId}")
    public List<Attributes> getAttributeById(@PathVariable Long attributeId) {
        return attributeServ.getAttributeById(attributeId);
    }

    @PutMapping("updateAttribute/{attributeId}")
    public Attributes updateAttribute(@PathVariable Long attributeId, @RequestBody Attributes attribute) {
        return attributeServ.updateAttribute(attributeId, attribute);
    }

    @DeleteMapping("deleteAttribute/{attributeId}")
    public ResponseEntity<String> deleteAttribute(@PathVariable Long attributeId) {
        attributeServ.deleteAttribute(attributeId);
        return new ResponseEntity<String>("Product Attributes Deleted Sucessfully", HttpStatus.OK);
    }
    
}
