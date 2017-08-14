package com.alacriti.inventory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.inventory.exceptions.DAOException;
import com.alacriti.inventory.models.AvailableItemsModel;
import com.alacriti.inventory.models.CreateItemModel;
import com.alacriti.inventory.models.DeleteItemModel;
import com.alacriti.inventory.models.SortAndSearchModel;
import com.alacriti.inventory.models.UpdateItemModel;

public class InventoryItemsDAO {
	
		
		
		public static final Logger log= Logger.getLogger(InventoryItemsDAO.class);
			
			
		public List<AvailableItemsModel> getAllItemsFromDetailsBySortAndSearch(Connection connection,SortAndSearchModel o) throws DAOException        
		{
			
			Statement statement = null;
			ResultSet result = null;
			List<AvailableItemsModel> list=null;
			
			try 
			{				
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				
				
				if(o.categoryId==0)
				{
					result = statement.executeQuery("select * from sivaprasadt_inventory_items_details "
							+ "where Concat(Item_Name,Available_Quantity) like '%"+o.searchText+"%'"
							+ " order by "+o.sortBy+" asc;");
					
				}
				else
				{
					result = statement.executeQuery("select * from sivaprasadt_inventory_items_details "
						+ "where Concat(Item_Name,Available_Quantity) like '%"+o.searchText+"%'"
						+ "and Category_Id="+o.categoryId+" order by "+o.sortBy+" asc;");
				}
				

				
				list=new ArrayList<AvailableItemsModel>();
				
				while (result.next())
				{
					
					list.add(new AvailableItemsModel(result.getInt(1),
							result.getInt(3),result.getString(2)));
					
				}
				
			} 
			catch(SQLException sqle)
			{
				
				log.error(" SQL Exception Details ::getAllItemsBySortAndSearch"+sqle);
				throw new DAOException("Exception Occured In DAO");
				
			}
			catch (Exception e)
			{
				
				log.error("Exception Details ::getAllItemsBySortAndSearch"+e);
				throw new DAOException("Exception Occured In DAO");
				
			}
			return list;
		} 
		
		
		
		
		
		public List<AvailableItemsModel> getAllInventoryItemsFromDetails(Connection connection) throws DAOException 
		{	
			Statement statement = null;
			ResultSet result = null;
			List<AvailableItemsModel> list=null;
			
			try
			{
				
				
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				
				result = statement.executeQuery("select * from sivaprasadt_inventory_items_details;");
				
				
				
				list=new ArrayList<AvailableItemsModel>();
				
				
				while (result.next())
				{
					
					list.add(new AvailableItemsModel(result.getInt(1),result.getInt(3),result.getString(2)));
					
				}
				
			}
			catch (SQLException e) 
			{
				
				log.error("Exception Details ::getAllInventoryItemsFromDetails"+e);
				throw new DAOException("Exception Occured In DAO");
				
			} 
			catch (Exception e)
			{
				
				log.error("Exception Details ::addItemsToDetails"+e);	
				throw new DAOException("Exception Occured In DAO");
				
			}
			return list;
			
		}

			
			
