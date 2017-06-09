package com.vishnu.hibernate.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.vishnu.hibernate.model.Employee;

public class HibernateConfiguration {

	private static SessionFactory sessionFactory;

	static {
		Configuration config = new Configuration();

		config.addAnnotatedClass(Employee.class);
		config.setProperties(getProperties());

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties());

		sessionFactory = config.buildSessionFactory(builder.build());
	}

	private static Properties getProperties() {

		Properties props = new Properties();
		props.setProperty("hibernate.current_session_context_class", "org.hibernate.context.internal.ThreadLocalSessionContext");
		props.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		props.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/testdb");
		props.setProperty("hibernate.connection.username", "root");
		props.setProperty("hibernate.connection.password", "");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty(" hibernate.connection.pool_size", "10");

		return props;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
