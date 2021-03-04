package com.cisco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.cisco.prj.entity.Product;
import com.cisco.prj.service.OrderService;

@SpringBootApplication
public class OrderappApplication implements CommandLineRunner {
	@Autowired
	private OrderService service;
	
	public static void main(String[] args) {
		SpringApplication.run(OrderappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Product p = new Product(0,"Logitech Mouse", 500.00, 100);
//		service.addProduct(p);

//		List<Product> products = service.getProducts();
//		List<Product> products = service.byRange(100, 1000);
		// pageNumber, recordsperpage, sort
		/*
		Pageable pageable = PageRequest.of(0, 2, Sort.by("price").descending());
		
		Page<Product> productsPage = service.getProductsPage(pageable);
		System.out.println(productsPage.getTotalPages());
		
		List<Product> products = productsPage.getContent(); 
		for(Product prd : products) {
			System.out.println(prd.getName() + ", " + prd.getPrice());
		}
		*/
	}

}
