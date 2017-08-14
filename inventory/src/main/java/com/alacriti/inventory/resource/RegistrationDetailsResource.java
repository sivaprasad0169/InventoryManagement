package com.alacriti.inventory.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.alacriti.inventory.delegate.RegistrationDetailsDelegate;
import com.alacriti.inventory.models.RegistrationDetailsModel;


@Path("LoginDetails")
public class RegistrationDetailsResource {
	
	RegistrationDetailsDelegate loginDetailsDelegate=new RegistrationDetailsDelegate();
	
	public static final Logger log= Logger.getLogger(RegistrationDetailsResource.class);
	
	
	@GET
	@Path("get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RegistrationDetailsModel> getAllUserDetails()
	{
		log.debug("DEBUG getAllInventoryItems " );
		
		return loginDetailsDelegate.getAllRegistrationDetails();
	}
	
	@PUT
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<RegistrationDetailsModel> updateUserDetails(RegistrationDetailsModel p[])
	{
		log.debug("DEBUG updateUserDetails " );
		
		loginDetailsDelegate.updateDataToTableLoginDetails(p);
		return loginDetailsDelegate.getAllRegistrationDetails();
	}
	
	@POST
	@Path("post")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public int postUserDetails(RegistrationDetailsModel p[])
	{
		log.debug("DEBUG postUserDetails " );
		
		return loginDetailsDelegate.addRegistrationDetails(p);
	
	}
	
	@DELETE
	@Path("delete")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public List<RegistrationDetailsModel> deleteUserDetails(String str)
	{
		log.debug("DEBUG deleteUserDetails " );
		
		loginDetailsDelegate.deleteDataFromTableLoginDetails(str);
		return loginDetailsDelegate.getAllRegistrationDetails();
	}
	
	
	@POST
	@Path("PostRegDetails")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public int PostRegDetails(RegistrationDetailsModel p[])
	{
		log.debug("DEBUG postUserDetails " );
		
		return loginDetailsDelegate.addRegistrationDetails(p);
	}
	

}
