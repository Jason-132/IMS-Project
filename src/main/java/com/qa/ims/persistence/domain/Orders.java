package com.qa.ims.persistence.domain;

import java.util.ArrayList;

public class Orders {

	private Long order_id;
	private Long customer_id;
	private ArrayList<String> items;

	public Orders(Long order_id, Long customer_id, ArrayList<String> items) { 

		this.order_id = order_id;
		this.customer_id = customer_id;
		this.items = items;
	}

	public Orders(Long customer_id, ArrayList<String> items) {

		this.customer_id = customer_id;
		this.items = items;
	}

	public Orders(Long customer_id) {
		super();
		this.customer_id = customer_id;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public ArrayList<String> getItems() {
		return items;
	}

	public void setItems(ArrayList<String> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "order_id: " + order_id + " customer_id: " + customer_id + " items: " + items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		return true;
	}

}
