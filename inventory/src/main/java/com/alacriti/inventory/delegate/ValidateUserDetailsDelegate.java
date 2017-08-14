package com.alacriti.inventory.delegate;

import java.util.List;

import com.alacriti.inventory.models.LoginDetailsModel;
import com.alacriti.inventory.models.RegistrationDetailsModel;
import com.alacriti.inventory.models.ValidationModel;

public class ValidateUserDetailsDelegate {
	
	
	RegistrationDetailsDelegate access=new RegistrationDetailsDelegate();
	
	public ValidationModel ValidateUserDetails(LoginDetailsModel p)
	{
		
		ValidationModel userDetails=new ValidationModel("ASD",false);
		
		List<RegistrationDetailsModel> listOfRecords=access.getAllRegistrationDetails();
		
		for(RegistrationDetailsModel record:listOfRecords)
		{
			
			if(record.userName.equals(p.userName) && record.password.equals(p.password))
			{	
				
				userDetails=new ValidationModel(record.firstName,true);
			}
			
		}
		
		return userDetails;
		
	}
	
	
	
	

}
