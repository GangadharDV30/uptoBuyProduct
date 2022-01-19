package com.onlineshoping.bean;

public class Item {
	private String items;
	private int quantity;
	private String userName;
	
	public Item() {
		
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Item(String items, int quantity, String userName) {
		super();
		this.items = items;
		this.quantity = quantity;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Item [items=" + items + ", quantity=" + quantity + ", userName=" + userName + "]";
	}
	
	
	
}
