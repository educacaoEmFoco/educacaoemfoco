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
	
	public HashMap<String, String> getInformacoesEstado(int posicao, Context context) throws IOException {
		DadosParse parser = new DadosParse(context);
		Estado estado = parser.getEstado(posicao);
		
		HashMap<String, String> informacoes = new HashMap<String, String>();
		
		informacoes.put("sigla", estado.getSigla() );
		informacoes.put("nome", estado.getNome() );;
		informacoes.put("populacao", estado.getPopulacao() + " habitantes" );
		informacoes.put("percentual_participacao_pib", estado.getParticipacaoPercentualPIB()[estado.getParticipacaoPercentualPIB().length-1] + "%" );
		informacoes.put("projetos_ciencia_tecnologia", estado.getNumeroDeProjetosCienciaTecnologia()[estado.getNumeroDeProjetosCienciaTecnologia().length-1] + " projetos" );
		informacoes.put("valor_ciencia_tecnologia", estado.getValorInvestidoCienciaTecnologia()[estado.getValorInvestidoCienciaTecnologia().length-1] + "" );
		informacoes.put("ideb_fundamental_final", "Ensino Fundamental: "+ estado.getIdebs()[estado.getIdebs().length-1].getFundamental());
		informacoes.put("ideb_ensino_medio", "Ensino M�dio: " + estado.getIdebs()[estado.getIdebs().length-1].getMedio() + "");
		informacoes.put("ideb_fundamental_inicial ","Ensino Fundamental:" + estado.getIdebs()[estado.getIdebs().length-1].getSeriesIniciais() + "");
		informacoes.put("quantidade_primeiros_projetos","Quantidade dos Primeiros Projetos:"+ estado.getPrimeirosProjetos()[estado.getPrimeirosProjetos().length-1].getQuantidade() + "");
		informacoes.put("valor_primeiros_projetos","Valor dos Primeiros Projetos:"+ estado.getPrimeirosProjetos()[estado.getPrimeirosProjetos().length-1].getValor() + "");
		informacoes.put("quantidade_projeto_cnpq","Quantidade Projetos  de Apoio Cnpq" + estado.getProjetosApoioCnpq()[estado.getProjetosApoioCnpq().length-1].getQuantidade() + "");
		informacoes.put("valor_projetos_cnpq","Valor dos Projetos de Apoio Cnpq" + estado.getProjetosApoioCnpq()[estado.getProjetosApoioCnpq().length-1].getValor() + "");
		informacoes.put("quantidade_projeto_jovens_pesquisadores","Quantidade de projetos Jovens Pesquisadores" + estado.getProjetoJovensPesquisadores()[estado.getProjetoJovensPesquisadores().length-1].getQuantidade() + "");
		informacoes.put("valor_projetos_jovens_pesquisadores","Valor de projetos Jovens Pesquisadores" + estado.getProjetoJovensPesquisadores()[estado.getProjetoJovensPesquisadores().length-1].getValor() + "");
		informacoes.put("quantidade_projetos_iniciacao_cientifica","Quantidade de projetos de Inicia��o Cient�fica" + estado.getProjetosInct()[estado.getProjetosInct().length-1].getQuantidade() + "");
		informacoes.put( "valor_projetos_iniciacao_cientifica","Valor de projetos de Inicia��o Cient�fica" + estado.getProjetosInct()[estado.getProjetosInct().length-1].getValor() + "");
		return informacoes;
		
	}
}
