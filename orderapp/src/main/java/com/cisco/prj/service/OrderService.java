package com.cisco.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.entity.Product;

@Service
public class OrderService {
	@Autowired
	private ProductDao productDao;
	
	public Page<Product> getProductsPage(Pageable page){
		return productDao.findAll(page);
	}
	
	public List<Product> getProducts(){
		return productDao.findAll();
	}

	public List<Product> byRange(double lower, double upper) {
		return productDao.getByRange(lower, upper);
	}
	
	public Product getProduct(int id) {
		return productDao.findById(id).get();
	}
	
	@Transactional
	public Product addProduct(Product p) {
		return productDao.save(p);
	}
}
