package com.appsstuff.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeesDaoService {

	@Autowired
	private Employees emps;
	public String getEmployeeInfo(int empId) {
			
		emps.setEmpId(10);
		return emps.getEmpName();
		
	}
}
