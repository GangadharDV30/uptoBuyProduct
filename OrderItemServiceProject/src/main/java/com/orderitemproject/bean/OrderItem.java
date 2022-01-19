package com.orderitemproject.bean;

public class OrderItem {
	 private Long id;
	    private String productcode;
	    private int quantity;
	    private double price;
	    public OrderItem() {
	    	
	    }
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getProductcode() {
			return productcode;
		}
		public void setProductcode(String productcode) {
			this.productcode = productcode;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public OrderItem(Long id, String productcode, int quantity, double price) {
			super();
			this.id = id;
			this.productcode = productcode;
			this.quantity = quantity;
			this.price = price;
		}
		@Override
		public String toString() {
			return "OrderItem [id=" + id + ", productcode=" + productcode + ", quantity=" + quantity + ", price="
					+ price + "]";
		}
		
}
