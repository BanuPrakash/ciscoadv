package com.cisco.prj.dao;

import java.util.List;

import com.cisco.prj.entity.Order;

public interface OrderDao {
	void placeOrder(Order o);
	List<Order> getOrders();
}
