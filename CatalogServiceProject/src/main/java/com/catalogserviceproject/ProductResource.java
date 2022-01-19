package com.catalogserviceproject;
import java.sql.SQLException;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.catalogserviceproject.bean.Product;
import com.catalogserviceproject.bean.ProductList;
import com.catalogserviceproject.service.ProductService;
import com.catalogserviceproject.service.ProductServiceImpl;

@Path("/products")
public class ProductResource {
	private ProductService productService=new ProductServiceImpl();
		
//		@GET
//		@Produces(MediaType.APPLICATION_JSON)
//		public List<Product> listAllProducts(){
//			try {
//				return productService.viewAllProducts();
//			} catch (ClassNotFoundException | SQLException e) {
//				e.printStackTrace();
//			}
//			return null;
//		}
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response listAllProducts(){
			ProductList productList=new ProductList();
			try {
				List<Product> proList=productService.viewAllProducts();
				productList.setProducts(proList);
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
		            .entity(productList)
		            .build();
		}
		
		
		@Path("/code/{code}")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response getProductByCode(@PathParam("code") String code) {
			Product product=null;
			try {
				product=productService.getProductByCode(code);
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
}

