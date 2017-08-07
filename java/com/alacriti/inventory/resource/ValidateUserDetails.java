package com.alacriti.inventory.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alacriti.inventory.deligate.LoginDetailsDeligate;
import com.alacriti.inventory.models.LoginDetailsModel;
import com.alacriti.inventory.models.UserDetailsModel;


@Path("/")
public class ValidateUserDetails {
	
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("Validate")
	public UserDetailsModel validateUser(LoginDetailsModel p)
	{
		return validate(p);
	}
	
	LoginDetailsDeligate access=new LoginDetailsDeligate();
	
	
	
	
	
	 
	public UserDetailsModel validate(LoginDetailsModel p)
	{
		
		UserDetailsModel userDetails=new UserDetailsModel("",false);
		List<LoginDetailsModel> listOfRecords=access.getAllDataFromLoginDetailsTable();
		for(LoginDetailsModel record:listOfRecords)
		{
			if(record.userName.equals(p.userName) && record.password.equals(p.password))
			{	
				
				userDetails=new UserDetailsModel(record.firstName,true);
			}
		}	
		return userDetails;
		
	}
	
	
	
		
}


