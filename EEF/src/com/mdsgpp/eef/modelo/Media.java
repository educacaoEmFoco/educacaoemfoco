package com.mdsgpp.eef.modelo;

public abstract class Media {
		private double creche[];
		private double preEscola[];
		private double anosIniciais[];
		private double anosFinais[];
		private double primeiroAnoFundamental[];
		private double segundoAnoFundamental[];
		private double terceiroAnoFundamental[];
		private double quartoAnoFundamental[];
		private double quintoAnoFundamental[];
		private double sextaAnoFundamental[];
		private double setimaAnoFundamental[];
		private double oitavoAnoFundamental[];
		private double nonoAnoFundamental[];
		private double primeiroAnoMedio[];
		private double segundoAnoMedio[];
		private double terceiroAnoMedio[];
		private double quartoAnoMedio[];
		private double medioNaoSeriado[];
		private Estado estado;
		
		public Media() {
		}
		
		public Media(double creche[], double preEscola[], double anosIniciais[], double anosFinais[],
				double primeiroAnoFundamental[], double segundoAnoFundamental[], double terceiroAnoFundamental[],
				double quartoAnoFundamental[],  double quintoAnoFundamental[],  double sextoAnoFundamental[],
				double setimoAnoFundamental[], double oitavoAnoFundamental[], double nonoAnoFundamental[],
				double primeiroAnoMedio[], double segundoAnoMedio[], double terceiroAnoMedio[],
				double quartoAnoMedio[], double medioNaoSeriado[]){
			this.creche = creche;
			this.preEscola = preEscola;
			this.anosIniciais = anosIniciais;
			this.primeiroAnoFundamental = primeiroAnoFundamental;
			this.segundoAnoFundamental = segundoAnoFundamental;
			this.terceiroAnoFundamental = terceiroAnoFundamental;
			this.quartoAnoFundamental = quartoAnoFundamental;
			this.quintoAnoFundamental = quintoAnoFundamental;
			this.sextaAnoFundamental = sextoAnoFundamental;
			this.setimaAnoFundamental = setimoAnoFundamental;
			this.oitavoAnoFundamental = oitavoAnoFundamental;
			this.nonoAnoFundamental = nonoAnoFundamental;
			this.primeiroAnoMedio = primeiroAnoMedio;
			this.segundoAnoMedio = segundoAnoMedio;
			this.terceiroAnoMedio = terceiroAnoMedio;
			this.quartoAnoMedio = quartoAnoMedio;
			this.medioNaoSeriado = medioNaoSeriado;  
			
		}
		
		public Media(double primeiroAnoFundamental[], double segundoAnoFundamental[], double terceiroAnoFundamental[],
				double quartoAnoFundamental[],  double quintoAnoFundamental[],  double sextoAnoFundamental[],
				double setimoAnoFundamental[], double oitavoAnoFundamental[], double nonoAnoFundamental[],
				double primeiroAnoMedio[], double segundoAnoMedio[], double terceiroAnoMedio[],
				double quartoAnoMedio[], double medioNaoSeriado[]){
			this.primeiroAnoFundamental = primeiroAnoFundamental;
			this.segundoAnoFundamental = segundoAnoFundamental;
			this.terceiroAnoFundamental = terceiroAnoFundamental;
			this.quartoAnoFundamental = quartoAnoFundamental;
			this.quintoAnoFundamental = quintoAnoFundamental;
			this.sextaAnoFundamental = sextoAnoFundamental;
			this.setimaAnoFundamental = setimoAnoFundamental;
			this.oitavoAnoFundamental = oitavoAnoFundamental;
			this.nonoAnoFundamental = nonoAnoFundamental;
			this.primeiroAnoMedio = primeiroAnoMedio;
			this.segundoAnoMedio = segundoAnoMedio;
			this.terceiroAnoMedio = terceiroAnoMedio;
			this.quartoAnoMedio = quartoAnoMedio;
			this.medioNaoSeriado = medioNaoSeriado;  
			
		}

		public double[] getCreche() {
			return creche;
		}

		public void setCreche(double[] creche) {
			this.creche = creche;
		}

