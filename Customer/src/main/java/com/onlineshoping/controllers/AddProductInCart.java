package com.onlineshoping.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineshoping.bean.Item;
import com.onlineshoping.bean.ItemList;
import com.onlineshoping.service.CartService;
import com.onlineshoping.service.CartServiceImpl;

public class AddProductInCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		CartService cartService=new CartServiceImpl();
		Item items = new Item();
		String userName=(String) session.getAttribute("name");
		String item=request.getParameter("item");
		String str=request.getParameter("quantity");
		System.out.println(item);
		int quantity=1;
		if(str!="" && str!=null ) 
			quantity = Integer.parseInt(str);;
		items.setUserName(userName);
		items.setItems(item);
		items.setQuantity(quantity);
		try {
			System.out.println(quantity);
			System.out.println(items);
			cartService.addItemsInCart(items);
			System.out.println(quantity);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		ItemList cartlist=null;
		try {
			System.out.println("iam try above");
			System.out.println(userName);
			cartlist=cartService.getItemsFromCart(userName);
			System.out.println(cartlist.getItems());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		session.setAttribute("cartlist", cartlist.getItems());
		RequestDispatcher dispatcher=request.getRequestDispatcher("./main.jsp");
		dispatcher.forward(request, response);
	}

}
