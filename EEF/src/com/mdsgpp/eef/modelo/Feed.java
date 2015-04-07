package com.mdsgpp.eef.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Feed implements Serializable {

	// Default serial id
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Noticias> items;

	public Feed() {
		items = new ArrayList<Noticias>();
	}

	public ArrayList<Noticias> getItems() {
		return items;
	}
	
	public Noticias getItem(int position) {
		return items.get(position);
	}

	public void setItems(ArrayList<Noticias> items) {
		this.items = items;
	}
	
	// This method adds a report in the array "items".
	public void addItem(Noticias newItem) {
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