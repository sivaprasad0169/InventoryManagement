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
import com.alacriti.inventory.models.CategoriesModel;

public class CategoryDAO 
{
	
public static final Logger log= Logger.getLogger(CategoryDAO.class);
public List<CategoriesModel> list;

	
	public List<CategoriesModel> getAllCategories(Connection connection)  throws DAOException
	{
		Statement statement = null;
		ResultSet result = null;
		List<CategoriesModel> list=null;
		try
		{
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
													ResultSet.CONCUR_UPDATABLE);
			
			result = statement.executeQuery("select * from sivaprasad_inventory_CategoryInfo;");
			
			list=new ArrayList<CategoriesModel>();
			
			while(result.next())
			{
				
				list.add(new CategoriesModel(result.getInt(1),result.getString(2)));
				
			}
			
		}
		catch(SQLException e)
		{
			
			log.error("Exception Details: getAllCategories :"+e);
			throw new DAOException("Exception occured In DAO");
			
			
		}
		catch(Exception e)
		{
			log.error("Exception Detials: getAllCategories  "+e);
			throw new DAOException("Exception Occured In DAO");
		}
		return list;
	}
	
	public CategoriesModel getCategoryId(Connection connection,String categoryName) throws DAOException
	{
		Statement statement = null;
		ResultSet result = null;
		CategoriesModel model=null;
		try
		{
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
													ResultSet.CONCUR_UPDATABLE);
			String query="select Category_Id from"
					+ " sivaprasad_inventory_CategoryInfo where Category_Name='"+categoryName+"';";
			
			result = statement.executeQuery(query);
			
			while(result.next())
			{	
				
				model=new CategoriesModel(result.getInt(1),categoryName);		
			}
		}
		catch(SQLException e)
		{
			
			log.error("Exception Details: getCategoryId :"+e);
			throw new DAOException("Exception occured In DAO");
			
			
		}
		catch(Exception e)
		{
			
			log.error("Exception Detials: getCategoryId  "+e);
			throw new DAOException("Exception Occured In DAO");
			
		}
		return model;
		
	}
	
	
	
	public int addCategory(Connection connection,String categoryName) throws DAOException
	{
		int noOfRecordsEffected=0;
		PreparedStatement preparedStatement = null;
		try
		{
			String query="insert into sivaprasad_inventory_CategoryInfo values(null,?);";
			preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setString(1, categoryName);
			noOfRecordsEffected=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			
			log.error("Exception Details: addCategory :"+e);
			throw new DAOException("Exception occured In DAO");
			
		}
		catch(Exception e)
		{
			
			log.error("Exception Detials: addCategory  "+e);
			throw new DAOException("Exception Occured In DAO");
			
		}
		
		return noOfRecordsEffected;
	}
	
	
	

}
