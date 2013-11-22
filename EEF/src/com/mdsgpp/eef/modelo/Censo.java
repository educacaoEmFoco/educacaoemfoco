package com.mdsgpp.eef.modelo;

public class Censo {

	private double anosIniciaisFundamental;
	private double anosFinaisFundamental;
	private double ensinoMedio;
	private double fundamentalEJA;
	private double medioEJA;
	private int ano;
	private Estado estado;
	
	public Censo() {
	}

	public Censo(double anosIniciaisFundamental, double anosFinaisFundamental,
			     double ensinoMedio, double fundamentalEJA, double medioEJA){

		this.anosIniciaisFundamental = anosIniciaisFundamental;
		this.anosFinaisFundamental = anosFinaisFundamental;
		this.ensinoMedio = ensinoMedio;
		this.fundamentalEJA = fundamentalEJA;
		this.medioEJA = medioEJA;
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
