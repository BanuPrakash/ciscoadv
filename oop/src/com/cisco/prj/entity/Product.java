package com.cisco.prj.entity;

import com.cisco.prj.annotations.Column;
import com.cisco.prj.annotations.Table;

@Table(name="products")
public class Product {
	private int id;
	private String name;
	private double price;
	private String category;

	public Product() {
	}

	public Product(int id, String name, double price, String category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	@Column(name="prd_id", type = "NUMERIC(10)")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="prd_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
