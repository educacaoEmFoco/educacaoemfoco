/************************************************************
 * File: News.java
 *
 * Purpose: Create a news about any state to update the feed.
 ************************************************************/

package com.mdsgpp.eef.model;

import java.io.Serializable;

public class News implements Serializable {

	private static final long serialVersionUID = 1L;
	private String title;
	private String category;
	private String description;
	private String link;
	private String date; 
	private Feed feed;
	
	public News(Feed feed) {
		this.feed = feed;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public Feed getFeed() {
		return this.feed;
	}	
}