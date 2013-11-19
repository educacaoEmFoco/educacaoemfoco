package com.mdsgpp.eef.testes;

import java.util.ArrayList;

import android.test.AndroidTestCase;

import com.mdsgpp.eef.modelo.Feed;
import com.mdsgpp.eef.modelo.Noticias;

public class FeedTeste extends AndroidTestCase {

	private ArrayList<Noticias> itens;
	private Feed feed;
	private Noticias noticias;
	

	public void setUp(){
		
		itens = new ArrayList<Noticias>();
		feed = new Feed();
		noticias = new Noticias(feed);
		
		itens.add(noticias);
		feed.setItems(itens);
	}
	
	  
	public void testSetArrayListDeNoticias() {

		assertEquals(itens,feed.getItems());
		
	}
	
	  
	public void testGetSizeDoArrayDeNoticias(){
		
		assertEquals(1,feed.getItemsSize());
	}
	
	  
	public void testResetDoArrayListDeNoticias(){
		feed.reset();
		
		assertEquals(0,feed.getItemsSize());
	}
	
	  
	public void testGetItemDoArrayDeNoticias(){
		assertEquals(noticias,feed.getItem(0));
	}
	
	  
	public void testAdicionarItensNoArrayDeNoticias(){
		feed.addItem(noticias);
		assertEquals(2,feed.getItemsSize());
	}
	
	
	

}