		public int addItemsToDetails(Connection connection,CreateItemModel p[]) throws DAOException 
		{
				PreparedStatement preparedStatement=null;
				int noOfRecordsUpdated=0;
				ResultSet result=null;
				int itemId=0;
				try
				{										
					preparedStatement=connection.prepareStatement("insert into "
							+ "sivaprasadt_inventory_items_details values(null,?,?,?);"
							,Statement.RETURN_GENERATED_KEYS);
					
					for(int i=0;i<(p.length);i++)
					{	
						preparedStatement.setString(1, p[i].itemName);
						preparedStatement.setInt(2, p[i].itemQuantity);	
						preparedStatement.setInt(3, p[i].categoryId);
						noOfRecordsUpdated +=preparedStatement.executeUpdate();
						result = preparedStatement.getGeneratedKeys();
						while(result!=null && result.next())
						{
							
							itemId=result.getInt(1);
							
						}
						
						addItemToUpdateDetails(connection,itemId, p[i].itemQuantity,
								p[i].updatedBy,p[i].itemQuantity, 1);
					}
					
				}
				catch(SQLException sqle)
				{
					
					log.error(" SQL Exception Details ::addItemsToDetails"+sqle);
					throw new DAOException("Exception Occured In DAO");
					
				}
				catch (Exception e)
				{
					
					log.error("Exception Details ::addItemsToDetails"+e);	
					throw new DAOException("Exception Occured In DAO");
					
				}
				return noOfRecordsUpdated;
		}	
		
		
		
		
		
		
		
		
		
		
		public int updateItemsInDetails(Connection connection,UpdateItemModel p[]) throws DAOException 
		{
				int noOfRecordsUpdated=0;
				PreparedStatement preparedStatement=null;
				try 
				{

					preparedStatement=connection.prepareStatement("update  sivaprasadt_inventory_items_details"
							+ " set Item_Name=?,Available_Quantity=? where Item_Id=?;");
					
					for(int i=0;i<(p.length);i++)
					{
						
						preparedStatement.setString(1, p[i].updatedItemName);
						preparedStatement.setInt(2, p[i].itemUpdatedQuantity);
						preparedStatement.setInt(3, p[i].itemId);						
						noOfRecordsUpdated=preparedStatement.executeUpdate();
						
						if(p[i].purchasedQuantity>0)
						{
							addItemToUpdateDetails(connection, p[i].itemId, p[i].purchasedQuantity,
									p[i].updatedBy, p[i].itemUpdatedQuantity+p[i].consumedQuantity, 1);
						}
						
						if(p[i].consumedQuantity>0)
						{
							
							addItemToUpdateDetails(connection, p[i].itemId, p[i].consumedQuantity,
									p[i].updatedBy, p[i].itemUpdatedQuantity, 2);
						}
						
					}
					
				} 
				catch(SQLException sqle)
				{
					
					log.error(" SQL Exception Details ::updateItemsInDetails "+sqle);
					throw new DAOException("Exception Occured In DAO");
					
				}
				catch (Exception e)
				{
					
					log.error("Exception Details ::updateItemsInDetails"+e);
					throw new DAOException("Exception Occured In DAO");
					
					
				} 
				return noOfRecordsUpdated;
		}
				
		
		
		
		public int deleteItemFromDetails(Connection connection,DeleteItemModel d)  throws DAOException 
		{
				
				PreparedStatement preparedStatement=null;
				int noOfRecordsEffected=0;
				try 
				{
					
				
					
					preparedStatement=connection.prepareStatement("delete from "
							+ "sivaprasadt_inventory_items_details where Item_Id=?;");
					
					preparedStatement.setInt(1, d.itemId);
					noOfRecordsEffected=preparedStatement.executeUpdate();
					deleteItemFromUpdateDetails(connection, d.itemId);
					
					
				} 
				catch(SQLException sqle)
				{
					
					log.error(" SQL Exception Details ::deleteItemFromDetails"+sqle);
					throw new DAOException("Exception Occured In DAO");
					
				}
				catch (Exception e)
				{
					
					log.error("Exception Details ::deleteItemFromDetails"+e);
					throw new DAOException("Exception Occured In DAO");
					
				}
				
				return noOfRecordsEffected;
		}
		
		
		
		
		
		
		public int deleteItemFromUpdateDetails(Connection connection,int itemId)  throws DAOException 
		{
				
				PreparedStatement preparedStatement=null;
				int noOfRecordsEffected=0;
				try 
				{
					preparedStatement=connection.prepareStatement("delete from "
							+ "sivaprasadt_inventory_update_details where Item_Id=?;");
					
					preparedStatement.setInt(1, itemId);
					noOfRecordsEffected=preparedStatement.executeUpdate();
					
					
					
				} 
				catch(SQLException sqle)
				{
					
					log.error(" SQL Exception Details ::deleteItemFromUpdateDetails"+sqle);	
					throw new DAOException("Exception Occured In DAO");
					
				}
				catch (Exception e)
				{
					
					log.error("Exception Details ::deleteItemFromUpdateDetails"+e);
					throw new DAOException("Exception Occured In DAO");
					
				}
				return noOfRecordsEffected;
		}
		
		
		
		
		
		public static int addItemToUpdateDetails(Connection connection,
				int itemId,int updatedQuantity,String updatedBy,
				int availableQuantity,int OperationId) throws DAOException 
		{
				PreparedStatement preparedStatement=null;
				int noOfRecordsUpdated=0;
				try
				{
					
					
					preparedStatement=connection.prepareStatement("insert into "
							+ "sivaprasadt_inventory_update_details values(null,?,?,?,null,?,?);");
					
						preparedStatement.setInt(1, itemId);
						preparedStatement.setInt(2, updatedQuantity);
						preparedStatement.setInt(3, availableQuantity);
						preparedStatement.setString(4,updatedBy);
						preparedStatement.setInt(5,OperationId);
						
						noOfRecordsUpdated =preparedStatement.executeUpdate();
						
					
				
				}
				catch(SQLException sqle)
				{
					
					log.error(" SQL Exception Details ::addItemToUpdateDetails"+sqle);
					throw new DAOException("Exception Occured In DAO");
					
				}
				catch (Exception e)
				{
					
					log.error("Exception Details ::addItemToUpdateDetails"+e);
					throw new DAOException("Exception Occured In DAO");
					
				}
				return noOfRecordsUpdated;
		}
		
		
			
			
		

}

	
	
	
	

