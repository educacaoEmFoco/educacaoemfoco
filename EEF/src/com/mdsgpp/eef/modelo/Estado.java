package com.mdsgpp.eef.modelo;

import java.util.ArrayList;
import java.util.HashMap;

import android.util.Log;

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
		
		Log.i("teste", nome+"-"+sigla);
		
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

	public void setParticipacaoPercentualPIB(double[] participacaoPercentualPIB) {
		this.participacaoPercentualPIB = participacaoPercentualPIB;
	}

	public int getPopulacao() {
		return populacao;
	}

	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}

	public int[] getNumeroDeProjetosCienciaTecnologia() {
		if (numeroDeProjetosCienciaTecnologia == null) {
			int[] vazio = {0};
			return vazio;
		}
		
		return numeroDeProjetosCienciaTecnologia;
	}

	public void setNumeroDeProjetosCienciaTecnologia(
			int[] numeroDeProjetosCienciaTecnologia) {
		this.numeroDeProjetosCienciaTecnologia = numeroDeProjetosCienciaTecnologia;
	}

	public double[] getValorInvestidoCienciaTecnologia() {
		if (valorInvestidoCienciaTecnologia == null) {
			double[] vazio = {0};
			return vazio;
		}
		
		return valorInvestidoCienciaTecnologia;
	}

	public void setValorInvestidoCienciaTecnologia(double[] valorInvestidoCienciaTecnologia) {
		this.valorInvestidoCienciaTecnologia = valorInvestidoCienciaTecnologia;
	}

	public Ideb[] getIdebs() {
		if (idebs == null) {
			Ideb vazio[] = { new Ideb(0,0,0) };
			return vazio;
		}
		
		return idebs;
	}

	public void setIdebs(Ideb[] idebs) {
		this.idebs = idebs;
	}

	public Media[] getmediaNotasPorTurma() {
		if (mediaNotasPorTurma == null) {
			Media vazio[] = { new Media(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0) };
			return vazio;
		}
		
		return mediaNotasPorTurma;
	}

	public void setmediaNotasPorTurma(Media[] mediaNotasPorTurma) {
		this.mediaNotasPorTurma = mediaNotasPorTurma;
	}

	public Media[] getMediaHorasAula() {
		if (mediaHorasAula == null) {
			Media vazio[] = { new Media(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0) };
			return vazio;
		}
		
		return mediaHorasAula;
	}

	public void setMediaHorasAula(Media[] mediaHorasAula) {
		this.mediaHorasAula = mediaHorasAula;
	}

	public Media[] getTaxaDistorcaoIdadeSerie() {
		if (taxaDistorcaoIdadeSerie == null) {
			Media vazio[] = { new Media(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0) };
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

	public void setPrimeirosProjetos(Projeto[] primeirosProjetos) {
		this.primeirosProjetos = primeirosProjetos;
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

	public void setProjetosInct(Projeto[] projetoInct) {
		this.projetoInct = projetoInct;
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

	public void setProjetosApoioCnpq(Projeto[] projetosApoioCnpq) {
		this.projetosApoioCnpq = projetosApoioCnpq;
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

	public void setProjetoJovensPesquisadores(Projeto[] projetoJovensPesquisadores) {
		this.projetoJovensPesquisadores = projetoJovensPesquisadores;
	}

	private void preencheDados(HashMap<String, ArrayList<String[]>> informacoes) {
		Ideb ideb[] = null;
		Projeto numPrimProjetos[] = null;
		Projeto numProjInct[] = null;
		Projeto numProjCnpq[] = null;
		Projeto numJovensPesq[] = null;
		ArrayList<String[]> dadosH;
		
		if (informacoes.containsKey("populacao")) {
			dadosH = informacoes.get("populacao");
			this.populacao = Integer.parseInt(dadosH.get(0)[1].replaceAll(",", "."));
		} 
		
		if (informacoes.containsKey("5a_8a")) {
			dadosH = informacoes.get("5a_8a");
			if (ideb == null)
				ideb = new Ideb[dadosH.size()];
			for (int i=0; i<dadosH.size(); i++) {
				if (ideb[i] == null) 
					ideb[i] = new Ideb();
				ideb[i].setEstado(this); // exemplo do set estado, cardinalidade oposta, para os projetos
				if (dadosH.get(i)[1].equalsIgnoreCase("-"))
					ideb[i].setFundamental(0);
				else 
					ideb[i].setFundamental(Double.parseDouble(dadosH.get(i)[1].replaceAll(",", ".")));
			}
		}
		
		if (informacoes.containsKey("ensino_medio")) {
			dadosH = informacoes.get("ensino_medio");
			if (ideb == null)
				ideb = new Ideb[dadosH.size()];
			for (int i=0; i<dadosH.size(); i++) {
				if (ideb[i] == null) 
					ideb[i] = new Ideb();
				if (dadosH.get(i)[1].equalsIgnoreCase("-"))
					ideb[i].setMedio(0);
				else 
					ideb[i].setMedio(Double.parseDouble(dadosH.get(i)[1].replaceAll(",", ".")));
			}
		}
		
		if (informacoes.containsKey("series_iniciais")) {
			dadosH = informacoes.get("series_iniciais");
			if (ideb == null)
				ideb = new Ideb[dadosH.size()];
			for (int i=0; i<dadosH.size(); i++) {
				if (ideb[i] == null) 
					ideb[i] = new Ideb();
				if (dadosH.get(i)[1].equalsIgnoreCase("-"))
					ideb[i].setSeriesIniciais(0);
				else 
					ideb[i].setSeriesIniciais(Double.parseDouble(dadosH.get(i)[1].replaceAll(",", ".")));
			}
		}
		
		if (informacoes.containsKey("projetos_apoio_pesquisa_cnpq")) {
			dadosH = informacoes.get("projetos_apoio_pesquisa_cnpq");
			if (numProjCnpq == null) {
				numProjCnpq = new Projeto[dadosH.size()];
			}
			for (int i=0; i<dadosH.size(); i++) {
				if (numProjCnpq[i] == null) 
					numProjCnpq[i] = new Projeto();
				numProjCnpq[i].setEstado(this);
				if (dadosH.get(i)[1].equalsIgnoreCase("-"))
					numProjCnpq[i].setQuantidade(0);
				else 
					numProjCnpq[i].setQuantidade(Integer.parseInt(dadosH.get(i)[1].replaceAll(",", ".")));
			}
		}
		
		if (informacoes.containsKey("jovens_pesquisadores")) {
			dadosH = informacoes.get("jovens_pesquisadores");
			if (numJovensPesq == null) {
				numJovensPesq = new Projeto[dadosH.size()];
			}
			for (int i=0; i<dadosH.size(); i++) {
				if (numJovensPesq[i] == null) 
					numJovensPesq[i] = new Projeto();
				numJovensPesq[i].setEstado(this);
				if (dadosH.get(i)[1].equalsIgnoreCase("-"))
					numJovensPesq[i].setQuantidade(0);
				else 
					numJovensPesq[i].setQuantidade(Integer.parseInt(dadosH.get(i)[1].replaceAll(",", ".")));
			}
		}
		
		if (informacoes.containsKey("programa_primeiros_projetos")) {
			dadosH = informacoes.get("programa_primeiros_projetos");
			if (numPrimProjetos == null) {
				numPrimProjetos = new Projeto[dadosH.size()];
			}
			for (int i=0; i<dadosH.size(); i++) {
				if (numPrimProjetos[i] == null) 
					numPrimProjetos[i] = new Projeto();
				numPrimProjetos[i].setEstado(this);
				if (dadosH.get(i)[1].equalsIgnoreCase("-"))
					numPrimProjetos[i].setQuantidade(0);
				else 
					numPrimProjetos[i].setQuantidade(Integer.parseInt(dadosH.get(i)[1].replaceAll(",", ".")));
			}
		}
		
		if (informacoes.containsKey("projetos_inct")) {
			dadosH = informacoes.get("projetos_inct");
			if (numProjInct == null) {
				numProjInct = new Projeto[dadosH.size()];
			}
			for (int i=0; i<dadosH.size(); i++) {
				if (numProjInct[i] == null) 
					numProjInct[i] = new Projeto();
				numProjInct[i].setEstado(this);
				if (dadosH.get(i)[1].equalsIgnoreCase("-"))
					numProjInct[i].setQuantidade(0);
				else 
					numProjInct[i].setQuantidade(Integer.parseInt(dadosH.get(i)[1].replaceAll(",", ".")));
			}
		}
		
		if (informacoes.containsKey("valores_projetos_apoio_pesquisa_cnpq")) {
			dadosH = informacoes.get("valores_projetos_apoio_pesquisa_cnpq");
			if (numProjCnpq == null) {
				numProjCnpq = new Projeto[dadosH.size()];
			}
			for (int i=0; i<dadosH.size(); i++) {
				if (numProjCnpq[i] == null) 
					numProjCnpq[i] = new Projeto();
				if (dadosH.get(i)[1].equalsIgnoreCase("-"))
					numProjCnpq[i].setValor(0);
				else 
					numProjCnpq[i].setValor(Double.parseDouble(dadosH.get(i)[1].replaceAll(",", ".")));
			}
		}
		
		if (informacoes.containsKey("valores_projetos_inct")) {
			dadosH = informacoes.get("valores_projetos_inct");
			if (numProjInct == null) {
				numProjInct = new Projeto[dadosH.size()];
			}
			for (int i=0; i<dadosH.size(); i++) {
				if (numProjInct[i] == null) 
					numProjInct[i] = new Projeto();
				if (dadosH.get(i)[1].equalsIgnoreCase("-"))
					numProjInct[i].setValor(0);
				else 
					numProjInct[i].setValor(Double.parseDouble(dadosH.get(i)[1].replaceAll(",", ".")));
			}
		}
		
		if (informacoes.containsKey("valores_programa_primeiros_projetos")) {
			dadosH = informacoes.get("valores_programa_primeiros_projetos");
			if (numPrimProjetos == null) {
				numPrimProjetos = new Projeto[dadosH.size()];
			}
			for (int i=0; i<dadosH.size(); i++) {
				if (numPrimProjetos[i] == null) 
					numPrimProjetos[i] = new Projeto();
				if (dadosH.get(i)[1].equalsIgnoreCase("-"))
					numPrimProjetos[i].setValor(0);
				else 
					numPrimProjetos[i].setValor(Double.parseDouble(dadosH.get(i)[1].replaceAll(",", ".")));
			}
		}
		
		if (informacoes.containsKey("valores_jovens_pesquisadores")) {
			dadosH = informacoes.get("valores_jovens_pesquisadores");
			if (numJovensPesq == null) {
				numJovensPesq = new Projeto[dadosH.size()];
			}
			for (int i=0; i<dadosH.size(); i++) {
				if (numJovensPesq[i] == null) 
					numJovensPesq[i] = new Projeto();
				if (dadosH.get(i)[1].equalsIgnoreCase("-"))
					numJovensPesq[i].setValor(0);
				else 
					numJovensPesq[i].setValor(Double.parseDouble(dadosH.get(i)[1].replaceAll(",", ".")));
			}
		}
		
		if (informacoes.containsKey("participacao_estadual_pib")) {
			dadosH = informacoes.get("participacao_estadual_pib");
			this.participacaoPercentualPIB = new double[dadosH.size()];
			for (int i=0; i<dadosH.size(); i++) {
				if (dadosH.get(i)[1].equalsIgnoreCase("-"))
					this.participacaoPercentualPIB[i] = 0;
				else 
					this.participacaoPercentualPIB[i] = Double.parseDouble(dadosH.get(i)[1].replaceAll(",", "."));
			}
		}
		
		if (informacoes.containsKey("numero_projetos")) {
			dadosH = informacoes.get("numero_projetos");
			this.numeroDeProjetosCienciaTecnologia = new int[dadosH.size()];
			for (int i=0; i<dadosH.size(); i++) {
				if (dadosH.get(i)[1].equalsIgnoreCase("-"))
					this.numeroDeProjetosCienciaTecnologia[i] = 0;
				else 
					this.numeroDeProjetosCienciaTecnologia[i] = Integer.parseInt(dadosH.get(i)[1].replaceAll(",", "."));
			}
		}
		
		if (informacoes.containsKey("valor_investido")) {
			dadosH = informacoes.get("valor_investido");
			this.valorInvestidoCienciaTecnologia = new double[dadosH.size()];
			Log.i("Teste", "quantidade: "+dadosH.size());
			for (int i=0; i<dadosH.size(); i++) {
				if (dadosH.get(i)[1].equalsIgnoreCase("-")) {
					this.valorInvestidoCienciaTecnologia[i] = 0;
				} else 
					this.valorInvestidoCienciaTecnologia[i] = Double.parseDouble(dadosH.get(i)[1].replaceAll(",", "."));
			}
		}
		

		this.setIdebs(ideb);
		this.setPrimeirosProjetos(numPrimProjetos);
		this.setProjetosInct(numProjInct);
		this.setProjetosApoioCnpq(numProjCnpq);
		this.setProjetoJovensPesquisadores(numJovensPesq);
	}
	
}
