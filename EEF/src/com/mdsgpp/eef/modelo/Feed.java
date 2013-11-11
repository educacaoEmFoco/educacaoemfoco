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
	
	public void addItem(Noticias newItem) {
		this.items.add(newItem);
	}
	
	public int getItemsSize() {
		return items.size();
	}
	
	public void reset() {
		this.items.clear();
	}
	
}
