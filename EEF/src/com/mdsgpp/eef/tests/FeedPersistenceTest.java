package com.mdsgpp.eef.tests;

import java.io.IOException;

import com.mdsgpp.eef.model.Feed;
import com.mdsgpp.eef.model.News;
import com.mdsgpp.eef.parser.FeedPersistence;

import android.content.Context;
import android.test.AndroidTestCase;

public class FeedPersistenceTest extends AndroidTestCase {
	private Feed feed;
	private Context context;
	private News news;

	protected void setUp() throws Exception {
		super.setUp();
		feed = new Feed();
		news = new News(feed);
		news.setTitle("Teste de persistencia");
		news.setCategory("teste");
		news.setDate("18/02");
		news.setLink("www.newss.gov");
		news.setDescription("Descricao");

		feed.addItem(news);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetInstance() {
		context = getContext();
		String nomeClasseRetorno = FeedPersistence.getInstance(context).getClass().getSimpleName();
		assertEquals("FeedPersistencia", nomeClasseRetorno);
	}

	public void testWriteFeedFile() throws IOException, ClassNotFoundException {
		@SuppressWarnings("unused")
		Feed feedRead;

		FeedPersistence.getInstance(getContext()).writeFeedFile(feed);
		feedRead = FeedPersistence.getInstance(getContext()).readFeedFile();

		assertEquals("Título esperado", "Teste de persistencia", feed.getItem(0).getTitle());
		assertEquals("Categoria esperada", "teste", feed.getItem(0).getCategory());
		assertEquals("Data esperada", "18/02", feed.getItem(0).getDate());
		assertEquals("Link esperado", "www.newss.gov", feed.getItem(0).getLink());
		assertEquals("Descricao esperada", "Descricao", feed.getItem(0).getDescription());
	}
}
