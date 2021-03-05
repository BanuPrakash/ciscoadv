package com.cisco.prj.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.prj.entity.Product;
import com.cisco.prj.service.OrderService;

@RestController
@RequestMapping("api/products")
public class ProductController {
	@Autowired
	private OrderService service;

	// http://localhost:8080/api/products
	// http://localhost:8080/api/products?lower=100&upper=500

	@GetMapping
	public @ResponseBody List<Product> getProducts(@RequestParam(name = "lower", defaultValue = "0.0") double lower,
			@RequestParam(name = "upper", defaultValue = "0.0") double upper) {
		if (lower == 0.0 && upper == 0.0) {
			return service.getProducts();
		} else {
			return service.byRange(lower, upper);
		}
	}

	// http://localhost:8080/api/products/2
	@GetMapping("/{id}")
	public @ResponseBody Product getProductById(@PathVariable("id") int id) {
		Product p = service.getProduct(id);
		if(p == null) {
			throw new NotFoundException("Product with " + id + " not available");
		}
		return p;
	}

	@PostMapping
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product p) {
		service.addProduct(p);
		return new ResponseEntity<Product>(p, HttpStatus.CREATED);
	}
}
