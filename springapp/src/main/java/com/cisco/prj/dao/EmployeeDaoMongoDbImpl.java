package com.cisco.prj.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.cisco.prj.entity.Employee;

@Repository
public class EmployeeDaoMongoDbImpl implements EmployeeDao {

	@Override
	public void addEmployee(Employee e) {
		System.out.println("mongo store!!!");
	}

}
