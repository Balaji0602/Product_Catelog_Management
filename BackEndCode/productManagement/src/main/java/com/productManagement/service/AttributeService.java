package com.productManagement.service;


import java.util.List;

import com.productManagement.Model.Attributes;

public interface AttributeService {
	
	Attributes createAttribute(Attributes attribute);
	List<Attributes> getAttributeById(long productId);
    Attributes updateAttribute(Long attributeId, Attributes attribute);
    void deleteAttribute(Long attributeId);
}
