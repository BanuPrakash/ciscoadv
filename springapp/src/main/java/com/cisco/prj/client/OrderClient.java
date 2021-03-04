package com.cisco.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cisco.prj.entity.Customer;
import com.cisco.prj.entity.LineItem;
import com.cisco.prj.entity.Order;
import com.cisco.prj.entity.Product;
import com.cisco.prj.service.OrderService;

public class OrderClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.cisco");
		ctx.refresh();
		OrderService service = ctx.getBean("orderService", OrderService.class);

		Customer c = new Customer();
		c.setEmail("banu@gmail.com");
		
		Order o = new Order();
		o.setCustomer(c);
		
		LineItem item1 = new LineItem();
		Product p1 = new Product();
		p1.setId(2);
		item1.setProduct(p1);
		item1.setQty(1);
		item1.setAmt(p1.getPrice());
		
		LineItem item2 = new LineItem();
		Product p2 = new Product();
		p2.setId(1);
		item2.setProduct(p2);
		item2.setQty(2);
		item2.setAmt(200000);
		
		o.getItems().add(item1);
		o.getItems().add(item2);
		
		o.setTotal(330000.00);
		
		service.placeOrder(o);
		
	}

}
