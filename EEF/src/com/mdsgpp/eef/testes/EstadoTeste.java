package com.mdsgpp.eef.testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mdsgpp.eef.modelo.Estado;
import com.mdsgpp.eef.modelo.Ideb;

// Classe de testes referentes a classe Estado do modelo

public class EstadoTeste {

	private Estado estado;
	private HashMap<String, ArrayList<String[]>> informacoes;
	ArrayList<String[]> dados;
	ArrayList<String[]> dadosFundamentalFinais;
	ArrayList<String[]> dadosFundamentalIniciais;
	ArrayList<String[]> dadosMedio;
	private String valores[];


	@Before
	public void setUp() throws Exception {
		
		// Objetos utilizados para realizar os testes
		dados = new ArrayList<String[]>();
		dadosFundamentalFinais = new ArrayList<String[]>();
		dadosFundamentalIniciais = new ArrayList<String[]>();
		dadosMedio = new ArrayList<String[]>();
				
		informacoes = new HashMap<String, ArrayList<String[]>>();
		estado = new Estado();
		valores = new String[2];
		
		
		valores[0] = "1998";
		valores[1] ="3000";
		
		String[] idebs1 = {"2000","2.5"};
		String[] idebs2 = {"2000","3.7"};
		String[] idebs3 = {"2000","4.1"};
		
		dados.add(valores);
		dadosFundamentalFinais.add(idebs1);
		dadosFundamentalIniciais.add(idebs2);
		dadosMedio.add(idebs3);
		
		informacoes.put("valor_investido", dados);
		informacoes.put("numero_projetos", dados);
		informacoes.put("participacao_estadual_pib", dados);
		informacoes.put("5a_8a",dadosFundamentalFinais);
		informacoes.put("series_iniciais",dadosFundamentalIniciais);
		informacoes.put("ensino_medio",dadosMedio);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValorInvestidoCienciaTecnologia() {

		double[] valores;	
		estado.setValorInvestidoCienciaTecnologia(informacoes);
		
		valores = estado.getValorInvestidoCienciaTecnologia();

		
		assertEquals(valores[0], 3000, 0.00001);
	}
	
	@Test
	public void testNumeroDeProjetosCienciaTecnologia() {

		int[] valores;	
		estado.setNumeroDeProjetosCienciaTecnologia(informacoes);
		
		valores = estado.getNumeroDeProjetosCienciaTecnologia();

		assertEquals(valores[0], 3000, 0.00001);
	}
	
	@Test
	public void testParticipacaoPercentualPIB() {

		double[] valores;	
		estado.setParticipacaoPercentualPIB(informacoes);
		
		valores = estado.getParticipacaoPercentualPIB();

		assertEquals(valores[0], 3000, 0.00001);
	}
	
	@Test
	public void testIdeb(){
		Ideb[] idebs;
		estado.setIdebs(informacoes);
		
		idebs = estado.getIdebs();
		
	assertEquals(2.5,idebs[0].getFundamental(), 0.00001);
	assertEquals(3.7,idebs[0].getSeriesIniciais(),0.00001);
	assertEquals(4.1,idebs[0].getMedio(),0.00001);
	}
}
