package com.cisco.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cisco.prj.entity.Customer;
import com.cisco.prj.service.OrderService;

public class AddCustomer {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.cisco");
		ctx.refresh();
		
		OrderService service = ctx.getBean("orderService", OrderService.class);
		
		Customer c = new Customer("banu@gmail.com", "Banu");
		service.insertCustomer(c);
	 
		
	}

}
