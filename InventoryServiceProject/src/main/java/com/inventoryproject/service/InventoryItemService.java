package com.inventoryproject.service;
import java.sql.SQLException;
import com.inventoryproject.bean.InventoryItem;

public interface InventoryItemService {
	public InventoryItem getInventoryItemByProductCode(String productCode) throws ClassNotFoundException,SQLException;
	public InventoryItem  updateInventoryItemQuantityByProductCode(String productCode, int availableQuantity)throws ClassNotFoundException, SQLException;
}
