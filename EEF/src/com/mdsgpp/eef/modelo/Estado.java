package com.mdsgpp.eef.modelo;

import java.util.ArrayList;
import java.util.HashMap;

import android.util.Log;

public class Estado {

	private String nome;
	private String sigla;
	private double participacaoPercentualPIB[];
	private int populacao;
	private Censo censos[];//novo funcionando
	private Ideb idebs[];
	private Media mediaAlunosPorTurma[];//novo funcionando
	private Media mediaHorasAula[];//novo funcionando
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
			censo[i].setAnosFinaisFundamental(Double.parseDouble(dadosFundamentalFinais.get(i)[1].replaceAll("\\.", "")));
			censo[i].setEnsinoMedio(Double.parseDouble(dadosMedio.get(i)[1].replaceAll("\\.", "")));
			censo[i].setAnosIniciaisFundamental(Double.parseDouble(dadosFundamentalIniciais.get(i)[1].replaceAll("\\.", "")));
			censo[i].setMedioEJA(Double.parseDouble(dadosEjaMedio.get(i)[1].replaceAll("\\.", "")));
			censo[i].setFundamentalEJA(Double.parseDouble(dadosEjaFundamental.get(i)[1].replaceAll("\\.", "")));
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

	public Media[] setMedia(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		ArrayList<String[]> dadosFundamental;
		ArrayList<String[]> dadosMedio;
		Media mediaLida[] = null;
		
		dadosFundamental = informacoes.get(nomesIndicativo[0]);
		dadosMedio = informacoes.get(nomesIndicativo[1]);
		
		mediaLida = new Media[dadosMedio.size()];
		for (int i=0; i<mediaLida.length; i++) {
			mediaLida[i] = new Media();
			mediaLida[i].setEstado(this); 
			mediaLida[i].setAno(Integer.parseInt(dadosMedio.get(i)[0]));
			mediaLida[i].setEnsinoFundamental(Double.parseDouble(dadosFundamental.get(i)[1].replaceAll(",", ".")));
			mediaLida[i].setEnsinoMedio(Double.parseDouble(dadosMedio.get(i)[1].replaceAll(",", ".")));
		}
		
		return mediaLida;
	}
	
	public Media[] getMediaAlunosPorTurma() {
		if (mediaAlunosPorTurma == null) {
			Media vazio[] = { new Media(0,0) };
			return vazio;
		}
		
		return mediaAlunosPorTurma;
	}

	public void setMediaAlunosPorTurma(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		this.mediaAlunosPorTurma = this.setMedia(informacoes, nomesIndicativo);
	}

	public Media[] getMediaHorasAula() {
		if (mediaHorasAula == null) {
			Media vazio[] = { new Media(0,0) };
			return vazio;
		}
		
		return mediaHorasAula;
	}

	public void setMediaHorasAula(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		this.mediaHorasAula = this.setMedia(informacoes, nomesIndicativo);
	}

	public Media[] getTaxaDistorcaoIdadeSerie() {
		if (taxaDistorcaoIdadeSerie == null) {
			Media vazio[] = { new Media(0,0) };
			return vazio;
		}
		
		return taxaDistorcaoIdadeSerie;
	}

