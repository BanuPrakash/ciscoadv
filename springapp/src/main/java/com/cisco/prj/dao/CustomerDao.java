package com.cisco.prj.dao;

import java.util.List;

import com.cisco.prj.entity.Customer;

public interface CustomerDao {
	Customer addCustomer(Customer c);
	List<Customer> getCustomers();
	Customer getCustomer(String email);
}
