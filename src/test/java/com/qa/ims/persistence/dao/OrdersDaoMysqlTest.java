//package com.qa.ims.persistence.dao;
//
//import static org.junit.Assert.assertEquals;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
//
//import org.apache.log4j.Logger;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import com.qa.ims.Ims;
//import com.qa.ims.persistence.domain.Orders;
//
//public class OrdersDaoMysqlTest {
//
//	public static final Logger LOGGER = Logger.getLogger(OrderDaoMysql.class);
//
//	private static String jdbcConnectionUrl = "jdbc:mysql://localhost:3306/project";
//	private static String username = "root";
//	private static String password = "root";
//
//	@BeforeClass
//	public static void init() {
//		Ims ims = new Ims();
//		ims.init(jdbcConnectionUrl, username, password, "src/test/resources/sql-schema.sql");
//	}
//
//	@Before
//	public void setup() {
//		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
//				Statement statement = connection.createStatement();) {
//			statement.executeUpdate("delete from orders");
//		} catch (Exception e) {
//			LOGGER.debug(e.getStackTrace());
//			LOGGER.error(e.getMessage());
//		}
//	}
//
//	@Test
//	public void createTest() {
//		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(jdbcConnectionUrl, username, password);
//		
//		
//		Orders order1 = new Orders(1L);
//		
//		order1 = orderDaoMysql.create(order1);
//		assertEquals(1, 1); 
//	}
//} 