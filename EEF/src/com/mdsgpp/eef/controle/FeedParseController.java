package com.mdsgpp.eef.controle;

import com.mdsgpp.eef.modelo.Feed;
import com.mdsgpp.eef.modelo.Noticias;

public class FeedParseController {

	private Feed feed;
	private Noticias item;
	private static FeedParseController instance;
	
	public FeedParseController() {
		this.feed = new Feed();
	}
	
	public static FeedParseController getInstance() {
		if(instance == null) {
			instance = new FeedParseController();
		}
		else {
			// Nothing to do.
		}
		
		return instance;
	}

	public Feed getFeed() {
		return this.feed;
	}
	
	// This method clear the feed.
	public void creatNewFeed() {
		this.feed.reset();
	}
	
	// This method creates a new item based on the feed.
	public void createNewItem() {
		this.item = new Noticias(this.feed);
	}
	
	// This method add an item on the feed.
	public void addItem() {
		this.feed.addItem(this.item);
	}
	
	public Noticias getItem() {
		return this.item;
	}	
}