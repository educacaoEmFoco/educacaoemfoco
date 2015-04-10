package com.mdsgpp.eef.controle;

import com.mdsgpp.eef.modelo.Feed;
import com.mdsgpp.eef.modelo.Noticias;

public class FeedParseControle {

	private Feed feed;
	private Noticias item;
	private static FeedParseControle instancia;
	
	public FeedParseControle() {
		this.feed = new Feed();
	}
	
	public static FeedParseControle getInstance() {
		if(instancia == null) {
			instancia = new FeedParseControle();
		}
		else {
			// Nothing to do.
		}
		
		return instancia;
	}

	public Feed getFeed() {
		return this.feed;
	}
	
	// This method clear the feed.
	public void criaNovoFeed() {
		this.feed.reset();
	}
	
	// This method creates a new item based on the feed.
	public void criaNovoItem() {
		this.item = new Noticias(this.feed);
	}
	
	// This method add an item on the feed.
	public void adicionaItem() {
		this.feed.addItem(this.item);
	}
	
	public Noticias getItem() {
		return this.item;
	}	
}