package com.cisco.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cisco.prj.entity.Product;
import com.cisco.prj.service.OrderService;

public class ListProduct {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.cisco");
		ctx.refresh();
		
		OrderService service = ctx.getBean("orderService", OrderService.class);
		List<Product> products = service.fetchProducts();
		for(Product p : products) {
			System.out.println(p.getName() + "," + p.getPrice());
		}
	}

}
