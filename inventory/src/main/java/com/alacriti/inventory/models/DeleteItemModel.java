package com.alacriti.inventory.models;

public class DeleteItemModel {
	
	public int itemId;
	public DeleteItemModel() {
		// TODO Auto-generated constructor stub
	}
	public DeleteItemModel(int itemId) {
		super();
		this.itemId = itemId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	

}
