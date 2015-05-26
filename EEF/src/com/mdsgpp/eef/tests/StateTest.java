package com.mdsgpp.eef.tests;

import java.util.ArrayList;
import java.util.HashMap;

import android.test.AndroidTestCase;

import com.mdsgpp.eef.model.Census;
import com.mdsgpp.eef.model.State;
import com.mdsgpp.eef.model.Ideb;
import com.mdsgpp.eef.model.Project;
import com.mdsgpp.eef.model.Average;

public class StateTest extends AndroidTestCase {

	private State state;
	private HashMap<String, ArrayList<String[]>> informacoes;
	private String valores[];
	
	ArrayList<String[]> dados;
	ArrayList<String[]> dadosFundamentalFinais;
	ArrayList<String[]> dadosFundamentalIniciais;
	ArrayList<String[]> dadosMedio;
	ArrayList<String[]> dadosProjects;
	ArrayList<String[]> dadosValuees;
	ArrayList<String[]> dadosProjectsInct;
	ArrayList<String[]> dadosValueesInct;
	ArrayList<String[]> dadosProjectsCnpq;
	ArrayList<String[]> dadosValueesCnpq;
	ArrayList<String[]> dadosJovensPesquisadores;
	ArrayList<String[]> dadosValueesJovensPesquisadores;
	ArrayList<String[]> dadosProjectsTecnologia;
	ArrayList<String[]> dadosValueesProjectsTecnologia;
	ArrayList<String[]> dadosCensusIniciais;
	ArrayList<String[]> dadosCensusFinais;
	ArrayList<String[]> dadosCensusMedio;
	ArrayList<String[]> dadosCensusEjaFundamental;
	ArrayList<String[]> dadosCensusEjaMedio;
	ArrayList<String[]> dadosAlunosPorTurmaFundamental;
	ArrayList<String[]> dadosAlunosPorTurmaMedio;
	ArrayList<String[]> dadoshorasAulaFundamental;
	ArrayList<String[]> dadoshorasAulaMedio;
	ArrayList<String[]> dadosDistorcaoFundamental;
	ArrayList<String[]> dadosDistorcaoMedio;
	ArrayList<String[]> dadosAprovacaoFundamental;
	ArrayList<String[]> dadosAprovacaoMedio;
	ArrayList<String[]> dadosAbandonoFundamental;
	ArrayList<String[]> dadosAbandonoMedio;
		
