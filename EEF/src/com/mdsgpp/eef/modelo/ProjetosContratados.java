package com.mdsgpp.eef.modelo;

public class ProjetosContratados {
	private int jovensPesquisadores[];
	private int programaPrimeirosProjetos[];
	private int projetosApoioPesquisacnpq[];
	private int projetosInct[];
	private double valoresJovensPesquisadores[];
	private double valoresProgamaPrimeirosProjetos[];
	private double valoresProjetosApoioPesquisacnpq[];
	private double valoresProjetosInct[];
	private Estado estado;
		
	public ProjetosContratados(int jovensPesquisadores[],int programaPrimeirosProjetos[],
			int projetosApoioPesquisacnpq[],int projetosInct[],double valoresJovensPesquisadores[],
			double valoresProgamaPrimeirosProjetos[],double valoresProjetosApoioPesquisacnpq[],
			double valoresProjetosInct[]) {
		this.jovensPesquisadores = jovensPesquisadores;
		this.programaPrimeirosProjetos = programaPrimeirosProjetos;
		this.projetosApoioPesquisacnpq = projetosApoioPesquisacnpq;
		this.projetosInct = projetosInct;
		this.valoresJovensPesquisadores = valoresJovensPesquisadores;
		this.valoresProgamaPrimeirosProjetos = valoresProgamaPrimeirosProjetos;
		this.valoresProjetosApoioPesquisacnpq = valoresProjetosApoioPesquisacnpq;
		this.valoresProjetosInct = valoresProjetosInct;
		
	}

	public int[] getJovensPesquisadores() {
		return jovensPesquisadores;
	}

	public void setJovensPesquisadores(int[] jovensPesquisadores) {
		this.jovensPesquisadores = jovensPesquisadores;
	}

	public int[] getProgramaPrimeirosProjetos() {
		return programaPrimeirosProjetos;
	}

	public void setProgramaPrimeirosProjetos(int[] programaPrimeirosProjetos) {
		this.programaPrimeirosProjetos = programaPrimeirosProjetos;
	}

	public int[] getProjetosApoioPesquisacnpq() {
		return projetosApoioPesquisacnpq;
	}

	public void setProjetosApoioPesquisacnpq(int[] projetosApoioPesquisacnpq) {
		this.projetosApoioPesquisacnpq = projetosApoioPesquisacnpq;
	}

	public int[] getProjetosInct() {
		return projetosInct;
	}

	public void setProjetosInct(int[] projetosInct) {
		this.projetosInct = projetosInct;
	}

	public double[] getValoresJovensPesquisadores() {
		return valoresJovensPesquisadores;
	}

	public void setValoresJovensPesquisadores(double[] valoresJovensPesquisadores) {
		this.valoresJovensPesquisadores = valoresJovensPesquisadores;
	}

	public double[] getValoresProgamaPrimeirosProjetos() {
		return valoresProgamaPrimeirosProjetos;
	}

	public void setValoresProgamaPrimeirosProjetos(
			double[] valoresProgamaPrimeirosProjetos) {
		this.valoresProgamaPrimeirosProjetos = valoresProgamaPrimeirosProjetos;
	}

	public double[] getValoresProjetosApoioPesquisacnpq() {
		return valoresProjetosApoioPesquisacnpq;
	}

	public void setValoresProjetosApoioPesquisacnpq(
			double[] valoresProjetosApoioPesquisacnpq) {
		this.valoresProjetosApoioPesquisacnpq = valoresProjetosApoioPesquisacnpq;
	}

	public double[] getValoresProjetosInct() {
		return valoresProjetosInct;
	}

	public void setValoresProjetosInct(double[] valoresProjetosInct) {
		this.valoresProjetosInct = valoresProjetosInct;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	

}
