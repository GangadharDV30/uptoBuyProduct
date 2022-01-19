package com.onlineshoping.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onlineshoping.helper.DatabaseConnector;

public class CartDaoImpl implements CartDao{

	@Override
	public String createNewCart(String userName) {

		String s="can't create";
		Connection connection;
		try {
			connection = DatabaseConnector.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CART VALUES (?,'')");
			preparedStatement.setString(1, userName);
			int row=preparedStatement.executeUpdate();
			if(row!=0)
				s="new Cart Created";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	

	@Override
	public Boolean updateItemInCart(String userName, String items) {
		Connection connection;
		try {
			connection = DatabaseConnector.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE CART SET ITEMS=? WHERE USERNAME=?");
			preparedStatement.setString(1, items);
			preparedStatement.setString(2,userName );
			int row=preparedStatement.executeUpdate();
			connection.close();
			if(row!=0)
				return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getItemsFromCart(String userName) {
		String items="";
		try {
			Connection connection = DatabaseConnector.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CART WHERE USERNAME=?");
			preparedStatement.setString(1, userName);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				items= resultSet.getString("ITEMS");
			}
			else {
				items="cart empty";
			}
			connection.close();			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
	}

}
