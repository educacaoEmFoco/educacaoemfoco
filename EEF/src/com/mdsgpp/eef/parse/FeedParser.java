package com.mdsgpp.eef.parse;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.mdsgpp.eef.controle.FeedParseControle;
import com.mdsgpp.eef.modelo.Feed;

import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.sax.StartElementListener;
import android.util.Xml;

public class FeedParser extends DefaultHandler {

	public Feed parse(InputStream is) {

		RootElement root = new RootElement("rss");
		Element chanElement = root.getChild("channel");

		Element chanItem = chanElement.getChild("item");
		Element itemTitle = chanItem.getChild("title");
		Element itemDescription = chanItem.getChild("description");
		Element itemCategory = chanItem.getChild("category");
		Element itemPubDate = chanItem.getChild("pubDate");
		Element itemLink = chanItem.getChild("link");

		chanElement.setStartElementListener(new StartElementListener() {
			public void start(Attributes attributes) {
				FeedParseControle.getInstance().criaNovoFeed();
			}
		});

		chanItem.setStartElementListener(new StartElementListener() {
			public void start(Attributes attributes) {
				FeedParseControle.getInstance().criaNovoItem();
			}
		});

		chanItem.setEndElementListener(new EndElementListener() {
			public void end() {
				FeedParseControle.getInstance().adicionaItem();
			}
		});

		itemTitle.setEndTextElementListener(new EndTextElementListener() {
			public void end(String body) {
				FeedParseControle.getInstance().getItem().setTitle(body);
			}
		});
		itemDescription.setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				FeedParseControle.getInstance().getItem().setDescription(body);
			}
		});
		itemCategory.setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				FeedParseControle.getInstance().getItem().setCategory(body);
			}
		});

		itemPubDate.setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				FeedParseControle.getInstance().getItem().setDate(body);
			}
		});

		itemLink.setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				FeedParseControle.getInstance().getItem().setLink(body);
			}
		});

		try {
			Xml.parse(is, Xml.Encoding.UTF_8, root.getContentHandler());
			return FeedParseControle.getInstance().getFeed();
		} catch (SAXException e) {
		} catch (IOException e) {
		}

		return null;
	}
}
