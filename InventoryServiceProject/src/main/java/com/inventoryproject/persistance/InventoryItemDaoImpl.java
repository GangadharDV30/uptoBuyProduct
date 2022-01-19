package com.inventoryproject.persistance;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.inventoryproject.bean.InventoryItem;
import com.inventoryproject.helper.DatabaseConnector;



public class InventoryItemDaoImpl implements InventoryItemDao {

	@Override
	public InventoryItem getInventoryItemByProductCode(String productCode) throws ClassNotFoundException, SQLException {
		InventoryItem inventoryItem=null;
		
		Connection connection = DatabaseConnector.getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM INVENTORYITEM WHERE PRODUCTCODE=?");
		preparedStatement.setString(1, productCode);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next()) {
			long id = resultSet.getLong("ID");
			String code = resultSet.getString("PRODUCTCODE");
			int noOfItems=resultSet.getInt("AVAILABLEQUANTITY");
		
			inventoryItem=new InventoryItem(id,code,noOfItems);
		}

		connection.close();
		return inventoryItem;
	}

	@Override
	public int updateInventoryItemQuantityByProductCode(String productCode, int availableQuantity)
			throws ClassNotFoundException, SQLException {
		Connection connection = DatabaseConnector.getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE INVENTORYITEM SET AVAILABLEQUANTITY=? WHERE PRODUCTCODE=?");
		
		preparedStatement.setInt(1, availableQuantity);
		preparedStatement.setString(2, productCode);
		
		int rows=preparedStatement.executeUpdate();

		return rows;
			
	}
	

}
