package com.mdsgpp.eef.tests;

import android.test.AndroidTestCase;

import com.mdsgpp.eef.model.Feed;
import com.mdsgpp.eef.model.News;

public class NewsTest extends AndroidTestCase {

	private String title;
	private String category;
	private String description;
	private String link;
	private String date; 
	private Feed feed;
	private News noticias;
	
	public void setUp(){
		feed = new Feed();
		noticias = new News(feed);
		category = "categoria";
		title = "title";
		description = "description";
		link = "link";
		date = "date";
	}
	
	public void testTitle() {
		noticias.setTitle(title);
		assertEquals(title,noticias.getTitle());
	}
	
	public void testCategory() {
		noticias.setCategory(category);
		assertEquals(category,noticias.getCategory());
	}
	
	public void testDescription() {
		noticias.setDescription(description);
		assertEquals(description,noticias.getDescription());
	}
	
	public void testLink() {
		noticias.setLink(link);
		assertEquals(link,noticias.getLink());
	}
	
	public void testDate() {
		noticias.setDate(date);
		assertEquals(date,noticias.getDate());
	}
	
	public void testGetFeed() {
		assertEquals(feed,noticias.getFeed());
	}
}
