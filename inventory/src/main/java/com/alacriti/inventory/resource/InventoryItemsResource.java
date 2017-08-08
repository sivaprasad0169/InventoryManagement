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

import com.alacriti.inventory.deligate.InventoryItemsDeligate;
import com.alacriti.inventory.models.InventoryItemsModel;
import com.alacriti.inventory.models.SortAndSearchModel;


@Path("InventoryItems")
public class InventoryItemsResource {
	
	
	public static final Logger log= Logger.getLogger(LoginDetailsResource.class);
	InventoryItemsDeligate inventoryItemsDeligate=new InventoryItemsDeligate();
	
	
	@GET
	@Path("get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<InventoryItemsModel> getAllInventoryItems()
	{
		log.debug("DEBUG getAllInventoryItems " );
		
		return inventoryItemsDeligate.getAllDataFromInventoryItemsTable();
	}
	
	
	@PUT
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<InventoryItemsModel> updateInventoryItems(InventoryItemsModel p[])
	{
		log.debug("DEBUG updateInventoryItems " );
		
		inventoryItemsDeligate.updateDataToTableInventoryItems(p);
		return inventoryItemsDeligate.getAllDataFromInventoryItemsTable();
	}
	
	
	
	@POST
	@Path("post")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<InventoryItemsModel> addInventoryItems(InventoryItemsModel p[])
	{
		log.debug("DEBUG addInventoryItems " );
		
		inventoryItemsDeligate.addDataToTableInventoryItems(p);
		return inventoryItemsDeligate.getAllDataFromInventoryItemsTable();
	}
	
	
	
	@DELETE
	@Path("delete")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public List<InventoryItemsModel> deleteInventoryItem(String str)
	{
		log.debug("DEBUG deleteInventoryItem " );
		
		inventoryItemsDeligate.deleteDataFromTableInventoryItems(str);
		return inventoryItemsDeligate.getAllDataFromInventoryItemsTable();
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getItemsBySortingAndSearching")
	public List<InventoryItemsModel> getAllDetailsBySeaching(SortAndSearchModel p)
	{
		log.debug("DEBUG getAllDetailsBySeaching " );
		
		return inventoryItemsDeligate.getInventoryItemsBySortingAndSearching(p);
	}
	

}
