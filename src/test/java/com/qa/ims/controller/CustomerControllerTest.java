package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.services.CustomerServices;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
	
	/**
	 *  The thing I want to fake functionlity for
	 */
	@Mock
	private CustomerServices customerServices;
	
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer controller
	 */
	@Spy
	@InjectMocks
	private CustomerController customerController;

	@Test
	public void readAllTest() {
		CustomerController customerController = new CustomerController(customerServices); 
		ArrayList<Customer> customers = new ArrayList<>();
		customers.add(new Customer("Chris", "P", "T"));
		customers.add(new Customer("Rhys", "T", "O"));
		customers.add(new Customer("Nic", "J", "Q")); 
		Mockito.when(customerServices.readAll()).thenReturn(customers);
		assertEquals(customers, customerController.readAll());
	}

	@Test
	public void createTest() {
		String firstName = "Chris";
		String surname = "Perrins";
		String address = "Candy Lane";
		Mockito.doReturn(firstName, surname).when(customerController).getInput();
		Customer customer = new Customer(firstName, surname, address);
		Customer savedCustomer = new Customer(1L, "Chris", "Perrins", "Candy Lane");
		Mockito.when(customerServices.create(customer)).thenReturn(savedCustomer);
		assertEquals(savedCustomer, customerController.create());
	} 

	/** 
	 * 
	 */
	@Test
	public void updateTest() {  
		String id = "1";
		String firstName = "Rhys";
		String surname = "Thompson"; 
		String address = "23 Candy Lane";
		Mockito.doReturn(id, firstName, surname).when(customerController).getInput();
		Customer customer = new Customer(1L, firstName, surname, address);
		Mockito.when(customerServices.update(customer)).thenReturn(customer);
		assertEquals(customer, customerController.update());
	}
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(customerController).getInput();
		customerController.delete();
		Mockito.verify(customerServices, Mockito.times(1)).delete(1L);
	}
	
}
