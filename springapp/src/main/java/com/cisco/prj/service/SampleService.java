package com.cisco.prj.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.prj.dao.EmployeeDao;
import com.cisco.prj.entity.Employee;

//@Service
public class SampleService {
	
	@Autowired
	private EmployeeDao empDao;
	
	@Autowired 
	EmailService es;
	
	public void insertEmployee(Employee e) {
		empDao.addEmployee(e);
	}
	
	public void sendEmail() {
		System.out.println(es.getDetails());
	}
}
