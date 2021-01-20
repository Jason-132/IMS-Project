package com.qa.ims.persistence.domain;

public class Orderline {

	private Long orderline_id;
	private Long order_id;
	private Long item_id;

	public Orderline(Long orderline_id, Long order_id, Long item_id) {
		this.orderline_id = orderline_id;
		this.order_id = order_id;
		this.item_id = item_id;
	}

	public Orderline(Long order_id, Long item_id) {
		this.order_id = order_id;
		this.item_id = item_id;
	}

	@Override
	public String toString() {
		return "orderline_id: " + orderline_id + " order_id=" + order_id + " item_id: " + item_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((orderline_id == null) ? 0 : orderline_id.hashCode());
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
		Orderline other = (Orderline) obj;
		if (item_id == null) {
			if (other.item_id != null)
				return false;
		} else if (!item_id.equals(other.item_id))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (orderline_id == null) {
			if (other.orderline_id != null)
				return false;
		} else if (!orderline_id.equals(other.orderline_id))
			return false;
		return true;
	}

	
}
