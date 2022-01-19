package com.catalogserviceproject.persistance;

import java.sql.SQLException;
import java.util.List;

import com.catalogserviceproject.bean.Product;

public interface ProductDao {
	public List<Product> listAllProducts()throws ClassNotFoundException,SQLException;
	public Product getProductByCode(String productCode)throws ClassNotFoundException,SQLException;
}
