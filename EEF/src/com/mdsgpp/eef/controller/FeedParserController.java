/*****************************************************************
 * File: FeedParserController.java 
 * 
 * Purpose: Create News' items or add them to a given Feed object.
 *****************************************************************/

package com.mdsgpp.eef.controller;

import com.mdsgpp.eef.debug.Debug;
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
			Debug.debug(Debug.INFO, "Already exist a FeedParserController Instance");
		}
		
		return instance;
	}

	public Feed getFeed() {
		return this.feed;
	}
	
	// This method clear the feed.
	public void createNewFeed() {
		this.feed.reset();
		Debug.debug(Debug.DEBUG, "Creating a new Feed");
	}
	
	// This method creates a new item based on the feed.
	public void createNewItem() {
		this.newsItem = null;
		this.newsItem = new News(this.feed);
		Debug.debug(Debug.DEBUG, "Building a new item");
	}
	
	// This method add an item on the feed.
	public void addItem() {
		this.feed.addItem(this.newsItem);
		Debug.debug(Debug.DEBUG, "Add an item on feed");
	}
	
	public News getItem() {
		return this.newsItem;
	}	
}