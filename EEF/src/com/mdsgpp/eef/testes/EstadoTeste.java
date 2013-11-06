package com.mdsgpp.eef.testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mdsgpp.eef.modelo.Estado;
import com.mdsgpp.eef.modelo.Ideb;
import com.mdsgpp.eef.modelo.Media;
import com.mdsgpp.eef.modelo.Projeto;

// Classe de testes referentes a classe Estado do modelo

public class EstadoTeste {

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
	private String valores[];
	
	@Before
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
		
		informacoes = new HashMap<String, ArrayList<String[]>>();
		estado = new Estado();
		valores = new String[2];
		
		valores[0] = "1998";
		valores[1] ="3000";
		
		
		String[] idebs1 = {"2000","2.5"};
		String[] idebs2 = {"2000","3.7"};
		String[] idebs3 = {"2000","4.1"};
		String[] PrimeirosProjetos1 = {"2001","10"};
		String[] PrimeirosProjetos2 = {"2001","10000.50"};
		String[] ProjetosInct1 = {"2001","10"};
		String[] ProjetosInct2 ={"2001","10000.50"};
		String[] ProjetosCnpq1 = {"2001","10"};
		String[] ProjetosCnpq2 ={"2001","10000.50"};
		String[] JovensPesquisadores1 = {"2001","10"};
		String[] JovensPesquisadores2 ={"2001","10000.50"};
		
		dados.add(valores);
		dadosFundamentalFinais.add(idebs1);
		dadosFundamentalIniciais.add(idebs2);
		dadosMedio.add(idebs3);
		dadosProjetos.add(PrimeirosProjetos1);
		dadosValores.add(PrimeirosProjetos2);
		dadosProjetosInct.add(ProjetosInct1);
		dadosValoresInct.add(ProjetosInct2);
		dadosProjetosCnpq.add(ProjetosCnpq1);
		dadosValoresCnpq.add(ProjetosCnpq2);
		dadosJovensPesquisadores.add(JovensPesquisadores1);
		dadosValoresJovensPesquisadores.add(JovensPesquisadores2);
		
		
		
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
	
	
	}

	@After
	public void tearDown() throws Exception {
	}

	/*@Test
	public void testValorInvestidoCienciaTecnologia() {

		double[] valores;	
		estado.setValorInvestidoCienciaTecnologia(informacoes);
		
		valores = estado.getValorInvestidoCienciaTecnologia();

		
		assertEquals(valores[0], 3000, 0.00001);
	}
	
	@Test
	public void testNumeroDeProjetosCienciaTecnologia() {

		int[] valores;	
		estado.setNumeroDeProjetosCienciaTecnologia(informacoes);
		
		valores = estado.getNumeroDeProjetosCienciaTecnologia();

		assertEquals(valores[0], 3000, 0.00001);
	}*/
	
	@Test
	public void testParticipacaoPercentualPIB() {

		double[] valores;	
		estado.setParticipacaoPercentualPIB(informacoes);
		
		valores = estado.getParticipacaoPercentualPIB();

		assertEquals(valores[0], 3000, 0.00001);
	}
	
	@Test
	public void testIdeb(){
		Ideb[] idebs;
		estado.setIdebs(informacoes);
		
		idebs = estado.getIdebs();
		
		assertEquals(2.5,idebs[0].getFundamental(), 0.00001);
		assertEquals(3.7,idebs[0].getSeriesIniciais(),0.00001);
		assertEquals(4.1,idebs[0].getMedio(),0.00001);
	}
	 
	@Test
	public void testProjeto(){
		Projeto[] PrimeirosProjetos;
		estado.setPrimeirosProjetos(informacoes);
		PrimeirosProjetos = estado.getPrimeirosProjetos();
		assertEquals(10,PrimeirosProjetos[0].getQuantidade());
		assertEquals(10000.50,PrimeirosProjetos[0].getValor(),0.00001);
		
	}
	
	
	@Test
	public void testProjetosInct(){
		Projeto[] ProjetosInct;
		estado.setProjetosInct(informacoes);
		ProjetosInct = estado.getProjetosInct();
		assertEquals(10,ProjetosInct[0].getQuantidade());
		assertEquals(10000.50,ProjetosInct[0].getValor(),0.00001);
		}
	
	@Test
	public void testProjetosApoioCnpq(){
		Projeto[] ProjetosApoioCnpq;
		estado.setProjetosApoioCnpq(informacoes);
		ProjetosApoioCnpq = estado.getProjetosApoioCnpq();
		assertEquals(10,ProjetosApoioCnpq[0].getQuantidade());
		assertEquals(10000.50,ProjetosApoioCnpq[0].getValor(),0.00001);
	}
	@Test
	public void testProjetoJovensPesquisadores(){
		Projeto[] ProjetoJovensPesquisadores;
		estado.setProjetoJovensPesquisadores(informacoes);
		ProjetoJovensPesquisadores = estado.getProjetoJovensPesquisadores();
		assertEquals(10,ProjetoJovensPesquisadores[0].getQuantidade());
		assertEquals(10000.50,ProjetoJovensPesquisadores[0].getValor(),0.00001);
	}
}
	

