package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class OrdersTest {

	private Orders order;
	private Orders test_order;

	@Before
	public void setUp() {
		order = new Orders(1L);
		test_order = new Orders(1L);
	}

	@Test
	public void equalsWithNull() {
		assertNotEquals(order, (null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertNotEquals(order, (new Object()));
	} 

//	@Test
//	public void createOrderWithId() {
//		assertEquals(1L, 1L);
//		assertEquals(1L, 1L);
//	}

	@Test
	public void checkEquality() {
		assertEquals(order, (order));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertEquals(order, test_order);
	}

	@Test
	public void orderCustmerIdNullButOtherNameNotNull() {
		order.setCustomer_id(null);
		;
		assertNotEquals(order, test_order);
	}

	@Test
	public void checkEqualityBetweenDifferentObjectsNullCustomerId() {
		order.setCustomer_id(null);
		;
		test_order.setCustomer_id(null);
		assertEquals(order, test_order);
	}

	@Test
	public void nullIdOnBoth() {
		order.setOrder_id(null);
		test_order.setOrder_id(null);
		assertEquals(order, test_order);
	}

	@Test
	public void otherIdDifferent() {
		test_order.setOrder_id(1L);
		;
		assertNotEquals(order, test_order);
	}

	@Test
	public void constructorWithoutId() {
		Orders order = new Orders(1L);
		assertNull(order.getOrder_id());
		assertNotNull(order.getCustomer_id());
	}

	@Test
	public void hashCodeTest() {
		assertEquals(order.hashCode(), test_order.hashCode());
	}

	@Test
	public void hashCodeTestWithNull() {
		Orders order = new Orders(null, null);
		Orders other = new Orders(null, null);
		assertEquals(order.hashCode(), other.hashCode());
	}

}
