package com.alacriti.inventory.bo;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.inventory.dao.CategoryDAO;
import com.alacriti.inventory.exceptions.BOException;
import com.alacriti.inventory.exceptions.DAOException;
import com.alacriti.inventory.models.CategoriesModel;

public class CategoryBO {
	
	
	
	public static final Logger log= Logger.getLogger(CategoryBO.class);
	
	CategoryDAO categoryDAO=null;
	
	
	
	
	public List<CategoriesModel> getAllCategories(Connection connection) throws BOException
	{
		
		
		List<CategoriesModel> list=null;
		
		try
		{
			
			categoryDAO=new CategoryDAO();
			list=categoryDAO.getAllCategories(connection);
			
		}
		catch(DAOException daoe)
		{
			
			log.error("Exception Detials: getAllCategories  "+daoe);
			throw new BOException();
			
		}
		catch(Exception e)
		{
			
			log.error("Exception Detials: getAllCategories  "+e);
			throw new BOException("Exception Occured In BO");
			
		}
		
		return list;
		
		
	}
	
	
	
	
	public CategoriesModel getCategoryId(Connection connection,String categoryName) throws BOException
	{
		
		CategoriesModel model=null;
		try
		{
			
			categoryDAO=new CategoryDAO();
			model=categoryDAO.getCategoryId(connection, categoryName);
			
		}
		catch(DAOException daoe)
		{
			
			log.error("Exception Detials: getCategoryId  "+daoe);
			throw new BOException();
			
		}
		catch(Exception e)
		{
			
			log.error("Exception Detials: getCategoryId  "+e);
			throw new BOException("Exception Occured In BO");
			
		}
		return model;
		
	}
	
	
	
	
	public int addCategoryName(Connection connection,String categoryName) throws BOException
	{
		
		int noOfRecordsEffected=0;
		try
		{
			
			categoryDAO=new CategoryDAO();
			noOfRecordsEffected=categoryDAO.addCategory(connection, categoryName);
			
		}
		catch(DAOException daoe)
		{
			
			log.error("Exception Detials: addCategoryName  "+daoe);
			throw new BOException();
			
		}
		catch(Exception e)
		{
			
			log.error("Exception Detials: addCategoryName  "+e);
			throw new BOException("Exception Occured In BO");
			
		}
		return noOfRecordsEffected;
		
	}

}
