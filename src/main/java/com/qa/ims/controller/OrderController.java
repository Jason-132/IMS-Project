package com.qa.ims.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Orders> {

	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private CrudServices<Orders> orderService;

	public OrderController(CrudServices<Orders> orderService) {
		this.orderService = orderService;

	}

	String getInput() {
		return Utils.getInput();
	}

	@Override
	public List<Orders> readAll() {
		List<Orders> orders = orderService.readAll();
		for (Orders order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	public Orders create() {
		LOGGER.info("Please enter the customer ID");
		Long customer_id = Long.valueOf(getInput());
		ArrayList<String> basket = new ArrayList<String>();
		int continue_shopping;
		do {
			LOGGER.info("Please enter an item name");
			String item_name = getInput();
			basket.add(item_name);
			System.out.println(item_name + " was added to your basket");
			LOGGER.info("Do you whish to add more items to your order? Enter 1 = yes or 2 = no");
			continue_shopping = Integer.valueOf(getInput());
			System.out.println("TEST: GET VALUE OF continue_shopping:" + continue_shopping);
		} while (continue_shopping == 1);
		Orders order = orderService.create(new Orders(customer_id, basket));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public Orders update() {
		LOGGER.info("Please enter the ID of the order you would like to update");
		Long order_id = Long.valueOf(getInput());
		LOGGER.info("Please enter the customer_ID");
		Long customer_id = Long.valueOf(getInput());
		LOGGER.info("Please enter the item you wish to add");
		String new_item = getInput();
		ArrayList<String> basket = new ArrayList<String>();
		basket.add(new_item);
		Orders order = orderService.update(new Orders(order_id, customer_id, basket));
		LOGGER.info("Order Updated");
		return order;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the ID of the Order you would like to delete");
		Long id = Long.valueOf(getInput());
		orderService.delete(id);
	}
}
