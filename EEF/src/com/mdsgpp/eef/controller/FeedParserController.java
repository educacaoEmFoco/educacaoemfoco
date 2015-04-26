package com.mdsgpp.eef.controller;

import com.mdsgpp.eef.model.Feed;
import com.mdsgpp.eef.model.News;

public class FeedParserController {

	private Feed feed;
	private News newsItem;
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
	public void createNewFeed() {
		this.feed.reset();
	}
	
	// This method creates a new item based on the feed.
	public void createNewItem() {
		this.newsItem = null;
		this.newsItem = new News(this.feed);
	}
	
	// This method add an item on the feed.
	public void addItem() {
		this.feed.addItem(this.newsItem);
	}
	
	public News getItem() {
		return this.newsItem;
	}	
}