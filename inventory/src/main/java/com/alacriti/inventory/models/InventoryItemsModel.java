package com.alacriti.inventory.models;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class InventoryItemsModel {
	
	public int itemId,itemQuantity,purchasedItemQuantity,consumedItemQuantity;
	public String inventoryItemName,itemPurchasedDate,itemConsumedDate;
	
	
	public InventoryItemsModel()
	{
		
	};
	
	public InventoryItemsModel(int itemId,String inventoryItemName, int itemQuantity,
			int purchasedItemQuantity, String itemPurchasedDate, int consumedItemQuantity,String itemConsumedDate) 
	{
		this.itemId = itemId;
		this.itemQuantity = itemQuantity;
		this.purchasedItemQuantity = purchasedItemQuantity;
		this.consumedItemQuantity = consumedItemQuantity;
		this.inventoryItemName = inventoryItemName;
		this.itemPurchasedDate = itemPurchasedDate;
		this.itemConsumedDate = itemConsumedDate;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public int getPurchasedItemQuantity() {
		return purchasedItemQuantity;
	}

	public void setPurchasedItemQuantity(int purchasedItemQuantity) {
		this.purchasedItemQuantity = purchasedItemQuantity;
	}

	public int getConsumedItemQuantity() {
		return consumedItemQuantity;
	}

	public void setConsumedItemQuantity(int consumedItemQuantity) {
		this.consumedItemQuantity = consumedItemQuantity;
	}

	public String getInventoryItemName() {
		return inventoryItemName;
	}

	public void setInventoryItemName(String inventoryItemName) {
		this.inventoryItemName = inventoryItemName;
	}

	public String getItemPurchasedDate() {
		return itemPurchasedDate;
	}

	public void setItemPurchasedDate(String itemPurchasedDate) {
		this.itemPurchasedDate = itemPurchasedDate;
	}

	public String getItemConsumedDate() {
		return itemConsumedDate;
	}

	public void setItemConsumedDate(String itemConsumedDate) {
		this.itemConsumedDate = itemConsumedDate;
	}
	
	
	
	

}
