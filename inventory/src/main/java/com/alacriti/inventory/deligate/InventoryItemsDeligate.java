package com.alacriti.inventory.deligate;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.inventory.bo.InventoryItemsBO;
import com.alacriti.inventory.db.DBUtil;
import com.alacriti.inventory.models.InventoryItemsModel;
import com.alacriti.inventory.models.SortAndSearchModel;




public class InventoryItemsDeligate {
	
	public static final Logger log= Logger.getLogger(InventoryItemsDeligate.class);
	InventoryItemsBO inventoryItemsBO=null;
	
	
	
	public List<InventoryItemsModel> getAllDataFromInventoryItemsTable(){
		Connection connection=DBUtil.getConnection();
		boolean isError=false;
		List<InventoryItemsModel> list=null;
		
		try
		{
			inventoryItemsBO=new InventoryItemsBO();
			list=inventoryItemsBO.getAllInventoryItemsBO(connection);
			
			
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

	
	public void addDataToTableInventoryItems(InventoryItemsModel p[])
	{
			Connection connection=DBUtil.getConnection();
			boolean isError=false;
			
			try
			{
				
				inventoryItemsBO=new InventoryItemsBO();
				inventoryItemsBO.addDataToLoginDetailsBO(connection, p);
				
				
				
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
	}

	
	
	public void updateDataToTableInventoryItems(InventoryItemsModel p[])
	{
			
			Connection connection=DBUtil.getConnection();
			boolean isError=false;
			try 
			{
				
				inventoryItemsBO=new InventoryItemsBO();
				inventoryItemsBO.updateDataToLoginDetailsBO(connection, p);
				
				
				
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
	}

	
	
	public void deleteDataFromTableInventoryItems(String p)
	{
			
			Connection connection=DBUtil.getConnection();
			boolean isError=false;
			
			try
			{
				inventoryItemsBO=new InventoryItemsBO();
				inventoryItemsBO.deleteDataFromLoginDetailsBO(connection, p);
			
				
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
	}
	
	
	
	public List<InventoryItemsModel> getInventoryItemsBySortingAndSearching(SortAndSearchModel o)
	{
		Connection connection=DBUtil.getConnection();
		boolean isError=false;
		List<InventoryItemsModel> list=null;
		
		try 
		{
			inventoryItemsBO=new InventoryItemsBO();
			list=inventoryItemsBO.getInventoryItemsBySortingAndSearchingBO(connection, o);
			
			
		} 
		catch (Exception e) 
		{
			
			log.error("Exception Details : getInventoryItemsBySortingAndSearching"+e);
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
