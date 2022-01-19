package com.onlineshoping.bean;

public class Customer
{
	private String customerName;
	private String customerEmail;
	private String customerPassword;
	public Customer()
	{

	}
	public Customer(String customerName, String customerEmail, String customerPassword) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Customer(String customerName, String customerPassword) {
		super();
		this.customerName = customerName;
		this.customerPassword = customerPassword;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerEmail=" + customerEmail + ", customerPassword="
				+ customerPassword + "]";
	}
}
