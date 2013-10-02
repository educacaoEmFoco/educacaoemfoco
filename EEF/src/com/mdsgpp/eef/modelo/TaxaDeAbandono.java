package com.mdsgpp.eef.modelo;

public class TaxaDeAbandono extends Media{
	
	public TaxaDeAbandono() {
	}

	public TaxaDeAbandono(double primeiroAnoFundamental, double segundoAnoFundamental, double terceiroAnoFundamental,
			double quartoAnoFundamental,  double quintoAnoFundamental,  double sextoAnoFundamental,
			double setimoAnoFundamental, double oitavoAnoFundamental, double nonoAnoFundamental,
			double primeiroAnoMedio, double segundoAnoMedio, double terceiroAnoMedio,
			double quartoAnoMedio, double medioNaoSeriado){
		super(primeiroAnoFundamental, segundoAnoFundamental, terceiroAnoFundamental,
				quartoAnoFundamental, quintoAnoFundamental, sextoAnoFundamental,
				setimoAnoFundamental, oitavoAnoFundamental, nonoAnoFundamental,
				primeiroAnoMedio, segundoAnoMedio, terceiroAnoMedio,
				quartoAnoMedio, medioNaoSeriado);
	}
}
