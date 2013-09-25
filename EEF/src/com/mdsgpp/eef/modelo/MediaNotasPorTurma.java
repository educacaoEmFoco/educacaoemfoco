package com.mdsgpp.eef.modelo;

public class MediaNotasPorTurma extends Media{
	
	public MediaNotasPorTurma(){}

	public MediaNotasPorTurma(double creche[], double preEscola[], double anosIniciais[], double anosFinais[],
			double primeiroAnoFundamental[], double segundoAnoFundamental[], double terceiroAnoFundamental[],
			double quartoAnoFundamental[],  double quintoAnoFundamental[],  double sextoAnoFundamental[],
			double setimoAnoFundamental[], double oitavoAnoFundamental[], double nonoAnoFundamental[],
			double primeiroAnoMedio[], double segundoAnoMedio[], double terceiroAnoMedio[],
			double quartoAnoMedio[], double medioNaoSeriado[]){
		super( creche, preEscola, anosIniciais, anosFinais, primeiroAnoFundamental,
				segundoAnoFundamental, terceiroAnoFundamental, quartoAnoFundamental,
				quintoAnoFundamental,  sextoAnoFundamental, setimoAnoFundamental,
				oitavoAnoFundamental, nonoAnoFundamental, primeiroAnoMedio, segundoAnoMedio,
				terceiroAnoMedio, quartoAnoMedio, medioNaoSeriado);
	}
	
}