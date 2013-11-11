package com.mdsgpp.eef.testes;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import android.test.AndroidTestCase;

import com.mdsgpp.eef.modelo.Estado;
import com.mdsgpp.eef.modelo.Projeto;

public class ProjetoTeste extends AndroidTestCase {

	private Projeto projeto;
	private Estado estado;
	private int quantidade;
	private double valor;
	private int ano;
	
	@Before
	public void setUp() throws Exception {
		this.estado = new Estado();
		this.projeto = new Projeto();
		this.quantidade = 10;
		this.valor = 10000.50;
		this.ano = 1990;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValor() {
		double valorAtual;
		
		this.projeto.setValor(this.valor);
		valorAtual = this.projeto.getValor();
		
		assertEquals(this.valor, valorAtual, 0.0);
	}
	
	@Test
	public void testQuantidade() {
		int quantidadeAtual;
		
		this.projeto.setQuantidade(this.quantidade);
		quantidadeAtual = this.projeto.getQuantidade();
		
		assertEquals(this.quantidade, quantidadeAtual);
	}
	
	@Test
	public void testEstado() {
		Estado estadoAtual;
		
		this.projeto.setEstado(this.estado);
		estadoAtual = this.projeto.getEstado();
		
		assertEquals(this.estado, estadoAtual);
	}
	@Test
	public void testAno() {
		int anoAtual;
		
		this.projeto.setAno(this.ano);
		anoAtual = this.projeto.getAno();
		
		assertEquals(this.ano, anoAtual);
	}

}
