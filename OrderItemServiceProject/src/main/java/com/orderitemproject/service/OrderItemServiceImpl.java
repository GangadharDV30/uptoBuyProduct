package com.orderitemproject.service;

import java.sql.SQLException;
import java.util.List;

import com.orderitemproject.bean.Order;
import com.orderitemproject.bean.OrderItem;
import com.orderitemproject.bean.OrderList;
import com.orderitemproject.persistance.OrderItemDao;
import com.orderitemproject.persistance.OrderItemDaoImpl;

public class OrderItemServiceImpl implements OrderItemService {
	OrderItemDao orderItemDao =new OrderItemDaoImpl();
	@Override
	public boolean insertItem(OrderItem orderItem) throws ClassNotFoundException, SQLException {
		int rows=orderItemDao.insertItem(orderItem);
		if(rows>0)
		{
			return true;
		}
		return false;
	}
	@Override
	public List<OrderItem> viewAllProducts() throws ClassNotFoundException, SQLException {
		return orderItemDao.listAllProducts();
	}
	@Override
	public boolean insertItem(Order orderItem) throws ClassNotFoundException, SQLException {
		int rows=orderItemDao.insertItem(orderItem);
		if(rows>0)
		{
			return true;
		}
		return false;
	}
	@Override
	public Order getOrderById(Long orderId) throws ClassNotFoundException, SQLException {
		Order order=orderItemDao.getOrderByCode(orderId);
		return order;
	}
	@Override
	public List<Order> listAllProductsOrderList(Long transId) throws ClassNotFoundException, SQLException {
		return orderItemDao.listAllProductsOrderList(transId);
	}

}
