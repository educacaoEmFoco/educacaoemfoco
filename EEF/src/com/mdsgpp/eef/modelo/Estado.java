package com.mdsgpp.eef.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import android.util.Log;

public class Estado {

	private String nome;
	private String sigla;
	private Censo censos[]; //vetores, pois, será disponibilizado os valores referentes desde 2010
	private double participacaoPercentualPIB[];
	private int populacao;
	private int numeroDeProjetosCienciaTecnologia[];
	private double valorInvestidoCienciaTecnologia[];
	private Ideb idebs[];
	private MediaNotasPorTurma mpt[];
	private MediaHorasAulaDiaria mhad[];
	private ProjetosContratados projetos[];
	private TaxaDistorcaoIdadeSerie tdis[];
	
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
		return numeroDeProjetosCienciaTecnologia;
	}

	public void setNumeroDeProjetosCienciaTecnologia(
			int[] numeroDeProjetosCienciaTecnologia) {
		this.numeroDeProjetosCienciaTecnologia = numeroDeProjetosCienciaTecnologia;
	}

	public double[] getValorInvestidoCienciaTecnologia() {
		return valorInvestidoCienciaTecnologia;
	}

	public void setValorInvestidoCienciaTecnologia(double[] valorInvestidoCienciaTecnologia) {
		this.valorInvestidoCienciaTecnologia = valorInvestidoCienciaTecnologia;
	}

	public Ideb[] getIdebs() {
		return idebs;
	}

	public void setIdebs(Ideb[] idebs) {
		this.idebs = idebs;
	}

	public MediaNotasPorTurma[] getMpt() {
		return mpt;
	}

	public void setMpt(MediaNotasPorTurma[] mpt) {
		this.mpt = mpt;
	}

	public MediaHorasAulaDiaria[] getMhad() {
		return mhad;
	}

	public void setMhad(MediaHorasAulaDiaria[] mhad) {
		this.mhad = mhad;
	}

	public ProjetosContratados[] getProjetos() {
		return projetos;
	}

	public void setProjetos(ProjetosContratados[] projetos) {
		this.projetos = projetos;
	}

	public TaxaDistorcaoIdadeSerie[] getTdis() {
		return tdis;
	}

	public void setTdis(TaxaDistorcaoIdadeSerie[] tdis) {
		this.tdis = tdis;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
	private void preencheDados(HashMap<String, ArrayList<String[]>> informacoes) {
		Iterator<String> it = informacoes.keySet().iterator();
		Ideb ideb[] = null;
		ProjetosContratados numProjetos[] = null;
		
		while (it.hasNext()) {
			String key = it.next();
			ArrayList<String[]> dadosH = informacoes.get(key);
			
			Log.i("teste",key);
			if (key.equalsIgnoreCase("populacao")) {
				this.populacao = Integer.parseInt(dadosH.get(0)[1].replaceAll(",", "."));
				Log.i("teste",""+this.populacao);
				
			} else if (key.equalsIgnoreCase("5a_8a")) {
				if (ideb == null)
					ideb = new Ideb[dadosH.size()];
				for (int i=0; i<dadosH.size(); i++) {
					if (ideb[i] == null) 
						ideb[i] = new Ideb();
					Log.i("Teste", dadosH.get(i)[1].replaceAll(",", "."));
					if (dadosH.get(i)[1].equalsIgnoreCase("-"))
						ideb[i].setFundamental(0);
					else 
						ideb[i].setFundamental(Double.parseDouble(dadosH.get(i)[1].replaceAll(",", ".")));
				}
			
			} else if (key.equalsIgnoreCase("ensino_medio")) {
				if (ideb == null)
					ideb = new Ideb[dadosH.size()];
				for (int i=0; i<dadosH.size(); i++) {
					if (ideb[i] == null) 
						ideb[i] = new Ideb();
					Log.i("Teste", dadosH.get(i)[1].replaceAll(",", "."));
					if (dadosH.get(i)[1].equalsIgnoreCase("-"))
						ideb[i].setMedio(0);
					else 
						ideb[i].setMedio(Double.parseDouble(dadosH.get(i)[1].replaceAll(",", ".")));
					Log.i("teste",""+ideb[i].getMedio());
				}
				
			} else if (key.equalsIgnoreCase("series_iniciais")) {
				if (ideb == null)
					ideb = new Ideb[dadosH.size()];
				for (int i=0; i<dadosH.size(); i++) {
					if (ideb[i] == null) 
						ideb[i] = new Ideb();
					Log.i("Teste", dadosH.get(i)[1].replaceAll(",", "."));
					if (dadosH.get(i)[1].equalsIgnoreCase("-"))
						ideb[i].setSeriesIniciais(0);
					else 
						ideb[i].setSeriesIniciais(Double.parseDouble(dadosH.get(i)[1].replaceAll(",", ".")));
				}
				
			} else if (key.equalsIgnoreCase("projetos_apoio_pesquisa_cnpq")) {
				if (numProjetos == null) {
					numProjetos = new ProjetosContratados[dadosH.size()];
					Log.i("Teste", "criado");
				}
				for (int i=0; i<dadosH.size(); i++) {
					if (numProjetos[i] == null) 
						numProjetos[i] = new ProjetosContratados();
					Log.i("Teste", dadosH.get(i)[1].replaceAll(",", "."));
					if (dadosH.get(i)[1].equalsIgnoreCase("-"))
						numProjetos[i].setProjetosApoioPesquisacnpq(0);
					else 
						numProjetos[i].setProjetosApoioPesquisacnpq(Integer.parseInt(dadosH.get(i)[1].replaceAll(",", ".")));
				}
				
			} else if (key.equalsIgnoreCase("jovens_pesquisadores")) {
				if (numProjetos == null) {
					numProjetos = new ProjetosContratados[dadosH.size()];
					Log.i("Teste", "criado");
				}
				for (int i=0; i<dadosH.size(); i++) {
					if (numProjetos[i] == null) 
						numProjetos[i] = new ProjetosContratados();
					if (dadosH.get(i)[1].equalsIgnoreCase("-"))
						numProjetos[i].setJovensPesquisadores(0);
					else 
						numProjetos[i].setJovensPesquisadores(Integer.parseInt(dadosH.get(i)[1].replaceAll(",", ".")));
				}
				
			} else if (key.equalsIgnoreCase("programa_primeiros_projetos")) {
				if (numProjetos == null) {
					numProjetos = new ProjetosContratados[dadosH.size()];
					Log.i("Teste", "criado");
				}
				for (int i=0; i<dadosH.size(); i++) {
					if (numProjetos[i] == null) 
						numProjetos[i] = new ProjetosContratados();
					if (dadosH.get(i)[1].equalsIgnoreCase("-"))
						numProjetos[i].setProgramaPrimeirosProjetos(0);
					else 
						numProjetos[i].setProgramaPrimeirosProjetos(Integer.parseInt(dadosH.get(i)[1].replaceAll(",", ".")));
				}
				
			} else if (key.equalsIgnoreCase("projetos_inct")) {
				if (numProjetos == null) {
					numProjetos = new ProjetosContratados[dadosH.size()];
					Log.i("Teste", "criado");
				}
				for (int i=0; i<dadosH.size(); i++) {
					if (numProjetos[i] == null) 
						numProjetos[i] = new ProjetosContratados();
					if (dadosH.get(i)[1].equalsIgnoreCase("-"))
						numProjetos[i].setProjetosInct(0);
					else 
						numProjetos[i].setProjetosInct(Integer.parseInt(dadosH.get(i)[1].replaceAll(",", ".")));
					Log.i("teste",""+numProjetos[i].getProjetosInct());
				}
				
			} else if (key.equalsIgnoreCase("valores_projetos_apoio_pesquisa_cnpq")) {
				if (numProjetos == null) {
					numProjetos = new ProjetosContratados[dadosH.size()];
					Log.i("Teste", "criado");
				}
				Log.i("Teste", "tamanho: "+dadosH.size());
				for (int i=0; i<dadosH.size(); i++) {
					if (numProjetos[i] == null) 
						numProjetos[i] = new ProjetosContratados();
					if (dadosH.get(i)[1].equalsIgnoreCase("-"))
						numProjetos[i].setValoresProjetosApoioPesquisacnpq(0);
					else 
						numProjetos[i].setValoresProjetosApoioPesquisacnpq(Double.parseDouble(dadosH.get(i)[1].replaceAll(",", ".")));
				}
				
			} else if (key.equalsIgnoreCase("valores_projetos_inct")) {
				if (numProjetos == null) {
					numProjetos = new ProjetosContratados[dadosH.size()];
					Log.i("Teste", "criado");
				}
				for (int i=0; i<dadosH.size(); i++) {
					if (numProjetos[i] == null) 
						numProjetos[i] = new ProjetosContratados();
					if (dadosH.get(i)[1].equalsIgnoreCase("-"))
						numProjetos[i].setValoresProjetosInct(0);
					else 
						numProjetos[i].setValoresProjetosInct(Double.parseDouble(dadosH.get(i)[1].replaceAll(",", ".")));
				}
				
			} else if (key.equalsIgnoreCase("valores_programa_primeiros_projetos")) {
				if (numProjetos == null) {
					numProjetos = new ProjetosContratados[dadosH.size()];
					Log.i("Teste", "criado");
				}
				for (int i=0; i<dadosH.size(); i++) {
					if (numProjetos[i] == null) 
						numProjetos[i] = new ProjetosContratados();
					if (dadosH.get(i)[1].equalsIgnoreCase("-"))
						numProjetos[i].setValoresProgamaPrimeirosProjetos(0);
					else 
						numProjetos[i].setValoresProgamaPrimeirosProjetos(Double.parseDouble(dadosH.get(i)[1].replaceAll(",", ".")));
				}
				
			} else if (key.equalsIgnoreCase("valores_jovens_pesquisadores")) {
				if (numProjetos == null) {
					numProjetos = new ProjetosContratados[dadosH.size()];
					Log.i("Teste", "criado");
				}
				for (int i=0; i<dadosH.size(); i++) {
					if (numProjetos[i] == null) 
						numProjetos[i] = new ProjetosContratados();
					if (dadosH.get(i)[1].equalsIgnoreCase("-"))
						numProjetos[i].setValoresJovensPesquisadores(0);
					else 
						numProjetos[i].setValoresJovensPesquisadores(Double.parseDouble(dadosH.get(i)[1].replaceAll(",", ".")));
				}
				
			} else if (key.equalsIgnoreCase("participacao_estadual_pib")) {
				this.participacaoPercentualPIB = new double[dadosH.size()];
				Log.i("Teste", "criado");
				for (int i=0; i<dadosH.size(); i++) {
					
					if (dadosH.get(i)[1].equalsIgnoreCase("-"))
						this.participacaoPercentualPIB[i] = 0;
					else 
						this.participacaoPercentualPIB[i] = Double.parseDouble(dadosH.get(i)[1].replaceAll(",", "."));
				}
				
			} else if (key.equalsIgnoreCase("numero_projetos")) {
				this.numeroDeProjetosCienciaTecnologia = new int[dadosH.size()];
				Log.i("Teste", "criado");
				for (int i=0; i<dadosH.size(); i++) {
					if (dadosH.get(i)[1].equalsIgnoreCase("-"))
						this.numeroDeProjetosCienciaTecnologia[i] = 0;
					else 
						this.numeroDeProjetosCienciaTecnologia[i] = Integer.parseInt(dadosH.get(i)[1].replaceAll(",", "."));
				}
				
			} else if (key.equalsIgnoreCase("valor_investido")) {
				this.valorInvestidoCienciaTecnologia = new double[dadosH.size()];
				Log.i("Teste", "quantidade: "+dadosH.size());
				for (int i=0; i<dadosH.size(); i++) {
					if (dadosH.get(i)[1].equalsIgnoreCase("-")) {
						this.valorInvestidoCienciaTecnologia[i] = 0;
					} else 
						this.valorInvestidoCienciaTecnologia[i] = Double.parseDouble(dadosH.get(i)[1].replaceAll(",", "."));
				}
				
			}
			
		} 
		
		this.setProjetos(numProjetos);
		this.setIdebs(ideb);
	}
	
}
