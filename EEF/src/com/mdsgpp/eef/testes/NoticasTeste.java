package com.mdsgpp.eef.testes;

import org.junit.Before;
import org.junit.Test;

import android.test.AndroidTestCase;

import com.mdsgpp.eef.modelo.Feed;
import com.mdsgpp.eef.modelo.Noticias;

public class NoticasTeste extends AndroidTestCase {

	private String title;
	private String category;
	private String description;
	private String link;
	private String date; 
	private Feed feed;
	private Noticias noticias;
	
	
	public void setUp(){
		feed = new Feed();
		noticias = new Noticias(feed);
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