	public void setUp() throws Exception {
		dados = new ArrayList<String[]>();
		dadosFundamentalFinais = new ArrayList<String[]>();
		dadosFundamentalIniciais = new ArrayList<String[]>();
		dadosMedio = new ArrayList<String[]>();
		dadosProjects = new ArrayList<String[]>();
		dadosValuees = new ArrayList<String[]>();
		dadosProjectsInct = new ArrayList<String[]>();
		dadosValueesInct = new ArrayList<String[]>();
		dadosProjectsCnpq = new ArrayList<String[]>();
		dadosValueesCnpq = 	new ArrayList<String[]>();
		dadosJovensPesquisadores = new ArrayList<String[]>();
		dadosValueesJovensPesquisadores = new ArrayList<String[]>();
		dadosProjectsTecnologia = new ArrayList<String[]>();
		dadosValueesProjectsTecnologia = new ArrayList<String[]>();
		dadosCensusIniciais = new ArrayList<String[]>();
		dadosCensusFinais = new ArrayList<String[]>();
		dadosCensusMedio = new ArrayList<String[]>();
		dadosCensusEjaFundamental = new ArrayList<String[]>();
		dadosCensusEjaMedio = new ArrayList<String[]>();
		dadosAlunosPorTurmaFundamental = new ArrayList<String[]>();
		dadosAlunosPorTurmaMedio = new ArrayList<String[]>();
		dadoshorasAulaFundamental = new ArrayList<String[]>();
		dadoshorasAulaMedio = new ArrayList<String[]>();
		dadosDistorcaoFundamental = new ArrayList<String[]>();
		dadosDistorcaoMedio = new ArrayList<String[]>();
		dadosAprovacaoFundamental = new ArrayList<String[]>();
		dadosAprovacaoMedio = new ArrayList<String[]>();
		dadosAbandonoFundamental = new ArrayList<String[]>();
		dadosAbandonoMedio = new ArrayList<String[]>();
		
		informacoes = new HashMap<String, ArrayList<String[]>>();
		state = new State();
		valores = new String[2];
		
		valores[0] = "1998";
		valores[1] ="3000";
		
		String[] idebs1 = {"2000","2.5"};
		String[] idebs2 = {"2000","3.7"};
		String[] idebs3 = {"2000","4.1"};
		String[] idebs4 = {"Total","5.5"};
		String[] primeirosProjects1 = {"2001","10"};
		String[] primeirosProjects2 = {"2001","10000.50"};
		String[] primeirosProjects3 = {"Total","11"};
		String[] projetosInct1 = {"2001","10"};
		String[] projetosInct2 ={"2001","10000.50"};
		String[] projetosInct3 ={"2001","11"};
		String[] projetosCnpq1 = {"2001","10"};
		String[] projetosCnpq2 ={"2001","10000.50"};
		String[] projetosCnpq3 = {"2001","11"};
		String[] jovensPesquisadores1 = {"2001","10"};
		String[] jovensPesquisadores3 = {"2001","11"};
		String[] jovensPesquisadores2 ={"2001","10000.50"};
		String[] projetosTecnologia1 = {"2001","10"};
		String[] projetosTecnologia3 = {"2001","11"};
		String[] projetosTecnologia2 ={"2001","10000.50"};
		
		String[] censusIniciais = {"2000", "1000"};
		String[] censusFinais = {"2000", "2000"};
		String[] censusMedio = {"2000", "3000"};
		String[] censusEjaFundamental = {"2000", "4000"};
		String[] censusEjaMedio = {"2000", "5000"};
		
		String[] alunosPorTurmaFundamental = { "2000", "50" };
		String[] alunosPorTurmaMedio = { "2000", "60" };
		String[] horasAulaFundamental = { "2001", "4" };
		String[] horasAulaMedio = { "2001", "5" };
		String[] distorcaoFundamental = { "2002", "15" };
		String[] distorcaoMedio = { "2002", "20" };
		String[] aprovacaoFundamental = { "2003", "95" };
		String[] aprovacaoMedio = { "2003", "80" };
		String[] abandonoFundamental = { "2004", "5" };
		String[] abandonoMedio = { "2004", "20" };
		
		dados.add(valores);
		dadosFundamentalFinais.add(idebs1);
		dadosFundamentalFinais.add(idebs4);
		dadosFundamentalIniciais.add(idebs2);
		dadosFundamentalIniciais.add(idebs4);
		dadosMedio.add(idebs3);
		dadosMedio.add(idebs4);
		dadosProjects.add(primeirosProjects1);
		dadosValuees.add(primeirosProjects2);
		dadosProjects.add(primeirosProjects3);
		dadosValuees.add(primeirosProjects3);
		dadosProjectsInct.add(projetosInct1);
		dadosValueesInct.add(projetosInct2);
		dadosProjectsInct.add(projetosInct3);
		dadosValueesInct.add(projetosInct3);
		dadosProjectsCnpq.add(projetosCnpq1);
		dadosValueesCnpq.add(projetosCnpq2);
		dadosProjectsCnpq.add(projetosCnpq3);
		dadosValueesCnpq.add(projetosCnpq3);
		dadosJovensPesquisadores.add(jovensPesquisadores1);
		dadosValueesJovensPesquisadores.add(jovensPesquisadores2);
		dadosJovensPesquisadores.add(jovensPesquisadores3);
		dadosValueesJovensPesquisadores.add(jovensPesquisadores3);
		dadosProjectsTecnologia.add(projetosTecnologia1);
		dadosValueesProjectsTecnologia.add(projetosTecnologia2);
		dadosProjectsTecnologia.add(projetosTecnologia3);
		dadosValueesProjectsTecnologia.add(projetosTecnologia3);
		
		dadosCensusIniciais.add(censusIniciais);
		dadosCensusFinais.add(censusFinais);
		dadosCensusMedio.add(censusMedio);
		dadosCensusEjaFundamental.add(censusEjaFundamental);
		dadosCensusEjaMedio.add(censusEjaMedio);
		
		dadosAlunosPorTurmaFundamental.add(alunosPorTurmaFundamental);
		dadosAlunosPorTurmaMedio.add(alunosPorTurmaMedio);
		dadoshorasAulaFundamental.add(horasAulaFundamental);
		dadoshorasAulaMedio.add(horasAulaMedio);
		dadosDistorcaoFundamental.add(distorcaoFundamental);
		dadosDistorcaoMedio.add(distorcaoMedio);
		dadosAprovacaoFundamental.add(aprovacaoFundamental);
		dadosAprovacaoMedio.add(aprovacaoMedio);
		dadosAbandonoFundamental.add(abandonoFundamental);
		dadosAbandonoMedio.add(abandonoMedio);
		
		informacoes.put("population", dados);
		informacoes.put("valor_investido", dados);
		informacoes.put("numero_projetos", dados);
		informacoes.put("participacao_estadual_pib", dados);
		informacoes.put("5a_8a",dadosFundamentalFinais);
		informacoes.put("series_iniciais",dadosFundamentalIniciais);
		informacoes.put("ensino_medio",dadosMedio);
		informacoes.put("programa_primeiros_projetos",dadosProjects);
		informacoes.put("valores_programa_primeiros_projetos",dadosValuees);
		informacoes.put("projetos_inct",dadosProjectsInct);
		informacoes.put("valores_projetos_inct",dadosValueesInct);
		informacoes.put("projetos_apoio_pesquisa_cnpq",dadosProjectsCnpq);
		informacoes.put("valores_projetos_apoio_pesquisa_cnpq",dadosValueesCnpq);
		informacoes.put("jovens_pesquisadores",dadosJovensPesquisadores);
		informacoes.put("valores_jovens_pesquisadores",dadosValueesJovensPesquisadores);
		informacoes.put("numero_projetos",dadosProjectsTecnologia);
		informacoes.put("valor_investido",dadosValueesProjectsTecnologia);
		
		informacoes.put("censo_anos_iniciais",dadosCensusIniciais);
		informacoes.put("censo_anos_finais",dadosCensusFinais);
		informacoes.put("censo_ensino_medio",dadosCensusMedio);
		informacoes.put("censo_eja_fundamental",dadosCensusEjaFundamental);
		informacoes.put("censo_eja_medio",dadosCensusEjaMedio);
	
		informacoes.put("alunos_por_turma_ensino_fundamental", dadosAlunosPorTurmaFundamental);
		informacoes.put("alunos_por_turma_ensino_medio", dadosAlunosPorTurmaMedio);
		informacoes.put("horas_aula_ensino_fundamental", dadoshorasAulaFundamental);
		informacoes.put("horas_aula_ensino_medio", dadoshorasAulaMedio);
		informacoes.put("taxa_distorcao_fundamental", dadosDistorcaoFundamental);
		informacoes.put("taxa_distorcao_ensino_medio", dadosDistorcaoMedio);
		informacoes.put("taxa_aprovacao_fundamental", dadosAprovacaoFundamental);
		informacoes.put("taxa_aprovacao_medio", dadosAprovacaoMedio);
		informacoes.put("taxa_abandono_fundamental", dadosAbandonoFundamental);
		informacoes.put("taxa_abandono_medio", dadosAbandonoMedio);
	}
	
