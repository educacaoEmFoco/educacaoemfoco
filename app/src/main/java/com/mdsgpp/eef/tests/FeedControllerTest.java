package com.mdsgpp.eef.tests;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.mdsgpp.eef.controller.FeedController;
import com.mdsgpp.eef.view.FeedScreen;

import android.test.ActivityInstrumentationTestCase2;

public class FeedControllerTest extends ActivityInstrumentationTestCase2<FeedScreen> {

	private final String FEED_ADDRESS = "http://noticias.gov.br/noticias/rss?id=AFSZW";
	private FeedController task1;
	private FeedScreen screen;

	public FeedControllerTest() {
		super(FeedScreen.class);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		screen = getActivity();
	}

	public void tearDown() throws Exception {
	}

	public void testTask() throws Throwable {
		final CountDownLatch signal = new CountDownLatch(1);

		runTestOnUiThread(new Runnable() {
			@Override
			public void run() {

				task1 = new FeedController(screen, null);

				task1.execute(FEED_ADDRESS);
			}
		});

		signal.await(30, TimeUnit.SECONDS);
	}
}
