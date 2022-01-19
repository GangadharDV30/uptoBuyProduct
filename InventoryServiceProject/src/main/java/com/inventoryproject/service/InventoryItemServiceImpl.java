package com.inventoryproject.service;
import java.sql.SQLException;
import com.inventoryproject.bean.InventoryItem;
import com.inventoryproject.persistance.InventoryItemDao;
import com.inventoryproject.persistance.InventoryItemDaoImpl;

public class InventoryItemServiceImpl implements InventoryItemService {
	InventoryItemDao inventoryItemDao=new InventoryItemDaoImpl();
	@Override
	public InventoryItem getInventoryItemByProductCode(String productCode) throws ClassNotFoundException, SQLException {
		InventoryItem inventoryItem=inventoryItemDao.getInventoryItemByProductCode(productCode);
		return inventoryItem;
	}
	@Override
	public InventoryItem updateInventoryItemQuantityByProductCode(String productCode, int availableQuantity)
			throws ClassNotFoundException, SQLException {
		InventoryItem inventoryItem=null;
		int rows=inventoryItemDao.updateInventoryItemQuantityByProductCode(productCode, availableQuantity);
		if(rows>0)
		{
			inventoryItem=inventoryItemDao.getInventoryItemByProductCode(productCode);
			System.out.println(inventoryItem);
			return inventoryItem;	
		}
		return null;
	}

}
