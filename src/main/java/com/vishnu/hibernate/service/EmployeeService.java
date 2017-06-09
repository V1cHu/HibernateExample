package com.vishnu.hibernate.service;

import com.vishnu.hibernate.dao.EmployeeDAO;
import com.vishnu.hibernate.model.Employee;

public class EmployeeService {

	private EmployeeDAO empDAO;

	public EmployeeService() {
		empDAO = new EmployeeDAO();
	}

	public void createEmployee(Employee emp) {
		System.out.println("Begin Creating Employee");
		empDAO.createEmployee(emp);
		System.out.println("End Creating Employee");
	}

	public void deleteEmployee(String empName) {
		System.out.println("Deleting employee...");
		empDAO.deleteEmployeeByName(empName);
		System.out.println("End delete employee.");
	}

	public void close() {
		empDAO.close();
	}

}
