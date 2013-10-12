package com.mdsgpp.eef.controle;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;

import com.mdsgpp.eef.modelo.Estado;

public class EstadoControle {
	
	private static EstadoControle instancia;
	private Context context;
	private HashMap<String, String> informacoesEstado;
	private HashMap<String, ArrayList<String[]>> informacoesParse;
	private DecimalFormat dfValor = new DecimalFormat("#,##0.00");
	private DecimalFormat dfPopulação = new DecimalFormat("#,###");
	private DecimalFormat dfPorcentagem = new DecimalFormat("#.##");
	
	public EstadoControle(Context contextActivity) {
		this.context = contextActivity;
		this.informacoesEstado = new HashMap<String, String>();
		this.informacoesParse = new HashMap<String, ArrayList<String[]>>();
	}
	
	public static EstadoControle getInstancia(Context contextActivity) {
		if (instancia == null)
			instancia = new EstadoControle(contextActivity);
		return instancia; 
	}
	
	public HashMap<String, String> getInformacoesEstado(int posicao) throws IOException {	
		return informacoesEstado;
	}
	
	public HashMap<String, String> lerEstado(int posicao) throws IOException {
		informacoesParse = ParseControle.getInstancia(context).getInformacoes(posicao);
		
		String nomeSigla[] = informacoesParse.get("nome_e_sigla").get(0);
		Estado estado = new Estado(nomeSigla[0], nomeSigla[1], informacoesParse);
		
		informacoesEstado.put("sigla", estado.getSigla() );
		informacoesEstado.put("nome", estado.getNome() );;
		informacoesEstado.put("populacao", dfPopulação.format( estado.getPopulacao() ) + " habitantes" );
		informacoesEstado.put("percentual_participacao_pib", dfPorcentagem.format( estado.getParticipacaoPercentualPIB()[estado.getParticipacaoPercentualPIB().length-1] ) + "%" );
		informacoesEstado.put("projetos_ciencia_tecnologia","Quantidade: " + estado.getNumeroDeProjetosCienciaTecnologia()[estado.getNumeroDeProjetosCienciaTecnologia().length-1] + " projetos" );
		informacoesEstado.put("valor_ciencia_tecnologia", "Valor investido: R$ " + dfValor.format( estado.getValorInvestidoCienciaTecnologia()[estado.getValorInvestidoCienciaTecnologia().length-1] ) + " (em mil)" );
		informacoesEstado.put("ideb_fundamental_final", "Ensino Fundamental (séries finais): "+ dfPorcentagem.format( estado.getIdebs()[estado.getIdebs().length-1].getFundamental()) );
		informacoesEstado.put("ideb_ensino_medio", "Ensino Médio: " +dfPorcentagem.format(  estado.getIdebs()[estado.getIdebs().length-1].getMedio() ) + "" );
		informacoesEstado.put("ideb_fundamental_inicial", "Ensino Fundamental (Séries iniciais): " + dfPorcentagem.format( estado.getIdebs()[estado.getIdebs().length-1].getSeriesIniciais() ) + "");
		informacoesEstado.put("quantidade_primeiros_projetos","Quantidade: "+ estado.getPrimeirosProjetos()[estado.getPrimeirosProjetos().length-1].getQuantidade() + " projetos");
		informacoesEstado.put("valor_primeiros_projetos","Valor investido: R$ "+ dfValor.format( estado.getPrimeirosProjetos()[estado.getPrimeirosProjetos().length-1].getValor() ) + " (em mil)");
		informacoesEstado.put("quantidade_projeto_cnpq","Quantidade: " + estado.getProjetosApoioCnpq()[estado.getProjetosApoioCnpq().length-1].getQuantidade() + " projetos");
		informacoesEstado.put("valor_projetos_cnpq","Valor investido: R$ " + dfValor.format( estado.getProjetosApoioCnpq()[estado.getProjetosApoioCnpq().length-1].getValor() ) + " (em mil)");
		informacoesEstado.put("quantidade_projeto_jovens_pesquisadores","Quantidade: " + estado.getProjetoJovensPesquisadores()[estado.getProjetoJovensPesquisadores().length-1].getQuantidade() + " projetos");
		informacoesEstado.put("valor_projetos_jovens_pesquisadores","Valor investido: R$ " + dfValor.format( estado.getProjetoJovensPesquisadores()[estado.getProjetoJovensPesquisadores().length-1].getValor() ) + " (em mil)");
		informacoesEstado.put("quantidade_projetos_inct","Quantidade: " + estado.getProjetosInct()[estado.getProjetosInct().length-1].getQuantidade() + " projetos");
		informacoesEstado.put( "valor_projetos_inct","Valor investido: R$ " + dfValor.format( estado.getProjetosInct()[estado.getProjetosInct().length-1].getValor() ) + " (em mil)");
	
		return getInformacoesEstado(posicao);
	}

}
