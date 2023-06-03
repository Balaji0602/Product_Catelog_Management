package com.productManagement.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "attributes")
public class Attributes {
	 	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "attribute_id")
	    private Long attributeId;

	    @Column(name = "product_id")
	    private Long productId;

	    @Column(name = "attribute_name")
	    private String attributeName;

	    @Column(name = "attribute_value")
	    private String attributeValue;

		public Long getAttributeId() {
			return attributeId;
		}

		public void setAttributeId(Long attributeId) {
			this.attributeId = attributeId;
		}

		public Long getProductId() {
			return productId;
		}

		public void setProductId(Long productId) {
			this.productId = productId;
		}

		public String getAttributeName() {
			return attributeName;
		}

		public void setAttributeName(String attributeName) {
			this.attributeName = attributeName;
		}

		public String getAttributeValue() {
			return attributeValue;
		}

		public void setAttributeValue(String attributeValue) {
			this.attributeValue = attributeValue;
		}
	    
	    
}
