package com.mdsgpp.eef.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Estado {

	private String nome;
	private String sigla;
	private double participacaoPercentualPIB[];
	private int populacao;
	private int numeroDeProjetosCienciaTecnologia[];
	private double valorInvestidoCienciaTecnologia[];
	private Censo censos[]; //vetores, pois, será disponibilizado os valores referentes desde 2010
	private Ideb idebs[];
	private Media mediaNotasPorTurma[];
	private Media mediaHorasAula[];
	private Projeto primeirosProjetos[];
	private Projeto projetoInct[];
	private Projeto projetosApoioCnpq[];
	private Projeto projetoJovensPesquisadores[];
	private Media taxaDistorcaoIdadeSerie[];
	
	public Estado(){
	}
	
	public Estado(String nome, String sigla, HashMap<String, ArrayList<String[]>> informacoes){
		this.nome = nome;
		this.sigla = sigla;
		
		preencheDados(informacoes);		
	}

	
	public Censo[] getCensos() {
		return censos;
	}

	public void setCensos(Censo[] censos) {
		this.censos = censos;
	}

	public double[] getParticipacaoPercentualPIB() {
		if (participacaoPercentualPIB == null) {
			double[] vazio = {0};
			return vazio;
		}
			
		return participacaoPercentualPIB;
	}

	public void setParticipacaoPercentualPIB(HashMap<String, ArrayList<String[]>> informacoes) {
		
		double participacaoPercentual[];
		ArrayList<String[]> dados = informacoes.get("participacao_estadual_pib");
			
		participacaoPercentual = new double[dados.size()];
		for (int i=0; i<dados.size(); i++) {
			participacaoPercentual[i] = Double.parseDouble(dados.get(i)[1].replaceAll(",", "."));
		}
			
		this.participacaoPercentualPIB = participacaoPercentual;
	}

	public int getPopulacao() {
		return populacao;
	}

	public void setPopulacao(HashMap<String, ArrayList<String[]>> informacoes) {
		
		ArrayList<String[]> dados = informacoes.get("populacao");
		this.populacao = Integer.parseInt(dados.get(0)[1].replaceAll(",", "."));

	}

	public int[] getNumeroDeProjetosCienciaTecnologia() {
		if (numeroDeProjetosCienciaTecnologia == null) {
			int[] vazio = {0};
			return vazio;
		}
		
		return numeroDeProjetosCienciaTecnologia;
	}

	public void setNumeroDeProjetosCienciaTecnologia(HashMap<String, ArrayList<String[]>> informacoes) {
		int quantidadeProjetosCienciaTecnologia[] = null;
		ArrayList<String[]> dados;
		
		if (informacoes.containsKey("numero_projetos")) {
			dados = informacoes.get("numero_projetos");
			quantidadeProjetosCienciaTecnologia = new int[dados.size()];
			for (int i=0; i<dados.size(); i++) {
				quantidadeProjetosCienciaTecnologia[i] = Integer.parseInt(dados.get(i)[1].replaceAll(",", "."));
			}
		}
		
		this.numeroDeProjetosCienciaTecnologia = quantidadeProjetosCienciaTecnologia;
	}

	public double[] getValorInvestidoCienciaTecnologia() {
		if (valorInvestidoCienciaTecnologia == null) {
			double[] vazio = {0};
			return vazio;
		}
		
		return valorInvestidoCienciaTecnologia;
	}

	public void setValorInvestidoCienciaTecnologia(HashMap<String, ArrayList<String[]>> informacoes) {
		double valoresProjetosCienciaTecnologia[] = null;
		ArrayList<String[]> dados;
		
		if (informacoes.containsKey("valor_investido")) {
			dados = informacoes.get("valor_investido");
			valoresProjetosCienciaTecnologia = new double[dados.size()];
			for (int i=0; i<dados.size(); i++) {
				valoresProjetosCienciaTecnologia[i] = Double.parseDouble(dados.get(i)[1].replaceAll(",", "."));
			}
		}
		
		this.valorInvestidoCienciaTecnologia = valoresProjetosCienciaTecnologia;
	}

	public Ideb[] getIdebs() {
		if (idebs == null) {
			Ideb vazio[] = { new Ideb(0,0,0) };
			return vazio;
		}
		
		return idebs;
	}

	public void setIdebs(HashMap<String, ArrayList<String[]>> informacoes) {
		ArrayList<String[]> dadosFundamentalFinais;
		ArrayList<String[]> dadosFundamentalIniciais;
		ArrayList<String[]> dadosMedio;
		Ideb ideb[] = null;
		
		dadosFundamentalFinais = informacoes.get("5a_8a");
		dadosFundamentalIniciais = informacoes.get("series_iniciais");
		dadosMedio = informacoes.get("ensino_medio");
		
		ideb = new Ideb[dadosMedio.size()];
		for (int i=0; i<ideb.length; i++) {
			ideb[i] = new Ideb();
			ideb[i].setEstado(this); 
			
			ideb[i].setFundamental(Double.parseDouble(dadosFundamentalFinais.get(i)[1].replaceAll(",", ".")));
			ideb[i].setMedio(Double.parseDouble(dadosMedio.get(i)[1].replaceAll(",", ".")));
			ideb[i].setSeriesIniciais(Double.parseDouble(dadosFundamentalIniciais.get(i)[1].replaceAll(",", ".")));
		}
		
		this.idebs = ideb;
	}

	public Media[] getmediaNotasPorTurma() {
		if (mediaNotasPorTurma == null) {
			Media vazio[] = { new Media(0,0,0,0,0,0) };
			return vazio;
		}
		
		return mediaNotasPorTurma;
	}

	public void setmediaNotasPorTurma(Media[] mediaNotasPorTurma) {
		this.mediaNotasPorTurma = mediaNotasPorTurma;
	}

	public Media[] getMediaHorasAula() {
		if (mediaHorasAula == null) {
			Media vazio[] = { new Media(0,0,0,0,0,0) };
			return vazio;
		}
		
		return mediaHorasAula;
	}

	public void setMediaHorasAula(Media[] mediaHorasAula) {
		this.mediaHorasAula = mediaHorasAula;
	}

	public Media[] getTaxaDistorcaoIdadeSerie() {
		if (taxaDistorcaoIdadeSerie == null) {
			Media vazio[] = { new Media(0,0,0,0,0,0) };
			return vazio;
		}
		
		return taxaDistorcaoIdadeSerie;
	}

	public void setTaxaDistorcaoIdadeSerie(Media[] taxaDistorcaoIdadeSerie) {
		this.taxaDistorcaoIdadeSerie = taxaDistorcaoIdadeSerie;
	}

	public String getNome() {
		if (nome == null) {
			return "Sem nome";
		}
		
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		if (nome == null) {
			return "Sem sigla";
		}
		
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public Projeto[] getPrimeirosProjetos() {
		if (primeirosProjetos == null) {
			Projeto vazio[] = { new Projeto() };
			vazio[0].setQuantidade(0);
			vazio[0].setValor(0);
			
			return vazio;
		}
		
		return primeirosProjetos;
	}

	public void setPrimeirosProjetos(HashMap<String, ArrayList<String[]>> informacoes) {
		Projeto projetosPrimeirosProjetos[] = null;
		
		if (informacoes.containsKey("programa_primeiros_projetos") 
				&& informacoes.containsKey("valores_programa_primeiros_projetos")) {

			ArrayList<String[]> dadosProjetos = informacoes.get("programa_primeiros_projetos");
			ArrayList<String[]> dadosValores = informacoes.get("valores_programa_primeiros_projetos");
			
			projetosPrimeirosProjetos = new Projeto[dadosProjetos.size()];
			
			for (int i=0; i<projetosPrimeirosProjetos.length; i++) { 
				projetosPrimeirosProjetos[i] = new Projeto();
				projetosPrimeirosProjetos[i].setEstado(this);
				projetosPrimeirosProjetos[i].setQuantidade(Integer.parseInt(dadosProjetos.get(i)[1].replaceAll(",", ".")));
				projetosPrimeirosProjetos[i].setValor(Double.parseDouble(dadosValores.get(i)[1].replaceAll(",", ".")));
			}
		}
		
		this.primeirosProjetos = projetosPrimeirosProjetos;
	}

	public Projeto[] getProjetosInct() {
		if (projetoInct == null) {
			Projeto vazio[] = { new Projeto() };
			vazio[0].setQuantidade(0);
			vazio[0].setValor(0);
			
			return vazio;
		}
		
		return projetoInct;
	}

	public void setProjetosInct(HashMap<String, ArrayList<String[]>> informacoes) {
		Projeto projetosIniciacaoCientifica[] = null;
		
		if (informacoes.containsKey("projetos_inct") 
				&& informacoes.containsKey("valores_projetos_inct")) {

			ArrayList<String[]> dadosProjetos = informacoes.get("projetos_inct");
			ArrayList<String[]> dadosValores = informacoes.get("valores_projetos_inct");
			
			projetosIniciacaoCientifica = new Projeto[dadosProjetos.size()];
			
			for (int i=0; i<projetosIniciacaoCientifica.length; i++) { 
				projetosIniciacaoCientifica[i] = new Projeto();
				projetosIniciacaoCientifica[i].setEstado(this);
				projetosIniciacaoCientifica[i].setQuantidade(Integer.parseInt(dadosProjetos.get(i)[1].replaceAll(",", ".")));
				projetosIniciacaoCientifica[i].setValor(Double.parseDouble(dadosValores.get(i)[1].replaceAll(",", ".")));
			}
		}
		
		this.projetoInct = projetosIniciacaoCientifica;
	}

	public Projeto[] getProjetosApoioCnpq() {
		if (projetosApoioCnpq == null) {
			Projeto vazio[] = { new Projeto() };
			vazio[0].setQuantidade(0);
			vazio[0].setValor(0);
			
			return vazio;
		}
		
		return projetosApoioCnpq;
	}

	public void setProjetosApoioCnpq(HashMap<String, ArrayList<String[]>> informacoes) {
		Projeto projetosCnpq[] = null;
		
		if (informacoes.containsKey("projetos_apoio_pesquisa_cnpq") 
				&& informacoes.containsKey("valores_projetos_apoio_pesquisa_cnpq")) {

			ArrayList<String[]> dadosProjetos = informacoes.get("projetos_apoio_pesquisa_cnpq");
			ArrayList<String[]> dadosValores = informacoes.get("valores_projetos_apoio_pesquisa_cnpq");
			
			projetosCnpq = new Projeto[dadosProjetos.size()];
			
			for (int i=0; i<projetosCnpq.length; i++) { 
				projetosCnpq[i] = new Projeto();
				projetosCnpq[i].setEstado(this);
				projetosCnpq[i].setQuantidade(Integer.parseInt(dadosProjetos.get(i)[1].replaceAll(",", ".")));
				projetosCnpq[i].setValor(Double.parseDouble(dadosValores.get(i)[1].replaceAll(",", ".")));
			}
		}
		
		this.projetosApoioCnpq = projetosCnpq;
	}

	public Projeto[] getProjetoJovensPesquisadores() {
		if (projetoJovensPesquisadores == null) {
			Projeto vazio[] = { new Projeto() };
			vazio[0].setQuantidade(0);
			vazio[0].setValor(0);
			
			return vazio;
		}
		
		return projetoJovensPesquisadores;
	}

	public void setProjetoJovensPesquisadores(HashMap<String, ArrayList<String[]>> informacoes) {
		Projeto projetosJovensPesquisadores[] = null;
		
		if (informacoes.containsKey("jovens_pesquisadores") 
				&& informacoes.containsKey("valores_jovens_pesquisadores")) {

			ArrayList<String[]> dadosProjetos = informacoes.get("jovens_pesquisadores");
			ArrayList<String[]> dadosValores = informacoes.get("valores_jovens_pesquisadores");
			
			projetosJovensPesquisadores = new Projeto[dadosProjetos.size()];
			
			for (int i=0; i<projetosJovensPesquisadores.length; i++) { 
				projetosJovensPesquisadores[i] = new Projeto();
				projetosJovensPesquisadores[i].setEstado(this);
				projetosJovensPesquisadores[i].setQuantidade(Integer.parseInt(dadosProjetos.get(i)[1].replaceAll(",", ".")));
				projetosJovensPesquisadores[i].setValor(Double.parseDouble(dadosValores.get(i)[1].replaceAll(",", ".")));
			}
		}
				
		this.projetoJovensPesquisadores = projetosJovensPesquisadores; 
	}

	private void preencheDados(HashMap<String, ArrayList<String[]>> informacoes) {
		
		this.setPopulacao(informacoes);
		this.setIdebs(informacoes);
		this.setNumeroDeProjetosCienciaTecnologia(informacoes);
		this.setValorInvestidoCienciaTecnologia(informacoes);
		this.setParticipacaoPercentualPIB(informacoes);
		this.setPrimeirosProjetos(informacoes);
		this.setProjetoJovensPesquisadores(informacoes);
		this.setProjetosApoioCnpq(informacoes);
		this.setProjetosInct(informacoes);
		

	}
	
}
