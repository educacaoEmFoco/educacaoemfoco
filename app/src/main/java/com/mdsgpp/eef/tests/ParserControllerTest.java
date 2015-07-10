package com.mdsgpp.eef.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.test.AndroidTestCase;

import com.mdsgpp.eef.controller.ParserController;

public class ParserControllerTest extends AndroidTestCase {
	
	private ParserController parserController;
	private Context context;	
	private HashMap<String, ArrayList<String[]>> information;
	private ArrayList<String[]> data1;
	private ArrayList<String[]> data2;
	private ArrayList<String[]> data3;
	private ArrayList<String[]> data4;
	private ArrayList<String[]> data5;
	private ArrayList<String[]> data6;
	private ArrayList<String[]> data7;
	private ArrayList<String[]> data8;
	private ArrayList<String[]> data9;
	private ArrayList<String[]> data10;
	private ArrayList<String[]> data11;
	private ArrayList<String[]> data12;
	private ArrayList<String[]> data13;
	private String indicators[] = new String[13];
	private ArrayList<String[]> container;
	private String nameAndAcronym[] = new String[2];
	

	public void setUp() throws Exception {
		context = getContext();

		parserController = new ParserController(context);		
		information = new HashMap<String, ArrayList<String[]>>();
		container = new ArrayList<String[]>();
		data1 = new ArrayList<String[]>();
		data2 = new ArrayList<String[]>();
		data3 = new ArrayList<String[]>();
		data4 = new ArrayList<String[]>();
		data5 = new ArrayList<String[]>();
		data6 = new ArrayList<String[]>();
		data7 = new ArrayList<String[]>();
		data8 = new ArrayList<String[]>();
		data9 = new ArrayList<String[]>();
		data10 = new ArrayList<String[]>();
		data11 = new ArrayList<String[]>();
		data12 = new ArrayList<String[]>();
		data13 = new ArrayList<String[]>();

		nameAndAcronym[0] = "Acre";
		nameAndAcronym[1] = "AC";

		container.add(nameAndAcronym);
		this.information.put("nome_e_sigla", container);
		
		indicators[0] = "participacao_estadual_pib";
		data1.add("1995: 0,200000000000045".split(": "));
		data1.add("1996: 0,200000000000045".split(": "));
		data1.add("1997: 0,200000000000045".split(": "));
		data1.add("1998: 0,200000000000045".split(": "));
		data1.add("1999: 0,200000000000045".split(": "));
		data1.add("2000: 0,200000000000045".split(": "));
		data1.add("2001: 0,200000000000045".split(": "));
		data1.add("2002: 0,200000000000045".split(": "));
		data1.add("2003: 0,200000000000045".split(": "));
		data1.add("2004: 0,200000000000045".split(": "));
		data1.add("2005: 0,200000000000045".split(": "));
		data1.add("2006: 0,200000000000045".split(": "));
		data1.add("2007: 0,200000000000045".split(": "));
		data1.add("2008: 0,200000000000045".split(": "));
		information.put(indicators[0], data1);
		
		indicators[1] = "populacao";
		data2.add("2009: 691132".split(": "));
		information.put(indicators[1], data2);
		
		indicators[2] = "numero_projetos";
		data3.add("2003: 0".split(": "));
		data3.add("2004: 2".split(": "));
		data3.add("2005: 0".split(": "));
		data3.add("2006: 0".split(": "));
		data3.add("2007: 0".split(": "));
		data3.add("2008: 0".split(": "));
		data3.add("2009: 1".split(": "));
		data3.add("Total: 3".split(": "));
		information.put(indicators[2], data3);
		
		indicators[3] = "valor_investido";
		data4.add("2003: 0".split(": "));
		data4.add("2004: 516790".split(": "));
		data4.add("2005: 0".split(": "));
		data4.add("2006: 0".split(": "));
		data4.add("2007: 0".split(": "));
		data4.add("2008: 0".split(": "));
		data4.add("2009: 46891,8999999762".split(": "));
		data4.add("Total: 563681,899999976".split(": "));
		information.put(indicators[3], data4);
		
		indicators[4] = "5a_8a";
		data5.add("2005: 3,5".split(": "));
		data5.add("2007: 3,79999999999927".split(": "));
		data5.add("2009: 4,09999999999854".split(": "));
		information.put(indicators[4], data5);
		
		indicators[5] = "ensino_medio";
		data6.add("2005: 3".split(": "));
		data6.add("2007: 3,29999999999927".split(": "));
		data6.add("2009: 3,5".split(": "));
		information.put(indicators[5], data6);
		
		indicators[6] = "series_iniciais";
		data7.add("2005: 3,29999999999927".split(": "));
		data7.add("2007: 3,79999999999927".split(": "));
		data7.add("2009: 4,5".split(": "));
		information.put(indicators[6], data7);
		
		indicators[7] = "jovens_pesquisadores";
		data8.add("2005: 0".split(": "));
		data8.add("2006: 0".split(": "));
		data8.add("2007: 1".split(": "));
		data8.add("2008: 1".split(": "));
		data8.add("2009: 1".split(": "));
		data8.add("2010: 0".split(": "));
		data8.add("Total: 3".split(": "));
		information.put(indicators[7], data8);
		
		indicators[8] = "programa_primeiros_projetos";
		data9.add("2007: 2".split(": "));
		data9.add("2008: 0".split(": "));
		data9.add("2009: 0".split(": "));
		data9.add("2010: 0".split(": "));
		data9.add("Total: 2".split(": "));
		information.put(indicators[8], data9);
		
		indicators[9] = "projetos_apoio_pesquisa_cnpq";
		data10.add("2001: 5".split(": "));
		data10.add("2002: 8".split(": "));
		data10.add("2003: 9".split(": "));
		data10.add("2004: 7".split(": "));
		data10.add("2005: 11".split(": "));
		data10.add("2006: 13".split(": "));
		data10.add("2007: 26".split(": "));
		data10.add("2008: 27".split(": "));
		data10.add("2009: 16".split(": "));
		data10.add("2010: 11".split(": "));
		data10.add("Total: 133".split(": "));
		information.put(indicators[9], data10);
		
		indicators[10] = "valores_jovens_pesquisadores";
		data11.add("2005: 0".split(": "));
		data11.add("2006: 0".split(": "));
		data11.add("2007: 92,25".split(": "));
		data11.add("2008: 36,2800000000279".split(": "));
		data11.add("2009: 9,72000000000116".split(": "));
		data11.add("2010: 0".split(": "));
		data11.add("Total: 138,250000000029".split(": "));
		information.put(indicators[10], data11);
		
		indicators[11] = "valores_programa_primeiros_projetos";
		data12.add("2007: 55,4400000000023".split(": "));
		data12.add("2008: 0".split(": "));
		data12.add("2009: 0".split(": "));
		data12.add("2010: 0".split(": "));
		data12.add("Total: 55,4400000000023".split(": "));
		information.put(indicators[11], data12);
		
		indicators[12] = "valores_projetos_apoio_pesquisa_cnpq";
		data13.add("2001: 22".split(": "));
		data13.add("2002: 0".split(": "));
		data13.add("2003: 146,469999999972".split(": "));
		data13.add("2004: 26".split(": "));
		data13.add("2005: 117,939999999944".split(": "));
		data13.add("2006: 24,0599999999977".split(": "));
		data13.add("2007: 797,44000000041".split(": "));
		data13.add("2008: 440,970000000205".split(": "));
		data13.add("2009: 113,739999999991".split(": "));
		data13.add("2010: 216,510000000009".split(": "));
		data13.add("Total: 1905,13000000053".split(": "));
		information.put(indicators[12], data13);
	}
	