	public void tearDown() throws Exception {
		// Do nothing.
	}

	public void testNome() {
		String name;
		state.setName("Acre");
		
		name = state.getName();
		assertEquals("Acre",name);
	}
	
	public void testNomeNull() {
		String name;
		name = state.getName();
		
		assertEquals("No name", name);
	}

	public void testAcronym() {
		String acronym;
		state.setAcronym("AC");
		
		acronym = state.getAcronym();
		assertEquals("AC", acronym);
	}
	
	public void testAcronymNull() {
		String acronym;
		acronym = state.getAcronym();
		
		assertEquals("No acronym", acronym);
	}

	public void testPopulation() {
		int population;
		state.setPopulation(informacoes);
		
		population = state.getPopulation();
		assertEquals(population, 3000, 0.00001);
	}
	
	public void testParticipacaoPercentualPIB() {
		double[] valores;	
		valores = state.getParticipacaoPercentualPIB();
		assertEquals(valores[0], 3000, 0.00001);
	}
	
	public void testParticipacaoPercentualPIBNull() {
		double[] valores;
		valores = state.getParticipacaoPercentualPIB();
		
		assertEquals(0, valores[0], 0);
	}

	public void testIdeb() {
		Ideb[] idebs;
		state.setIdebs(informacoes);
		
		idebs = state.getIdebs();
		
		assertEquals(2.5,idebs[0].getFundamental(), 0.00001);
		assertEquals(3.7,idebs[0].getSeriesIniciais(),0.00001);
		assertEquals(4.1,idebs[0].getMedio(),0.00001);
		assertEquals(2000,idebs[0].getYear());
	}
	
