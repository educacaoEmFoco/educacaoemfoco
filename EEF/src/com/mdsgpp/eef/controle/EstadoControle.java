package com.mdsgpp.eef.controle;

import java.io.IOException;
import java.util.ArrayList;

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
		
		ArrayList<String> informacoes = new ArrayList<String>();
		
		informacoes.add( estado.getSigla() );
		informacoes.add( estado.getNome() );;
		informacoes.add( estado.getPopulacao() + " habitantes" );
		informacoes.add( estado.getParticipacaoPercentualPIB()[estado.getParticipacaoPercentualPIB().length-1] + "%" );
		informacoes.add( estado.getNumeroDeProjetosCienciaTecnologia()[estado.getNumeroDeProjetosCienciaTecnologia().length-1] + " projetos" );
		informacoes.add( estado.getValorInvestidoCienciaTecnologia()[estado.getValorInvestidoCienciaTecnologia().length-1] + "" );
		informacoes.add( "Ensino Fundamental (séries finais): " + estado.getIdebs()[estado.getIdebs().length-1].getFundamental());
		informacoes.add( "Ensino Médio: " + estado.getIdebs()[estado.getIdebs().length-1].getMedio() + "");
		informacoes.add( "Ensino Fundamental (séries iniciais): " + estado.getIdebs()[estado.getIdebs().length-1].getSeriesIniciais() + "");
		informacoes.add( estado.getPrimProj()[estado.getPrimProj().length-1].getQuantidade() + "");
		informacoes.add( estado.getPrimProj()[estado.getPrimProj().length-1].getValor() + "");
		informacoes.add( estado.getCnpq()[estado.getCnpq().length-1].getQuantidade() + "");
		informacoes.add( estado.getCnpq()[estado.getCnpq().length-1].getValor() + "");
		informacoes.add( estado.getJovensPesq()[estado.getJovensPesq().length-1].getQuantidade() + "");
		informacoes.add( estado.getJovensPesq()[estado.getJovensPesq().length-1].getValor() + "");
		informacoes.add( estado.getpInct()[estado.getpInct().length-1].getQuantidade() + "");
		informacoes.add( estado.getpInct()[estado.getpInct().length-1].getValor() + "");
		
		return informacoes; 
	}
}
