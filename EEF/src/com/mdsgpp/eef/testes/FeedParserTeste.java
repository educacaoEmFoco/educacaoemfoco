package com.mdsgpp.eef.testes;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.mdsgpp.eef.parse.FeedParser;

import junit.framework.TestCase;

public class FeedParserTeste extends TestCase {

	private FeedParser feedParser;
	private InputStream stream;

	protected void setUp() throws Exception {
		super.setUp();
		feedParser = new FeedParser();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testParse() throws MalformedURLException, IOException {
		stream = new URL("http://www.noticias.gov.br/noticias/rss?id=AFSZW").openStream();
		assertEquals("Feed", feedParser.parse(stream).getClass().getSimpleName());
	}

}
