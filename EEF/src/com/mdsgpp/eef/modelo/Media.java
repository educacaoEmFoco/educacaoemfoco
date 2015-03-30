package com.mdsgpp.eef.modelo;

public class Media {
	private double ensinoFundamental;
	private double ensinoMedio;
	private int ano;
	private Estado estado;
		
	public Media() {
	}
		
	public Media(double ensinoFundamental, double ensinoMedio){
		this.ensinoFundamental = ensinoFundamental;
		this.ensinoMedio = ensinoMedio;
	}
		
	public double getEnsinoFundamental() {
		return ensinoFundamental;
	}

	public void setEnsinoFundamental(double ensinoFundamental) {
		this.ensinoFundamental = ensinoFundamental;
	}

	public double getEnsinoMedio() {
		return ensinoMedio;
	}

	public void setEnsinoMedio(double ensinoMedio) {
		this.ensinoMedio = ensinoMedio;
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
