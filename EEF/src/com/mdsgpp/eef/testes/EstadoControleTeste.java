package com.mdsgpp.eef.testes;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import  org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mdsgpp.eef.controle.EstadoControle;
import com.mdsgpp.eef.parse.DadosParse;

import android.test.AndroidTestCase;

public class EstadoControleTeste extends AndroidTestCase{
	
	private HashMap<String, String> informacoesEstado;
	private EstadoControle instancia;
	private DecimalFormat dfValor = new DecimalFormat("#,##0.00");
	private DecimalFormat dfPopulação = new DecimalFormat("#,###");
	private DecimalFormat dfPorcentagem = new DecimalFormat("#.##");


	@Before
	public void setUp() throws Exception {
		instancia = new EstadoControle(getContext());
		
		informacoesEstado = new HashMap<String, String>();

		this.informacoesEstado.put("sigla", "AC");
		this.informacoesEstado.put("nome", "Acre");
		this.informacoesEstado.put("populacao",  dfPopulação.format(691132) + "habitantes");
		this.informacoesEstado.put("percentual_participacao_pib", dfPorcentagem.format("0,200000000000045")+ "%");
		this.informacoesEstado.put("projetos_ciencia_tecnologia","Quantidade: " + 3 + " projetos" );
		this.informacoesEstado.put("valor_ciencia_tecnologia", "Valor investido: R$ " + dfValor.format("563681,899999976") + " (em mil)" );
		this.informacoesEstado.put("ideb_fundamental_final", "Ensino Fundamental (séries finais): "+ dfPorcentagem.format(" 4,09999999999854") );
		this.informacoesEstado.put("ideb_ensino_medio", "Ensino Médio: " +dfPorcentagem.format("3,5") + "%" );
		this.informacoesEstado.put("ideb_fundamental_inicial", "Ensino Fundamental (Séries iniciais): " + dfPorcentagem.format("4,5") + "");
		this.informacoesEstado.put("quantidade_primeiros_projetos","Quantidade: "+ 2 + " projetos");
		this.informacoesEstado.put("valor_primeiros_projetos","Valor investido: R$ "+ dfValor.format("55,4400000000023") + " (em mil)");
		this.informacoesEstado.put("quantidade_projeto_cnpq","Quantidade: " + 133 + " projetos");
		this.informacoesEstado.put("valor_projetos_cnpq","Valor investido: R$ " + dfValor.format("1905,13000000053") + " (em mil)");
		this.informacoesEstado.put("quantidade_projeto_jovens_pesquisadores","Quantidade: " + 3 + " projetos");
		this.informacoesEstado.put("valor_projetos_jovens_pesquisadores","Valor investido: R$ " + dfValor.format("138,250000000029") + " (em mil)");
		this.informacoesEstado.put("quantidade_projetos_inct","Quantidade: " +  93  + " projetos");
		this.informacoesEstado.put( "valor_projetos_inct","Valor investido: R$ " + dfValor.format("61025,1700000018") + " (em mil)");
		
	}
		
	

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void testLerEstado() throws IOException {
		
		assertEquals(this.informacoesEstado.get("sigla"),EstadoControle.getInstancia(getContext()).lerEstado(0).get("sigla"));
		assertEquals(this.informacoesEstado.get("nome"),EstadoControle.getInstancia(getContext()).lerEstado(0).get("nome"));
		assertEquals(this.informacoesEstado.get("populacao"),EstadoControle.getInstancia(getContext()).lerEstado(0).get("populacao"));
		assertEquals(this.informacoesEstado.get("percentual_participacao_pib"),EstadoControle.getInstancia(getContext()).lerEstado(0).get("percentual_participacao_pib"));
		assertEquals(this.informacoesEstado.get("projetos_ciencia_tecnologia"),EstadoControle.getInstancia(getContext()).lerEstado(0).get("projetos_ciencia_tecnologia"));
		assertEquals(this.informacoesEstado.get("valor_ciencia_tecnologia"),EstadoControle.getInstancia(getContext()).lerEstado(0).get("valor_ciencia_tecnologia"));
		assertEquals(this.informacoesEstado.get("ideb_fundamental_final"),EstadoControle.getInstancia(getContext()).lerEstado(0).get("ideb_fundamental_final"));
		assertEquals(this.informacoesEstado.get("ideb_ensino_medio"),EstadoControle.getInstancia(getContext()).lerEstado(0).get("ideb_fundamental_final"));
		assertEquals(this.informacoesEstado.get("ideb_fundamental_inicial"),EstadoControle.getInstancia(getContext()).lerEstado(0).get("ideb_fundamental_inicial"));
		assertEquals(this.informacoesEstado.get("quantidade_primeiros_projetos"),EstadoControle.getInstancia(getContext()).lerEstado(0).get("quantidade_primeiros_projetos"));
		assertEquals(this.informacoesEstado.get("valor_primeiros_projetos"),EstadoControle.getInstancia(getContext()).lerEstado(0).get("valor_primeiros_projetos"));
		assertEquals(this.informacoesEstado.get("quantidade_projeto_cnpq"),EstadoControle.getInstancia(getContext()).lerEstado(0).get("quantidade_projeto_cnpq"));
		assertEquals(this.informacoesEstado.get("quantidade_projeto_jovens_pesquisadores"),EstadoControle.getInstancia(getContext()).lerEstado(0).get("quantidade_projeto_jovens_pesquisadores"));
		
		
		
	}

}
