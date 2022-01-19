package com.orderitemproject.bean;

import java.util.List;

public class Order {
	private Long orderId;
	private String customerEmail;
	private String customerAddress;
	private List<OrderItem> items;
	
	public Order() {
		
	}

	public Order(Long orderId, String customerEmail, String customerAddress, List<OrderItem> items) {
		super();
		this.orderId = orderId;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.items = items;
	}

	

	public Order(Long orderId, String customerEmail, String customerAddress) {
		super();
		this.orderId = orderId;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
}
