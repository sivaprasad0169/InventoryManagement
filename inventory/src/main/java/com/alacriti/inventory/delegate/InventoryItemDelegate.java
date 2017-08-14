package com.alacriti.inventory.delegate;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.inventory.bo.InventoryItemBO;
import com.alacriti.inventory.db.DBUtil;
import com.alacriti.inventory.models.AvailableItemsModel;
import com.alacriti.inventory.models.ItemDetailsModel;

public class InventoryItemDelegate {
	
	
	public static final Logger log= Logger.getLogger(InventoryItemDelegate.class);
	InventoryItemBO inventoryItemBO=null;
	
	
	public AvailableItemsModel getInventoryItemDetailsById(String itemId){
		Connection connection=DBUtil.getConnection();
		boolean isError=false;
		AvailableItemsModel model=null;
		
		try
		{
			inventoryItemBO=new InventoryItemBO();
			model=inventoryItemBO.getInventoryItemDetailsById(connection, itemId);
			
			
		}
		catch (Exception e)
		{
			
			log.error("Exception Details : getAllDataFromInventoryItemsTable"+e);
			isError=true;
			return model;
			
		} 
		finally 
		{
			
			DBUtil.closeConnection(connection,isError);
		}
		return model;
		
	}
	
	
	
	
	
	
	public List<ItemDetailsModel> getInventoryItemDetails(String itemId){
		Connection connection=DBUtil.getConnection();
		boolean isError=false;
		List<ItemDetailsModel> list=null;
		
		try
		{
			inventoryItemBO=new InventoryItemBO();
			list=inventoryItemBO.getInventoryItemDetails(connection, itemId);
			
			
		}
		catch (Exception e)
		{
			
			log.error("Exception Details : getAllDataFromInventoryItemsTable"+e);
			isError=true;
			return list;
			
		} 
		finally 
		{
			
			DBUtil.closeConnection(connection,isError);
		}
		return list;
		
	}
	
	
	
	public List<ItemDetailsModel> getInventoryItemPurchaseDetails(String itemId){
		Connection connection=DBUtil.getConnection();
		boolean isError=false;
		List<ItemDetailsModel> list=null;
		
		try
		{
			inventoryItemBO=new InventoryItemBO();
			list=inventoryItemBO.getInventoryItemPurchaseDetails(connection, itemId);
			
			
		}
		catch (Exception e)
		{
			
			log.error("Exception Details : getAllDataFromInventoryItemsTable"+e);
			isError=true;
			return list;
			
		} 
		finally 
		{
			
			DBUtil.closeConnection(connection,isError);
		}
		return list;
		
	}
	
	
	public List<ItemDetailsModel> getInventoryItemConsumesDetails(String itemId){
		Connection connection=DBUtil.getConnection();
		boolean isError=false;
		List<ItemDetailsModel> list=null;
		
		try
		{
			inventoryItemBO=new InventoryItemBO();
			list=inventoryItemBO.getInventoryItemConsumeDetails(connection, itemId);
			
			
		}
		catch (Exception e)
		{
			
			log.error("Exception Details : getAllDataFromInventoryItemsTable"+e);
			isError=true;
			return list;
			
		} 
		finally 
		{
			
			DBUtil.closeConnection(connection,isError);
		}
		return list;
		
	}

}
