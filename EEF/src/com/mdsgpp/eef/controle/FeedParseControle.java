package com.rssfeed.control;

import com.rssfeed.model.Feed;
import com.rssfeed.model.Noticias;

public class FeedParseControle {

	private Feed feed;
	private Noticias item;
	private static FeedParseControle instancia;
	
	public FeedParseControle() {
		this.feed = new Feed();
	}
	
	public static FeedParseControle getInstance() {
		if (instancia == null) {
			instancia = new FeedParseControle();
		}
		return instancia;
	}

	public Feed getFeed() {
		return this.feed;
	}
	
	public void criaNovoFeed() {
		this.feed.reset();
	}
	
	public void criaNovoItem() {
		this.item = new Noticias(this.feed);
	}
	
	public void adicionaItem() {
		this.feed.addItem(this.item);
	}
	
	public Noticias getItem() {
		return this.item;
	}
	
}
