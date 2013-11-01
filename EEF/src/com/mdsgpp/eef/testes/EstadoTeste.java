package com.mdsgpp.eef.testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mdsgpp.eef.modelo.Estado;

public class EstadoTeste {

	private Estado estado;
	private HashMap<String, ArrayList<String[]>> informacoes;
	ArrayList<String[]> dados;
	private String valores[];
	
	@Before
	public void setUp() throws Exception {
		
		dados = new ArrayList<String[]>();
		informacoes = new HashMap<String, ArrayList<String[]>>();
		estado = new Estado();
		valores = new String[2];
		
		valores[0] = "1998";
		valores[1] ="3000";
		
		dados.add(valores);
		
		informacoes.put("valor_investido", dados);
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

}
