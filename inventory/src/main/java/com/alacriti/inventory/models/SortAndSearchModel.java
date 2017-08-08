package com.alacriti.inventory.models;

public class SortAndSearchModel {
	
	public String sortBy,searchText;
	public SortAndSearchModel() {
		
	}
	
	public SortAndSearchModel(String sortBy, String searchText) {
		super();
		this.sortBy = sortBy;
		this.searchText = searchText;
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
