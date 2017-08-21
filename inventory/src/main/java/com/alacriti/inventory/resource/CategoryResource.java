package com.alacriti.inventory.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.alacriti.inventory.delegate.CategoryDelegate;
import com.alacriti.inventory.models.CategoriesModel;


@Path("Categories")
public class CategoryResource {
	
	public static final Logger log= Logger.getLogger(CategoryResource.class);
	CategoryDelegate categoryDelegate=new CategoryDelegate();
	
	
	@GET
	@Path("get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CategoriesModel> getAllCategories()
	{
		log.debug("Getting All Categories");
		return categoryDelegate.getAllCategories();
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("getCategoryId")
	@Produces(MediaType.APPLICATION_JSON)
	public CategoriesModel getACategoryId(String categoryName)
	{
		log.debug("Getting Category by Id ");
		return categoryDelegate.getCategoryId(categoryName);
		
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("addCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CategoriesModel> addCategory(String categoryName)
	{
		log.debug("Adding a Category ");
		categoryDelegate.addCategory(categoryName);
		return categoryDelegate.getAllCategories();
		
	}
		

}