	public void tearDown() throws Exception {
		// Do nothing.
	}
	
	public void testInstancie() {
		assertNotNull(parserController);
	}
	
	public void testSingleton() {
		assertNotNull(ParserController.getInstance(context));
	}
	
	public void testParserInformation() {
		HashMap<String, ArrayList<String[]>> state;
		state = null;
		try {
			state = parserController.getStateInformation(0);
		} 
		catch(IOException e) {
			fail();
		}
		
		assertEquals("AC", state.get("nome_e_sigla").get(0)[1]);

		assertEquals("0,200000000000045", state.get("participacao_estadual_pib").get(0)[1]);
		
		assertEquals("691132", state.get("populacao").get(0)[1]);
		
		assertEquals("0", state.get("numero_projetos").get(0)[1]);
		
		assertEquals("0", state.get("valor_investido").get(0)[1]);
		
		assertEquals("3,5", state.get("5a_8a").get(0)[1]);

		assertEquals("3", state.get("ensino_medio").get(0)[1]);
		
		assertEquals("3,29999999999927", state.get("series_iniciais").get(0)[1]);
		
		assertEquals("0", state.get("jovens_pesquisadores").get(0)[1]);
		
		assertEquals("2", state.get("programa_primeiros_projetos").get(0)[1]);

		assertEquals("5", state.get("projetos_apoio_pesquisa_cnpq").get(0)[1]);
		
		assertEquals("0", state.get("valores_jovens_pesquisadores").get(0)[1]);

		assertEquals("55,4400000000023", 
			state.get("valores_programa_primeiros_projetos").get(0)[1]);
		
		assertEquals("22", state.get("valores_projetos_apoio_pesquisa_cnpq").get(0)[1]);
	}
}