//package com.qa.ims.controller;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.Spy;
//import org.mockito.junit.MockitoJUnitRunner;
//import com.qa.ims.persistence.domain.Items;
//import com.qa.ims.services.ItemServices;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ItemControllerTest {
//
//	@Mock
//	private ItemServices itemServices;
//
//	@Spy
//	@InjectMocks
//	private ItemController itemController;
//
//	@Test
//	public void readAllTest() {
//		ItemController itemController = new ItemController(itemServices);
//		ArrayList<Items> items = new ArrayList<>();
//		items.add(new Items("Super-Mario", 23.99));
//		items.add(new Items("Sonic", 6.76));
//		items.add(new Items("Paragon", 23.55));
//		Mockito.when(itemServices.readAll()).thenReturn(items);
//		assertEquals(items, itemController.readAll());
//
//	}
//
//	@Test
//	public void deleteTest() {
//		String id = "1";
//		Mockito.doReturn(id).when(itemController).getInput();
//		itemController.delete();
//		Mockito.verify(itemServices, Mockito.times(1)).delete(1L);
//	}
//
//	@Test 
//	public void updateTest() {
//		String item_name = "Sonic";
////		Double price = 34.99;
//		Mockito.doReturn(item_name).when(itemController).getInput();
////		Items item = new Items(1L, item_name, price);
////		Mockito.when(itemServices.update(item)).thenReturn(item);
////		assertEquals(item, itemController.update());
//	}
//
//} 
