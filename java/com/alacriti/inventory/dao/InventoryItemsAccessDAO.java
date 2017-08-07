package com.alacriti.inventory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.inventory.models.InventoryItemsModel;
import com.alacriti.inventory.models.SortAndSearchModel;

public class InventoryItemsAccessDAO {
	
	
		public static final Logger log= Logger.getLogger(InventoryItemsAccessDAO.class);

	
	
	
		
		
		public List<InventoryItemsModel> getAllInventoryItemsDAO(Connection connection){
			
			Statement statement = null;
			ResultSet result = null;
			List<InventoryItemsModel> list=null;
			
			try
			{
				
				
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				
				result = statement.executeQuery("select * from sivaprasadt_inventory_items;");
				
				list=new ArrayList<InventoryItemsModel>();
				
				while (result.next()) {
					list.add(new InventoryItemsModel(result.getInt(1),result.getString(2),result.getInt(3),result.getInt(4),result.getString(5),result.getInt(6),result.getString(7)));
				}
				
			}
			catch(SQLException sqle)
			{
				log.error(" SQL Exception Details ::getAllInventoryItemsDAO"+sqle);
				return list;
				
			}
			catch (Exception e) 
			{
				
				log.error("Exception Details ::getAllInventoryItemsDAO"+e);
				return list;
				
			} 
			return list;
			
		}

		
		
		public void addDataInventoryItemsDAO(Connection connection,InventoryItemsModel p[])
		{
				PreparedStatement preparedStatement=null;
				try
				{
					
				
					
					preparedStatement=connection.prepareStatement("insert into sivaprasadt_inventory_items values(null,?,?,?,null,?,null);");
					
					for(int i=0;i<(p.length);i++)
					{
						preparedStatement.setString(1, p[i].inventoryItemName);
						preparedStatement.setInt(2, p[i].itemQuantity);
						preparedStatement.setInt(3, p[i].purchasedItemQuantity);
						preparedStatement.setInt(4, p[i].consumedItemQuantity);					
						preparedStatement.executeUpdate();
					}
					
				}
				catch(SQLException sqle)
				{
					log.error(" SQL Exception Details ::getAllInventoryItemsDAO"+sqle);					
				}
				catch (Exception e)
				{
					
					log.error("Exception Details ::addDataInventoryItemsDAO"+e);					
					
				}
		}

		
		
		public void updateDataToInventoryItemsDAO(Connection connection,InventoryItemsModel p[])
		{
				PreparedStatement preparedStatement=null;
				try 
				{
					
				
					
					preparedStatement=connection.prepareStatement("update sivaprasadt_inventory_items set itemName=?,quantity=?,purchaseQuantity=?,purchaseDate=?,consumeQuantity=?,consumedate=? where itemId=?;");
					
					for(int i=0;i<(p.length);i++)
					{
						preparedStatement.setString(1, p[i].inventoryItemName);
						preparedStatement.setInt(2, p[i].itemQuantity);
						preparedStatement.setInt(3, p[i].purchasedItemQuantity);
						preparedStatement.setString(4, p[i].itemPurchasedDate);
						preparedStatement.setInt(5, p[i].consumedItemQuantity);	
						preparedStatement.setString(6, p[i].itemConsumedDate);
						preparedStatement.setInt(7, p[i].itemId);					
						preparedStatement.executeUpdate();
					}
					
				} 
				catch(SQLException sqle)
				{
					log.error(" SQL Exception Details ::getAllInventoryItemsDAO"+sqle);					
				}
				catch (Exception e)
				{
					
					log.error("Exception Details ::updateDataToInventoryItemsDAO"+e);
					
					
				} 
		}

		
		
		public void deleteDataFromInventoryItemsDAO(Connection connection,String p)
		{
				
				PreparedStatement preparedStatement=null;
				try 
				{
					
				
					
					preparedStatement=connection.prepareStatement("delete from sivaprasadt_inventory_items where itemName=?;");
					preparedStatement.setString(1, p);
					preparedStatement.executeUpdate();
					
					
				} 
				catch(SQLException sqle)
				{
					log.error(" SQL Exception Details ::getAllInventoryItemsDAO"+sqle);					
				}
				catch (Exception e)
				{
					
					log.error("Exception Details ::deleteDataFromInventoryItemsDAO"+e);
					
				}
		}
		
		
		public List<InventoryItemsModel> getAllInventoryItemsBySortingAndSearchingDAO(Connection connection,SortAndSearchModel o)
		{
			Statement statement = null;
			ResultSet result = null;
			List<InventoryItemsModel> list=null;
			try 
			{				
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				
				result = statement.executeQuery("select * from sivaprasadt_inventory_items where Concat(itemName,quantity,purchaseDate,purchaseQuantity,consumeQuantity,consumedate) like '%"+o.searchText+"%' order by "+o.sortBy+" asc;");
				

				
				list=new ArrayList<InventoryItemsModel>();
				
				while (result.next())
				{
					list.add(new InventoryItemsModel(result.getInt(1),result.getString(2),result.getInt(3),result.getInt(4),result.getString(5),result.getInt(6),result.getString(7)));
				}
				
			}
			catch(SQLException sqle)
			{
				log.error(" SQL Exception Details ::getAllInventoryItemsDAO"+sqle);					
			}
			catch (Exception e)
			{
				
				
				log.error("Exception Details ::getAllInventoryItemsBySortingAndSearchingDAO"+e);
				return list;
				
			} 
			return list;
			
		}
		
		
		
		
		
		public List<InventoryItemsModel> getInventoryItemsBySortingAndSearchingDAO(Connection connection,SortAndSearchModel o)
		{
			
			Statement statement = null;
			ResultSet result = null;
			List<InventoryItemsModel> list=null;
			try 
			{				
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				
				result = statement.executeQuery("select * from sivaprasadt_inventory_items where Concat(itemName,quantity,purchaseDate,purchaseQuantity,consumeQuantity,consumedate) like '%"+o.searchText+"%' order by "+o.sortBy+" asc;");
				

				
				list=new ArrayList<InventoryItemsModel>();
				
				while (result.next())
				{
					list.add(new InventoryItemsModel(result.getInt(1),result.getString(2),result.getInt(3),result.getInt(4),result.getString(5),result.getInt(6),result.getString(7)));
				}
				
			} 
			catch(SQLException sqle)
			{
				log.error(" SQL Exception Details ::getAllInventoryItemsDAO"+sqle);					
			}
			catch (Exception e)
			{
				
				log.error("Exception Details ::getInventoryItemsBySortingAndSearchingDAO"+e);
				return list;
				
			}
			return list;
		} 
		
		
		
		
		
	

}
