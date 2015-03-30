package com.mdsgpp.eef.testes;


import android.test.AndroidTestCase;

import com.mdsgpp.eef.modelo.Estado;
import com.mdsgpp.eef.modelo.Media;

public class MediaTeste extends AndroidTestCase {

	private Media media;
	private Estado estado;
	private double ensinoFundamental, ensinoMedio;
	private int ano;
	
	public void setUp() throws Exception {
		this.media = new Media();
		this.estado = new Estado();
		
		this.ensinoFundamental = 450.00;
		this.ensinoMedio = 90.90;
		this.ano = 2006;
	}
	
	public void tearDown() throws Exception {
		// Do nothing.
	}
	
	public void testAnosFinais() {
		double anosFinaisAtual;
		
		this.media.setEnsinoFundamental(this.ensinoFundamental);
		anosFinaisAtual = this.media.getEnsinoFundamental();
		
		assertEquals(this.ensinoFundamental, anosFinaisAtual, 0.0);
	}
	
	public void testTotalMedio() {
		double totalMedioAtual;
		
		this.media.setEnsinoMedio(this.ensinoMedio);
		totalMedioAtual = this.media.getEnsinoMedio();
		
		assertEquals(this.ensinoMedio, totalMedioAtual, 0.0);
	}
	
	public void testEstado() {
		Estado estadoAtual;
		
		this.media.setEstado(this.estado);
		estadoAtual = this.media.getEstado();
		
		assertEquals(this.estado, estadoAtual);
	}
	
	public void testAno() {
		int anoAtual;
		
		this.media.setAno(this.ano);
		anoAtual = this.media.getAno();
		
		assertEquals(this.ano, anoAtual);
	}
}
