package com.orderitemproject;

import java.sql.SQLException;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.orderitemproject.bean.Order;
import com.orderitemproject.bean.OrderItem;
import com.orderitemproject.bean.OrderItemList;
import com.orderitemproject.bean.OrderList;
import com.orderitemproject.service.OrderItemService;
import com.orderitemproject.service.OrderItemServiceImpl;

@Path("/orderItem")
public class OrderItemResource {
	private OrderItemService orderItemService=new OrderItemServiceImpl();
	
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response listAllProducts(){
//		OrderItemList productList=new OrderItemList();
//		try {
//			List<OrderItem> proList=orderItemService.viewAllProducts();
//			productList.setProducts(proList);
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		return Response
//	            .status(200)
//	            .header("Access-Control-Allow-Origin", "*")
//	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//	            .header("Access-Control-Allow-Credentials", "true")
//	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//	            .header("Access-Control-Max-Age", "1209600")
//	            .entity(productList)
//	            .build();
//	}
	
	@Path("/orderItems")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProduct( OrderItem c) 
	{ 
		
		boolean orderItem1=false;
		try {
			orderItem1=orderItemService.insertItem(c);
		} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
return Response
		.status(200)
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
        .header("Access-Control-Allow-Credentials", "true")
        .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
        .header("Access-Control-Max-Age", "1209600")
        .entity(orderItem1)
        .build();


	}
	
	@Path("/order")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProdu( Order c) 
	{ 
		
		boolean orderItem1=false;
		try {
			orderItem1=orderItemService.insertItem(c);
		} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
return Response
		.status(200)
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
        .header("Access-Control-Allow-Credentials", "true")
        .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
        .header("Access-Control-Max-Age", "1209600")
        .entity(orderItem1)
        .build();
}
	
	@Path("/id/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductByCode(@PathParam("id") Long id) {
		Order product=null;
		try {
			product=orderItemService.getOrderById(id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
	            .entity(product)
	            .build();
	
	}
	
	@Path("/tran/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getorderlistByCode(@PathParam("id") Long id) {
		OrderList orderlist=new OrderList();
		try {
			//System.out.println(id);
			List<Order> orderlist1=orderItemService.listAllProductsOrderList(id);
			//orderlist.setOrders(orderser.getorderbycodelist(id));
			orderlist.setOrders(orderlist1);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
	            .entity(orderlist)
	            .build();
	}
}
