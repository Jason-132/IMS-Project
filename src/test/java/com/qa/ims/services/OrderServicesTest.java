package com.qa.ims.services;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Orders;

@RunWith(MockitoJUnitRunner.class)
public class OrderServicesTest {

	@Mock
	private Dao<Orders> orderDao;
	
	@InjectMocks
	private OrderServices orderservices;
	
	@Test
	public void orderServicesDelete() {
		orderservices.delete(1L);
		Mockito.verify(orderDao, Mockito.times(1)).delete(1L);
		
	}
	
}
