package com.alacriti.inventory.models;

public class CreateItemModel {
	
	public String itemName,updatedBy;
	public int itemQuantity,categoryId;
	public CreateItemModel()
	{
		
	}
	public CreateItemModel(String itemName, int itemQuantity,String updatedBy,int categoryId) {
		super();
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.updatedBy=updatedBy;
		this.categoryId=categoryId;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	

}
