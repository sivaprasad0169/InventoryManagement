package com.alacriti.inventory.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import session.SessionUtility;

import com.alacriti.inventory.delegate.ValidateUserDetailsDelegate;
import com.alacriti.inventory.models.LoginDetailsModel;
import com.alacriti.inventory.models.ValidationModel;


@Path("/")
public class ValidateUserDetails {
	
	ValidateUserDetailsDelegate userDetailsDelegate=new ValidateUserDetailsDelegate();
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("Validate")
	public ValidationModel validateUser(LoginDetailsModel p,@Context HttpServletRequest request)
	{
		ValidationModel validationModel=new ValidationModel();
		validationModel= userDetailsDelegate.ValidateUserDetails(p);
		if(validationModel.isValid)
		{
			HttpSession session=request.getSession();
					
		}
		return validationModel;
	}
	
	
	
	@GET
	@Path("CheckSession")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean checkSession(@Context HttpServletRequest request)
	{
		System.out.println("Method");
		SessionUtility sessionUtility=new SessionUtility();
		return sessionUtility.checkForSession(request);
	}
	
	
	@GET
	@Path("removeSession")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean removeSession(@Context HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		session.invalidate();
		SessionUtility sessionUtility=new SessionUtility();
		return sessionUtility.checkForSession(request);
	}
	
	
	
	
	
	
	 
	
	
	
		
}


