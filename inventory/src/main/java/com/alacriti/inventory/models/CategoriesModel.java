package com.alacriti.inventory.models;

public class CategoriesModel {
	
	public int categoryId;
	public String categoryName;
	
	
	public CategoriesModel()
	{
		
	}


	public CategoriesModel(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	
}
