package com.mdsgpp.eef.testes;

import java.io.IOException;

import com.mdsgpp.eef.modelo.Feed;
import com.mdsgpp.eef.modelo.Noticias;
import com.mdsgpp.eef.parse.FeedPersistencia;

import android.content.Context;
import android.test.AndroidTestCase;

public class FeedPersistenciaTeste extends AndroidTestCase {
	private Feed feed;
	private Context context;
	private Noticias noticia;

	protected void setUp() throws Exception {
		super.setUp();
		feed = new Feed();
		noticia = new Noticias(feed);
		noticia.setTitle("Teste de persistencia");
		noticia.setCategory("teste");
		noticia.setDate("18/02");
		noticia.setLink("www.noticias.gov");
		noticia.setDescription("Descricao");

		feed.addItem(noticia);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testgetinstancia() {
		context = getContext();
		String nomeClasseRetorno = FeedPersistencia.getInstance(context)
				.getClass().getSimpleName();
		assertEquals("FeedPersistencia", nomeClasseRetorno);

	}

	public void testWriteFeedFile() throws IOException, ClassNotFoundException {
		@SuppressWarnings("unused")
		Feed feedRead;

		FeedPersistencia.getInstance(getContext()).writeFeedFile(feed);
		feedRead = FeedPersistencia.getInstance(getContext()).readFeedFile();

		assertEquals("T�tulo esperado", "Teste de persistencia", feed.getItem(0).getTitle());
		assertEquals("Categoria esperada", "teste", feed.getItem(0).getCategory());
		assertEquals("Data esperada", "18/02", feed.getItem(0).getDate());
		assertEquals("Link esperado", "www.noticias.gov", feed.getItem(0).getLink());
		assertEquals("Descricao esperada", "Descricao", feed.getItem(0).getDescription());
	}
}
