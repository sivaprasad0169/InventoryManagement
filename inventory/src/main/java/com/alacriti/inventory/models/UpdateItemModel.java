package com.alacriti.inventory.models;

public class UpdateItemModel {
	
	
	public int itemId,itemUpdatedQuantity,consumedQuantity,purchasedQuantity;
	public String updatedItemName,updatedBy;
	public UpdateItemModel()
	{
		
	}
	public UpdateItemModel(int itemId,String updatedItemName, int itemUpdatedQuantity,
			 int purchasedQuantity,int consumedQuantity,
			 String updatedBy) {
		super();
		this.itemId = itemId;
		this.itemUpdatedQuantity = itemUpdatedQuantity;
		this.consumedQuantity = consumedQuantity;
		this.purchasedQuantity = purchasedQuantity;
		this.updatedItemName = updatedItemName;
		this.updatedBy = updatedBy;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getItemUpdatedQuantity() {
		return itemUpdatedQuantity;
	}
	public void setItemUpdatedQuantity(int itemUpdatedQuantity) {
		this.itemUpdatedQuantity = itemUpdatedQuantity;
	}
	public int getConsumedQuantity() {
		return consumedQuantity;
	}
	public void setConsumedQuantity(int consumedQuantity) {
		this.consumedQuantity = consumedQuantity;
	}
	public int getPurchasedQuantity() {
		return purchasedQuantity;
	}
	public void setPurchasedQuantity(int purchasedQuantity) {
		this.purchasedQuantity = purchasedQuantity;
	}
	public String getUpdatedItemName() {
		return updatedItemName;
	}
	public void setUpdatedItemName(String updatedItemName) {
		this.updatedItemName = updatedItemName;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	

}
