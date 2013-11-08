package com.mdsgpp.eef.testes;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import android.test.AndroidTestCase;

import com.mdsgpp.eef.parse.DadosParse;

public class DadosParseTeste extends AndroidTestCase{
	
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
	
	@Before
	public void setUp() throws Exception {
		new DadosParse(getContext());
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

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testGetEstado() throws IOException {
		assertEquals(container, this.informacoes.get("nome_e_sigla"));

		assertEquals(dados1, this.informacoes.get("participacao_estadual_pib"));
		
		assertEquals(dados2, this.informacoes.get("populacao"));
		
		assertEquals(dados3, this.informacoes.get("numero_projetos"));
		
		assertEquals(dados4, this.informacoes.get("valor_investido"));
		
		assertEquals(dados5, this.informacoes.get("5a_8a"));

		assertEquals(dados6, this.informacoes.get("ensino_medio"));
		
		assertEquals(dados7, this.informacoes.get("series_iniciais"));
		
		assertEquals(dados8, this.informacoes.get("jovens_pesquisadores"));
		
		assertEquals(dados9, this.informacoes.get("programa_primeiros_projetos"));

		assertEquals(dados10, this.informacoes.get("projetos_apoio_pesquisa_cnpq"));
		
		assertEquals(dados11, this.informacoes.get("valores_jovens_pesquisadores"));

		assertEquals(dados12, this.informacoes.get("valores_programa_primeiros_projetos"));
		
		assertEquals(dados13, this.informacoes.get("valores_projetos_apoio_pesquisa_cnpq"));
		
	}

}
