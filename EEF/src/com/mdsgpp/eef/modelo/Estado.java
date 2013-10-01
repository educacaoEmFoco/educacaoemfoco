package com.mdsgpp.eef.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Estado {

	private String nome;
	private String sigla;
	private Censo censos[];//vetores, pois, será disponibilizado os valores referentes desde 2010
	private double participacaoPercentualPIB[];
	private int populacao;
	private int numeroDeProjetosCienciaTecnologia[];
	private int valorInvestidoCienciaTecnologia[];
	private Ideb idebs;
	private MediaNotasPorTurma mpt[];
	private MediaHorasAulaDiaria mhad[];
	private ProjetosContratados projetos[];
	private TaxaDistorcaoIdadeSerie tdis[];
	
	public Estado(){
	}
	
	public Estado(String nome, String sigla, HashMap<String, ArrayList<String[]>> informacoes){
		this.nome = nome;
		this.sigla = sigla;
		
		Iterator<String> it = informacoes.keySet().iterator();
		
		while (it.hasNext()) {
			String key = it.next();
			ArrayList<String[]> dadosH = informacoes.get(key);
			
			Ideb ideb = new Ideb();
			double fundamental[] = null;
			double medio[] = null;
			double iniciais[] = null;
			
			if (key.equalsIgnoreCase("populacao")) {
				this.populacao = Integer.parseInt(dadosH.get(0)[1]);
			
			} else if (key.equalsIgnoreCase("5a_8a")) {
				fundamental = new double[dadosH.size()];
				for (int i=0; i<dadosH.size(); i++) {
					fundamental[i] = Double.parseDouble(dadosH.get(i)[1]);
				}
			
			} else if (key.equalsIgnoreCase("ensino_medio")) {
				medio = new double[dadosH.size()];
				for (int i=0; i<dadosH.size(); i++) {
					medio[i] = Double.parseDouble(dadosH.get(i)[1]);
				}
				
			} else if (key.equalsIgnoreCase("series_iniciais")) {
				iniciais = new double[dadosH.size()];
				for (int i=0; i<dadosH.size(); i++) {
					iniciais[i] = Double.parseDouble(dadosH.get(i)[1]);
				}
			}
			
			
			ideb = new Ideb(fundamental, medio, iniciais);
			this.idebs = ideb;
		}
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

	public int[] getValorInvestidoCienciaTecnologia() {
		return valorInvestidoCienciaTecnologia;
	}

	public void setValorInvestidoCienciaTecnologia(
			int[] valorInvestidoCienciaTecnologia) {
		this.valorInvestidoCienciaTecnologia = valorInvestidoCienciaTecnologia;
	}

	public Ideb getIdebs() {
		return idebs;
	}

	public void setIdebs(Ideb idebs) {
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
}
