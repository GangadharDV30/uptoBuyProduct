package com.onlineshoping.service;

import java.util.ArrayList;
import java.util.List;

import com.onlineshoping.bean.Item;
import com.onlineshoping.bean.ItemList;
import com.onlineshoping.persistance.CartDaoImpl;

public class CartServiceImpl implements CartService {
	CartDaoImpl cartDaoImpl = new CartDaoImpl();
	
	
		
	@Override
	public String createNewCart(String userName) {
		return cartDaoImpl.createNewCart(userName);
	}

	@Override
	public String deleteAllItemsFromCart(String userName) {
		String oldItems=cartDaoImpl.getItemsFromCart(userName);
		if(oldItems!=null && cartDaoImpl.updateItemInCart(userName,""))
			return "deleted all";
		else
		return "no itoms to delete";
		
	}

	@Override
	public String addItemInCart(Item item) {
		String addedItem=item.getItems();
		String oldItems =cartDaoImpl.getItemsFromCart(item.getUserName());
		if(oldItems!=null) { 
			if(cartDaoImpl.updateItemInCart(item.getUserName(),(oldItems+","+item.getItems()))) 
				return addedItem+" added to cart";
			else 
				return "can'n add";
			}
		else {
			if(cartDaoImpl.updateItemInCart(item.getUserName(),item.getItems())) 
				return addedItem+" added to cart";
			else 
				return "can'n add";	
		}
	}

	@Override
	public String addItemsInCart(Item item) {
		String s="";
		for(int i=0;i<item.getQuantity();i++)
			s=addItemInCart(item);
		return s;
	}

	@Override
	public ItemList getItemsFromCart(String userName) {
		ItemList list = new ItemList();
		List<Item> itemList = new ArrayList<Item>();
		String items =cartDaoImpl.getItemsFromCart(userName);									//----------------
		if(items==null) {
			Item item = new Item();
//			itom.setUserName(userName);
			item.setQuantity(0);
			item.setItems("empty");
			itemList.add(item);
			list.setItems(itemList);
			return list;
		}
		list.setItems(stringToListWithQuantity(userName,items));
		return list;
	}

	@Override
	public String deleteItemFromCart(Item item) {
		boolean b=false;
		String deletedItem="";
		String oldItems =cartDaoImpl.getItemsFromCart(item.getUserName());
		if(oldItems==null) 
			return "cart empty";
		List<Item> list =stringToListWithoutQuantity(item.getUserName(), oldItems);
		for(Item str : list) {                             
			if(str.getItems().equals(item.getItems())) {
				deletedItem=str.getItems();
				list.remove(str);
				b=true;
				break;
			}
		}
		String newString=listToString(list);
		if(cartDaoImpl.updateItemInCart(item.getUserName(), newString) && b)
			return deletedItem+" deleted from cart";
		else
			return "can't delete";
	}

	@Override
	public String deleteItemsFromCart(Item item) {
		System.out.println(item);
		String s="";
		int i=0;
		
		for( ;i<item.getQuantity();i++) {
			s=deleteItemFromCart(item);
			if(i==(item.getQuantity()-1) && (!s.equals("can't delete")))
				return (i+1)+" "+item.getItems()+" is deleted";
		}
		System.out.println((!s.equals("can't delete")));
		if(s.equals("can't delete") && i!=(item.getQuantity())) 
			return i+" itoms delete";
		else
			return "can't delete";
	}
	
	public String listToString(List <Item> list) {
		String items="";
		for(Item s: list)
			if(items!="") 
				items=items+","+(s.getItems());
			else 
				items=s.getItems();
		return items;
	}
	public List<Item> stringToListWithQuantity(String userName, String items) {
		String[] myArray = items.split(",");
		for (int i = 0; i < myArray.length - 1; i++) {
			for (int j = i + 1; j < myArray.length; j++) {
				if (myArray[i].compareTo(myArray[j]) > 0) {
					String temp = myArray[i];
					myArray[i] = myArray[j];
					myArray[j] = temp;
				}
			}
		} 
		return stringToListForQuantity(userName, myArray);
	}
	public List<Item> stringToListForQuantity(String userName, String[] myArray) {
		List<Item> itemsList = new ArrayList<Item>();
		int quant = 0;
		for (int i = 0; i < myArray.length; i++) {
			Item item = new Item();
			//itom.setUserName(userName);
			if (myArray.length == 1) {
				item.setItems(myArray[i]);
				item.setQuantity(1);
				itemsList.add(item);
				break;
			}
			if(myArray.length==2 ) {
				if(myArray[0].equals(myArray[1])) {
					item.setQuantity(2);
					item.setItems(myArray[0]);
					itemsList.add(item);
					break;
				}
				else {
					item.setQuantity(1);
					item.setItems(myArray[0]);
					itemsList.add(item);
					item.setItems(myArray[1]);
					itemsList.add(item);
					break;
				}
				
			}
			if (myArray.length >2 && i == (myArray.length-2)) {
				if( myArray[(myArray.length-2)].equals(myArray[(myArray.length-1)])){
					item.setItems(myArray[myArray.length-1]);
					item.setQuantity(quant+2);
					itemsList.add(item);
					break;
				}
				else {
					Item item1 = new Item();
					item1.setQuantity(++quant);
					item1.setItems(myArray[(myArray.length-2)]);
					itemsList.add(item1);
					Item item2 = new Item();
					item.setItems(myArray[(myArray.length-1)]);
					item2.setQuantity(1);
					itemsList.add(item2);
					break;
				}
			}
			if (myArray[i+1].equals(myArray[i]))
				item.setQuantity(++quant);
			else {
				item.setQuantity(++quant);
				item.setItems(myArray[i]);
				itemsList.add(item);
				quant=0;
			}
		}
		return itemsList;
	}
	public List<Item> stringToListWithoutQuantity(String userName, String items){
		List<Item> itemsList = new ArrayList<Item>();
		String[] myArray = {""};
		if(items!="") 
			myArray = items.split(",");
	     for (int i = 0; i < myArray.length; i++) {
	 		Item item = new Item();
			item.setUserName(userName);
			item.setItems(myArray[i]);
			itemsList.add(item);
		}
	    return itemsList;
		}

}
