package com.mdsgpp.eef.tests;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;

import com.mdsgpp.eef.controle.EstadoControle;

import android.test.AndroidTestCase;

public class EstadoControleTeste extends AndroidTestCase {

	private HashMap<String, String> informacoes;
	private HashMap<String, String> informacoesCompletas;
	private EstadoControle instancia;
	private EstadoControle instancia2;
	private EstadoControle instancia3;
	private DecimalFormat dfValor = new DecimalFormat("#,##0.00");
	private DecimalFormat dfPopulacao = new DecimalFormat("#,###");
	private DecimalFormat dfPorcentagem = new DecimalFormat("#.##");
	
	public void setUp() throws Exception {
		instancia = new EstadoControle(getContext());
		
		instancia = EstadoControle.getInstancia(getContext());
		informacoes = new HashMap<String, String>();
		informacoesCompletas =  new HashMap<String, String>();
		
		instancia2 = EstadoControle.getInstancia(getContext());
		instancia3 = EstadoControle.getInstancia(getContext());
		
		this.informacoes.put("sigla", "AC");
		this.informacoes.put("nome", "Acre");
		this.informacoes.put("populacao", dfPopulacao.format(691132) + " habitantes");
		this.informacoes.put("percentual_participacao_pib", 
			dfPorcentagem.format(0.200000000000045) + "%");
		this.informacoes.put("projetos_ciencia_tecnologia", "Quantidade: " + 3 + " projetos");
		this.informacoes.put("valor_ciencia_tecnologia", "Valor investido: R$ " 
			+ dfValor.format(563681.899999976) + " (em mil)");
		this.informacoes.put("ideb_fundamental_final", "Ensino Fundamental (séries finais): " 
			+ dfPorcentagem.format(4.09999999999854));
		this.informacoes.put("ideb_ensino_medio", "Ensino Médio: " + dfPorcentagem.format(3.5) 
			+ "" );	
		this.informacoes.put("ideb_fundamental_inicial", "Ensino Fundamental (Séries iniciais): " 
			+ dfPorcentagem.format(4.5) + "");
		this.informacoes.put("quantidade_primeiros_projetos", "Quantidade: " + 2 + " projetos");
		this.informacoes.put("valor_primeiros_projetos", "Valor investido: R$ " 
			+ dfValor.format(55.4400000000023) + " (em mil)");
		this.informacoes.put("quantidade_projeto_cnpq", "Quantidade: " + 133 + " projetos");
		this.informacoes.put("valor_projetos_cnpq", "Valor investido: R$ " 
			+ dfValor.format( 1905.13000000053 ) + " (em mil)");
		this.informacoes.put("quantidade_projeto_jovens_pesquisadores", "Quantidade: " + 3 
			+ " projetos");
		this.informacoes.put("valor_projetos_jovens_pesquisadores", "Valor investido: R$ " 
			+ dfValor.format( 138.250000000029 ) + " (em mil)");
		
		this.informacoesCompletas.put("sigla", "AC");
		this.informacoesCompletas.put("nome", "Acre");
		this.informacoesCompletas.put("populacao", dfPopulacao.format(691132) + " habitantes");
	}

	public void tearDown() throws Exception {
		//Do nothing.
	}

	public void testLerEstado() throws IOException {
		assertEquals(this.informacoes.get("nome"), 
			EstadoControle.getInstancia(getContext()).lerEstado(0).get("nome"));

		assertEquals(this.informacoes.get("sigla"), 
			EstadoControle.getInstancia(getContext()).lerEstado(0).get("sigla"));

		assertEquals(this.informacoes.get("populacao"), 
			EstadoControle.getInstancia(getContext()).lerEstado(0).get("populacao"));

		assertEquals(this.informacoes.get("percentual_participacao_pib"), 
			EstadoControle.getInstancia(getContext()).lerEstado(0).get
				("percentual_participacao_pib"));
		
		assertEquals(this.informacoes.get("projetos_ciencia_tecnologia"), 
			EstadoControle.getInstancia(getContext()).lerEstado(0).get
				("projetos_ciencia_tecnologia"));
		
		assertEquals(this.informacoes.get("ideb_fundamental_final"), 
			EstadoControle.getInstancia(getContext()).lerEstado(0).get("ideb_fundamental_final"));
		
		assertEquals(this.informacoes.get("ideb_ensino_medio"), 
			EstadoControle.getInstancia(getContext()).lerEstado(0).get("ideb_ensino_medio"));
		
		assertEquals(this.informacoes.get("ideb_fundamental_inicial"), 
			EstadoControle.getInstancia(getContext()).lerEstado(0).get("ideb_fundamental_inicial"));

		assertEquals(this.informacoes.get("quantidade_primeiros_projetos"), 
			EstadoControle.getInstancia(getContext()).lerEstado(0).get
				("quantidade_primeiros_projetos"));

		assertEquals(this.informacoes.get("valor_primeiros_projetos"), 
			EstadoControle.getInstancia(getContext()).lerEstado(0).get("valor_primeiros_projetos"));

		assertEquals(this.informacoes.get("quantidade_projeto_cnpq"), 
			EstadoControle.getInstancia(getContext()).lerEstado(0).get("quantidade_projeto_cnpq"));

		assertEquals(this.informacoes.get("valor_projetos_cnpq"), 
			EstadoControle.getInstancia(getContext()).lerEstado(0).get("valor_projetos_cnpq"));

		assertEquals(this.informacoes.get("quantidade_projeto_jovens_pesquisadores"), 
			EstadoControle.getInstancia(getContext()).lerEstado(0).get
				("quantidade_projeto_jovens_pesquisadores"));

		assertEquals(this.informacoes.get("valor_projetos_jovens_pesquisadores"), 
			EstadoControle.getInstancia(getContext()).lerEstado(0).get
				("valor_projetos_jovens_pesquisadores"));
	}
	
	public void testLerEstadoCompleto() throws IOException {
		assertEquals(this.informacoesCompletas.get("nome"), 
			EstadoControle.getInstancia(getContext()).lerEstadoCompleto(0).get("nome"));

		assertEquals(this.informacoesCompletas.get("sigla"), 
			EstadoControle.getInstancia(getContext()).lerEstadoCompleto(0).get("sigla"));
		
		assertEquals(this.informacoesCompletas.get("populacao"), 
			EstadoControle.getInstancia(getContext()).lerEstadoCompleto(0).get("populacao"));
	}

	public void testInstancia() throws IOException {
		assertEquals(instancia, instancia2);
		assertEquals(instancia, instancia3);
	}
}
