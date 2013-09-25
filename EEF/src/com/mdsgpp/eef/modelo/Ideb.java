package com.mdsgpp.eef.modelo;

public class Ideb {

	private double fundamental[];
	private double medio[];
	private double seriesIniciais[];
	private Estado estado;
	
	public Ideb() {
	}
	
	public Ideb(double fundamental[], double medio[], double iniciais[]){
		this.fundamental = fundamental;
		this.medio = medio;
		this.seriesIniciais = iniciais;
	}

	public double[] getFundamental() {
		return fundamental;
	}

	public void setFundamental(double[] fundamental) {
		this.fundamental = fundamental;
	}

	public double[] getMedio() {
		return medio;
	}

	public void setMedio(double[] medio) {
		this.medio = medio;
	}

	public double[] getSeriesIniciais() {
		return seriesIniciais;
	}

	public void setSeriesIniciais(double[] seriesIniciais) {
		this.seriesIniciais = seriesIniciais;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}	
}
