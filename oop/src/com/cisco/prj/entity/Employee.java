package com.cisco.prj.entity;

import com.cisco.prj.annotations.Column;
import com.cisco.prj.annotations.Table;

@Table(name="emps")
public class Employee {
	private String email;
	private String firstName;
	
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="first_name", type="VARCHAR(100)")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
}
