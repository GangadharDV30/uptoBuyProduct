package com.orderitemproject.bean;

import java.util.List;

public class OrderItemList {
	private List<OrderItem> products;

	public List<OrderItem> getProducts() {
		return products;
	}

	public void setProducts(List<OrderItem> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "OrderItemList [products=" + products + "]";
	}
	
	
}
