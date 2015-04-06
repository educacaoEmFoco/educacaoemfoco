package com.mdsgpp.eef.testes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.test.AndroidTestCase;

import com.mdsgpp.eef.controle.ParseControle;

public class ParseControleTeste extends AndroidTestCase {
	
	private ParseControle parseControle;
	private Context context;	
	private HashMap<String, ArrayList<String[]>> informacoes;
	private ArrayList<String[]> dados1;
	private ArrayList<String[]> dados2;
	private ArrayList<String[]> dados3;
	private ArrayList<String[]> dados4;
	private ArrayList<String[]> dados5;
	private ArrayList<String[]> dados6;
	private ArrayList<String[]> dados7;
	private ArrayList<String[]> dados8;
	private ArrayList<String[]> dados9;
	private ArrayList<String[]> dados10;
	private ArrayList<String[]> dados11;
	private ArrayList<String[]> dados12;
	private ArrayList<String[]> dados13;
	private String indicadores[] = new String[13];
	private ArrayList<String[]> container;
	private String nomeEsigla[] = new String[2];
	

	public void setUp() throws Exception {
		context = getContext();

		parseControle = new ParseControle(context);		
		informacoes = new HashMap<String, ArrayList<String[]>>();
		container = new ArrayList<String[]>();
		dados1 = new ArrayList<String[]>();
		dados2 = new ArrayList<String[]>();
		dados3 = new ArrayList<String[]>();
		dados4 = new ArrayList<String[]>();
		dados5 = new ArrayList<String[]>();
		dados6 = new ArrayList<String[]>();
		dados7 = new ArrayList<String[]>();
		dados8 = new ArrayList<String[]>();
		dados9 = new ArrayList<String[]>();
		dados10 = new ArrayList<String[]>();
		dados11 = new ArrayList<String[]>();
		dados12 = new ArrayList<String[]>();
		dados13 = new ArrayList<String[]>();

		nomeEsigla[0] = "Acre";
		nomeEsigla[1] = "AC";

		container.add(nomeEsigla);
		this.informacoes.put("nome_e_sigla", container);
		
		indicadores[0] = "participacao_estadual_pib";
		dados1.add("1995: 0,200000000000045".split(": "));
		dados1.add("1996: 0,200000000000045".split(": "));
		dados1.add("1997: 0,200000000000045".split(": "));
		dados1.add("1998: 0,200000000000045".split(": "));
		dados1.add("1999: 0,200000000000045".split(": "));
		dados1.add("2000: 0,200000000000045".split(": "));
		dados1.add("2001: 0,200000000000045".split(": "));
		dados1.add("2002: 0,200000000000045".split(": "));
		dados1.add("2003: 0,200000000000045".split(": "));
		dados1.add("2004: 0,200000000000045".split(": "));
		dados1.add("2005: 0,200000000000045".split(": "));
		dados1.add("2006: 0,200000000000045".split(": "));
		dados1.add("2007: 0,200000000000045".split(": "));
		dados1.add("2008: 0,200000000000045".split(": "));
		informacoes.put(indicadores[0], dados1);
		
		indicadores[1] = "populacao";
		dados2.add("2009: 691132".split(": "));
		informacoes.put(indicadores[1], dados2);
		
		indicadores[2] = "numero_projetos";
		dados3.add("2003: 0".split(": "));
		dados3.add("2004: 2".split(": "));
		dados3.add("2005: 0".split(": "));
		dados3.add("2006: 0".split(": "));
		dados3.add("2007: 0".split(": "));
		dados3.add("2008: 0".split(": "));
		dados3.add("2009: 1".split(": "));
		dados3.add("Total: 3".split(": "));
		informacoes.put(indicadores[2], dados3);
		
		indicadores[3] = "valor_investido";
		dados4.add("2003: 0".split(": "));
		dados4.add("2004: 516790".split(": "));
		dados4.add("2005: 0".split(": "));
		dados4.add("2006: 0".split(": "));
		dados4.add("2007: 0".split(": "));
		dados4.add("2008: 0".split(": "));
		dados4.add("2009: 46891,8999999762".split(": "));
		dados4.add("Total: 563681,899999976".split(": "));
		informacoes.put(indicadores[3], dados4);
		
		indicadores[4] = "5a_8a";
		dados5.add("2005: 3,5".split(": "));
		dados5.add("2007: 3,79999999999927".split(": "));
		dados5.add("2009: 4,09999999999854".split(": "));
		informacoes.put(indicadores[4], dados5);
		
		indicadores[5] = "ensino_medio";
		dados6.add("2005: 3".split(": "));
		dados6.add("2007: 3,29999999999927".split(": "));
		dados6.add("2009: 3,5".split(": "));
		informacoes.put(indicadores[5], dados6);
		
		indicadores[6] = "series_iniciais";
		dados7.add("2005: 3,29999999999927".split(": "));
		dados7.add("2007: 3,79999999999927".split(": "));
		dados7.add("2009: 4,5".split(": "));
		informacoes.put(indicadores[6], dados7);
		
		indicadores[7] = "jovens_pesquisadores";
		dados8.add("2005: 0".split(": "));
		dados8.add("2006: 0".split(": "));
		dados8.add("2007: 1".split(": "));
		dados8.add("2008: 1".split(": "));
		dados8.add("2009: 1".split(": "));
		dados8.add("2010: 0".split(": "));
		dados8.add("Total: 3".split(": "));
		informacoes.put(indicadores[7], dados8);
		
		indicadores[8] = "programa_primeiros_projetos";
		dados9.add("2007: 2".split(": "));
		dados9.add("2008: 0".split(": "));
		dados9.add("2009: 0".split(": "));
		dados9.add("2010: 0".split(": "));
		dados9.add("Total: 2".split(": "));
		informacoes.put(indicadores[8], dados9);
		
		indicadores[9] = "projetos_apoio_pesquisa_cnpq";
		dados10.add("2001: 5".split(": "));
		dados10.add("2002: 8".split(": "));
		dados10.add("2003: 9".split(": "));
		dados10.add("2004: 7".split(": "));
		dados10.add("2005: 11".split(": "));
		dados10.add("2006: 13".split(": "));
		dados10.add("2007: 26".split(": "));
		dados10.add("2008: 27".split(": "));
		dados10.add("2009: 16".split(": "));
		dados10.add("2010: 11".split(": "));
		dados10.add("Total: 133".split(": "));
		informacoes.put(indicadores[9], dados10);
		
		indicadores[10] = "valores_jovens_pesquisadores";
		dados11.add("2005: 0".split(": "));
		dados11.add("2006: 0".split(": "));
		dados11.add("2007: 92,25".split(": "));
		dados11.add("2008: 36,2800000000279".split(": "));
		dados11.add("2009: 9,72000000000116".split(": "));
		dados11.add("2010: 0".split(": "));
		dados11.add("Total: 138,250000000029".split(": "));
		informacoes.put(indicadores[10], dados11);
		
		indicadores[11] = "valores_programa_primeiros_projetos";
		dados12.add("2007: 55,4400000000023".split(": "));
		dados12.add("2008: 0".split(": "));
		dados12.add("2009: 0".split(": "));
		dados12.add("2010: 0".split(": "));
		dados12.add("Total: 55,4400000000023".split(": "));
		informacoes.put(indicadores[11], dados12);
		
		indicadores[12] = "valores_projetos_apoio_pesquisa_cnpq";
		dados13.add("2001: 22".split(": "));
		dados13.add("2002: 0".split(": "));
		dados13.add("2003: 146,469999999972".split(": "));
		dados13.add("2004: 26".split(": "));
		dados13.add("2005: 117,939999999944".split(": "));
		dados13.add("2006: 24,0599999999977".split(": "));
		dados13.add("2007: 797,44000000041".split(": "));
		dados13.add("2008: 440,970000000205".split(": "));
		dados13.add("2009: 113,739999999991".split(": "));
		dados13.add("2010: 216,510000000009".split(": "));
		dados13.add("Total: 1905,13000000053".split(": "));
		informacoes.put(indicadores[12], dados13);
	}
	
