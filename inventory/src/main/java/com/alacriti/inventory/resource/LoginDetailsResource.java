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

import com.alacriti.inventory.deligate.LoginDetailsDeligate;
import com.alacriti.inventory.models.LoginDetailsModel;


@Path("LoginDetails")
public class LoginDetailsResource {
	
	LoginDetailsDeligate loginDetailsDelegate=new LoginDetailsDeligate();
	
	public static final Logger log= Logger.getLogger(LoginDetailsResource.class);
	
	
	@GET
	@Path("get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LoginDetailsModel> getAllUserDetails()
	{
		log.debug("DEBUG getAllInventoryItems " );
		
		return loginDetailsDelegate.getAllDataFromLoginDetailsTable();
	}
	
	@PUT
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<LoginDetailsModel> updateUserDetails(LoginDetailsModel p[])
	{
		log.debug("DEBUG updateUserDetails " );
		
		loginDetailsDelegate.updateDataToTableLoginDetails(p);
		return loginDetailsDelegate.getAllDataFromLoginDetailsTable();
	}
	
	@POST
	@Path("post")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<LoginDetailsModel> postUserDetails(LoginDetailsModel p[])
	{
		log.debug("DEBUG postUserDetails " );
		
		loginDetailsDelegate.addDataToTableLoginDetails(p);
		return loginDetailsDelegate.getAllDataFromLoginDetailsTable();
	}
	
	@DELETE
	@Path("delete")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public List<LoginDetailsModel> deleteUserDetails(String str)
	{
		log.debug("DEBUG deleteUserDetails " );
		
		loginDetailsDelegate.deleteDataFromTableLoginDetails(str);
		return loginDetailsDelegate.getAllDataFromLoginDetailsTable();
	}
	
	
	@POST
	@Path("PostRegDetails")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public int PostRegDetails(LoginDetailsModel p[])
	{
		log.debug("DEBUG postUserDetails " );
		
		return loginDetailsDelegate.addDataToTableLoginDetails(p);
	}
	

}
