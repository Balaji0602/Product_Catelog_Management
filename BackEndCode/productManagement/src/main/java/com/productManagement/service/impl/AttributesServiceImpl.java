package com.productManagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productManagement.Model.Attributes;
import com.productManagement.repository.AttributeRepo;
import com.productManagement.service.AttributeService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AttributesServiceImpl implements AttributeService{

	private final AttributeRepo attributeRepository;

	public AttributesServiceImpl(AttributeRepo attributeRepository) {
		super();
		this.attributeRepository = attributeRepository;
	}

	@Override
    public Attributes createAttribute(Attributes attribute) {
        return attributeRepository.save(attribute);
    }

	

    @Override
    public Attributes updateAttribute(Long attributeId, Attributes attribute) {
        attribute.setAttributeId(attributeId);
        return attributeRepository.save(attribute);
    }

    @Override
    public void deleteAttribute(Long productId) {
        attributeRepository.deleteByProductId(productId);
    }

	@Override
	public List<Attributes> getAttributeById(long productId) {
		return attributeRepository.getAttriutesByProductId(productId);
	}
	
}
