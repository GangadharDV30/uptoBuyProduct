package com.onlineshoping.service;

import java.sql.SQLException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import com.onlineshoping.bean.Customer;
import com.onlineshoping.bean.ProductList;
import com.onlineshoping.persistance.CustomerDao;
import com.onlineshoping.persistance.CustomerDaoImpl;

public class CustomerServiceImpl implements CustomerService
{
CustomerDao customerDao=new CustomerDaoImpl();
	public boolean signingUp(Customer customer) throws ClassNotFoundException,SQLException
	{
			int  rows=customerDao.signUp(customer);
			if(rows>0) return true;
		return false;
	}

	public boolean logingIn(String name, String Password)throws ClassNotFoundException,SQLException
	{  
		Customer customer=customerDao.logIn(name, Password);
		
	if(customer!=null)
		return true;
	return false;
	}
	
	@Override
	public ProductList viewProduct() throws ClassNotFoundException, SQLException {
		ProductList product=null;
		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
		WebTarget webTarget = client.target("http://localhost:8085/CatalogServiceProject/webapi/").path("products");

		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationBuilder.get();
		
		product = response.readEntity(ProductList.class);
		System.out.println(response.getStatus());
//		System.out.println(product);
//		System.out.println(product.getProducts());
		return product;
	}

	

}
