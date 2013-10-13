package com.mdsgpp.eef.modelo;

public class Media {
		private double creche;
		private double preEscola;
		private double anosIniciais;
		private double anosFinais;
		private double totalMedio;
		private double medioNaoSeriado;
		private Estado estado;
		
		public Media() {
		}
		
		public Media(double creche, double preEscola, double anosIniciais, double anosFinais,
				double totalMedio, double medioNaoSeriado){
			this.creche = creche;
			this.preEscola = preEscola;
			this.anosIniciais = anosIniciais;
			this.totalMedio = totalMedio;
			this.medioNaoSeriado = medioNaoSeriado;  
			
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

		public double getAnosIniciais() {
			return anosIniciais;
		}

		public void setAnosIniciais(double anosIniciais) {
			this.anosIniciais = anosIniciais;
		}

		public double getAnosFinais() {
			return anosFinais;
		}

		public void setAnosFinais(double anosFinais) {
			this.anosFinais = anosFinais;
		}

		public void setMedioNaoSeriado(double medioNaoSeriado) {
			this.medioNaoSeriado = medioNaoSeriado;
		}

		public Estado getEstado() {
			return estado;
		}

		public void setEstado(Estado estado) {
			this.estado = estado;
		}

		public double getTotalMedio() {
			return totalMedio;
		}

		public void setTotalMedio(double totalMedio) {
			this.totalMedio = totalMedio;
		}

		public double getMedioNaoSeriado() {
			return medioNaoSeriado;
		}
		
}
