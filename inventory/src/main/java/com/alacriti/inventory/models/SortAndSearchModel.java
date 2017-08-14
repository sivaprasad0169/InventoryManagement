package com.alacriti.inventory.models;

public class SortAndSearchModel {
	
	public String sortBy,searchText;
	public int categoryId;
	public SortAndSearchModel() {
		
	}
	
	public SortAndSearchModel(String sortBy, String searchText,int categoryId) {
		super();
		this.sortBy = sortBy;
		this.searchText = searchText;
		this.categoryId=categoryId;
	}

	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
}