	public void tearDown() throws Exception {
		// Do nothing.
	}
	
	public void testInstancia() {
		assertNotNull(parseControle);
	}
	
	public void testarSingleton() {
		assertNotNull(ParseControle.getInstancia(context));
	}
	
	public void testarInformacoesParse() {
		HashMap<String, ArrayList<String[]>> estado;
		estado = null;
		try {
			estado = parseControle.getInformacoes(0);
		} 
		catch(IOException e) {
			fail();
		}
		
		assertEquals("AC", estado.get("nome_e_sigla").get(0)[1]);

		assertEquals("0,200000000000045", estado.get("participacao_estadual_pib").get(0)[1]);
		
		assertEquals("691132", estado.get("populacao").get(0)[1]);
		
		assertEquals("0", estado.get("numero_projetos").get(0)[1]);
		
		assertEquals("0", estado.get("valor_investido").get(0)[1]);
		
		assertEquals("3,5", estado.get("5a_8a").get(0)[1]);

		assertEquals("3", estado.get("ensino_medio").get(0)[1]);
		
		assertEquals("3,29999999999927", estado.get("series_iniciais").get(0)[1]);
		
		assertEquals("0", estado.get("jovens_pesquisadores").get(0)[1]);
		
		assertEquals("2", estado.get("programa_primeiros_projetos").get(0)[1]);

		assertEquals("5", estado.get("projetos_apoio_pesquisa_cnpq").get(0)[1]);
		
		assertEquals("0", estado.get("valores_jovens_pesquisadores").get(0)[1]);

		assertEquals("55,4400000000023", 
			estado.get("valores_programa_primeiros_projetos").get(0)[1]);
		
		assertEquals("22", estado.get("valores_projetos_apoio_pesquisa_cnpq").get(0)[1]);
	}
}