	public void setTaxaDistorcaoIdadeSerie(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		this.taxaDistorcaoIdadeSerie = this.setMedia(informacoes, nomesIndicativo);
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
	
	public Projeto[] setProjetos(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		ArrayList<String[]> dadosValoresInvestidos = null;
		ArrayList<String[]> dadosQtdProjetos = null;
		Projeto projetosLido[] = null;
		
		if(informacoes.containsKey(nomesIndicativo[0])){
			dadosQtdProjetos = informacoes.get(nomesIndicativo[0]);
			projetosLido = new Projeto[dadosQtdProjetos.size()];
			dadosValoresInvestidos = informacoes.get(nomesIndicativo[1]);
			
		}
		
		for (int i=0; projetosLido!=null && i<projetosLido.length; i++) { 
			projetosLido[i] = new Projeto();
			projetosLido[i].setEstado(this);
			if(i<projetosLido.length-1){
				projetosLido[i].setAno(Integer.parseInt(dadosQtdProjetos.get(i)[0]));
			}
			projetosLido[i].setQuantidade(Integer.parseInt(dadosQtdProjetos.get(i)[1].replaceAll(",", ".")));
			projetosLido[i].setValor(Double.parseDouble(dadosValoresInvestidos.get(i)[1].replaceAll(",", ".")));
		}
		Log.i("teste_set_projetos", nomesIndicativo[0]);
		Log.i("teste_set_projetos", nomesIndicativo[1]);
		
		return projetosLido;
	}

	public void setProjetosCienciaTecnologia(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		this.projetosCienciaTecnologia = this.setProjetos(informacoes, nomesIndicativo);
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

	public void setPrimeirosProjetos(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		this.primeirosProjetos = this.setProjetos(informacoes, nomesIndicativo);
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

	public void setProjetosInct(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		this.projetoInct = this.setProjetos(informacoes, nomesIndicativo);
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

	public void setProjetosApoioCnpq(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		this.projetosApoioCnpq = this.setProjetos(informacoes, nomesIndicativo);
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

	public void setProjetoJovensPesquisadores(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		this.projetoJovensPesquisadores = this.setProjetos(informacoes, nomesIndicativo);
	}

	public Media[] getTaxaDeAproveitamento() {
		if (taxaDeAproveitamento == null) {
			Media vazio[] = { new Media(0,0) };
			return vazio;
		}
		
		return taxaDeAproveitamento;
	}

	public void setTaxaDeAproveitamento(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		this.taxaDeAproveitamento = this.setMedia(informacoes, nomesIndicativo);
	}

	public Media[] getTaxaDeAbandono() {
		if (taxaDeAbandono == null) {
			Media vazio[] = { new Media(0,0) };
			return vazio;
		}
		
		return taxaDeAbandono;
	}

	public void setTaxaDeAbandono(HashMap<String, ArrayList<String[]>> informacoes, String[] nomesIndicativo) {
		this.taxaDeAbandono = this.setMedia(informacoes, nomesIndicativo);
	}

	private void preencheDados(HashMap<String, ArrayList<String[]>> informacoes) {
		String[] indicativosMediaHorasAula = { "horas_aula_ensino_fundamental", "horas_aula_ensino_medio" };
		String[] indicativosMediaAlunosPorTurma = { "alunos_por_turma_ensino_fundamental", "alunos_por_turma_ensino_medio" };
		String[] indicativosProjetosCienciaTecnologia = { "numero_projetos", "valor_investido" };
		String[] indicativosPrimeirosProjetos = { "programa_primeiros_projetos", "valores_programa_primeiros_projetos" };
		String[] indicativosApoioCnpq = { "projetos_apoio_pesquisa_cnpq", "valores_projetos_apoio_pesquisa_cnpq" };
		String[] indicativosJovensPesquisadores = { "jovens_pesquisadores", "valores_jovens_pesquisadores" };
		String[] indicativosProjetosInct = { "projetos_inct", "valores_projetos_inct" };
		String[] taxaDistorcaoIdadeSerie = { "taxa_distorcao_fundamental", "taxa_distorcao_ensino_medio" };
		String[] taxaDeAproveitamento = { "taxa_aprovacao_fundamental", "taxa_aprovacao_medio" };
		String[] taxaDeAbandono = { "taxa_abandono_fundamental", "taxa_abandono_medio" };
		
		this.setPopulacao(informacoes);
		this.setCensos(informacoes);
		this.setIdebs(informacoes);
		this.setParticipacaoPercentualPIB(informacoes);
				
		this.setProjetosInct(informacoes, indicativosProjetosInct);
		this.setProjetoJovensPesquisadores(informacoes, indicativosJovensPesquisadores);
		this.setProjetosApoioCnpq(informacoes, indicativosApoioCnpq);
		this.setPrimeirosProjetos(informacoes, indicativosPrimeirosProjetos);
		this.setProjetosCienciaTecnologia(informacoes, indicativosProjetosCienciaTecnologia);
		
		this.setMediaAlunosPorTurma(informacoes, indicativosMediaAlunosPorTurma);
		this.setMediaHorasAula(informacoes, indicativosMediaHorasAula);
		this.setTaxaDistorcaoIdadeSerie(informacoes, taxaDistorcaoIdadeSerie);
		this.setTaxaDeAproveitamento(informacoes, taxaDeAproveitamento);
		this.setTaxaDeAbandono(informacoes, taxaDeAbandono);

	}
	
}
