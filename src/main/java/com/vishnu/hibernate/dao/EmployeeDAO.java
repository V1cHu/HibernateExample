package com.vishnu.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.vishnu.hibernate.model.Employee;
import com.vishnu.hibernate.util.HibernateConfiguration;

public class EmployeeDAO {

	public static SessionFactory sessionFactory;
	public static Session session;
	public static Transaction transaction;

	public EmployeeDAO() {
		sessionFactory = HibernateConfiguration.getSessionFactory();
		session = sessionFactory.openSession();
	}

	public void createEmployee(Employee emp) {

		transaction = session.beginTransaction();
		session.save(emp);
		transaction.commit();
		System.out.println("Employee " + emp.getEmpName() + " has been created successfully.");

	}

	public void deleteEmployeeByName(String empName) {

		transaction = session.beginTransaction();
		String queryString = "from Employee as model where model.empName=?";
		Query query = session.createQuery(queryString);
		query.setParameter(0, empName);
		List<Employee> empList = query.list();

		for (Employee e : empList) {
			System.out.println(String.format("Deleting employee : %s %s %s", e.getEmpName(), e.getEmpAddress(),
					e.getEmpMobileNos()));
			session.delete(e);
		}
		transaction.commit();
	}

	public void updateEmployee(Employee emp) {
		transaction = session.beginTransaction();

	}

	public void close() {
		session.close();
		sessionFactory.close();
	}

}
