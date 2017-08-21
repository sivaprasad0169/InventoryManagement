package com.alacriti.inventory.delegate;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.inventory.bo.CategoryBO;
import com.alacriti.inventory.db.DBUtil;
import com.alacriti.inventory.models.CategoriesModel;

public class CategoryDelegate {
	
	
	public static final Logger log= Logger.getLogger(CategoryDelegate.class);
	CategoryBO categoryBO=null;
	
	public List<CategoriesModel> getAllCategories()
	{
			List<CategoriesModel> list=null;
			Connection connection=DBUtil.getConnection();
			boolean isError=false;
			
			try
			{
				categoryBO=new CategoryBO();
				list=categoryBO.getAllCategories(connection);
				
				
			} 
			catch (Exception e)
			{
				
				log.error("Exception Details : getAllCategories "+e);
				isError=true;
								
			} 
			finally 
			{
				
				DBUtil.closeConnection(connection,isError);
				
			}
			return list;
	}

	public CategoriesModel getCategoryId(String categoryName)
	{		
			CategoriesModel model=null;
			Connection connection=DBUtil.getConnection();
			boolean isError=false;
			
			try
			{
				categoryBO=new CategoryBO();
				model=categoryBO.getCategoryId(connection, categoryName);
				
				
			} 
			catch (Exception e)
			{
				
				log.error("Exception Details : getCategoryId "+e);
				isError=true;
				
				
			} 
			finally 
			{
				
				DBUtil.closeConnection(connection,isError);
			}
			return model;
	}
	
	public int addCategory(String categoryName)
	{		int noOfRecordsEffected=0;
			Connection connection=DBUtil.getConnection();
			boolean isError=false;
			
			try
			{
				categoryBO=new CategoryBO();
				noOfRecordsEffected=categoryBO.addCategoryName(connection, categoryName);
				
				
			} 
			catch (Exception e)
			{
				
				log.error("Exception Details : addCategory "+e);
				isError=true;
				
				
			} 
			finally 
			{
				
				DBUtil.closeConnection(connection,isError);
				
			}
			return noOfRecordsEffected;
	}



}
