package com.cisco.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cisco.prj.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
	@Query("from Product p where p.price >= :l and p.price <= :u")
	List<Product> getByRange(@Param("l") double lower, @Param("u") double upper);
	
	@Query("update Product set price = :pr where id = :id")
	@Modifying
	void updateProduct(@Param("id") int id, @Param("pr") double price);
}
