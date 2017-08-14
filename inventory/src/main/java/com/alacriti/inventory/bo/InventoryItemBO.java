package com.alacriti.inventory.bo;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.inventory.dao.InventoryItemDAO;
import com.alacriti.inventory.exceptions.BOException;
import com.alacriti.inventory.exceptions.DAOException;
import com.alacriti.inventory.models.AvailableItemsModel;
import com.alacriti.inventory.models.ItemDetailsModel;

public class InventoryItemBO {
	
	
	public static final Logger log= Logger.getLogger(InventoryItemsBO.class);
	
	InventoryItemDAO inventoryItemDAO=null;
	
	
	
	
	public AvailableItemsModel getInventoryItemDetailsById(Connection connection,String itemId) throws BOException
	{
		AvailableItemsModel model=null;
		try
		{
			inventoryItemDAO=new InventoryItemDAO();
			model=inventoryItemDAO.getInventoryItemByID(connection, itemId);
		}
		catch(DAOException daoe)
		{
			log.error("Exception Detials: getInventoryItemDetailsByIdBO "+daoe);
			throw new BOException();
		}
		catch(Exception e)
		{
			log.error("Exception Detials: getInventoryItemDetailsByIdBO "+e);
			throw new BOException("Exception Occured In BO");
		}
		return model;
	}
	
	
	
	
	
	public List<ItemDetailsModel> getInventoryItemDetails(Connection connection,String itemId) throws BOException
	{
		List<ItemDetailsModel> list=null;
		try
		{
			inventoryItemDAO=new InventoryItemDAO();
			list=inventoryItemDAO.getInventoryItemDetails(connection, itemId);
			
		}
		catch(DAOException daoe)
		{
			log.error("Exception Detials: getInventoryItemDetailsByIdBO "+daoe);
			throw new BOException();
		}
		catch(Exception e)
		{
			log.error("ExceptionDetails : getInventoryItemDetailsBO"+e);
			throw new BOException("Exception Occured In BO");
		}
		return list;
	}
	
	
	
	public List<ItemDetailsModel> getInventoryItemPurchaseDetails(Connection connection,String itemId) throws BOException
	{
		List<ItemDetailsModel> list=null;
		try
		{
			inventoryItemDAO=new InventoryItemDAO();
			list=inventoryItemDAO.getInventoryItemPurchaseDetails(connection, itemId);
			
		}
		catch(DAOException daoe)
		{
			log.error("Exception Detials: getInventoryItemDetailsByIdBO "+daoe);
			throw new BOException();
		}
		catch(Exception e)
		{
			log.error("Exception Details: getInventoryItemPurchaseDetailsBO "+e);
			throw new BOException("Exception Occured In BO");
		}
		return list;
	}
	
	
	public List<ItemDetailsModel> getInventoryItemConsumeDetails(Connection connection,String itemId) throws BOException
	{
		List<ItemDetailsModel> list=null;
		try
		{
			inventoryItemDAO=new InventoryItemDAO();
			list=inventoryItemDAO.getInventoryItemConsumeDetails(connection, itemId);
			
		}
		catch(DAOException daoe)
		{
			log.error("Exception Detials: getInventoryItemDetailsByIdBO "+daoe);
			throw new BOException();
		}
		catch(Exception e)
		{
			log.error("Exception Details: getInventoryItemConsumeDetailsBO "+e);
			throw new BOException("Exception Occured In BO");
		}
		return list;
	}
	
	

}
