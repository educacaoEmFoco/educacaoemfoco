package com.mdsgpp.eef.tests;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.mdsgpp.eef.controle.FeedControle;
import com.mdsgpp.eef.visao.TelaFeed;

import android.test.ActivityInstrumentationTestCase2;

public class FeedControleTeste extends ActivityInstrumentationTestCase2<TelaFeed> {

	private final String FEED_ADDRESS = "http://noticias.gov.br/noticias/rss?id=AFSZW";
	private FeedControle task1, task2;
	private TelaFeed tela;

	public FeedControleTeste() {
		super(TelaFeed.class);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		tela = getActivity();
	}

	public void tearDown() throws Exception {
	}

	public void testTask() throws Throwable {
		final CountDownLatch signal = new CountDownLatch(1);

		runTestOnUiThread(new Runnable() {
			@Override
			public void run() {

				task1 = new FeedControle(tela, null);
				task2 = new FeedControle(tela, tela);

				task1.execute(FEED_ADDRESS);
				task2.execute("url_errada");
			}
		});

		signal.await(30, TimeUnit.SECONDS);
	}
}
