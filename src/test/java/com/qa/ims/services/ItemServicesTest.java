package com.qa.ims.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Items;

@RunWith(MockitoJUnitRunner.class)
public class ItemServicesTest {

	@Mock
	private Dao<Items> itemDao;
	
	@InjectMocks
	private ItemServices itemservices;
	
	@Test
	public void itemServicesCreate() {
		Items item = new Items("Sonic", 22.22);
		itemservices.create(item);
		Mockito.verify(itemDao, Mockito.times(1)).create(item);
	}
	
	@Test
	public void customerServicesRead() { 
		itemservices.readAll();
		Mockito.verify(itemDao, Mockito.times(1)).readAll();
}
	
	@Test
	public void customerServicesUpdate() {
		Items item = new Items("Sonic", 22.22);
		itemservices.update(item);
		Mockito.verify(itemDao, Mockito.times(1)).update(item);
	}
	
	@Test
	public void customerServicesDelete() {
		itemservices.delete(1L);
		Mockito.verify(itemDao, Mockito.times(1)).delete(1L);
	} 
}
