package com.cisco.prj.dao;

import java.util.List;

import com.cisco.prj.entity.Product;

public interface ProductDao {
	Product addProduct(Product p);
	List<Product> getProducts();
	Product getProduct(int id);
	void deleteProduct(int id);
}
