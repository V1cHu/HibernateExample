package com.vishnu.hibernate;

import com.vishnu.hibernate.model.Employee;
import com.vishnu.hibernate.service.EmployeeService;

public class Main {

	public static EmployeeService empService;

	public static void main(String[] args) {

		Employee emp = new Employee();

		emp.setEmpName("Test");
		emp.setEmpAddress("test");
		emp.setEmpMobileNos("123456789");

		empService = new EmployeeService();
		
		
		empService.createEmployee(emp);
		empService.deleteEmployee(emp.getEmpName());

		empService.close();

	}

}
