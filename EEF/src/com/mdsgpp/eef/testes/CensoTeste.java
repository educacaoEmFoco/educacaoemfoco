package com.mdsgpp.eef.testes;


import android.test.AndroidTestCase;

import com.mdsgpp.eef.modelo.Censo;
import com.mdsgpp.eef.modelo.Estado;

public class CensoTeste extends AndroidTestCase {

	private Censo censo;
	private Estado estado;
	private double anosIniciaisFundamental, anosFinaisFundamental, 
		ensinoMedio, fundamentalEJA, medioEJA;
	private int ano;
	
	public void setUp() throws Exception {
		this.censo = new Censo();
		this.estado = new Estado();
		
		this.anosIniciaisFundamental = 87.11;
		this.anosFinaisFundamental = 880.98;
		this.ensinoMedio = 12.23;
		this.fundamentalEJA = 99.90;
		this.medioEJA = 460.21;
		this.ano = 2005;
	}

	public void tearDown() throws Exception {
		// Do nothing.
	}
	
	public void testConstrutorCheio() {
		Censo censoConstruido = new Censo(this.anosIniciaisFundamental, this.anosFinaisFundamental, this.ensinoMedio,
				this.fundamentalEJA, this.medioEJA);
		
		assertEquals(this.anosIniciaisFundamental, censoConstruido.getAnosIniciaisFundamental(), 0.0);
		assertEquals(this.anosFinaisFundamental, censoConstruido.getAnosFinaisFundamental(), 0.0);
		assertEquals(this.ensinoMedio, censoConstruido.getEnsinoMedio(), 0.0);
		assertEquals(this.fundamentalEJA, censoConstruido.getFundamentalEJA(), 0.0);
		assertEquals(this.medioEJA, censoConstruido.getMedioEJA(), 0.0);
	}
	
	public void testAnosIniciaisFundamental() {
		double anosIniciaisFundamentalAtual;
		
		this.censo.setAnosIniciaisFundamental(this.anosIniciaisFundamental);
		anosIniciaisFundamentalAtual = this.censo.getAnosIniciaisFundamental();
		
		assertEquals(this.anosIniciaisFundamental, anosIniciaisFundamentalAtual, 0.0);
	}
	
	public void testAnosFinaisFundamental() {
		double anosFinaisFundamentalAtual;
		
		this.censo.setAnosFinaisFundamental(this.anosFinaisFundamental);
		anosFinaisFundamentalAtual = this.censo.getAnosFinaisFundamental();
		
		assertEquals(this.anosFinaisFundamental, anosFinaisFundamentalAtual, 0.0);
	}
	
	public void testEnsinoMedio() {
		double ensinoMedioAtual;
		
		this.censo.setEnsinoMedio(this.ensinoMedio);
		ensinoMedioAtual = this.censo.getEnsinoMedio();
		
		assertEquals(this.ensinoMedio, ensinoMedioAtual, 0.0);
	}
	
	public void testFundamentalEJA() {
		double fundamentalEjaAtual;
		
		this.censo.setFundamentalEJA(this.fundamentalEJA);
		fundamentalEjaAtual = this.censo.getFundamentalEJA();
		
		assertEquals(this.fundamentalEJA, fundamentalEjaAtual, 0.0);
	}
	
	public void testMediaEJA() {
		double medioEjaAtual;
		
		this.censo.setMedioEJA(this.medioEJA);
		medioEjaAtual = this.censo.getMedioEJA();
		
		assertEquals(this.medioEJA, medioEjaAtual, 0.0);
	}
	
	public void testEstado() {
		Estado estadoAtual;
		
		this.censo.setEstado(this.estado);
		estadoAtual = this.censo.getEstado();
		
		assertEquals(this.estado, estadoAtual);
	}
	
	public void testAno() {
		int anoAtual;
		
		this.censo.setAno(this.ano);
		anoAtual = this.censo.getAno();
		
		assertEquals(this.ano, anoAtual);
	}
}