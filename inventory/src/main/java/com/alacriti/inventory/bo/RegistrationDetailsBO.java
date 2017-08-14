package com.alacriti.inventory.bo;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.inventory.dao.RegistrationDetailsDAO;
import com.alacriti.inventory.exceptions.BOException;
import com.alacriti.inventory.exceptions.DAOException;
import com.alacriti.inventory.models.RegistrationDetailsModel;


public class RegistrationDetailsBO {
	
	
	public static final Logger log= Logger.getLogger(RegistrationDetailsBO.class);
	RegistrationDetailsDAO userDAO=null;
	
	
	
	public List<RegistrationDetailsModel> getAllRegistrationDetails(Connection connection) throws BOException
	{
		
		List<RegistrationDetailsModel> list=null;
		try
		{
			userDAO=new RegistrationDetailsDAO();
			list=userDAO.getAllRegistrationDetails(connection);
			
		}
		catch(DAOException daoe)
		{
			log.error("Exception details :getAllRegistrationDetails :"+daoe);
			throw new BOException();
			
		}
		catch(Exception e)
		{
			
			log.error("Exception details :getAllRegistrationDetails :"+e);
			throw new BOException("Exception Occured In BO");
			
		}
		return list;
	}
	
	
	public int addRegistrationDetails(Connection connection,RegistrationDetailsModel p[]) throws BOException
	{	
		
		int noOfRecordsUpdated=0;
		try
		{
			
			userDAO=new RegistrationDetailsDAO();
			noOfRecordsUpdated +=userDAO.addRegistraionDetails(connection, p);
			
			
		}
		catch(DAOException daoe)
		{
			log.error("Exception details :addRegistrationDetails :"+daoe);
			throw new BOException();
			
		}
		catch(Exception e)
		{
			
			log.error("Exception details :addRegistrationDetails :"+e);
			throw new BOException("Exception Occured In BO");
			
		}
		return noOfRecordsUpdated;
	
	}
	
	
	public int updateRegistrationDetails(Connection connection,RegistrationDetailsModel[] p) throws BOException
	{
		int noOfRecordsUpdated=0;
		try
		{
			
			userDAO=new RegistrationDetailsDAO();
			noOfRecordsUpdated +=userDAO.updateRegistrationDetails(connection, p);
			
			
		}
		catch(DAOException daoe)
		{
			log.error("Exception details :updateRegistrationDetails :"+daoe);
			throw new BOException();
			
		}
		catch(Exception e)
		{
			
			log.error("Exception details :updateRegistrationDetails :"+e);
			throw new BOException("Exception Occured In BO");
			
		}
		return noOfRecordsUpdated;
	}
	
	
	public int removeRegistrationDetails(Connection connection,String p) throws BOException
	{
		int noOfRecordsEffected=0;
		try
		{
			
			userDAO=new RegistrationDetailsDAO();
			noOfRecordsEffected +=userDAO.removeRegistrationDetails(connection, p);
			
			
		}
		catch(DAOException daoe)
		{
			log.error("Exception details :removeRegistrationDetails :"+daoe);
			throw new BOException();
			
		}
		catch(Exception e)
		{
			
			log.error("Exception details :deleteDataFromLoginDetailsBO :"+e);
			throw new BOException("Exception Occured In BO");
			
		}
		return noOfRecordsEffected;
	}
	
	

}
