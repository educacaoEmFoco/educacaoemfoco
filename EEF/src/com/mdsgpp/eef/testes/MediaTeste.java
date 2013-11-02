package com.mdsgpp.eef.testes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mdsgpp.eef.modelo.Estado;
import com.mdsgpp.eef.modelo.Media;

public class MediaTeste {

	private Media media;
	private Estado estado;
	private double creche, preEscola, anosIniciais, anosFinais, totalMedio, medioNaoSeriado;
	
	@Before
	public void setUp() throws Exception {
		this.media = new Media();
		this.estado = new Estado();
		
		this.creche = 200.50;
		this.preEscola = 300.30;
		this.anosIniciais = 450.00;
		this.anosFinais = 210.21;
		this.totalMedio = 90.90;
		this.medioNaoSeriado = 105.17;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreche() {
		double crecheAtual;
		
		this.media.setCreche(this.creche);
		crecheAtual = this.media.getCreche();
		
		assertEquals(this.creche, crecheAtual, 0.0);
	}
	
	@Test
	public void testPreEscola() {
		double preEscolaAtual;
		
		this.media.setPreEscola(this.preEscola);
		preEscolaAtual = this.media.getPreEscola();
		
		assertEquals(this.preEscola, preEscolaAtual, 0.0);
	}
	
	@Test
	public void testAnosIniciais() {
		double anosIniciaisAtual;
		
		this.media.setAnosIniciais(this.anosIniciais);
		anosIniciaisAtual = this.media.getAnosIniciais();
		
		assertEquals(this.anosIniciais, anosIniciaisAtual, 0.0);
	}
	
	@Test
	public void testAnosFinais() {
		double anosFinaisAtual;
		
		this.media.setAnosFinais(this.anosFinais);
		anosFinaisAtual = this.media.getAnosFinais();
		
		assertEquals(this.anosFinais, anosFinaisAtual, 0.0);
	}
	
	@Test
	public void testTotalMedio() {
		double totalMedioAtual;
		
		this.media.setTotalMedio(this.totalMedio);
		totalMedioAtual = this.media.getTotalMedio();
		
		assertEquals(this.totalMedio, totalMedioAtual, 0.0);
	}
	
	@Test
	public void testMedioNaoSeriado() {
		double medioNaoSeriadoAtual;
		
		this.media.setMedioNaoSeriado(this.medioNaoSeriado);
		medioNaoSeriadoAtual = this.media.getMedioNaoSeriado();
		
		assertEquals(this.medioNaoSeriado, medioNaoSeriadoAtual, 0.0);
	}
	
	@Test
	public void testEstado() {
		Estado estadoAtual;
		
		this.media.setEstado(this.estado);
		estadoAtual = this.media.getEstado();
		
		assertEquals(this.estado, estadoAtual);
	}

}
