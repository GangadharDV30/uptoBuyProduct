package com.orderitemproject.persistance;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.orderitemproject.bean.Order;
import com.orderitemproject.bean.OrderItem;
import com.orderitemproject.bean.OrderList;
import com.orderitemproject.helper.DatabaseConnector;

public class OrderItemDaoImpl implements OrderItemDao {

	@Override
	public int insertItem(OrderItem orderItem) throws ClassNotFoundException, SQLException {
		Connection connection = DatabaseConnector.getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO ORDERITEM(ID,PRODUCTCODE,AVAILABLEQUANTITY,PRICE) VALUES(?,?,?,?)");
		
		
		preparedStatement.setLong(1, orderItem.getId());
		preparedStatement.setString(2, orderItem.getProductcode());
		preparedStatement.setInt(3, orderItem.getQuantity());
		preparedStatement.setDouble(4, orderItem.getPrice());
		int rows=preparedStatement.executeUpdate();
		connection.close();
		return rows;
	}
	
	@Override
	public Order getOrderByCode(Long orderId) throws ClassNotFoundException, SQLException {
		 Order product=null;
			
			Connection connection = DatabaseConnector.getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ORDERS WHERE ORDERID=?");
			preparedStatement.setLong(1, orderId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				long id = resultSet.getLong("ORDERID");
				String custMail = resultSet.getString("CUSTOMEREMAIL");
				String custAdd = resultSet.getString("CUSTOMERADDRESS");
			
				
				 product=new Order(id,custMail,custAdd);
			}

			connection.close();
			return product;
	}


	@Override
	public int insertItem(Order orderItem) throws ClassNotFoundException, SQLException {
		Connection connection = DatabaseConnector.getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO ORDERS(ORDERID,CUSTOMEREMAIL,CUSTOMERADDRESS) VALUES(?,?,?)");
		
		
		preparedStatement.setLong(1, orderItem.getOrderId());
		preparedStatement.setString(2, orderItem.getCustomerEmail());
		preparedStatement.setString(3, orderItem.getCustomerAddress());
		
		int rows=preparedStatement.executeUpdate();
		connection.close();
		return rows;
	}

	@Override
	public List<OrderItem> listAllProducts() throws ClassNotFoundException, SQLException {
		List<OrderItem> products = new ArrayList<OrderItem>();

		
		Connection connection = DatabaseConnector.getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ORDERITEM");
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			long id = resultSet.getLong("ID");
			String code = resultSet.getString("PRODUCTCODE");
			int qun = resultSet.getInt("AVAILABLEQUANTITY");
			double price=resultSet.getDouble("PRICE");
		
			
			OrderItem product=new OrderItem(id,code,qun,price);
			products.add(product);
		}

		connection.close();

		return products;
	}

	@Override
	public List<Order> listAllProductsOrder() throws ClassNotFoundException, SQLException {
		List<Order> products = new ArrayList<Order>();

		
		Connection connection = DatabaseConnector.getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ORDERS");
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			long id = resultSet.getLong("ORDERID");
			String custEmail = resultSet.getString("CUSTOMEREMAIL");
			String custAdd = resultSet.getString("CUSTOMERADDRESS");
			
			Order product=new Order(id,custEmail,custAdd);
			products.add(product);
		}

		connection.close();

		return products;
	}

	@Override
	public List<Order> listAllProductsOrderList(Long transId) throws ClassNotFoundException, SQLException {
		OrderList orderlist=new OrderList();
		OrderItem orderitem=null;
		//List<Order> listorder=null;
		List<Order> listorder=new ArrayList<Order>();
		List<OrderItem> listorderitem=new ArrayList<OrderItem>();
		List<OrderList> listorderlist=new ArrayList<OrderList>();
		
		Order order=null;
		
		long glid=0;
		long orderid=0;
		Connection connection=DatabaseConnector.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ORDERLIST WHERE TRANSACTIONID=?");
		preparedStatement.setLong(1,transId);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		System.out.println("I am orderlist");
		
		if(resultSet.next()) {
			long id=resultSet.getLong("ID");
			glid=id;
			orderid=resultSet.getLong("ORDERID");
			System.out.println(id+" "+orderid);
		}
		System.out.println(glid);
		PreparedStatement preparedStatement1 = connection.prepareStatement("select * from orderitem where id=?");
		preparedStatement1.setLong(1,glid);
		System.out.println(" i am below ps");
		ResultSet resultSet1 = preparedStatement1.executeQuery();
		System.out.println(" i am orderitem");
		if(resultSet1.next()) {
			long iditem=resultSet1.getLong("ID");
			String codeitem=resultSet1.getString("PRODUCTCODE");
			int availableitem=resultSet1.getInt("AVAILABLEQUANTITY");
			double priceitem=resultSet1.getDouble("PRICE");
			orderitem =new OrderItem(iditem,codeitem,availableitem,priceitem);
			listorderitem.add(orderitem);
		}
		PreparedStatement preparedstatement2=connection.prepareStatement("SELECT * FROM ORDERS WHERE ORDERID=?");
		preparedstatement2.setLong(1, orderid);
		ResultSet resultSet2 = preparedstatement2.executeQuery();
		if(resultSet2.next()) {
			long idorder=resultSet2.getLong("ORDERID");
			String customeremail=resultSet2.getString("CUSTOMEREMAIL");
			String customeraddress=resultSet2.getString("CUSTOMERADDRESS");
			order =new Order(idorder,customeremail,customeraddress);
			order.setItems(listorderitem);
			listorder.add(order);	
		}
		return listorder;
	}
}
	
	
	


