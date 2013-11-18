package com.mdsgpp.eef.testes;

import java.util.ArrayList;

import com.mdsgpp.eef.modelo.Feed;
import com.mdsgpp.eef.modelo.Noticias;
import com.mdsgpp.eef.parse.FeedPersistencia;

import android.content.Context;
import android.test.AndroidTestCase;

public class FeedPersistenciaTeste extends AndroidTestCase {
	private Feed feed;
	private Context context;
	private Noticias noticia;
	private ArrayList<Noticias> dados;
	

	protected void setUp() throws Exception {
		super.setUp();
		feed = new Feed();
		noticia = new Noticias(feed);
		noticia.setTitle("Teste de persistencia");
		noticia.setCategory("teste");
		noticia.setDate("18/02");
		noticia.setLink("www.noticias.gov");
		noticia.setDescription("Teste da classe de persistencia do parse.");
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testgetinstancia(){
		context = getContext();
		String nomeClasseRetorno = FeedPersistencia.getInstance(context).getClass().getSimpleName();
		assertEquals("FeedPersistencia",nomeClasseRetorno);
		
	}


}
