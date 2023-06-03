package com.productManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.productManagement.Model.Attributes;

@Repository
public interface AttributeRepo extends JpaRepository<Attributes, Long>{
	
	@Query(value = "SELECT * FROM attributes a WHERE a.product_id = :productId", nativeQuery = true)
	List<Attributes> getAttriutesByProductId(@Param("productId") long productId);
	
	@Query(value = "DELETE FROM attributes a WHERE a.product_id = :productId", nativeQuery = true)
	void deleteByProductId(@Param("productId") Long productId);
}
