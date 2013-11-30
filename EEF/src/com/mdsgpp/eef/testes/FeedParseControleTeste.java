package com.mdsgpp.eef.testes;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.mdsgpp.eef.controle.FeedControle;
import com.mdsgpp.eef.visao.TelaFeed;

import android.content.Context;
import android.test.ActivityUnitTestCase;

public class FeedParseControleTeste extends  ActivityUnitTestCase<TelaFeed> {

        private static Context context;
        private final String FEED_ADDRESS = "http://noticias.gov.br/noticias/rss?id=AFSZW";
        private FeedControle task1, task2;
        private TelaFeed tela;
        
        public FeedParseControleTeste() {
                super(TelaFeed.class);
        }

        public void setUp() throws Exception {
                context = getInstrumentation().getTargetContext();
                tela = getActivity();
        }

        public void tearDown() throws Exception {
        }

        public void testTask() {
                final CountDownLatch signal = new CountDownLatch(1);

                try {
                        runTestOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                        task1 = new FeedControle(context, null);
                                        task2 = new FeedControle(context, tela);
                                        try {
                                                task1.execute(FEED_ADDRESS);
                                                task2.execute("url_errada");
                                        } catch (Exception e) {
                                                fail();
                                        }
                                }
                        });

                        signal.await(30, TimeUnit.SECONDS);
                } catch (Throwable e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }

        }
}