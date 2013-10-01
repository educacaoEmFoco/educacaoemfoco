package com.mdsgpp.eef.modelo;

public class Estado {

	private Censo censos[];//vetores, pois, será disponibilizado os valores referentes desde 2010
	private double participacaoPercentualPIB[];
	private int populacao[];
	private int numeroDeProjetosCienciaTecnologia[];
	private int valorInvestidoCienciaTecnologia[];
	private Ideb idebs[];
	private MediaNotasPorTurma mpt[];
	private TaxaDeAprovacao ta[];
	private TaxaDeReprovacao tr[];
	private TaxaDeAbandono tAbandono[];
	private ProjetosContratados projetosContratados[];
	
	public Estado(){
	}


	public Estado(Censo censos[], double participacaoPercentualPIB[], int populacao[]){
		this.censos = censos;
		this.participacaoPercentualPIB = participacaoPercentualPIB;
		this.populacao = populacao;
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

	public int[] getPopulacao() {
		return populacao;
	}

	public void setPopulacao(int[] populacao) {
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

	public TaxaDeAprovacao[] getTa() {
		return ta;
	}

	public void setTa(TaxaDeAprovacao[] ta) {
		this.ta = ta;
	}

	public TaxaDeReprovacao[] getTr() {
		return tr;
	}

	public void setTr(TaxaDeReprovacao[] tr) {
		this.tr = tr;
	}

	public TaxaDeAbandono[] gettAbandono() {
		return tAbandono;
	}

	public void settAbandono(TaxaDeAbandono[] tAbandono) {
		this.tAbandono = tAbandono;
	}
	
	public ProjetosContratados[] getProjetosContratados() {
		return projetosContratados;
	}

	public void setProjetosContratados(ProjetosContratados[] projetosContratados) {
		this.projetosContratados = projetosContratados;
	}

	
}
