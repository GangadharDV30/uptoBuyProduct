package com.onlineshoping.persistance;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onlineshoping.bean.Customer;
import com.onlineshoping.helper.DatabaseConnector;

public class CustomerDaoImpl implements CustomerDao
{


	public int signUp(Customer customer) throws ClassNotFoundException,SQLException
	{

		Connection connection = DatabaseConnector.getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO CUSTOMER(CUSTOMERNAME,CUSTOMEREMAIL,CUSTOMERPASSWORD) VALUES(?,?,?)");
		
		
		preparedStatement.setString(1, customer.getCustomerName());
		preparedStatement.setString(2, customer.getCustomerEmail());
		preparedStatement.setString(3, customer.getCustomerPassword());
		
		int rows=preparedStatement.executeUpdate();
		connection.close();
		return rows;
	}
	
	
	
	public Customer logIn(String name, String password) throws ClassNotFoundException,SQLException
	{
		Connection connection = DatabaseConnector.getConnection();
	Customer customer=null;
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CUSTOMER WHERE CUSTOMERNAME=? and CUSTOMERPASSWORD=? ");
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			String customerName = resultSet.getString("CUSTOMERNAME");
			String customerEmail= resultSet.getString("CUSTOMEREMAIL");
			String customerPassword = resultSet.getString("CUSTOMERPASSWORD");
			
		 customer=new Customer(customerName,customerEmail,customerPassword);
		
		}

		connection.close();
		return customer;
	}

}
