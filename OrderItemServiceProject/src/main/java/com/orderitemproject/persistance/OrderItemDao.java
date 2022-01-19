package com.orderitemproject.persistance;

import java.sql.SQLException;

import java.util.List;

import com.orderitemproject.bean.Order;
import com.orderitemproject.bean.OrderItem;
import com.orderitemproject.bean.OrderList;

public interface OrderItemDao {
	public int insertItem(OrderItem orderItem)throws ClassNotFoundException, SQLException;
	public int insertItem(Order orderItem)throws ClassNotFoundException, SQLException;
	public Order getOrderByCode(Long orderId)throws ClassNotFoundException,SQLException;
	
	public List<Order> listAllProductsOrder()throws ClassNotFoundException,SQLException;
	public List<OrderItem> listAllProducts()throws ClassNotFoundException,SQLException;
	public List<Order> listAllProductsOrderList(Long transId)throws ClassNotFoundException,SQLException;
	
}
