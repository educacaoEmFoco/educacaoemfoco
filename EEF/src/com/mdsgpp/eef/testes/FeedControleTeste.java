package com.mdsgpp.eef.testes;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import com.mdsgpp.eef.controle.FeedControle;
import com.mdsgpp.eef.visao.ReceptorDados;
import com.mdsgpp.eef.visao.TelaFeed;



import android.app.Activity;
import android.test.AndroidTestCase;
import android.util.Log;

public class FeedControleTeste extends AndroidTestCase {

	private FeedControle feedControle;
	private TelaFeed telaFeed;
	private final static String FEED_ADDRESS = "http://noticias.gov.br/noticias/rss?id=AFSZW";
	private final static String FEED_ADDRESS_ERROR = "httpnoticiasgovbrnoticiasrss?id=AFSZW";

	
	public void setUp() throws Exception {
		
		telaFeed = new TelaFeed();
		feedControle = new FeedControle(telaFeed) ;
		
	}

	public void tearDown() throws Exception {
	}

	public void testTask() {
		try {
			feedControle.execute(FEED_ADDRESS);
		} catch (Exception e) {
			Log.i("testTask", e.getMessage());
			fail();
		}

	}
}
