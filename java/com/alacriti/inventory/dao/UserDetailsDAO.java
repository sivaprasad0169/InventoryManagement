package com.alacriti.inventory.dao;	

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.inventory.models.LoginDetailsModel;



public class UserDetailsDAO {
		
	
	public static final Logger log= Logger.getLogger(UserDetailsDAO.class);

		
		

		public int addDataToLoginDetailsDAO(Connection connection,LoginDetailsModel p[])
		{
				int noOfRecordsUpdated=0;			
				PreparedStatement preparedStatement=null;
				try
				{
					
					
					
					preparedStatement=connection.prepareStatement("insert into sivaprasadt_Inventory_loginDetails values(?,?,?,?);");
					int n=0;
					for(int i=0;i<(p.length);i++)
					{
						preparedStatement.setString(1, p[i].userName);
						preparedStatement.setString(2, p[i].password);
						preparedStatement.setString(3, p[i].firstName);
						preparedStatement.setString(4, p[i].lastName);					
						n=preparedStatement.executeUpdate();
						noOfRecordsUpdated +=n;
					}
					
				} 
				catch(SQLException sqle)
				{
					log.error(" SQL Exception Details ::getAllInventoryItemsDAO"+sqle);
					return 0;
					
				}
				catch (Exception e) 
				{
					
					log.error("Ecxeption Details  :addDataToLoginDetailsDAO"+e);
					return 0;
					
					
				} 
				return noOfRecordsUpdated;
		}
		
		
		

		public List<LoginDetailsModel> getAllDataFromLoginDetailsDAO(Connection connection){
			
			
			Statement statement = null;
			ResultSet result = null;
			List<LoginDetailsModel> list=null;
			try 
			{				
				
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				
				result = statement.executeQuery("select * from sivaprasadt_Inventory_loginDetails;");
				
				list=new ArrayList<LoginDetailsModel>();
				
				while (result.next()) 
				{
					list.add(new LoginDetailsModel(result.getString(1),result.getString(2),result.getString(3),result.getString(4)));
				}
				
			} 
			catch(SQLException sqle)
			{
				log.error(" SQL Exception Details ::getAllInventoryItemsDAO"+sqle);
				return list;
				
			}
			catch (Exception e)
			{
				
				
				log.error("Ecxeption Details  :getAllDataFromLoginDetailsDAO"+e);
				
				
			} 
			return list;
			
		}
		
		
		public void updateDataToLoginDetailsDAO(Connection connection,LoginDetailsModel[] p)
		{			
						
				PreparedStatement preparedStatement=null;
				try 
				{					
					preparedStatement=connection.prepareStatement("update sivaprasadt_Inventory_loginDetails set Password=?,FirstName=?,LastName=? where UserName=?;" );
					
					for(int i=0;i<(p.length);i++)
					{
						preparedStatement.setString(1, p[i].password);
						preparedStatement.setString(2, p[i].firstName);
						preparedStatement.setString(3, p[i].lastName);
						preparedStatement.setString(4, p[i].userName);
										
						preparedStatement.executeUpdate();
					}
	
				} 
				catch(SQLException sqle)
				{
					log.error(" SQL Exception Details ::getAllInventoryItemsDAO"+sqle);
					
				}
				catch (Exception e) 
				{
					
					log.error("Ecxeption Details  :updateDataToLoginDetailsDAO"+e);
					
					
				}
		}

		public void deleteDataFromLoginDetailsDAO(Connection connection,String p)
		{
			
				
				
				PreparedStatement preparedStatement=null;
				try 
				{
										
					preparedStatement=connection.prepareStatement("delete from sivaprasadt_Inventory_loginDetails where UserName=?;");
					preparedStatement.setString(1, p);
					preparedStatement.executeUpdate();
					
					
				} 
				catch(SQLException sqle)
				{
					log.error(" SQL Exception Details ::getAllInventoryItemsDAO"+sqle);
					
				}
				catch (Exception e) 
				{
					
					log.error("Ecxeption Details  :deleteDataFromLoginDetailsDAO"+e);
					
					
				} 
				
		}	
}

				
				

				

				
				
				
				
				
				
				
				
				
		




		
		
		
		




