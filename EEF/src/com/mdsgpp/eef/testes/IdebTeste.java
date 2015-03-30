package com.mdsgpp.eef.testes;


import android.test.AndroidTestCase;

import com.mdsgpp.eef.modelo.Estado;
import com.mdsgpp.eef.modelo.Ideb;

public class IdebTeste extends AndroidTestCase {

	private Ideb ideb;
	private Estado estado;
	private double seriesIniciais, fundamental, medio;
	private int ano;
	
	public void setUp() throws Exception {
		this.ideb = new Ideb();
		this.estado = new Estado();
		
		this.seriesIniciais = 1.5;
		this.fundamental = 2.3;
		this.medio = 1.9;
		this.ano = 1990;
	}
	
	public void tearDown() throws Exception {
		// Do nothing.
	}
	
	public void testSeriesIniciais() {
		double seriesIniciasAtual;
		
		this.ideb.setSeriesIniciais(this.seriesIniciais);
		seriesIniciasAtual = this.ideb.getSeriesIniciais();
		
		assertEquals(this.seriesIniciais, seriesIniciasAtual, 0.0);
	}

	public void testFundamental() {
		double fundamentalAtual;
		
		this.ideb.setFundamental(this.fundamental);
		fundamentalAtual = this.ideb.getFundamental();
		
		assertEquals(this.fundamental, fundamentalAtual, 0.0);
	}
	
	public void testMedio() {
		double medioAtual;
		
		this.ideb.setMedio(this.medio);
		medioAtual = this.ideb.getMedio();
		
		assertEquals(this.medio, medioAtual, 0.0);
	}
	
	public void testEstado() {
		Estado estadoAtual;
		
		this.ideb.setEstado(estado);
		estadoAtual = this.ideb.getEstado();
		
		assertEquals(this.estado, estadoAtual);
	}
	
	public void testAno() {
		int anoAtual;
		
		this.ideb.setAno(this.ano);
		anoAtual = this.ideb.getAno();
		
		assertEquals(this.ano, anoAtual);
	}
}
