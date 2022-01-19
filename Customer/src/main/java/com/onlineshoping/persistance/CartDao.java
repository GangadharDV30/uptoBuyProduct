package com.onlineshoping.persistance;

public interface CartDao{
	public String createNewCart(String userName);
	public Boolean updateItemInCart(String userName, String items);
	public String getItemsFromCart(String userName);
}
