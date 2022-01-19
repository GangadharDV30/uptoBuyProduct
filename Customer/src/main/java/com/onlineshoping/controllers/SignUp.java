package com.onlineshoping.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineshoping.bean.Customer;
import com.onlineshoping.service.CartService;
import com.onlineshoping.service.CartServiceImpl;
import com.onlineshoping.service.CustomerService;
import com.onlineshoping.service.CustomerServiceImpl;


public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session=request.getSession(false);
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		CustomerService customer=new CustomerServiceImpl();
		CartService cart=new CartServiceImpl();
		
		Customer cust=new Customer(name,email,password);

	String message=null;
		try {
			
			if(customer.signingUp(cust)) {
				
				cart.createNewCart(name);
			message="Signup Successfull.. please login and Continue Shopping";
		}
		else {
			message="Signing up failed....! , please try again";
		}
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		}
		session.setAttribute("message", message);
		RequestDispatcher dispatcher=request.getRequestDispatcher("./index.jsp");
		dispatcher.forward(request, response);
	}

}