	public void testIdebNull() {
		Ideb[] idebs;
		idebs = state.getIdebs();
		
		assertEquals(0,idebs[0].getFundamental(), 0);
		assertEquals(0,idebs[0].getSeriesIniciais(),0);
		assertEquals(0,idebs[0].getMedio(),0);
	} 
	
	public void testProjectCienciaTecnologia() {
		String[] indicativosProjectsCienciaTecnologia = {"numero_projetos", "valor_investido"};
		Project[] projetosTecnologia;
		
		state.setProjectsCienciaTecnologia(informacoes, indicativosProjectsCienciaTecnologia);
		projetosTecnologia = state.getProjectsCienciaTecnologia();
		
		assertEquals(10, projetosTecnologia[0].getQuantity());
		assertEquals(10000.50, projetosTecnologia[0].getValue(), 0.00001);
		assertEquals(2001, projetosTecnologia[0].getYear());
	}
	
	public void testProjectCienciaTecnologiaNull() {
		Project[] projetosTecnologia;
		projetosTecnologia = state.getProjectsCienciaTecnologia();
		
		assertEquals(0, projetosTecnologia[0].getQuantity());
		assertEquals(0, projetosTecnologia[0].getValue(), 0);
		assertEquals(0, projetosTecnologia[0].getYear());
	}
	
	public void testPrimeirosProjects() {
		String[] indicativosPrimeirosProjects = {"programa_primeiros_projetos", 
			"valores_programa_primeiros_projetos"};
		Project[] primeirosProjects;
		
		state.setPrimeirosProjects(informacoes, indicativosPrimeirosProjects);
		primeirosProjects = state.getPrimeirosProjects();
		
		assertEquals(10, primeirosProjects[0].getQuantity());
		assertEquals(10000.50, primeirosProjects[0].getValue(), 0.00001);
		assertEquals(2001, primeirosProjects[0].getYear());
	}	
	
	public void testPrimeirosProjectsNull() {
		Project[] primeirosProjects;
		primeirosProjects = state.getPrimeirosProjects();
		
		assertEquals(0, primeirosProjects[0].getQuantity());
		assertEquals(0, primeirosProjects[0].getValue(), 0);
		assertEquals(0, primeirosProjects[0].getYear());
	}
	
	public void testProjectsInct() {
		String[] indicativosProjectsInct = {"projetos_inct", "valores_projetos_inct"};
		Project[] projetosInct;
		
		state.setProjectsInct(informacoes, indicativosProjectsInct);
		projetosInct = state.getProjectsInct();
		
		assertEquals(10, projetosInct[0].getQuantity());
		assertEquals(10000.50, projetosInct[0].getValue(), 0.00001);
		assertEquals(2001, projetosInct[0].getYear());
	}
	
