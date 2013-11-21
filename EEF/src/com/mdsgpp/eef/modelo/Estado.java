package com.mdsgpp.eef.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Estado {

	private String nome;
	private String sigla;
	private double participacaoPercentualPIB[];
	private int populacao;
	private Censo censos[];
	private Ideb idebs[];
	private Media mediaAlunosPorTurma[];
	private Media mediaHorasAula[];
	private Projeto projetosCienciaTecnologia[];
	private Projeto primeirosProjetos[];
	private Projeto projetoInct[];
	private Projeto projetosApoioCnpq[];
	private Projeto projetoJovensPesquisadores[];
	private Media taxaDistorcaoIdadeSerie[]; //pendente
	private Media taxaDeAproveitamento[]; //pendente
	private Media taxaDeAbandono[];//pendente
	
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

	public void setCensos(HashMap<String, ArrayList<String[]>> informacoes) {
		ArrayList<String[]> dadosFundamentalFinais;
		ArrayList<String[]> dadosFundamentalIniciais;
		ArrayList<String[]> dadosMedio;
		ArrayList<String[]> dadosEjaMedio;
		ArrayList<String[]> dadosEjaFundamental;
		Censo censo[] = null;
		
		dadosFundamentalFinais = informacoes.get("censo_anos_finais");
		dadosFundamentalIniciais = informacoes.get("censo_anos_iniciais");
		dadosMedio = informacoes.get("censo_ensino_medio");
		dadosEjaMedio = informacoes.get("censo_eja_medio");
		dadosEjaFundamental = informacoes.get("censo_eja_fundamental");
		
		censo = new Censo[dadosMedio.size()];
		for (int i=0; i<censo.length; i++) {
			censo[i] = new Censo();
			censo[i].setEstado(this); 
			censo[i].setAno(Integer.parseInt(dadosMedio.get(i)[0]));
			censo[i].setAnosFinaisFundamental(Double.parseDouble(dadosFundamentalFinais.get(i)[1].replaceAll(",", ".")));
			censo[i].setEnsinoMedio(Double.parseDouble(dadosMedio.get(i)[1].replaceAll(",", ".")));
			censo[i].setAnosIniciaisFundamental(Double.parseDouble(dadosFundamentalIniciais.get(i)[1].replaceAll(",", ".")));
			censo[i].setMedioEJA(Double.parseDouble(dadosEjaMedio.get(i)[1].replaceAll(",", ".")));
			censo[i].setFundamentalEJA(Double.parseDouble(dadosEjaFundamental.get(i)[1].replaceAll(",", ".")));
		}
		
		this.censos = censo;
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
			if(i<ideb.length-1){
				ideb[i].setAno(Integer.parseInt(dadosMedio.get(i)[0]));
			}
			ideb[i].setFundamental(Double.parseDouble(dadosFundamentalFinais.get(i)[1].replaceAll(",", ".")));
			ideb[i].setMedio(Double.parseDouble(dadosMedio.get(i)[1].replaceAll(",", ".")));
			ideb[i].setSeriesIniciais(Double.parseDouble(dadosFundamentalIniciais.get(i)[1].replaceAll(",", ".")));
		}
		
		this.idebs = ideb;
	}

	public Media[] getmediaAlunosPorTurma() {
		if (mediaAlunosPorTurma == null) {
			Media vazio[] = { new Media(0,0) };
			return vazio;
		}
		
		return mediaAlunosPorTurma;
	}

	public void setmediaAlunosPorTurma(HashMap<String, ArrayList<String[]>> informacoes) {
		ArrayList<String[]> dadosFundamental;
		ArrayList<String[]> dadosMedio;
		Media notasPorTurma[] = null;
		
		dadosFundamental = informacoes.get("alunos_por_turma_ensino_fundamental");
		dadosMedio = informacoes.get("alunos_por_turma_ensino_medio");
		
		notasPorTurma = new Media[dadosMedio.size()];
		for (int i=0; i<notasPorTurma.length; i++) {
			notasPorTurma[i] = new Media();
			notasPorTurma[i].setEstado(this); 
			notasPorTurma[i].setAno(Integer.parseInt(dadosMedio.get(i)[0]));
			notasPorTurma[i].setEnsinoFundamental(Double.parseDouble(dadosFundamental.get(i)[1].replaceAll(",", ".")));
			notasPorTurma[i].setEnsinoMedio(Double.parseDouble(dadosMedio.get(i)[1].replaceAll(",", ".")));
		}
		
		this.mediaAlunosPorTurma = notasPorTurma;
	}

	public Media[] getMediaHorasAula() {
		if (mediaHorasAula == null) {
			Media vazio[] = { new Media(0,0) };
			return vazio;
		}
		
		return mediaHorasAula;
	}

	public void setMediaHorasAula(HashMap<String, ArrayList<String[]>> informacoes) {
		ArrayList<String[]> dadosFundamental;
		ArrayList<String[]> dadosMedio;
		Media horasAula[] = null;
		
		dadosFundamental = informacoes.get("horas_aula_ensino_fundamental");
		dadosMedio = informacoes.get("horas_aula_ensino_medio");
		
		horasAula = new Media[dadosMedio.size()];
		for (int i=0; i<horasAula.length; i++) {
			horasAula[i] = new Media();
			horasAula[i].setEstado(this); 
			horasAula[i].setAno(Integer.parseInt(dadosMedio.get(i)[0]));
			horasAula[i].setEnsinoFundamental(Double.parseDouble(dadosFundamental.get(i)[1].replaceAll(",", ".")));
			horasAula[i].setEnsinoMedio(Double.parseDouble(dadosMedio.get(i)[1].replaceAll(",", ".")));
		}
		
		this.mediaHorasAula = horasAula;
	}

	public Media[] getTaxaDistorcaoIdadeSerie() {
		if (taxaDistorcaoIdadeSerie == null) {
			Media vazio[] = { new Media(0,0) };
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
		if (sigla == null) {
			return "Sem sigla";
		}
		
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public Projeto[] getProjetosCienciaTecnologia() {
		if(projetosCienciaTecnologia == null){
			Projeto vazio[] = { new Projeto() };
			vazio[0].setQuantidade(0);
			vazio[0].setValor(0);
			
		}
		
		return projetosCienciaTecnologia;
	}

	public void setProjetosCienciaTecnologia(HashMap<String, ArrayList<String[]>> informacoes) {
		ArrayList<String[]> dadosValoresInvestidos = null;
		ArrayList<String[]> dadosQtdProjetos = null;
		Projeto projetosCienciaTecnologia[] = null;
		
		if(informacoes.containsKey("numero_projetos")){
			dadosQtdProjetos = informacoes.get("numero_projetos");
			projetosCienciaTecnologia = new Projeto[dadosQtdProjetos.size()];
			dadosValoresInvestidos = informacoes.get("valor_investido");
			
		}
		
		for (int i=0; projetosCienciaTecnologia!=null && i<projetosCienciaTecnologia.length; i++) { 
			projetosCienciaTecnologia[i] = new Projeto();
			projetosCienciaTecnologia[i].setEstado(this);
			//projeto.setano(integer(array[0]);
			if(i<projetosCienciaTecnologia.length-1){
				projetosCienciaTecnologia[i].setAno(Integer.parseInt(dadosQtdProjetos.get(i)[0]));
			}
			projetosCienciaTecnologia[i].setQuantidade(Integer.parseInt(dadosQtdProjetos.get(i)[1].replaceAll(",", ".")));
			projetosCienciaTecnologia[i].setValor(Double.parseDouble(dadosValoresInvestidos.get(i)[1].replaceAll(",", ".")));
		}
		
		this.projetosCienciaTecnologia = projetosCienciaTecnologia;
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
		ArrayList<String[]> dadosProjetos = null;
		ArrayList<String[]> dadosValores = null;
		ArrayList<String[]> dadosValoresInvestidos = null;
		ArrayList<String[]> dadosQtdProjetos = null;
		int quantidadeProjetosCienciaTecnologia[] = null;
		double valoresProjetosCienciaTecnologia[] = null;
		
		if (informacoes.containsKey("programa_primeiros_projetos")){
			dadosProjetos = informacoes.get("programa_primeiros_projetos");
			projetosPrimeirosProjetos = new Projeto[dadosProjetos.size()];
			dadosValores = informacoes.get("valores_programa_primeiros_projetos");
			dadosValoresInvestidos = informacoes.get("valor_investido");
			valoresProjetosCienciaTecnologia = new double[dadosValoresInvestidos.size()];
			dadosQtdProjetos = informacoes.get("numero_projetos");
			quantidadeProjetosCienciaTecnologia = new int[dadosQtdProjetos.size()];
		}
			
		for (int i=0; projetosPrimeirosProjetos!=null && i<projetosPrimeirosProjetos.length; i++) { 
			projetosPrimeirosProjetos[i] = new Projeto();
			projetosPrimeirosProjetos[i].setEstado(this);
			if(i<projetosPrimeirosProjetos.length-1){
				projetosPrimeirosProjetos[i].setAno(Integer.parseInt(dadosQtdProjetos.get(i)[0]));
				}
			projetosPrimeirosProjetos[i].setQuantidade(Integer.parseInt(dadosProjetos.get(i)[1].replaceAll(",", ".")));
			projetosPrimeirosProjetos[i].setValor(Double.parseDouble(dadosValores.get(i)[1].replaceAll(",", ".")));
			valoresProjetosCienciaTecnologia[i] = Double.parseDouble(dadosValoresInvestidos.get(i)[1].replaceAll(",", "."));
			quantidadeProjetosCienciaTecnologia[i] = Integer.parseInt(dadosQtdProjetos.get(i)[1].replaceAll(",", "."));
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
		
		if (informacoes.containsKey("projetos_inct")) {

			ArrayList<String[]> dadosProjetos = informacoes.get("projetos_inct");
			ArrayList<String[]> dadosValores = informacoes.get("valores_projetos_inct");
			
			projetosIniciacaoCientifica = new Projeto[dadosProjetos.size()];
			
			for (int i=0; i<projetosIniciacaoCientifica.length; i++) { 
				projetosIniciacaoCientifica[i] = new Projeto();
				projetosIniciacaoCientifica[i].setEstado(this);
				if(i<projetosIniciacaoCientifica.length-1){
					projetosIniciacaoCientifica[i].setAno(Integer.parseInt(dadosProjetos.get(i)[0]));
				}
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
				if(i<projetosCnpq.length-1){
					projetosCnpq[i].setAno(Integer.parseInt(dadosProjetos.get(i)[0]));
				}
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
				if(i<projetosJovensPesquisadores.length-1){
					projetosJovensPesquisadores[i].setAno(Integer.parseInt(dadosProjetos.get(i)[0]));
				}
				projetosJovensPesquisadores[i].setQuantidade(Integer.parseInt(dadosProjetos.get(i)[1].replaceAll(",", ".")));
				projetosJovensPesquisadores[i].setValor(Double.parseDouble(dadosValores.get(i)[1].replaceAll(",", ".")));
			}
		}
				
		this.projetoJovensPesquisadores = projetosJovensPesquisadores; 
	}

	public Media[] getTaxaDeAproveitamento() {
		if (taxaDeAproveitamento == null) {
			Media vazio[] = { new Media(0,0) };
			return vazio;
		}
		
		return taxaDeAproveitamento;
	}

	public void setTaxaDeAproveitamento(Media[] taxaDeAproveitamento) {
		this.taxaDeAproveitamento = taxaDeAproveitamento;
	}

	public Media[] getTaxaDeAbandono() {
		if (taxaDeAbandono == null) {
			Media vazio[] = { new Media(0,0) };
			return vazio;
		}
		
		return taxaDeAbandono;
	}

	public void setTaxaDeAbandono(Media[] taxaDeAbandono) {
		this.taxaDeAbandono = taxaDeAbandono;
	}

	private void preencheDados(HashMap<String, ArrayList<String[]>> informacoes) {
		
		this.setPopulacao(informacoes);
		this.setCensos(informacoes);
		this.setIdebs(informacoes);
		this.setParticipacaoPercentualPIB(informacoes);
		this.setPrimeirosProjetos(informacoes);
		this.setProjetoJovensPesquisadores(informacoes);
		this.setProjetosApoioCnpq(informacoes);
		this.setProjetosInct(informacoes);
		this.setProjetosCienciaTecnologia(informacoes);
		this.setmediaAlunosPorTurma(informacoes);
		this.setMediaHorasAula(informacoes);

	}
	
}
