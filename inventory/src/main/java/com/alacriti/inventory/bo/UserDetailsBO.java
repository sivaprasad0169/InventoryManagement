package com.alacriti.inventory.bo;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.inventory.dao.UserDetailsDAO;
import com.alacriti.inventory.models.LoginDetailsModel;


public class UserDetailsBO {
	
	
	public static final Logger log= Logger.getLogger(UserDetailsBO.class);
	UserDetailsDAO userDAO=null;
	
	public List<LoginDetailsModel> getAllDataFromLoginDetailsBO(Connection connection)
	{
		List<LoginDetailsModel> list=null;
		try
		{
			userDAO=new UserDetailsDAO();
			list=userDAO.getAllDataFromLoginDetailsDAO(connection);
		}
		catch(Exception e)
		{
			log.error("Exception details :getAllDataFromLoginDetailsBO :"+e);
			
		}
		return list;
	}
	
	
	public int addDataToLoginDetailsBO(Connection connection,LoginDetailsModel p[])
	{	
		int noOfRecordsUpdated=0;
		try
		{
			userDAO=new UserDetailsDAO();
			noOfRecordsUpdated=userDAO.addDataToLoginDetailsDAO(connection, p);
			
		}
		catch(Exception e)
		{
			log.error("Exception details :addDataToLoginDetailsBO :"+e);
			return 0;
		}
		return noOfRecordsUpdated;
	
	}
	
	
	public void updateDataToLoginDetailsBO(Connection connection,LoginDetailsModel[] p)
	{
		try
		{
			userDAO=new UserDetailsDAO();
			userDAO.updateDataToLoginDetailsDAO(connection, p);
			
		}
		catch(Exception e)
		{
			log.error("Exception details :updateDataToLoginDetailsBO :"+e);
		}
	
	}
	
	
	public void deleteDataFromLoginDetailsBO(Connection connection,String p)
	{
		try
		{
			userDAO=new UserDetailsDAO();
			userDAO.deleteDataFromLoginDetailsDAO(connection, p);
			
		}catch(Exception e)
		{
			log.error("Exception details :deleteDataFromLoginDetailsBO :"+e);
		}
	
	}
	
	

}