	public void testProjectsInctNull() {
		Project[] projetosInct;
		projetosInct = state.getProjectsInct();
		
		assertEquals(0, projetosInct[0].getQuantity());
		assertEquals(0, projetosInct[0].getValue(), 0);
		assertEquals(0, projetosInct[0].getYear());
	}
	
	public void testProjectsApoioCnpq() {
		String[] indicativosApoioCnpq = {"projetos_apoio_pesquisa_cnpq", 
			"valores_projetos_apoio_pesquisa_cnpq"};
		Project[] projetosApoioCnpq;
		
		state.setProjectsApoioCnpq(informacoes, indicativosApoioCnpq);
		projetosApoioCnpq = state.getProjectsApoioCnpq();
		
		assertEquals(10, projetosApoioCnpq[0].getQuantity());
		assertEquals(10000.50, projetosApoioCnpq[0].getValue(), 0.00001);
		assertEquals(2001, projetosApoioCnpq[0].getYear());
	}
	
	public void testProjectsApoioCnpqNull() {
		Project[] projetosApoioCnpq;
		projetosApoioCnpq = state.getProjectsApoioCnpq();
		
		assertEquals(0, projetosApoioCnpq[0].getQuantity());
		assertEquals(0, projetosApoioCnpq[0].getValue(), 0);
		assertEquals(0, projetosApoioCnpq[0].getYear());
	}
	
	public void testProjectJovensPesquisadores() {
		String[] indicativosJovensPesquisadores = {"jovens_pesquisadores", 
			"valores_jovens_pesquisadores"};
		Project[] projetoJovensPesquisadores;
		
		state.setProjectJovensPesquisadores(informacoes, indicativosJovensPesquisadores);
		projetoJovensPesquisadores = state.getProjectJovensPesquisadores();
		
		assertEquals(10, projetoJovensPesquisadores[0].getQuantity());
		assertEquals(10000.50, projetoJovensPesquisadores[0].getValue(), 0.00001);
		assertEquals(2001, projetoJovensPesquisadores[0].getYear());
	}
	
	public void testProjectJovensPesquisadoresNull() {
		Project[] projetoJovensPesquisadores;
		projetoJovensPesquisadores = state.getProjectJovensPesquisadores();
		
		assertEquals(0, projetoJovensPesquisadores[0].getQuantity());
		assertEquals(0, projetoJovensPesquisadores[0].getValue(), 0);
		assertEquals(0, projetoJovensPesquisadores[0].getYear());
	}
	
	public void testCensus() {
		Census[] census;
		state.setCensus(informacoes);
		
		census = state.getCensus();
		assertEquals(1000, census[0].getYearsIniciaisFundamental(), 0);
		assertEquals(2000, census[0].getYearsFinaisFundamental(), 0);
		assertEquals(3000, census[0].getHighSchool(), 0);
		assertEquals(4000, census[0].getFundamentalEJA(), 0);
		assertEquals(5000, census[0].getMedioEJA(), 0);
		assertEquals(2000, census[0].getYear());
	}
	
	public void testAverageAlunosPorTurma() {
		String[] indicativosAverageAlunosPorTurma = {"alunos_por_turma_ensino_fundamental", 
			"alunos_por_turma_ensino_medio"};
		Average[] alunosPorTurma;
		
		state.setAverageAlunosPorTurma(informacoes, indicativosAverageAlunosPorTurma);
		alunosPorTurma = state.getAverageAlunosPorTurma();
		
		assertEquals(50, alunosPorTurma[0].getElementarySchool(), 0);
		assertEquals(60, alunosPorTurma[0].getHighSchool(), 0);
		assertEquals(2000, alunosPorTurma[0].getYear());
	}
	
	public void testAverageAlunosPorTurmaNull() {
		Average[] alunosPorTurma;
		alunosPorTurma = state.getAverageAlunosPorTurma();
		
		assertEquals(0, alunosPorTurma[0].getElementarySchool(), 0);
		assertEquals(0, alunosPorTurma[0].getHighSchool(), 0);
		assertEquals(0, alunosPorTurma[0].getYear());
	}
	
