package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.Ims;
import com.qa.ims.persistence.domain.Customer;

public class CustomerDaoMysqlTest {

	public static final Logger LOGGER = Logger.getLogger(CustomerDaoMysql.class);

	private static String jdbcConnectionUrl = "jdbc:mysql://localhost:3306/project";
	private static String username = "root";
	private static String password = "root";
	
	
	@BeforeClass
	public static void init() {
		Ims ims = new Ims();
		ims.init(jdbcConnectionUrl, username, password, "src/test/resources/sql-schema.sql");
	}
	@Before
	public void setup() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from customers");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
}
	@Test
	public void createTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
		String first_name1 = "Sam";
		String surname1 = "Smith";
		String address1 = "14 Avery Road";
		
		Customer customer1 = new Customer(1L, first_name1, surname1, address1);
		Customer savedCustomer = new Customer(1L, first_name1, surname1, address1);
		customer1 = customerDaoMysql.create(customer1);
		assertEquals(savedCustomer.getFirstName(), customer1.getFirstName());
		assertEquals(savedCustomer.getSurname(), customer1.getSurname());
		assertEquals(savedCustomer.getAddress(), customer1.getAddress());
		
	} 
	@Test
	public void createTest2() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
		String first_name2 = "Paul";
		String surname2 = "Addison";
		String address2 = "33 Cannon Street";
		
		Customer customer2 = new Customer(1L, first_name2, surname2, address2);
		Customer savedCustomer = new Customer(1L, first_name2, surname2, address2);
		customer2 = customerDaoMysql.create(customer2);
		assertEquals(savedCustomer.getFirstName(), customer2.getFirstName()); 
		assertEquals(savedCustomer.getSurname(), customer2.getSurname());
		assertEquals(savedCustomer.getAddress(), customer2.getAddress()); 
	}
}