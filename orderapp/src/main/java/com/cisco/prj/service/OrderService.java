package com.cisco.prj.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cisco.prj.dao.OrderDao;
import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.entity.LineItem;
import com.cisco.prj.entity.Order;
import com.cisco.prj.entity.Product;

@Service
public class OrderService {
	@Autowired
	private ProductDao productDao;

	@Autowired
	private OrderDao orderDao;

	@Transactional
	public Order placeOrder(Order o) {
		List<LineItem> items = o.getItems();
		for (LineItem item : items) {
			Product p = productDao.findById(item.getProduct().getId()).get();
			if (item.getAmt() == 0) {
				item.setAmt(p.getPrice());
			}
			p.setQuantity(p.getQuantity() - item.getQty()); // dirty checking ==> update product
		}
		orderDao.save(o); // saves order and items [ cascade ]
		return o;
	}

	public List<Order> getOrders() {
		return orderDao.findAll();
	}

	public Page<Product> getProductsPage(Pageable page) {
		return productDao.findAll(page);
	}

	public List<Product> getProducts() {
		return productDao.findAll();
	}

	public List<Product> byRange(double lower, double upper) {
		return productDao.getByRange(lower, upper);
	}

	public Product getProduct(int id) {
		Optional<Product> optP = productDao.findById(id);
		if (optP.isPresent()) {
			return optP.get();
		}
		return null;
	}

	@Transactional
	public Product addProduct(Product p) {
		return productDao.save(p);
	}
}
