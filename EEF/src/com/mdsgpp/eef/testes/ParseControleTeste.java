package com.mdsgpp.eef.testes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import android.content.Context;
import android.test.AndroidTestCase;

import com.mdsgpp.eef.controle.ParseControle;

public class ParseControleTeste extends AndroidTestCase{
	
	private ParseControle parseControle;
	private Context context;
	
	@Before
	public void setUp() throws Exception {
		context = getContext();
		parseControle = new ParseControle(context);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInstancia() {
		assertNotNull(parseControle);
	}

}
