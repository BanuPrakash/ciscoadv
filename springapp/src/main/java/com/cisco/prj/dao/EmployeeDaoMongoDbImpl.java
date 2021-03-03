package com.cisco.prj.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.cisco.prj.entity.Employee;

@Repository
@Profile("prod")
public class EmployeeDaoMongoDbImpl implements EmployeeDao {

	@Override
	public void addEmployee(Employee e) {
		System.out.println("mongo store!!!");
	}

}
