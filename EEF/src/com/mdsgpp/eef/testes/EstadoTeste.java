package com.mdsgpp.eef.testes;

import java.util.ArrayList;
import java.util.HashMap;

import android.test.AndroidTestCase;

import com.mdsgpp.eef.modelo.Censo;
import com.mdsgpp.eef.modelo.Estado;
import com.mdsgpp.eef.modelo.Ideb;
import com.mdsgpp.eef.modelo.Projeto;
import com.mdsgpp.eef.modelo.Media;

public class EstadoTeste extends AndroidTestCase {

	private Estado estado;
	private HashMap<String, ArrayList<String[]>> informacoes;
	private String valores[];
	
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
	ArrayList<String[]> dadosCensosIniciais;
	ArrayList<String[]> dadosCensosFinais;
	ArrayList<String[]> dadosCensosMedio;
	ArrayList<String[]> dadosCensosEjaFundamental;
	ArrayList<String[]> dadosCensosEjaMedio;
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
		dadosProjetos = new ArrayList<String[]>();
		dadosValores = new ArrayList<String[]>();
		dadosProjetosInct = new ArrayList<String[]>();
		dadosValoresInct = new ArrayList<String[]>();
		dadosProjetosCnpq = new ArrayList<String[]>();
		dadosValoresCnpq = 	new ArrayList<String[]>();
		dadosJovensPesquisadores = new ArrayList<String[]>();
		dadosValoresJovensPesquisadores = new ArrayList<String[]>();
		dadosProjetosTecnologia = new ArrayList<String[]>();
		dadosValoresProjetosTecnologia = new ArrayList<String[]>();
		dadosCensosIniciais = new ArrayList<String[]>();
		dadosCensosFinais = new ArrayList<String[]>();
		dadosCensosMedio = new ArrayList<String[]>();
		dadosCensosEjaFundamental = new ArrayList<String[]>();
		dadosCensosEjaMedio = new ArrayList<String[]>();
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
		estado = new Estado();
		valores = new String[2];
		
		valores[0] = "1998";
		valores[1] ="3000";
		
		String[] idebs1 = {"2000","2.5"};
		String[] idebs2 = {"2000","3.7"};
		String[] idebs3 = {"2000","4.1"};
		String[] idebs4 = {"Total","5.5"};
		String[] primeirosProjetos1 = {"2001","10"};
		String[] primeirosProjetos2 = {"2001","10000.50"};
		String[] primeirosProjetos3 = {"Total","11"};
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
		
		String[] censosIniciais = {"2000", "1000"};
		String[] censosFinais = {"2000", "2000"};
		String[] censosMedio = {"2000", "3000"};
		String[] censosEjaFundamental = {"2000", "4000"};
		String[] censosEjaMedio = {"2000", "5000"};
		
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
		dadosProjetos.add(primeirosProjetos1);
		dadosValores.add(primeirosProjetos2);
		dadosProjetos.add(primeirosProjetos3);
		dadosValores.add(primeirosProjetos3);
		dadosProjetosInct.add(projetosInct1);
		dadosValoresInct.add(projetosInct2);
		dadosProjetosInct.add(projetosInct3);
		dadosValoresInct.add(projetosInct3);
		dadosProjetosCnpq.add(projetosCnpq1);
		dadosValoresCnpq.add(projetosCnpq2);
		dadosProjetosCnpq.add(projetosCnpq3);
		dadosValoresCnpq.add(projetosCnpq3);
		dadosJovensPesquisadores.add(jovensPesquisadores1);
		dadosValoresJovensPesquisadores.add(jovensPesquisadores2);
		dadosJovensPesquisadores.add(jovensPesquisadores3);
		dadosValoresJovensPesquisadores.add(jovensPesquisadores3);
		dadosProjetosTecnologia.add(projetosTecnologia1);
		dadosValoresProjetosTecnologia.add(projetosTecnologia2);
		dadosProjetosTecnologia.add(projetosTecnologia3);
		dadosValoresProjetosTecnologia.add(projetosTecnologia3);
		
		dadosCensosIniciais.add(censosIniciais);
		dadosCensosFinais.add(censosFinais);
		dadosCensosMedio.add(censosMedio);
		dadosCensosEjaFundamental.add(censosEjaFundamental);
		dadosCensosEjaMedio.add(censosEjaMedio);
		
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
		