	public void testAveragehorasAula() {
		String[] indicativosAverageClassHours = {"horas_aula_ensino_fundamental", 
			"horas_aula_ensino_medio"};
		Average[] horasAula;
		
		state.setAverageClassHours(information, indicativeNames)(informacoes, indicativosAverageClassHours);
		horasAula = state.getAverageClassHours();
		
		assertEquals(4, horasAula[0].getElementarySchool(), 0);
		assertEquals(5, horasAula[0].getHighSchool(), 0);
		assertEquals(2001, horasAula[0].getYear());
	}
	
	public void testAverageClassHoursNull() {
		Average[] horasAula;
		horasAula = state.getAverageClassHours();
		
		assertEquals(0, horasAula[0].getElementarySchool(), 0);
		assertEquals(0, horasAula[0].getHighSchool(), 0);
		assertEquals(0, horasAula[0].getYear());
	}
	
	public void testTaxaDistorcaoIdadeSerie() {
		String[] taxaDistorcaoIdadeSerie = {"taxa_distorcao_fundamental", 
			"taxa_distorcao_ensino_medio"};
		Average[] taxaDistorcao;
		
		state.setTaxaDistorcaoIdadeSerie(informacoes, taxaDistorcaoIdadeSerie);
		taxaDistorcao = state.getTaxaDistorcaoIdadeSerie();
		
		assertEquals(15, taxaDistorcao[0].getElementarySchool(), 0);
		assertEquals(20, taxaDistorcao[0].getHighSchool(), 0);
		assertEquals(2002, taxaDistorcao[0].getYear());
	}
	
	public void testTaxaDistorcaoIdadeSerieNull() {
		Average[] taxaDistorcao;
		taxaDistorcao = state.getTaxaDistorcaoIdadeSerie();
		
		assertEquals(0, taxaDistorcao[0].getElementarySchool(), 0);
		assertEquals(0, taxaDistorcao[0].getHighSchool(), 0);
		assertEquals(0, taxaDistorcao[0].getYear());
	}
	
	public void testTaxaAproveitamento() {
		String[] taxaDeAproveitamento = {"taxa_aprovacao_fundamental", "taxa_aprovacao_medio"};
		Average[] taxaAproveitamento;
		
		state.setTaxaDeAproveitamento(informacoes, taxaDeAproveitamento);
		taxaAproveitamento = state.getTaxaDeAproveitamento();
		
		assertEquals(95, taxaAproveitamento[0].getElementarySchool(), 0);
		assertEquals(80, taxaAproveitamento[0].getHighSchool(), 0);
		assertEquals(2003, taxaAproveitamento[0].getYear());
	}
	
	public void testTaxaAproveitamentoNull() {
		Average[] taxaAproveitamento;
		taxaAproveitamento = state.getTaxaDeAproveitamento();
		
		assertEquals(0, taxaAproveitamento[0].getElementarySchool(), 0);
		assertEquals(0, taxaAproveitamento[0].getHighSchool(), 0);
		assertEquals(0, taxaAproveitamento[0].getYear());
	}
	
	public void testDropoutRate() {
		String[] dropoutRate = {"taxa_abandono_fundamental", "taxa_abandono_medio"};
		Average[] taxaAbandono;
		
		state.setDropoutRate(informacoes, dropoutRate);
		taxaAbandono = state.getDropoutRate();
		
		assertEquals(5, taxaAbandono[0].getElementarySchool(), 0);
		assertEquals(20, taxaAbandono[0].getHighSchool(), 0);
		assertEquals(2004, taxaAbandono[0].getYear());
	}
	
	public void testDropoutRateNull() {
		Average[] taxaAbandono;
		taxaAbandono = state.getDropoutRate();
		
		assertEquals(0, taxaAbandono[0].getElementarySchool(), 0);
		assertEquals(0, taxaAbandono[0].getHighSchool(), 0);
		assertEquals(0, taxaAbandono[0].getYear());
	}
	
	public void testPreencheDados() {
		int population;
		
		state.fulfillData(informacoes);

		population = state.getPopulation();
		assertEquals(population, 3000, 0.00001);
	}
}