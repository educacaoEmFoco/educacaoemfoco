package com.mdsgpp.eef.tests;

import java.util.ArrayList;

import android.test.AndroidTestCase;

import com.mdsgpp.eef.model.Feed;
import com.mdsgpp.eef.model.News;

public class FeedTest extends AndroidTestCase {

	private ArrayList<News> items;
	private Feed feed;
	private News news;
	
	public void setUp() {
		items = new ArrayList<News>();
		feed = new Feed();
		news = new News(feed);
		
		items.add(news);
		feed.setItems(items);
	}
	
	public void testSetNewsArrayList() {
		assertEquals(items, feed.getItems());
	}
	  
	public void testGetSizeNewsArrayList() {
		assertEquals(1, feed.getItemsSize());
	}
	
	public void testResetNewsArrayList() {
		feed.reset();
		
		assertEquals(0, feed.getItemsSize());
	}
	  
	public void testGetItemNewsArrayList() {
		assertEquals(news, feed.getItem(0));
	}
	  
	public void testAddItemsNewsArrayList() {
		feed.addItem(news);
		assertEquals(2, feed.getItemsSize());
	}
}
