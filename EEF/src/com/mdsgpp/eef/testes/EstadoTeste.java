package com.mdsgpp.eef.testes;


import java.util.ArrayList;
import java.util.HashMap;

import android.test.AndroidTestCase;

import com.mdsgpp.eef.modelo.Estado;
import com.mdsgpp.eef.modelo.Ideb;
import com.mdsgpp.eef.modelo.Projeto;

// Classe de testes referentes a classe Estado do modelo

public class EstadoTeste extends AndroidTestCase {

	private Estado estado;
	private HashMap<String, ArrayList<String[]>> informacoes;
	ArrayList<String[]> dados;
	ArrayList<String[]> dadosFundamentalFinais;
	ArrayList<String[]> dadosFundamentalIniciais;
	ArrayList<String[]> dadosMedio;
	ArrayList<String[]> dadosProjetos;
	ArrayList<String[]> dadosValores;
	ArrayList<String[]> dadosProjetosInct;
	ArrayList<String[]> dadosValoresInct;
	ArrayList<String[]> dadosProjetosCnpq;
	ArrayList<String[]> dadosValoresCnpq;
	ArrayList<String[]> dadosJovensPesquisadores;
	ArrayList<String[]> dadosValoresJovensPesquisadores;
	ArrayList<String[]> dadosProjetosTecnologia;
	ArrayList<String[]> dadosValoresProjetosTecnologia;
	private String valores[];
	
	
	public void setUp() throws Exception {
		
		// Objetos utilizados para realizar os testes
		dados = new ArrayList<String[]>();
		dadosFundamentalFinais = new ArrayList<String[]>();
		dadosFundamentalIniciais = new ArrayList<String[]>();
		dadosMedio = new ArrayList<String[]>();
		dadosProjetos = new ArrayList<String[]>();
		dadosValores = new ArrayList<String[]>();
		dadosProjetosInct = new ArrayList<String[]>();
		dadosValoresInct = new ArrayList<String[]>();
		dadosProjetosCnpq = new ArrayList<String[]>();
		dadosValoresCnpq = 	new ArrayList<String[]>();
		dadosJovensPesquisadores = new ArrayList<String[]>();
		dadosValoresJovensPesquisadores = new ArrayList<String[]>();
		dadosProjetosTecnologia = new ArrayList<String[]>();
		dadosValoresProjetosTecnologia= new ArrayList<String[]>();
		
		informacoes = new HashMap<String, ArrayList<String[]>>();
		estado = new Estado();
		valores = new String[2];
		
		valores[0] = "1998";
		valores[1] ="3000";
		
		
		String[] idebs1 = {"2000","2.5"};
		String[] idebs2 = {"2000","3.7"};
		String[] idebs3 = {"2000","4.1"};
		String[] primeirosProjetos1 = {"2001","10"};
		String[] primeirosProjetos2 = {"2001","10000.50"};
		String[] projetosInct1 = {"2001","10"};
		String[] projetosInct2 ={"2001","10000.50"};
		String[] projetosCnpq1 = {"2001","10"};
		String[] projetosCnpq2 ={"2001","10000.50"};
		String[] jovensPesquisadores1 = {"2001","10"};
		String[] jovensPesquisadores2 ={"2001","10000.50"};
		String[] projetosTecnologia1 = {"2001","10"};
		String[] projetosTecnologia2 ={"2001","10000.50"};
		
		dados.add(valores);
		dadosFundamentalFinais.add(idebs1);
		dadosFundamentalIniciais.add(idebs2);
		dadosMedio.add(idebs3);
		dadosProjetos.add(primeirosProjetos1);
		dadosValores.add(primeirosProjetos2);
		dadosProjetosInct.add(projetosInct1);
		dadosValoresInct.add(projetosInct2);
		dadosProjetosCnpq.add(projetosCnpq1);
		dadosValoresCnpq.add(projetosCnpq2);
		dadosJovensPesquisadores.add(jovensPesquisadores1);
		dadosValoresJovensPesquisadores.add(jovensPesquisadores2);
		dadosProjetosTecnologia.add(projetosTecnologia1);
		dadosValoresProjetosTecnologia.add(projetosTecnologia2);
		
		
		informacoes.put("populacao", dados);
		informacoes.put("valor_investido", dados);
		informacoes.put("numero_projetos", dados);
		informacoes.put("participacao_estadual_pib", dados);
		informacoes.put("5a_8a",dadosFundamentalFinais);
		informacoes.put("series_iniciais",dadosFundamentalIniciais);
		informacoes.put("ensino_medio",dadosMedio);
		informacoes.put("programa_primeiros_projetos",dadosProjetos);
		informacoes.put("valores_programa_primeiros_projetos",dadosValores);
		informacoes.put("projetos_inct",dadosProjetosInct);
		informacoes.put("valores_projetos_inct",dadosValoresInct);
		informacoes.put("projetos_apoio_pesquisa_cnpq",dadosProjetosCnpq);
		informacoes.put("valores_projetos_apoio_pesquisa_cnpq",dadosValoresCnpq);
		informacoes.put("jovens_pesquisadores",dadosJovensPesquisadores);
		informacoes.put("valores_jovens_pesquisadores",dadosValoresJovensPesquisadores);
		informacoes.put("numero_projetos",dadosProjetosTecnologia);
		informacoes.put("valor_investido",dadosValoresProjetosTecnologia);
	
	
	}

	
	public void tearDown() throws Exception {
	}

	
	public void testNome(){
		String nome;
		estado.setNome("Acre");
		
		nome = estado.getNome();
		
		assertEquals("Acre",nome);
		
	}
	

