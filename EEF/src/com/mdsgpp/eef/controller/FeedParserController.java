package com.mdsgpp.eef.controller;

import com.mdsgpp.eef.model.Feed;
import com.mdsgpp.eef.model.News;

public class FeedParserController {

	private Feed feed;
	private News item;
	private static FeedParserController instance;
	
	public FeedParserController() {
		this.feed = new Feed();
	}
	
	public static FeedParserController getInstance() {
		if(instance == null) {
			instance = new FeedParserController();
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
		this.item = new News(this.feed);
	}
	
	// This method add an item on the feed.
	public void addItem() {
		this.feed.addItem(this.item);
	}
	
	public News getItem() {
		return this.item;
	}	
}