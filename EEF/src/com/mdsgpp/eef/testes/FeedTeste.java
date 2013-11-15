package com.mdsgpp.eef.testes;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import android.test.AndroidTestCase;

import com.mdsgpp.eef.modelo.Feed;
import com.mdsgpp.eef.modelo.Noticias;

public class FeedTeste extends AndroidTestCase {

	private ArrayList<Noticias> itens;
	private Feed feed;
	private Noticias noticias;
	
	@Before
	public void setUp(){
		
		itens = new ArrayList<Noticias>();
		feed = new Feed();
		noticias = new Noticias(feed);
		
		itens.add(noticias);
		feed.setItems(itens);
	}
	
	@Test
	public void testSetArrayListDeNoticias() {

		assertEquals(itens,feed.getItems());
		
	}
	
	@Test
	public void testGetSizeDoArrayDeNoticias(){
		
		assertEquals(1,feed.getItemsSize());
	}
	
	@Test
	public void testResetDoArrayListDeNoticias(){
		feed.reset();
		
		assertEquals(0,feed.getItemsSize());
	}
	
	@Test
	public void testGetItemDoArrayDeNoticias(){
		assertEquals(noticias,feed.getItem(0));
	}
	
	@Test
	public void testAdicionarItensNoArrayDeNoticias(){
		feed.addItem(noticias);
		assertEquals(2,feed.getItemsSize());
	}
	
	
	

}