	public void testSigla(){
		String sigla;
		estado.setSigla("AC");
		
		sigla = estado.getSigla();
		
		assertEquals("AC", sigla);
		
	}
	

	public void testPopulacao(){
		int valores;
		estado.setPopulacao(informacoes);
		
		valores = estado.getPopulacao();
		
		assertEquals(valores, 3000, 0.00001);
		
	}

	
	
	public void testParticipacaoPercentualPIB() {

		double[] valores;	
		estado.setParticipacaoPercentualPIB(informacoes);
		
		valores = estado.getParticipacaoPercentualPIB();

		assertEquals(valores[0], 3000, 0.00001);
	}
	

	public void testIdeb(){
		Ideb[] idebs;
		estado.setIdebs(informacoes);
		
		idebs = estado.getIdebs();
		
		assertEquals(2.5,idebs[0].getFundamental(), 0.00001);
		assertEquals(3.7,idebs[0].getSeriesIniciais(),0.00001);
		assertEquals(4.1,idebs[0].getMedio(),0.00001);
	}
	 
	
	public void testProjetoCienciaTecnologia(){
		Projeto[] ProjetosTecnologia;
		estado.setProjetosCienciaTecnologia(informacoes);
		ProjetosTecnologia = estado.getProjetosCienciaTecnologia();
		assertEquals(10,ProjetosTecnologia[0].getQuantidade());
		assertEquals(10000.50,ProjetosTecnologia[0].getValor(),0.00001);
		}
	
	
	public void testPrimeirosProjetos(){
		Projeto[] PrimeirosProjetos;
		estado.setPrimeirosProjetos(informacoes);
		PrimeirosProjetos = estado.getPrimeirosProjetos();
		assertEquals(10,PrimeirosProjetos[0].getQuantidade());
		assertEquals(10000.50,PrimeirosProjetos[0].getValor(),0.00001);
		
	}
	
	
	
	public void testProjetosInct(){
		Projeto[] ProjetosInct;
		estado.setProjetosInct(informacoes);
		ProjetosInct = estado.getProjetosInct();
		assertEquals(10,ProjetosInct[0].getQuantidade());
		assertEquals(10000.50,ProjetosInct[0].getValor(),0.00001);
		}
	
	
	public void testProjetosApoioCnpq(){
		Projeto[] ProjetosApoioCnpq;
		estado.setProjetosApoioCnpq(informacoes);
		ProjetosApoioCnpq = estado.getProjetosApoioCnpq();
		assertEquals(10,ProjetosApoioCnpq[0].getQuantidade());
		assertEquals(10000.50,ProjetosApoioCnpq[0].getValor(),0.00001);
	}
	
	public void testProjetoJovensPesquisadores(){
		Projeto[] ProjetoJovensPesquisadores;
		estado.setProjetoJovensPesquisadores(informacoes);
		ProjetoJovensPesquisadores = estado.getProjetoJovensPesquisadores();
		assertEquals(10,ProjetoJovensPesquisadores[0].getQuantidade());
		assertEquals(10000.50,ProjetoJovensPesquisadores[0].getValor(),0.00001);
	}
}
	

