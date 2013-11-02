package com.mdsgpp.eef.testes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mdsgpp.eef.modelo.Estado;
import com.mdsgpp.eef.modelo.Ideb;

public class IdebTeste {

	private Ideb ideb;
	private Estado estado;
	private double seriesIniciais, fundamental, medio;
	
	@Before
	public void setUp() throws Exception {
		this.ideb = new Ideb();
		this.estado = new Estado();
		
		this.seriesIniciais = 1.5;
		this.fundamental = 2.3;
		this.medio = 1.9;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSeriesIniciais() {
		double seriesIniciasAtual;
		
		this.ideb.setSeriesIniciais(this.seriesIniciais);
		seriesIniciasAtual = this.ideb.getSeriesIniciais();
		
		assertEquals(this.seriesIniciais, seriesIniciasAtual, 0.0);
	}

	@Test
	public void testFundamental() {
		double fundamentalAtual;
		
		this.ideb.setFundamental(this.fundamental);
		fundamentalAtual = this.ideb.getFundamental();
		
		assertEquals(this.fundamental, fundamentalAtual, 0.0);
	}
	
	@Test
	public void testMedio() {
		double medioAtual;
		
		this.ideb.setMedio(this.medio);
		medioAtual = this.ideb.getMedio();
		
		assertEquals(this.medio, medioAtual, 0.0);
	}
	
	@Test
	public void testEstado() {
		Estado estadoAtual;
		
		this.ideb.setEstado(estado);
		estadoAtual = this.ideb.getEstado();
		
		assertEquals(this.estado, estadoAtual);
	}
}
