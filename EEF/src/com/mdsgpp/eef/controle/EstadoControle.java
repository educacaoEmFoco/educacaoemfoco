package com.mdsgpp.eef.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;

import com.mdsgpp.eef.modelo.Estado;
import com.mdsgpp.eef.parse.DadosParse;

public class EstadoControle {
	
	private static EstadoControle instancia;
	
	public EstadoControle() {
	}
	
	public static EstadoControle getInstancia() {
		if (instancia == null)
			instancia = new EstadoControle();
		return instancia; 
	}
	
	public ArrayList<String> getInformacoesEstado(int posicao, Context context) throws IOException {
		DadosParse parser = new DadosParse(context);
		Estado estado = parser.getEstado(posicao);
		
		HashMap<String, String> informacoes = new HashMap<String, String>();
		
		informacoes.put("sigla", estado.getSigla() );
		informacoes.put("nome", estado.getNome() );;
		informacoes.put("populacao", estado.getPopulacao() + " habitantes" );
		informacoes.put("percentual_participacao_pib", estado.getParticipacaoPercentualPIB()[estado.getParticipacaoPercentualPIB().length-1] + "%" );
		informacoes.put("projetos_ciencia_tecnologia", estado.getNumeroDeProjetosCienciaTecnologia()[estado.getNumeroDeProjetosCienciaTecnologia().length-1] + " projetos" );
		informacoes.put("valor_ciencia_tecnologia", estado.getValorInvestidoCienciaTecnologia()[estado.getValorInvestidoCienciaTecnologia().length-1] + "" );
		informacoes.add( "Ensino Fundamental (séries finais): " + estado.getIdebs()[estado.getIdebs().length-1].getFundamental());
		informacoes.add( "Ensino Médio: " + estado.getIdebs()[estado.getIdebs().length-1].getMedio() + "");
		informacoes.add( "Ensino Fundamental (séries iniciais): " + estado.getIdebs()[estado.getIdebs().length-1].getSeriesIniciais() + "");
		informacoes.add( estado.getPrimeirosProjetos()[estado.getPrimeirosProjetos().length-1].getQuantidade() + "");
		informacoes.add( estado.getPrimeirosProjetos()[estado.getPrimeirosProjetos().length-1].getValor() + "");
		informacoes.add( estado.getProjetosApoioCnpq()[estado.getProjetosApoioCnpq().length-1].getQuantidade() + "");
		informacoes.add( estado.getProjetosApoioCnpq()[estado.getProjetosApoioCnpq().length-1].getValor() + "");
		informacoes.add( estado.getProjetoJovensPesquisadores()[estado.getProjetoJovensPesquisadores().length-1].getQuantidade() + "");
		informacoes.add( estado.getProjetoJovensPesquisadores()[estado.getProjetoJovensPesquisadores().length-1].getValor() + "");
		informacoes.add( estado.getProjetosInct()[estado.getProjetosInct().length-1].getQuantidade() + "");
		informacoes.add( estado.getProjetosInct()[estado.getProjetosInct().length-1].getValor() + "");

		
		return informacoes; 
	}
}
