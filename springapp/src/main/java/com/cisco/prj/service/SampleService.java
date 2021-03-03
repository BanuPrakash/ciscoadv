package com.cisco.prj.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cisco.prj.dao.EmployeeDao;
import com.cisco.prj.entity.Employee;

@Service
public class SampleService {
	
	@Autowired
	@Qualifier("employeeDaoMongoDbImpl")
	private EmployeeDao empDao;
	
	public void insertEmployee(Employee e) {
		empDao.addEmployee(e);
	}
}
