package com.productManagement.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class ProductModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productid;
	
	@Column(name = "categoryid")
	private long categoryId;
	
	@Column(name = "product_name")
	private String product_name;
	
	@Column(name = "MRP")
	private String MRP;
	
	@Column(name = "actual_price")
	private String actual_price;
	
	@Column(name = "product_quantity")
	private int quantity;
	
	@Column(name = "brand_name")
	private String brand;
	
	@Column(name = "product_description")
	private String description;
	
	@Column(name = "availability_status")
	private String availabilityStatus;
	
	
	public long getProductId() {
		return productid;
	}

	public void setProductId(long productid) {
		this.productid = productid;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getMRP() {
		return MRP;
	}

	public void setMRP(String mRP) {
		MRP = mRP;
	}

	public String getActual_price() {
		return actual_price;
	}

	public void setActual_price(String actual_price) {
		this.actual_price = actual_price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

}