		informacoes.put("censo_anos_iniciais",dadosCensosIniciais);
		informacoes.put("censo_anos_finais",dadosCensosFinais);
		informacoes.put("censo_ensino_medio",dadosCensosMedio);
		informacoes.put("censo_eja_fundamental",dadosCensosEjaFundamental);
		informacoes.put("censo_eja_medio",dadosCensosEjaMedio);
	
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
		String nome;
		estado.setNome("Acre");
		
		nome = estado.getNome();
		assertEquals("Acre",nome);
	}
	
	public void testNomeNull() {
		String nome;
		nome = estado.getNome();
		
		assertEquals("Sem nome",nome);
	}

	public void testSigla() {
		String sigla;
		estado.setSigla("AC");
		
		sigla = estado.getSigla();
		assertEquals("AC", sigla);
	}
	
	public void testSiglaNull() {
		String sigla;
		sigla = estado.getSigla();
		
		assertEquals("Sem sigla", sigla);
	}

	public void testPopulacao() {
		int populacao;
		estado.setPopulacao(informacoes);
		
		populacao = estado.getPopulacao();
		assertEquals(populacao, 3000, 0.00001);
	}
	
	public void testParticipacaoPercentualPIB() {
		double[] valores;	
		estado.setParticipacaoPercentualPIB(informacoes);
		
		valores = estado.getParticipacaoPercentualPIB();
		assertEquals(valores[0], 3000, 0.00001);
	}
	
	public void testParticipacaoPercentualPIBNull() {
		double[] valores;
		valores = estado.getParticipacaoPercentualPIB();
		
		assertEquals(0, valores[0], 0);
	}

	public void testIdeb() {
		Ideb[] idebs;
		estado.setIdebs(informacoes);
		
		idebs = estado.getIdebs();
		
		assertEquals(2.5,idebs[0].getFundamental(), 0.00001);
		assertEquals(3.7,idebs[0].getSeriesIniciais(),0.00001);
		assertEquals(4.1,idebs[0].getMedio(),0.00001);
		assertEquals(2000,idebs[0].getAno());
	}
	
	public void testIdebNull() {
		Ideb[] idebs;
		idebs = estado.getIdebs();
		
		assertEquals(0,idebs[0].getFundamental(), 0);
		assertEquals(0,idebs[0].getSeriesIniciais(),0);
		assertEquals(0,idebs[0].getMedio(),0);
	} 
	
	public void testProjetoCienciaTecnologia() {
		String[] indicativosProjetosCienciaTecnologia = {"numero_projetos", "valor_investido"};
		Projeto[] projetosTecnologia;
		
		estado.setProjetosCienciaTecnologia(informacoes, indicativosProjetosCienciaTecnologia);
		projetosTecnologia = estado.getProjetosCienciaTecnologia();
		
		assertEquals(10, projetosTecnologia[0].getQuantidade());
		assertEquals(10000.50, projetosTecnologia[0].getValor(), 0.00001);
		assertEquals(2001, projetosTecnologia[0].getAno());
	}
	
	public void testProjetoCienciaTecnologiaNull() {
		Projeto[] projetosTecnologia;
		projetosTecnologia = estado.getProjetosCienciaTecnologia();
		
		assertEquals(0, projetosTecnologia[0].getQuantidade());
		assertEquals(0, projetosTecnologia[0].getValor(), 0);
		assertEquals(0, projetosTecnologia[0].getAno());
	}
	
	public void testPrimeirosProjetos() {
		String[] indicativosPrimeirosProjetos = {"programa_primeiros_projetos", 
			"valores_programa_primeiros_projetos"};
		Projeto[] primeirosProjetos;
		
		estado.setPrimeirosProjetos(informacoes, indicativosPrimeirosProjetos);
		primeirosProjetos = estado.getPrimeirosProjetos();
		
		assertEquals(10, primeirosProjetos[0].getQuantidade());
		assertEquals(10000.50, primeirosProjetos[0].getValor(), 0.00001);
		assertEquals(2001, primeirosProjetos[0].getAno());
	}	
	
	public void testPrimeirosProjetosNull() {
		Projeto[] primeirosProjetos;
		primeirosProjetos = estado.getPrimeirosProjetos();
		
		assertEquals(0, primeirosProjetos[0].getQuantidade());
		assertEquals(0, primeirosProjetos[0].getValor(), 0);
		assertEquals(0, primeirosProjetos[0].getAno());
	}
	
	public void testProjetosInct() {
		String[] indicativosProjetosInct = {"projetos_inct", "valores_projetos_inct"};
		Projeto[] projetosInct;
		
		estado.setProjetosInct(informacoes, indicativosProjetosInct);
		projetosInct = estado.getProjetosInct();
		
		assertEquals(10, projetosInct[0].getQuantidade());
		assertEquals(10000.50, projetosInct[0].getValor(), 0.00001);
		assertEquals(2001, projetosInct[0].getAno());
	}
	
	public void testProjetosInctNull() {
		Projeto[] projetosInct;
		projetosInct = estado.getProjetosInct();
		
		assertEquals(0, projetosInct[0].getQuantidade());
		assertEquals(0, projetosInct[0].getValor(), 0);
		assertEquals(0, projetosInct[0].getAno());
	}
	
	public void testProjetosApoioCnpq() {
		String[] indicativosApoioCnpq = {"projetos_apoio_pesquisa_cnpq", 
			"valores_projetos_apoio_pesquisa_cnpq"};
		Projeto[] projetosApoioCnpq;
		
		estado.setProjetosApoioCnpq(informacoes, indicativosApoioCnpq);
		projetosApoioCnpq = estado.getProjetosApoioCnpq();
		
		assertEquals(10, projetosApoioCnpq[0].getQuantidade());
		assertEquals(10000.50, projetosApoioCnpq[0].getValor(), 0.00001);
		assertEquals(2001, projetosApoioCnpq[0].getAno());
	}
	
	public void testProjetosApoioCnpqNull() {
		Projeto[] projetosApoioCnpq;
		projetosApoioCnpq = estado.getProjetosApoioCnpq();
		
		assertEquals(0, projetosApoioCnpq[0].getQuantidade());
		assertEquals(0, projetosApoioCnpq[0].getValor(), 0);
		assertEquals(0, projetosApoioCnpq[0].getAno());
	}
	
	public void testProjetoJovensPesquisadores() {
		String[] indicativosJovensPesquisadores = {"jovens_pesquisadores", 
			"valores_jovens_pesquisadores"};
		Projeto[] projetoJovensPesquisadores;
		
		estado.setProjetoJovensPesquisadores(informacoes, indicativosJovensPesquisadores);
		projetoJovensPesquisadores = estado.getProjetoJovensPesquisadores();
		
		assertEquals(10, projetoJovensPesquisadores[0].getQuantidade());
		assertEquals(10000.50, projetoJovensPesquisadores[0].getValor(), 0.00001);
		assertEquals(2001, projetoJovensPesquisadores[0].getAno());
	}
	
	public void testProjetoJovensPesquisadoresNull() {
		Projeto[] projetoJovensPesquisadores;
		projetoJovensPesquisadores = estado.getProjetoJovensPesquisadores();
		
		assertEquals(0, projetoJovensPesquisadores[0].getQuantidade());
		assertEquals(0, projetoJovensPesquisadores[0].getValor(), 0);
		assertEquals(0, projetoJovensPesquisadores[0].getAno());
	}
	
	public void testCensos() {
		Census[] censos;
		estado.setCensos(informacoes);
		
		censos = estado.getCensos();
		assertEquals(1000, censos[0].getAnosIniciaisFundamental(), 0);
		assertEquals(2000, censos[0].getAnosFinaisFundamental(), 0);
		assertEquals(3000, censos[0].getEnsinoMedio(), 0);
		assertEquals(4000, censos[0].getFundamentalEJA(), 0);
		assertEquals(5000, censos[0].getMedioEJA(), 0);
		assertEquals(2000, censos[0].getAno());
	}
	
	public void testMediaAlunosPorTurma() {
		String[] indicativosMediaAlunosPorTurma = {"alunos_por_turma_ensino_fundamental", 
			"alunos_por_turma_ensino_medio"};
		Media[] alunosPorTurma;
		
		estado.setMediaAlunosPorTurma(informacoes, indicativosMediaAlunosPorTurma);
		alunosPorTurma = estado.getMediaAlunosPorTurma();
		
		assertEquals(50, alunosPorTurma[0].getEnsinoFundamental(), 0);
		assertEquals(60, alunosPorTurma[0].getEnsinoMedio(), 0);
		assertEquals(2000, alunosPorTurma[0].getAno());
	}
	
	public void testMediaAlunosPorTurmaNull() {
		Media[] alunosPorTurma;
		alunosPorTurma = estado.getMediaAlunosPorTurma();
		
		assertEquals(0, alunosPorTurma[0].getEnsinoFundamental(), 0);
		assertEquals(0, alunosPorTurma[0].getEnsinoMedio(), 0);
		assertEquals(0, alunosPorTurma[0].getAno());
	}
	
	public void testMediahorasAula() {
		String[] indicativosMediaHorasAula = {"horas_aula_ensino_fundamental", 
			"horas_aula_ensino_medio"};
		Media[] horasAula;
		
		estado.setMediaHorasAula(informacoes, indicativosMediaHorasAula);
		horasAula = estado.getMediaHorasAula();
		
		assertEquals(4, horasAula[0].getEnsinoFundamental(), 0);
		assertEquals(5, horasAula[0].getEnsinoMedio(), 0);
		assertEquals(2001, horasAula[0].getAno());
	}
	
	public void testMediaHorasAulaNull() {
		Media[] horasAula;
		horasAula = estado.getMediaHorasAula();
		
		assertEquals(0, horasAula[0].getEnsinoFundamental(), 0);
		assertEquals(0, horasAula[0].getEnsinoMedio(), 0);
		assertEquals(0, horasAula[0].getAno());
	}
	
	public void testTaxaDistorcaoIdadeSerie() {
		String[] taxaDistorcaoIdadeSerie = {"taxa_distorcao_fundamental", 
			"taxa_distorcao_ensino_medio"};
		Media[] taxaDistorcao;
		
		estado.setTaxaDistorcaoIdadeSerie(informacoes, taxaDistorcaoIdadeSerie);
		taxaDistorcao = estado.getTaxaDistorcaoIdadeSerie();
		
		assertEquals(15, taxaDistorcao[0].getEnsinoFundamental(), 0);
		assertEquals(20, taxaDistorcao[0].getEnsinoMedio(), 0);
		assertEquals(2002, taxaDistorcao[0].getAno());
	}
	
	public void testTaxaDistorcaoIdadeSerieNull() {
		Media[] taxaDistorcao;
		taxaDistorcao = estado.getTaxaDistorcaoIdadeSerie();
		
		assertEquals(0, taxaDistorcao[0].getEnsinoFundamental(), 0);
		assertEquals(0, taxaDistorcao[0].getEnsinoMedio(), 0);
		assertEquals(0, taxaDistorcao[0].getAno());
	}
	
	public void testTaxaAproveitamento() {
		String[] taxaDeAproveitamento = {"taxa_aprovacao_fundamental", "taxa_aprovacao_medio"};
		Media[] taxaAproveitamento;
		
		estado.setTaxaDeAproveitamento(informacoes, taxaDeAproveitamento);
		taxaAproveitamento = estado.getTaxaDeAproveitamento();
		
		assertEquals(95, taxaAproveitamento[0].getEnsinoFundamental(), 0);
		assertEquals(80, taxaAproveitamento[0].getEnsinoMedio(), 0);
		assertEquals(2003, taxaAproveitamento[0].getAno());
	}
	
	public void testTaxaAproveitamentoNull() {
		Media[] taxaAproveitamento;
		taxaAproveitamento = estado.getTaxaDeAproveitamento();
		
		assertEquals(0, taxaAproveitamento[0].getEnsinoFundamental(), 0);
		assertEquals(0, taxaAproveitamento[0].getEnsinoMedio(), 0);
		assertEquals(0, taxaAproveitamento[0].getAno());
	}
	
	public void testTaxaDeAbandono() {
		String[] taxaDeAbandono = {"taxa_abandono_fundamental", "taxa_abandono_medio"};
		Media[] taxaAbandono;
		
		estado.setTaxaDeAbandono(informacoes, taxaDeAbandono);
		taxaAbandono = estado.getTaxaDeAbandono();
		
		assertEquals(5, taxaAbandono[0].getEnsinoFundamental(), 0);
		assertEquals(20, taxaAbandono[0].getEnsinoMedio(), 0);
		assertEquals(2004, taxaAbandono[0].getAno());
	}
	
	public void testTaxaDeAbandonoNull() {
		Media[] taxaAbandono;
		taxaAbandono = estado.getTaxaDeAbandono();
		
		assertEquals(0, taxaAbandono[0].getEnsinoFundamental(), 0);
		assertEquals(0, taxaAbandono[0].getEnsinoMedio(), 0);
		assertEquals(0, taxaAbandono[0].getAno());
	}
	
	public void testPreencheDados() {
		int populacao;
		
		estado.preencheDados(informacoes);

		populacao = estado.getPopulacao();
		assertEquals(populacao, 3000, 0.00001);
	}
}