package com.cisco.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.entity.Product;

@Service
public class OrderService {
	@Autowired
	private ProductDao productDao;
	
	@Transactional
	public Product insertProduct(Product p) {
		return productDao.addProduct(p);
	}
	
	public List<Product> fetchProducts() {
		return productDao.getProducts();
	}
	
	public Product findProduct(int id) {
		return productDao.getProduct(id);
	}
}
