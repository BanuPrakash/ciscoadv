package com.cisco.prj.client;

import com.cisco.prj.entity.Employee;
import com.cisco.prj.entity.Product;
import com.cisco.prj.util.SQLUtil;

public class AnnotationMain {

	public static void main(String[] args) {
		String SQL = SQLUtil.generateCreateSQL(Product.class);
		System.out.println(SQL);
		
		SQL = SQLUtil.generateCreateSQL(Employee.class);
		
		System.out.println(SQL);
	}

}
