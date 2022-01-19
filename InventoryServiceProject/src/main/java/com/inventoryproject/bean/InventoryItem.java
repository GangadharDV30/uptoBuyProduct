package com.inventoryproject.bean;

public class InventoryItem {
    private long id; 
    private String productCode;
    private int availableQuantity ;
    
    public  InventoryItem() {
    	
    }

	public InventoryItem(long id, String productCode, int availableQuantity) {
		super();
		this.id = id;
		this.productCode = productCode;
		this.availableQuantity = availableQuantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	@Override
	public String toString() {
		return "InventoryItem [id=" + id + ", productCode=" + productCode + ", availableQuantity=" + availableQuantity
				+ "]";
	}
    
    

}
