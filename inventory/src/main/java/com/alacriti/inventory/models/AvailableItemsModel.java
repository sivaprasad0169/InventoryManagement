package com.alacriti.inventory.models;

public class AvailableItemsModel {
	
	
	public int itemId,availableQuantity;
	public String itemName;
	public AvailableItemsModel() {
	}
	public AvailableItemsModel(int itemId, int availableQuantity,
			String itemName) {
		super();
		this.itemId = itemId;
		this.availableQuantity = availableQuantity;
		this.itemName = itemName;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	

}
