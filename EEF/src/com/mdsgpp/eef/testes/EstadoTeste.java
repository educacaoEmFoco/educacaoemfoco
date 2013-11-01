package com.mdsgpp.eef.testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mdsgpp.eef.modelo.Estado;

// Classe de testes referentes a classe Estado do modelo

public class EstadoTeste {

	private Estado estado;
	private HashMap<String, ArrayList<String[]>> informacoes;
	ArrayList<String[]> dados;
	private String valores[];
	
	@Before
	public void setUp() throws Exception {
		
		// Objetos utilizados para realizar os testes
		dados = new ArrayList<String[]>();
		informacoes = new HashMap<String, ArrayList<String[]>>();
		estado = new Estado();
		valores = new String[2];
		
		valores[0] = "1998";
		valores[1] ="3000";
		
		dados.add(valores);
		
		informacoes.put("valor_investido", dados);
		informacoes.put("numero_projetos", dados);
		informacoes.put("participacao_estadual_pib", dados);
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

}
