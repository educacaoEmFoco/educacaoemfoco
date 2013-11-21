package com.mdsgpp.eef.modelo;

public class Censo {

	private double creche;//somente os dados integrais referentes à "Estadual Municipal"
	private double preEscola;
	private double anosIniciaisFundamental;
	private double anosFinaisFundamental;
	private double ensinoMedio;
	private double fundamentalEJA;
	private double medioEJA;
	private int ano;
	private Estado estado;
	
	public Censo() {
	}

	public Censo(double creche, double preEscola, double anosIniciaisFundamental, double anosFinaisFundamental,
			     double ensinoMedio, double fundamentalEJA, double medioEJA){
		this.creche = creche;
		this.preEscola = preEscola;
		this.anosIniciaisFundamental = anosIniciaisFundamental;
		this.anosFinaisFundamental = anosFinaisFundamental;
		this.ensinoMedio = ensinoMedio;
		this.fundamentalEJA = fundamentalEJA;
		this.medioEJA = medioEJA;
	}
	
	public double getCreche() {
		return creche;
	}

	public void setCreche(double creche) {
		this.creche = creche;
	}

	public double getPreEscola() {
		return preEscola;
	}

	public void setPreEscola(double preEscola) {
		this.preEscola = preEscola;
	}

	public double getAnosIniciaisFundamental() {
		return anosIniciaisFundamental;
	}

	public void setAnosIniciaisFundamental(double anosIniciaisFundamental) {
		this.anosIniciaisFundamental = anosIniciaisFundamental;
	}

	public double getAnosFinaisFundamental() {
		return anosFinaisFundamental;
	}

	public void setAnosFinaisFundamental(double anosFinaisFundamental) {
		this.anosFinaisFundamental = anosFinaisFundamental;
	}

	public double getEnsinoMedio() {
		return ensinoMedio;
	}

	public void setEnsinoMedio(double ensinoMedio) {
		this.ensinoMedio = ensinoMedio;
	}

	public double getFundamentalEJA() {
		return fundamentalEJA;
	}

	public void setFundamentalEJA(double fundamentalEJA) {
		this.fundamentalEJA = fundamentalEJA;
	}

	public double getMedioEJA() {
		return medioEJA;
	}

	public void setMedioEJA(double medioEJA) {
		this.medioEJA = medioEJA;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
}
