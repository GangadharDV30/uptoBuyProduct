package com.onlineshoping.service;

import com.onlineshoping.bean.Item;
import com.onlineshoping.bean.ItemList;

public interface CartService {
	public String createNewCart(String userName);
	public String addItemInCart(Item item);
	public String addItemsInCart(Item item);
	public ItemList getItemsFromCart(String userName);
	public String deleteItemFromCart(Item item);
	public String deleteItemsFromCart(Item item);
	public String deleteAllItemsFromCart(String userName);
}
