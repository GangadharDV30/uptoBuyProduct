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


public class DeleteProductFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		CartService cartService=new CartServiceImpl();
		Item items = new Item();
		String userName=(String) session.getAttribute("name");
		String item=request.getParameter("item");
		String str=request.getParameter("quantity");
		int quantity=1;
		if(str!="" && str!=null) 
			quantity = Integer.parseInt(str);
		items.setUserName(userName);
		items.setItems(item);
		items.setQuantity(quantity);
		try {
			cartService.deleteItemsFromCart(items);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		ItemList cartList=null;
		try {
			cartList=cartService.getItemsFromCart(userName);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		session.setAttribute("cartlist", cartList.getItems());
		RequestDispatcher dispatcher=request.getRequestDispatcher("./mycart.jsp");
		dispatcher.forward(request, response);
	}
}
