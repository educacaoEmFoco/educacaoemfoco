package com.mdsgpp.eef.controle;

import java.io.IOException;
import java.text.DecimalFormat;
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
		DecimalFormat df = new DecimalFormat("#,##0.00");  
		
		informacoes.put("sigla", estado.getSigla() );
		informacoes.put("nome", estado.getNome() );;
		informacoes.put("populacao", estado.getPopulacao() + " habitantes" );
		informacoes.put("percentual_participacao_pib", df.format( estado.getParticipacaoPercentualPIB()[estado.getParticipacaoPercentualPIB().length-1] ) + "%" );
		informacoes.put("projetos_ciencia_tecnologia","Quantidade: " + estado.getNumeroDeProjetosCienciaTecnologia()[estado.getNumeroDeProjetosCienciaTecnologia().length-1] + " projetos" );
		informacoes.put("valor_ciencia_tecnologia", "Valor investido: " + df.format( estado.getValorInvestidoCienciaTecnologia()[estado.getValorInvestidoCienciaTecnologia().length-1] ) + "" );
		informacoes.put("ideb_fundamental_final", "Ensino Fundamental (s�ries finais): "+ df.format( estado.getIdebs()[estado.getIdebs().length-1].getFundamental()) );
		informacoes.put("ideb_ensino_medio", "Ensino M�dio: " +df.format(  estado.getIdebs()[estado.getIdebs().length-1].getMedio() ) + "" );
		informacoes.put("ideb_fundamental_inicial", "Ensino Fundamental (S�ries iniciais): " + df.format( estado.getIdebs()[estado.getIdebs().length-1].getSeriesIniciais() ) + "");
		informacoes.put("quantidade_primeiros_projetos","Quantidade: "+ estado.getPrimeirosProjetos()[estado.getPrimeirosProjetos().length-1].getQuantidade() + " projetos");
		informacoes.put("valor_primeiros_projetos","Valor investido: "+ df.format( estado.getPrimeirosProjetos()[estado.getPrimeirosProjetos().length-1].getValor() ) + "");
		informacoes.put("quantidade_projeto_cnpq","Quantidade: " + estado.getProjetosApoioCnpq()[estado.getProjetosApoioCnpq().length-1].getQuantidade() + " projetos");
		informacoes.put("valor_projetos_cnpq","Valor investido: " + df.format( estado.getProjetosApoioCnpq()[estado.getProjetosApoioCnpq().length-1].getValor() ) + "");
		informacoes.put("quantidade_projeto_jovens_pesquisadores","Quantidade: " + estado.getProjetoJovensPesquisadores()[estado.getProjetoJovensPesquisadores().length-1].getQuantidade() + " projetos");
		informacoes.put("valor_projetos_jovens_pesquisadores","Valor investido: " + df.format( estado.getProjetoJovensPesquisadores()[estado.getProjetoJovensPesquisadores().length-1].getValor() ) + "");
		informacoes.put("quantidade_projetos_iniciacao_cientifica","Quantidade: " + estado.getProjetosInct()[estado.getProjetosInct().length-1].getQuantidade() + " projetos");
		informacoes.put( "valor_projetos_iniciacao_cientifica","Valor investido: " + df.format( estado.getProjetosInct()[estado.getProjetosInct().length-1].getValor() ) + "");
		
		return informacoes;
	}
}
