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
import com.qa.ims.persistence.domain.Items;

public class ItemDaoMysqlTest {

	public static final Logger LOGGER = Logger.getLogger(ItemDaoMysql.class); 

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
			statement.executeUpdate("delete from item");
		} catch (Exception e) { 
			LOGGER.debug(e.getStackTrace()); 
			LOGGER.error(e.getMessage());
		}  
	}
	 
	@Test
	public void createTest() {
		ItemDaoMysql itemDaoMysql = new ItemDaoMysql(jdbcConnectionUrl, username, password);
		String item_name = "Sonic";
		Double price = 12.99;
		
		Items item1 = new Items(item_name, price);
		Items saved_item = new Items(item_name, price);
		item1 = itemDaoMysql.create(item1);
		assertEquals(saved_item.getItem_name(), item1.getItem_name());
		assertEquals(saved_item.getPrice(), item1.getPrice()); 
		
	}
	
} 
