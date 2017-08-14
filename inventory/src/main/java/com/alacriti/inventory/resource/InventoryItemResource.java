package com.alacriti.inventory.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.alacriti.inventory.delegate.InventoryItemDelegate;
import com.alacriti.inventory.models.AvailableItemsModel;
import com.alacriti.inventory.models.ItemDetailsModel;


@Path("InventoryItem")
public class InventoryItemResource {
	
	
	public static final Logger log= Logger.getLogger(RegistrationDetailsResource.class);
	InventoryItemDelegate inventoryItemDelegate=new InventoryItemDelegate();
	
	
	
	@POST
	@Path("GetItemDetailsById")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public AvailableItemsModel getItemDetailsById(String itemId)
	{
		log.debug("DEBUG getAllInventoryItems " );
		
		return inventoryItemDelegate.getInventoryItemDetailsById(itemId);
	}
	
	
	
	
	@POST
	@Path("GetItemDetails")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public List<ItemDetailsModel> getItemDetails(String itemId)
	{
		log.debug("DEBUG getAllInventoryItems " );
		
		return inventoryItemDelegate.getInventoryItemDetails(itemId);
	}
	
	@POST
	@Path("GetItemPurchaseDetails")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public List<ItemDetailsModel> getItemPurchaseDetails(String itemId)
	{
		log.debug("DEBUG getAllInventoryItems " );
		
		return inventoryItemDelegate.getInventoryItemPurchaseDetails(itemId);
	}
	
	
	@POST
	@Path("GetItemConsumeDetails")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public List<ItemDetailsModel> getItemConsumeDetails(String itemId)
	{
		log.debug("DEBUG getAllInventoryItems " );
		
		return inventoryItemDelegate.getInventoryItemConsumesDetails(itemId);
	}

}
