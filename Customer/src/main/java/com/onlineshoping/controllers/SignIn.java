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
import com.onlineshoping.bean.ProductList;
import com.onlineshoping.service.CustomerService;
import com.onlineshoping.service.CustomerServiceImpl;


public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		String name=request.getParameter("uname");
		String password=request.getParameter("pwd");
		CustomerService customers=new CustomerServiceImpl();
		Customer customer=new Customer(name,password);
		session.setAttribute("customer", customer);
		session.setAttribute("name", name);
		ProductList products = null;
		try {
			if(customers.logingIn(name, password)) {
				
				try {
					products = customers.viewProduct();
					session.setAttribute("productlist", products);

					RequestDispatcher dispatcher = request.getRequestDispatcher("./main.jsp");
					dispatcher.forward(request, response);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
			}
			}
			else {
				response.sendRedirect("./index.jsp");
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
