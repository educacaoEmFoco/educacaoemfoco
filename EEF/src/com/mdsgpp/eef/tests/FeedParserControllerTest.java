package com.mdsgpp.eef.tests;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.mdsgpp.eef.controller.FeedController;
import com.mdsgpp.eef.visao.TelaFeed;

import android.content.Context;
import android.test.ActivityUnitTestCase;

public class FeedParserControllerTest extends  ActivityUnitTestCase<TelaFeed> {

	private static Context context;
	private final String FEED_ADDRESS = "http://noticias.gov.br/noticias/rss?id=AFSZW";
	private FeedController task1;
	private TelaFeed screen;

	public FeedParserControllerTest() {
		super(TelaFeed.class);
	}

	public void setUp() throws Exception {
		context = getInstrumentation().getTargetContext();
        screen = getActivity();
	}

	public void tearDown() throws Exception {
		// Do nothing.
	}

	public void testTask() {
        final CountDownLatch signal = new CountDownLatch(1);

        try {
        	runTestOnUiThread(new Runnable() {
        		@Override
        		public void run() {
        			task1 = new FeedController(context, null);
                    try {
                        task1.execute(FEED_ADDRESS);
                    } catch (Exception e) {
                        fail();
                    }
        		}
            });
        	
        	signal.await(30, TimeUnit.SECONDS);
        } catch (Throwable e) {
        	e.printStackTrace();
        }
	}
}