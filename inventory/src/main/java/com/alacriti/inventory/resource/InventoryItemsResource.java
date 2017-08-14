package com.alacriti.inventory.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.alacriti.inventory.delegate.InventoryItemsDelegate;
import com.alacriti.inventory.models.AvailableItemsModel;
import com.alacriti.inventory.models.CreateItemModel;
import com.alacriti.inventory.models.DeleteItemModel;
import com.alacriti.inventory.models.SortAndSearchModel;
import com.alacriti.inventory.models.UpdateItemModel;


@Path("InventoryItems")
public class InventoryItemsResource {
	
	
	public static final Logger log= Logger.getLogger(InventoryItemsResource.class);
	InventoryItemsDelegate inventoryItemsDelegate=new InventoryItemsDelegate();
	
	
	@GET
	@Path("get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AvailableItemsModel> getAllItems()
	{
		return inventoryItemsDelegate.getAllInventoryItems();
	}
	
	
	@POST
	@Path("getItemsBySortingAndSearching")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<AvailableItemsModel> getAllItemsBySortAndSearch(SortAndSearchModel p)
	{
		return inventoryItemsDelegate.getAllInventoryItemsBySortAndSearch(p);
	}
	
	@PUT
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public int updateItemsInDetails(UpdateItemModel p[])
	{
		log.debug("DEBUG updateInventoryItems " );
		return inventoryItemsDelegate.updateItemsInDetails(p);
		
		
	}
	
	
	
	@POST
	@Path("post")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public int addItemsToDetails(CreateItemModel p[])
	{
		log.debug("DEBUG addInventoryItems " );
		return inventoryItemsDelegate.addItemsToDetailsDelegate(p);
		
		
	}
	
	
	
	@POST
	@Path("delete")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteInventoryItem(DeleteItemModel d)
	{
		log.debug("DEBUG deleteInventoryItem " );
		
		return inventoryItemsDelegate.deleteItemsInDetails(d);
		
	}
	

}
