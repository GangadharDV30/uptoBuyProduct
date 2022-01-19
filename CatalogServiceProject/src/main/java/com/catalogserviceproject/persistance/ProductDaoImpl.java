package com.catalogserviceproject.persistance;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.catalogserviceproject.bean.Product;
import com.catalogserviceproject.helper.DatabaseConnector;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> listAllProducts() throws ClassNotFoundException, SQLException {
List<Product> products = new ArrayList<Product>();

		
		Connection connection = DatabaseConnector.getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCT");
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			long id = resultSet.getLong("ID");
			String code = resultSet.getString("CODE");
			String name = resultSet.getString("NAME");
			String description = resultSet.getString("DESCRIPTION");
			double price=resultSet.getDouble("PRICE");
		
			
			Product product=new Product(id,code,name,description,price);
			products.add(product);
		}

		connection.close();

		return products;
	}
	

	@Override
	public Product getProductByCode(String productCode) throws ClassNotFoundException, SQLException {
		
      Product product=null;
		
		Connection connection = DatabaseConnector.getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCT WHERE CODE=?");
		preparedStatement.setString(1, productCode);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next()) {
			long id = resultSet.getLong("ID");
			String code = resultSet.getString("CODE");
			String name = resultSet.getString("NAME");
			String description = resultSet.getString("DESCRIPTION");
			double price=resultSet.getDouble("PRICE");
		
			
			 product=new Product(id,code,name,description,price);
		}

		connection.close();
		return product;
	}


	
	}

	


