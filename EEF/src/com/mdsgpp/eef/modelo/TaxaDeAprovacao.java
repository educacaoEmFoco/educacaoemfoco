package com.mdsgpp.eef.modelo;

public class TaxaDeAprovacao extends Media{
	
	public TaxaDeAprovacao() {
	}

	public TaxaDeAprovacao(double primeiroAnoFundamental[], double segundoAnoFundamental[], double terceiroAnoFundamental[],
			double quartoAnoFundamental[],  double quintoAnoFundamental[],  double sextoAnoFundamental[],
			double setimoAnoFundamental[], double oitavoAnoFundamental[], double nonoAnoFundamental[],
			double primeiroAnoMedio[], double segundoAnoMedio[], double terceiroAnoMedio[],
			double quartoAnoMedio[], double medioNaoSeriado[]){
		super(primeiroAnoFundamental, segundoAnoFundamental, terceiroAnoFundamental,
				quartoAnoFundamental, quintoAnoFundamental, sextoAnoFundamental,
				setimoAnoFundamental, oitavoAnoFundamental, nonoAnoFundamental,
				primeiroAnoMedio, segundoAnoMedio, terceiroAnoMedio,
				quartoAnoMedio, medioNaoSeriado);
	}
}
