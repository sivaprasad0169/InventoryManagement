package com.alacriti.inventory.bo;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.inventory.dao.InventoryItemsAccessDAO;
import com.alacriti.inventory.models.SortAndSearchModel;
import com.alacriti.inventory.models.InventoryItemsModel;


public class InventoryItemsBO {
	
	public static final Logger log= Logger.getLogger(InventoryItemsBO.class);
	InventoryItemsAccessDAO inventoryItemsDAO=null;
	
	
	public List<InventoryItemsModel> getAllInventoryItemsBO(Connection connection)
	{
		List<InventoryItemsModel> list=null;
		try
		{
			inventoryItemsDAO=new InventoryItemsAccessDAO();
			list=inventoryItemsDAO.getAllInventoryItemsDAO(connection);
		}
		catch(Exception e)
		{
			log.error("Exception Details:getAllInventoryItemsBO"+e);
		}
		return list;
	}
	
	
	
	public void addDataToLoginDetailsBO(Connection connection,InventoryItemsModel p[])
	{
		try
		{
			inventoryItemsDAO=new InventoryItemsAccessDAO();
			inventoryItemsDAO.addDataInventoryItemsDAO(connection, p);
			
		}
		catch(Exception e)
		{
			log.error("Exception Details: addDataToLoginDetailsBO"+e);
		}
	
		
	}
	
	
	
	public void updateDataToLoginDetailsBO(Connection connection,InventoryItemsModel p[])
	{
		try
		{
			inventoryItemsDAO=new InventoryItemsAccessDAO();
			inventoryItemsDAO.updateDataToInventoryItemsDAO(connection, p);
			
		}
		catch(Exception e)
		{
			log.error("Exception Details: updateDataToLoginDetailsBO"+e);
		}
	
	}
	
	
	
	public void deleteDataFromLoginDetailsBO(Connection connection,String p)
	{
		
		try
		{
			inventoryItemsDAO=new InventoryItemsAccessDAO();
			inventoryItemsDAO.deleteDataFromInventoryItemsDAO(connection, p);
		}
		catch(Exception e)
		{
			log.error("Exception Details: deleteDataFromLoginDetailsBO"+e);
		}
	
	}
	
	public List<InventoryItemsModel> getInventoryItemsBySortingAndSearchingBO(Connection connection,SortAndSearchModel o)
	{
		List<InventoryItemsModel> list=null;
		try
		{
			inventoryItemsDAO=new InventoryItemsAccessDAO();
			list=inventoryItemsDAO.getAllInventoryItemsBySortingAndSearchingDAO(connection, o);
		}
		catch(Exception e)
		{
			log.error("Exception Details: getInventoryItemsBySortingAndSearchingBO"+e);
		}
		return list;
	} 
	
	
	

}
