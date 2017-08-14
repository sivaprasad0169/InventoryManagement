package com.alacriti.inventory.delegate;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.inventory.bo.InventoryItemsBO;
import com.alacriti.inventory.db.DBUtil;
import com.alacriti.inventory.models.AvailableItemsModel;
import com.alacriti.inventory.models.CreateItemModel;
import com.alacriti.inventory.models.DeleteItemModel;
import com.alacriti.inventory.models.SortAndSearchModel;
import com.alacriti.inventory.models.UpdateItemModel;

public class InventoryItemsDelegate {
	
	
	
	public static final Logger log= Logger.getLogger(InventoryItemsDelegate.class);
	InventoryItemsBO inventoryItemsBO=null;
	
	public int addItemsToDetailsDelegate(CreateItemModel p[])
	{		int noOfRecordsPosted=0;
			Connection connection=DBUtil.getConnection();
			boolean isError=false;
			
			try
			{
				inventoryItemsBO=new InventoryItemsBO();
				noOfRecordsPosted=inventoryItemsBO.addItemsToDetails(connection, p);				
				
				
			} 
			catch (Exception e)
			{
				
				log.error("Exception Details : addDataToTableInventoryItems"+e);
				isError=true;
				
				
			} 
			finally 
			{
				
				DBUtil.closeConnection(connection,isError);
			}
			return noOfRecordsPosted;
	}

	
	
	public int updateItemsInDetails(UpdateItemModel p[])
	{
			int noOfRecordsUpdated=0;
			Connection connection=DBUtil.getConnection();
			boolean isError=false;
			try 
			{
				
				inventoryItemsBO=new InventoryItemsBO();
				noOfRecordsUpdated=inventoryItemsBO.updateItemsInDetails(connection, p);
				
				
				
			} 
			catch (Exception e)
			{
				
				log.error("Exception Details : updateDataToTableInventoryItems"+e);
				isError=true;
				
				
			}
			finally 
			{
				
				DBUtil.closeConnection(connection,isError);
			}
			return noOfRecordsUpdated;
	}

	
	
	public int deleteItemsInDetails(DeleteItemModel d)
	{
			int noOfRecordsDeleted=0;
			Connection connection=DBUtil.getConnection();
			boolean isError=false;
			
			try
			{	
				inventoryItemsBO=new InventoryItemsBO();
				noOfRecordsDeleted=inventoryItemsBO.deleteItemsInDetails(connection, d);
			
				
			} 
			catch (Exception e) 
			{
				
				log.error("Exception Details : deleteDataFromTableInventoryItems"+e);
				isError=true;
				
				
			} 
			finally
			{
				
				DBUtil.closeConnection(connection,isError);
			}
			return noOfRecordsDeleted;
	}
	
	
	public List<AvailableItemsModel> getAllInventoryItemsBySortAndSearch(SortAndSearchModel p)
	{
		List<AvailableItemsModel> list=null;
		Connection connection=DBUtil.getConnection();
		boolean isError=false;
		
		try
		{	
			inventoryItemsBO=new InventoryItemsBO();
			list=inventoryItemsBO.getAllInventoryItemsFromDetailsBySortAndSearch(connection, p);
		
			
		} 
		catch (Exception e) 
		{
			
			log.error("Exception Details : deleteDataFromTableInventoryItems"+e);
			isError=true;
			
			
		} 
		finally
		{
			
			DBUtil.closeConnection(connection,isError);
		}
		return list;
	}
	public List<AvailableItemsModel> getAllInventoryItems()
	{
		List<AvailableItemsModel> list=null;
		Connection connection=DBUtil.getConnection();
		boolean isError=false;
		
		try
		{	
			inventoryItemsBO=new InventoryItemsBO();
			list=inventoryItemsBO.getAllInventoryItemsFromDetails(connection);
		
			
		} 
		catch (Exception e) 
		{
			
			log.error("Exception Details : deleteDataFromTableInventoryItems"+e);
			isError=true;
			
			
		} 
		finally
		{
			
			DBUtil.closeConnection(connection,isError);
		}
		return list;
	}

}
