package com.cisco.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.prj.dao.CustomerDao;
import com.cisco.prj.dao.OrderDao;
import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.entity.Customer;
import com.cisco.prj.entity.LineItem;
import com.cisco.prj.entity.Order;
import com.cisco.prj.entity.Product;

@Service
public class OrderService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Transactional
	public Order placeOrder(Order o) {
		List<LineItem> items = o.getItems();
		for(LineItem item : items) {
			Product p = productDao.getProduct(item.getProduct().getId());
			if(item.getAmt() == 0) {
				item.setAmt(p.getPrice());
			}
			p.setQuantity(p.getQuantity() - item.getQty()); // dirty checking ==> update product
		}
		orderDao.placeOrder(o); // saves order and items [ cascade ]
		return o;
	}
	
	public List<Order> getOrders() {
		return orderDao.getOrders();
	}
	
	@Transactional()
	public Customer insertCustomer(Customer c) {
		return customerDao.addCustomer(c);
	}
	
	public Customer getCustomer(String email) {
		return customerDao.getCustomer(email);
	}
	
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
