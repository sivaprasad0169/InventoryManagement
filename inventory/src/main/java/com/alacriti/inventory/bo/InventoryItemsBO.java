package com.alacriti.inventory.bo;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.inventory.dao.InventoryItemsDAO;
import com.alacriti.inventory.exceptions.BOException;
import com.alacriti.inventory.exceptions.DAOException;
import com.alacriti.inventory.models.AvailableItemsModel;
import com.alacriti.inventory.models.CreateItemModel;
import com.alacriti.inventory.models.DeleteItemModel;
import com.alacriti.inventory.models.SortAndSearchModel;
import com.alacriti.inventory.models.UpdateItemModel;

public class InventoryItemsBO {
	
	
	
	
	public static final Logger log= Logger.getLogger(InventoryItemsBO.class);
	InventoryItemsDAO inventoryItemsDAO=null;
	
	
	
	public List<AvailableItemsModel> getAllInventoryItemsFromDetails(Connection connection) throws BOException
	{
		List<AvailableItemsModel> list=null;
		try
		{
			
			inventoryItemsDAO=new InventoryItemsDAO();
			list=inventoryItemsDAO.getAllInventoryItemsFromDetails(connection);
			
		}
		catch(DAOException daoe)
		{
			log.error("Exception Details: getAllInventoryItemsFromDetails "+daoe);
			throw new BOException();
			
		}
		catch(Exception e)
		{
			
			log.error("Exception Details: getAllInventoryItemsFromDetails "+e);
			throw new BOException("Exception Occured In BO");
			
		}
		return list;
	}
	
	
	
	public List<AvailableItemsModel> getAllInventoryItemsFromDetailsBySortAndSearch(Connection connection,SortAndSearchModel p) throws BOException    
	{
		
		List<AvailableItemsModel> list=null;
		try
		{
			
			inventoryItemsDAO=new InventoryItemsDAO();
			list=inventoryItemsDAO.getAllItemsFromDetailsBySortAndSearch(connection, p);
			
		}
		catch(DAOException daoe)
		{
			log.error("Exception Details: getAllInventoryItemsFromDetailsBySortAndSearch "+daoe);
			throw new BOException();
			
		}
		catch(Exception e)
		{
			
			log.error("Exception Details: getAllInventoryItemsFromDetailsBySortAndSearch "+e);
			throw new BOException("Exception Occured In BO");
			
		}
		return list;
	}
	
	
	
	public int addItemsToDetails(Connection connection,CreateItemModel p[])  throws BOException
	{
		int noOfRecordsPosted=0;
		try
		{
			inventoryItemsDAO=new InventoryItemsDAO();
			noOfRecordsPosted=inventoryItemsDAO.addItemsToDetails(connection, p);
			
		}
		catch(DAOException daoe)
		{
			log.error("Exception Details: addItemsToDetails "+daoe);
			throw new BOException();
			
		}
		catch(Exception e)
		{
			
			log.error("Exception Details: addItemsToDetails "+e);
			throw new BOException("Exception Occured In BO");
			
		}
		return noOfRecordsPosted;
		
	}
	
	
	
	
	public int updateItemsInDetails(Connection connection,UpdateItemModel p[]) throws BOException
	{
		int noOfRecordsUpdated=0;
		try
		{
			
			inventoryItemsDAO=new InventoryItemsDAO();
			noOfRecordsUpdated=inventoryItemsDAO.updateItemsInDetails(connection, p);
			
			
		}
		catch(DAOException daoe)
		{
			log.error("Exception Details: updateItemsInDetails "+daoe);
			throw new BOException();
			
		}
		catch(Exception e)
		{
			
			log.error("Exception Details: updateItemsInDetails"+e);
			throw new BOException("Exception Occured In BO");
			
		}
		
		return noOfRecordsUpdated;
	
	}
	
	
	
	public int deleteItemsInDetails(Connection connection,DeleteItemModel d) throws BOException
	{
		int noOfRecordsUpdated=0;
		try
		{
			
			inventoryItemsDAO=new InventoryItemsDAO();
			noOfRecordsUpdated=inventoryItemsDAO.deleteItemFromDetails(connection, d);
			
		}
		catch(DAOException daoe)
		{
			log.error("Exception Details: deleteItemsInDetails "+daoe);
			throw new BOException();
			
		}
		catch(Exception e)
		{
			
			log.error("Exception Details: deleteItemsInDetails "+e);
			throw new BOException("Exception Occured In BO");
			
		}
		return noOfRecordsUpdated;
	}

}
