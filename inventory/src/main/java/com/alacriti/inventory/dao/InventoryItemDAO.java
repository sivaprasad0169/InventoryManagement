package com.alacriti.inventory.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.inventory.exceptions.DAOException;
import com.alacriti.inventory.models.AvailableItemsModel;
import com.alacriti.inventory.models.ItemDetailsModel;

public class InventoryItemDAO {
	
	
	
	public static final Logger log= Logger.getLogger(InventoryItemDAO.class);

	
	public AvailableItemsModel getInventoryItemByID(Connection connection ,String itemId) throws DAOException
	{
		Statement statement = null;
		ResultSet result = null;
		AvailableItemsModel model=null;
		try
		{
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
													ResultSet.CONCUR_UPDATABLE);
			String query="select * from "
					+ "sivaprasadt_inventory_items_details where Item_Id="+itemId+";";
			
			result = statement.executeQuery(query);
			
			while(result.next())
			{
				
				model=new AvailableItemsModel(result.getInt(1),result.getInt(3),result.getString(2));
				
			}
			
		}
		catch(SQLException e)
		{
			
			log.error("Exception Details: getInventoryItemByID :"+e);
			throw new DAOException("Exception Occured In DAO");
			
		}
		catch (Exception e) 
		{
			
			log.error("Exception Details ::getInventoryItemByID"+e);
			throw new DAOException("Exception Occured In DAO");
			
		} 
		return model;
	}
	
	
	
	public List<ItemDetailsModel> getInventoryItemDetails(Connection connection,String itemId) throws DAOException
	{
		
		Statement statement = null;
		ResultSet result = null;
		List<ItemDetailsModel> list=null;
		
		try
		{
			
			
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			
			
			
			String query=getQueryForItemDetails(itemId);
			result = statement.executeQuery(query);
			
			list=new ArrayList<ItemDetailsModel>();
			
			while (result.next()) 
			{
				
				list.add(new ItemDetailsModel(result.getInt(1),result.getInt(2),
						result.getInt(3),result.getInt(4),result.getString(5),
						result.getString(6),result.getInt(7),result.getString(9)));
			}
			
		}
		catch(SQLException sqle)
		{
			
			log.error(" SQL Exception Details ::getInventoryItemDetails"+sqle);
			throw new DAOException("Exception Occured In DAO");
			
		}
		catch (Exception e) 
		{
			
			log.error("Exception Details ::getInventoryItemDetails"+e);
			throw new DAOException("Exception Occured In DAO");
			
		} 
		return list;
		
	}
	
	
	public List<ItemDetailsModel> getInventoryItemPurchaseDetails(Connection connection,String itemId) throws DAOException
	{
			
		Statement statement = null;
		ResultSet result = null;
		List<ItemDetailsModel> list=null;
		
		try
		{
			
			
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			
			
			
			String query=getQueryForPurchaseDetails(itemId);
			result = statement.executeQuery(query);
			
			list=new ArrayList<ItemDetailsModel>();
			
			while (result.next())
			{
				
				list.add(new ItemDetailsModel(result.getInt(1),result.getInt(2),
						result.getInt(3),result.getInt(4),result.getString(5),
						result.getString(6),result.getInt(7),result.getString(9)));
			}
			
		}
		catch(SQLException sqle)
		{
			
			log.error(" SQL Exception Details ::getInventoryItemPurchaseDetails "+sqle);
			throw new DAOException("Exception Occured In DAO");
			
		}
		catch (Exception e) 
		{
			
			log.error("Exception Details ::getInventoryItemPurchaseDetails "+e);
			throw new DAOException("Exception Occured In DAO");
			
		} 
		return list;
			
		}
	
	
	public List<ItemDetailsModel> getInventoryItemConsumeDetails(Connection connection,String itemId) throws DAOException
	{
		
		Statement statement = null;
		ResultSet result = null;
		List<ItemDetailsModel> list=null;
		
		try
		{
			
			
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);			
			
			String query=getQueryForConsumeDetails(itemId);
			
			result = statement.executeQuery(query);
			
			list=new ArrayList<ItemDetailsModel>();
			
			while (result.next())
			{
				
				list.add(new ItemDetailsModel(result.getInt(1),result.getInt(2),result.getInt(3)
						,result.getInt(4),result.getString(5),result.getString(6),result.getInt(7),result.getString(9)));
			}
			
		}
		catch(SQLException sqle)
		{
			log.error(" SQL Exception Details ::getInventoryItemConsumeDetails"+sqle);
			throw new DAOException("Exception Occured In DAO");
			
		}
		catch (Exception e) 
		{
			
			log.error("Exception Details ::getInventoryItemConsumeDetails"+e);
			throw new DAOException("Exception Occured In DAO");
			
		} 
		return list;
		
	}
	
	
	
	
	
	
	
	public String getQueryForItemDetails(String id){
		

		String query="select * from "
				+ "sivaprasadt_inventory_update_details as t1"
				+ " left join sivaprasadt_inventory_master_table as t2 "
				+ "on  t1.Operation_Id=t2.Operation_Id where Item_Id="+id+" order by Update_Id desc;";
		
		
		return query;
		
	}
	
	
	public String getQueryForPurchaseDetails(String itemId)
	{
		String query="select * from sivaprasadt_inventory_update_details"
				+ " as t1 left join sivaprasadt_inventory_master_table as t2"
				+ " on  t1.Operation_Id=t2.Operation_Id where Item_Id="+itemId+" "
						+ "and t1.Operation_Id=1 order by Update_Id desc;";
		
		return query;
	}
	
	
	
	public String getQueryForConsumeDetails(String itemId)
	{
		
		String query="select * from sivaprasadt_inventory_update_details as t1"
				+ " left join sivaprasadt_inventory_master_table as t2"
				+ " on  t1.Operation_Id=t2.Operation_Id where Item_Id="+itemId+" and"
						+ " t1.Operation_Id=2 order by Update_Id desc;";
		return query;
		
	}
	

}
