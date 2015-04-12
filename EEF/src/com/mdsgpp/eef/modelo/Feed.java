package com.mdsgpp.eef.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Feed implements Serializable {

	// Default serial id
	private static final long serialVersionUID = 1L;
	
	private ArrayList<News> items;

	public Feed() {
		items = new ArrayList<News>();
	}

	public ArrayList<News> getItems() {
		return items;
	}
	
	public News getItem(int position) {
		return items.get(position);
	}

	public void setItems(ArrayList<News> items) {
		this.items = items;
	}
	
	// This method adds a report in the array "items".
	public void addItem(News newItem) {
		this.items.add(newItem);
	}
	
	// This method returns the size of the array "items".
	public int getItemsSize() {
		return items.size();
	}
	
	// This method clears the array "items"
	public void reset() {
		this.items.clear();
	}	
}