package com.alacriti.inventory.delegate;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.alacriti.inventory.bo.InventoryItemsBO;
import com.alacriti.inventory.bo.RegistrationDetailsBO;
import com.alacriti.inventory.db.DBUtil;
import com.alacriti.inventory.models.AvailableItemsModel;
import com.alacriti.inventory.models.LoginDetailsModel;
import com.alacriti.inventory.models.RegistrationDetailsModel;
import com.alacriti.inventory.models.ValidationModel;

public class ValidateUserDetailsDelegate {
	
	
	public static final Logger log= Logger.getLogger(ValidateUserDetailsDelegate.class);
	
	RegistrationDetailsBO registrationDetailsBO=new RegistrationDetailsBO();
	
	InventoryItemsBO inventoryItemsBO=new InventoryItemsBO();
	
	
	
	
	public ValidationModel ValidateUserDetails(LoginDetailsModel p)
	{
		
		ValidationModel userDetails=new ValidationModel("",false);
		Connection connection=DBUtil.getConnection();
		try
		{
			List<RegistrationDetailsModel> listOfRecords=registrationDetailsBO.getAllRegistrationDetails(connection);
			
			for(RegistrationDetailsModel record:listOfRecords)
			{
				
				if(record.userName.equals(p.userName) && record.password.equals(p.password))
				{	
					
					userDetails=new ValidationModel(record.firstName,true);
					log.debug("User Details Authenticated  : User First Name "+record.firstName);
					
				}
				
			}
		}
		catch(Exception e)
		{
			log.error("Exception Occured while checking Authentication "+ e);
		}
		finally
		{
			DBUtil.closeConnection(connection);
		}
		return userDetails;
		
	}
	
	
	
	
	public boolean checkAvailabilityOfUserName(String userName)
	{
		
		boolean isExist=false;		
		Connection connection=DBUtil.getConnection();
		try{
			List<RegistrationDetailsModel> listOfRecords=registrationDetailsBO.getAllRegistrationDetails(connection);
		
			for(RegistrationDetailsModel record:listOfRecords)
			{
				
				if(record.userName.equals(userName) && userName!=null)
				{	
					
					isExist=true;
					log.debug(userName+"   UserName Already exist");
				}
				
			}
		}
		catch(Exception e)
		{
			log.error("Exception Occured while checking User Name Availability "+ e);
		}
		finally
		{
			DBUtil.closeConnection(connection);
		}
		return isExist;
		
	}
	
	
	public boolean checkAvailabilityOfItemName(String itemName)
	{
		
		boolean isExist=false;
		Connection connection=DBUtil.getConnection();
		try{
			
		List<AvailableItemsModel> listOfRecords=inventoryItemsBO.
				getAllInventoryItemsFromDetails(connection);
		
		log.debug(""+listOfRecords);
		
		for(AvailableItemsModel record:listOfRecords)
		{
			if(record.itemName.equals(itemName) && itemName!=null)
			{	
				
				isExist=true;
				log.debug(itemName+"    Already exist");
			}
			
		}
		}
		catch(Exception e)
		{
			
			log.error("Exception occured while checking ItemName Existance");
			
		}
		finally
		{
			DBUtil.closeConnection(connection);
		}
		return isExist;
		
	}
	
	

}
