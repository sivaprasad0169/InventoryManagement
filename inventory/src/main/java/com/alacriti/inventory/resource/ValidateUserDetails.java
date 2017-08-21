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

import org.apache.log4j.Logger;

import com.alacriti.inventory.delegate.ValidateUserDetailsDelegate;
import com.alacriti.inventory.models.LoginDetailsModel;
import com.alacriti.inventory.models.ValidationModel;
import com.alacriti.inventory.session.SessionUtility;


@Path("/")
public class ValidateUserDetails {
	
	ValidateUserDetailsDelegate userDetailsDelegate=new ValidateUserDetailsDelegate();
	
	public static final Logger log= Logger.getLogger(ValidateUserDetails.class);
	
	
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
			log.debug("Session Created... "+session);
					
		}
		return validationModel;
	}
	
	
	
	@GET
	@Path("CheckSession")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean checkSession(@Context HttpServletRequest request)
	{
		log.debug("Checking For Session... ");
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
		log.debug("Session Removed..and Checking for Session");
		SessionUtility sessionUtility=new SessionUtility();
		return sessionUtility.checkForSession(request);
	}
	
	
	@POST
	@Path("CheckUserName")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public boolean checkAvailabilityOfUserName(String userName)
	{
		log.debug("Chicking For UserName Availability..");
		return userDetailsDelegate.checkAvailabilityOfUserName(userName);
	}

	
	@POST
	@Path("checkItemName")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public boolean checkItemNameAvaialability(String itemName)
	{
		log.debug("Chicking For ItemName Availability..");
		return userDetailsDelegate.checkAvailabilityOfItemName(itemName);
	}
	
	
	
	
	 
	
	
	
		
}


