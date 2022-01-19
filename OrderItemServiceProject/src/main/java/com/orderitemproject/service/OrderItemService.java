package com.orderitemproject.service;

import java.sql.SQLException;
import java.util.List;

import com.orderitemproject.bean.Order;
import com.orderitemproject.bean.OrderItem;
import com.orderitemproject.bean.OrderList;

public interface OrderItemService {
	public boolean insertItem(OrderItem orderItem) throws ClassNotFoundException, SQLException;
	List<OrderItem> viewAllProducts()throws ClassNotFoundException,SQLException;
	public boolean insertItem(Order orderItem) throws ClassNotFoundException, SQLException;
	public Order getOrderById(Long orderId) throws ClassNotFoundException, SQLException;
	public List<Order> listAllProductsOrderList(Long transId) throws ClassNotFoundException, SQLException;
}
