package com.onlineshoping.persistance;
import java.sql.SQLException;
import com.onlineshoping.bean.Customer;

public interface CustomerDao
{
	int signUp(Customer customer)throws ClassNotFoundException,SQLException;
	Customer logIn(String name, String password)throws ClassNotFoundException,SQLException;
}