		public double[] getPreEscola() {
			return preEscola;
		}

		public void setPreEscola(double[] preEscola) {
			this.preEscola = preEscola;
		}

		public double[] getAnosIniciais() {
			return anosIniciais;
		}

		public void setAnosIniciais(double[] anosIniciais) {
			this.anosIniciais = anosIniciais;
		}

		public double[] getAnosFinais() {
			return anosFinais;
		}

		public void setAnosFinais(double[] anosFinais) {
			this.anosFinais = anosFinais;
		}

		public double[] getPrimeiroAnoFundamental() {
			return primeiroAnoFundamental;
		}

		public void setPrimeiroAnoFundamental(double[] primeiroAnoFundamental) {
			this.primeiroAnoFundamental = primeiroAnoFundamental;
		}

		public double[] getSegundoAnoFundamental() {
			return segundoAnoFundamental;
		}

		public void setSegundoAnoFundamental(double[] segundoAnoFundamental) {
			this.segundoAnoFundamental = segundoAnoFundamental;
		}

		public double[] getTerceiroAnoFundamental() {
			return terceiroAnoFundamental;
		}

		public void setTerceiroAnoFundamental(double[] terceiroAnoFundamental) {
			this.terceiroAnoFundamental = terceiroAnoFundamental;
		}

		public double[] getQuartoAnoFundamental() {
			return quartoAnoFundamental;
		}

		public void setQuartoAnoFundamental(double[] quartoAnoFundamental) {
			this.quartoAnoFundamental = quartoAnoFundamental;
		}

		public double[] getQuintoAnoFundamental() {
			return quintoAnoFundamental;
		}

		public void setQuintoAnoFundamental(double[] quintoAnoFundamental) {
			this.quintoAnoFundamental = quintoAnoFundamental;
		}

		public double[] getSextaAnoFundamental() {
			return sextaAnoFundamental;
		}

		public void setSextaAnoFundamental(double[] sextaAnoFundamental) {
			this.sextaAnoFundamental = sextaAnoFundamental;
		}

		public double[] getSetimaAnoFundamental() {
			return setimaAnoFundamental;
		}

		public void setSetimaAnoFundamental(double[] setimaAnoFundamental) {
			this.setimaAnoFundamental = setimaAnoFundamental;
		}

		public double[] getOitavoAnoFundamental() {
			return oitavoAnoFundamental;
		}

		public void setOitavoAnoFundamental(double[] oitavoAnoFundamental) {
			this.oitavoAnoFundamental = oitavoAnoFundamental;
		}

		public double[] getPrimeiroAnoMedio() {
			return primeiroAnoMedio;
		}

		public void setPrimeiroAnoMedio(double[] primeiroAnoMedio) {
			this.primeiroAnoMedio = primeiroAnoMedio;
		}

		public double[] getSegundoAnoMedio() {
			return segundoAnoMedio;
		}

		public void setSegundoAnoMedio(double[] segundoAnoMedio) {
			this.segundoAnoMedio = segundoAnoMedio;
		}

		public double[] getTerceiroAnoMedio() {
			return terceiroAnoMedio;
		}

		public void setTerceiroAnoMedio(double[] terceiroAnoMedio) {
			this.terceiroAnoMedio = terceiroAnoMedio;
		}

		public double[] getQuartoAnoMedio() {
			return quartoAnoMedio;
		}

		public void setQuartoAnoMedio(double[] quartoAnoMedio) {
			this.quartoAnoMedio = quartoAnoMedio;
		}

		public double[] getMedioNaoSeriado() {
			return medioNaoSeriado;
		}

		public void setMedioNaoSeriado(double[] medioNaoSeriado) {
			this.medioNaoSeriado = medioNaoSeriado;
		}

		public double[] getNonoAnoFundamental() {
			return nonoAnoFundamental;
		}

		public void setNonoAnoFundamental(double[] nonoAnoFundamental) {
			this.nonoAnoFundamental = nonoAnoFundamental;
		}

		public Estado getEstado() {
			return estado;
		}

		public void setEstado(Estado estado) {
			this.estado = estado;
		}

}
