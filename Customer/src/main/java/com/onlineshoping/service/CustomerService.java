package com.onlineshoping.service;

import java.sql.SQLException;

import com.onlineshoping.bean.Customer;
import com.onlineshoping.bean.ProductList;


public interface CustomerService 
{
boolean signingUp(Customer customer)throws ClassNotFoundException,SQLException;
boolean logingIn(String name, String Password)throws ClassNotFoundException,SQLException;
public ProductList viewProduct() throws ClassNotFoundException, SQLException;
}
