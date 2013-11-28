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
	private DecimalFormat dfPopulacao = new DecimalFormat("#,###");
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
	
	public HashMap<String, String> lerEstado(int posicao) throws IOException {
		informacoesParse = ParseControle.getInstancia(context).getInformacoes(posicao);
		
		String nomeSigla[] = informacoesParse.get("nome_e_sigla").get(0);
		Estado estado = new Estado(nomeSigla[0], nomeSigla[1], informacoesParse);
		
		escreveEstado(estado);
		
		return this.informacoesEstado;
	
	}
	
	public HashMap<String, String> lerEstadoCompleto(int posicao) throws IOException {
		informacoesParse = ParseControle.getInstancia(context).getInformacoes(posicao);
		
		String nomeSigla[] = informacoesParse.get("nome_e_sigla").get(0);
		Estado estado = new Estado(nomeSigla[0], nomeSigla[1], informacoesParse);
		
		escreveEstadoComTodasInformacoes(estado);
		
		return this.informacoesEstado;
	
	}

	private void escreveEstado(Estado estado) {
		
		PreencherNomeSiglaEPopulacao(estado);
		
		this.informacoesEstado.put("percentual_participacao_pib", dfPorcentagem.format( estado.getParticipacaoPercentualPIB()[estado.getParticipacaoPercentualPIB().length-1] ) + "%" );
		this.informacoesEstado.put("projetos_ciencia_tecnologia","Quantidade: " + estado.getProjetosCienciaTecnologia()[estado.getProjetosCienciaTecnologia().length-1].getQuantidade() + " projetos" );
		this.informacoesEstado.put("valor_ciencia_tecnologia", "Valor investido: R$ " + dfValor.format( estado.getProjetosCienciaTecnologia()[estado.getProjetosCienciaTecnologia().length-1].getValor() ) + " (em mil)" );
		this.informacoesEstado.put("ideb_fundamental_final", "Ensino Fundamental (séries finais): "+ dfPorcentagem.format( estado.getIdebs()[estado.getIdebs().length-1].getFundamental()) );
		this.informacoesEstado.put("ideb_ensino_medio", "Ensino Médio: " +dfPorcentagem.format(  estado.getIdebs()[estado.getIdebs().length-1].getMedio() ) + "" );
		this.informacoesEstado.put("ideb_fundamental_inicial", "Ensino Fundamental (Séries iniciais): " + dfPorcentagem.format( estado.getIdebs()[estado.getIdebs().length-1].getSeriesIniciais() ) + "");
		this.informacoesEstado.put("quantidade_primeiros_projetos","Quantidade: "+ estado.getPrimeirosProjetos()[estado.getPrimeirosProjetos().length-1].getQuantidade() + " projetos");
		this.informacoesEstado.put("valor_primeiros_projetos","Valor investido: R$ "+ dfValor.format( estado.getPrimeirosProjetos()[estado.getPrimeirosProjetos().length-1].getValor() ) + " (em mil)");
		this.informacoesEstado.put("quantidade_projeto_cnpq","Quantidade: " + estado.getProjetosApoioCnpq()[estado.getProjetosApoioCnpq().length-1].getQuantidade() + " projetos");
		this.informacoesEstado.put("valor_projetos_cnpq","Valor investido: R$ " + dfValor.format( estado.getProjetosApoioCnpq()[estado.getProjetosApoioCnpq().length-1].getValor() ) + " (em mil)");
		this.informacoesEstado.put("quantidade_projeto_jovens_pesquisadores","Quantidade: " + estado.getProjetoJovensPesquisadores()[estado.getProjetoJovensPesquisadores().length-1].getQuantidade() + " projetos");
		this.informacoesEstado.put("valor_projetos_jovens_pesquisadores","Valor investido: R$ " + dfValor.format( estado.getProjetoJovensPesquisadores()[estado.getProjetoJovensPesquisadores().length-1].getValor() ) + " (em mil)");
		this.informacoesEstado.put("quantidade_projetos_inct","Quantidade: " + estado.getProjetosInct()[estado.getProjetosInct().length-1].getQuantidade() + " projetos");
		this.informacoesEstado.put("valor_projetos_inct","Valor investido: R$ " + dfValor.format( estado.getProjetosInct()[estado.getProjetosInct().length-1].getValor() ) + " (em mil)");
		
		this.informacoesEstado.put("alunos_por_turma_ensino_fundamental", "Quantidade media de alunos por turma (Fundamental): "+  dfValor.format( estado.getMediaAlunosPorTurma()[estado.getMediaAlunosPorTurma().length-1].getEnsinoFundamental()) );
		this.informacoesEstado.put("alunos_por_turma_ensino_medio", "Quantidade media de alunos por turma (Medio): "+  dfValor.format( estado.getMediaAlunosPorTurma()[estado.getMediaAlunosPorTurma().length-1].getEnsinoMedio()));	
		this.informacoesEstado.put("horas_aula_ensino_fundamental", "Quantidade media de horas de aula(Fundamental): "+  dfValor.format( estado.getMediaHorasAula()[estado.getMediaHorasAula().length-1].getEnsinoFundamental()) );
		this.informacoesEstado.put("horas_aula_ensino_medio", "Quantidade media de horas de aula (Medio): "+  dfValor.format( estado.getMediaHorasAula()[estado.getMediaHorasAula().length-1].getEnsinoMedio()));	
		this.informacoesEstado.put("taxa_distorcao_fundamental", "Quantidade de Distorééo da Idade(Fundamental): "+  dfPorcentagem.format( estado.getTaxaDistorcaoIdadeSerie()[estado.getTaxaDistorcaoIdadeSerie().length-1].getEnsinoFundamental()) );
		this.informacoesEstado.put("taxa_distorcao_medio", "Quantidade de Distorééo da Idade (Medio): "+  dfPorcentagem.format( estado.getTaxaDistorcaoIdadeSerie()[estado.getTaxaDistorcaoIdadeSerie().length-1].getEnsinoMedio()));	
		this.informacoesEstado.put("taxa_aprovacao_fundamental", "Taxa de Aprovaééo (Fundamental): "+  dfPorcentagem.format( estado.getTaxaDeAproveitamento()[estado.getTaxaDeAproveitamento().length-1].getEnsinoFundamental()) );
		this.informacoesEstado.put("taxa_aprovacao_medio", "Taxa de Aprovaééo (Medio): "+  dfPorcentagem.format( estado.getTaxaDeAproveitamento()[estado.getTaxaDeAproveitamento().length-1].getEnsinoMedio()));	
		this.informacoesEstado.put("taxa_abandono_fundamental", "Taxa de Abandono (Fundamental): "+  dfPorcentagem.format( estado.getTaxaDeAbandono()[estado.getTaxaDeAbandono().length-1].getEnsinoFundamental()) );
		this.informacoesEstado.put("taxa_abandono_medio", "Taxa de Abandono (Medio): "+  dfPorcentagem.format( estado.getTaxaDeAbandono()[estado.getTaxaDeAbandono().length-1].getEnsinoMedio()));	
		this.informacoesEstado.put("censo_anos_iniciais_fundamental", "Censo Anos Iniciais (Fundamental): "+  dfPorcentagem.format( estado.getCensos()[estado.getCensos().length-1].getAnosIniciaisFundamental()));	
		this.informacoesEstado.put("censo_anos_finais_fundamental", "Censo Anos Finais (Fundamental): "+  dfPorcentagem.format( estado.getCensos()[estado.getCensos().length-1].getAnosFinaisFundamental()));
		this.informacoesEstado.put("censo_ensino_medio", "Censo Ensino Médio: "+  dfPorcentagem.format( estado.getCensos()[estado.getCensos().length-1].getEnsinoMedio()));	
		this.informacoesEstado.put("censo_eja_fundamental", "Censo EJA (Fundamental): "+  dfPorcentagem.format( estado.getCensos()[estado.getCensos().length-1].getFundamentalEJA()));
		this.informacoesEstado.put("censo_eja_medio", "Censo EJA (Medio): "+  dfPorcentagem.format( estado.getCensos()[estado.getCensos().length-1].getMedioEJA()));	
		
	}
	
	private void escreveEstadoComTodasInformacoes(Estado estado) {
		String temp="";

		PreencherNomeSiglaEPopulacao(estado);
		
		for(int i=0, ano = 1995; i<estado.getParticipacaoPercentualPIB().length; i++, ano++)
			temp += ano + ": " + dfPorcentagem.format(estado.getParticipacaoPercentualPIB()[i]) + "%\n";
		this.informacoesEstado.put("percentual_participacao_pib", temp);
		temp = "";
		
		for(int i=0, ano = 2003; i<estado.getProjetosCienciaTecnologia().length; i++, ano++){
			temp += ano + ": " + "Quantidade: "+ estado.getProjetosCienciaTecnologia()[i].getQuantidade() + " projetos\n" +
					"\t\t " + "  Valor investido: R$ " + dfValor.format(estado.getProjetosCienciaTecnologia()[i].getValor()) + " (em mil)\n\n";
		}
		this.informacoesEstado.put("projetos_ciencia_tecnologia",temp);
		temp="";
		
		for(int i=0, ano=2005; i<estado.getIdebs().length; i++, ano++){
			temp += ano + ": " + "Ensino Fundamental (séries finais): "+ dfPorcentagem.format( estado.getIdebs()[i].getFundamental()) + "\n" +
					"\t\t  " + "Ensino Médio: " +dfPorcentagem.format(  estado.getIdebs()[i].getMedio() ) + "\n" +
					"\t\t  " + "Ensino Fundamental (Séries iniciais): " + dfPorcentagem.format( estado.getIdebs()[i].getSeriesIniciais() ) + "\n\n";
			
		}
		this.informacoesEstado.put("ideb", temp);
		
		for(int i=0, ano=2005; i<estado.getPrimeirosProjetos().length; i++, ano++){
			temp += ano + ": " + "Quantidade: "+ estado.getPrimeirosProjetos()[i].getQuantidade() + " projetos\n" +
					"\t\t  " + "Valor investido: R$ "+ dfValor.format( estado.getPrimeirosProjetos()[estado.getPrimeirosProjetos().length-1].getValor() ) + " (em mil)\n\n";
		}
		this.informacoesEstado.put("primeiros_projetos",temp);
		temp="";
		
		for(int i=0, ano=2005; i<estado.getPrimeirosProjetos().length; i++, ano++){
			temp += ano + ": " + "Quantidade: " + estado.getProjetosApoioCnpq()[i].getQuantidade() + " projetos\n" +
					"\t\t  " + "Valor investido: R$ " + dfValor.format( estado.getProjetosApoioCnpq()[i].getValor() ) + " (em mil)\n\n";	
		}
		this.informacoesEstado.put("cnpq",temp);
		temp="";
		
		this.informacoesEstado.put("quantidade_projeto_jovens_pesquisadores","Quantidade: " + estado.getProjetoJovensPesquisadores()[estado.getProjetoJovensPesquisadores().length-1].getQuantidade() + " projetos");
		this.informacoesEstado.put("valor_projetos_jovens_pesquisadores","Valor investido: R$ " + dfValor.format( estado.getProjetoJovensPesquisadores()[estado.getProjetoJovensPesquisadores().length-1].getValor() ) + " (em mil)");
		this.informacoesEstado.put("quantidade_projetos_inct","Quantidade: " + estado.getProjetosInct()[estado.getProjetosInct().length-1].getQuantidade() + " projetos");
		this.informacoesEstado.put("valor_projetos_inct","Valor investido: R$ " + dfValor.format( estado.getProjetosInct()[estado.getProjetosInct().length-1].getValor() ) + " (em mil)");
		
		this.informacoesEstado.put("alunos_por_turma_ensino_fundamental", "Quantidade media de alunos por turma (Fundamental): "+  dfValor.format( estado.getMediaAlunosPorTurma()[estado.getMediaAlunosPorTurma().length-1].getEnsinoFundamental()) );
		this.informacoesEstado.put("alunos_por_turma_ensino_medio", "Quantidade media de alunos por turma (Medio): "+  dfValor.format( estado.getMediaAlunosPorTurma()[estado.getMediaAlunosPorTurma().length-1].getEnsinoMedio()));	
		this.informacoesEstado.put("horas_aula_ensino_fundamental", "Quantidade media de horas de aula(Fundamental): "+  dfValor.format( estado.getMediaHorasAula()[estado.getMediaHorasAula().length-1].getEnsinoFundamental()) );
		this.informacoesEstado.put("horas_aula_ensino_medio", "Quantidade media de horas de aula (Medio): "+  dfValor.format( estado.getMediaHorasAula()[estado.getMediaHorasAula().length-1].getEnsinoMedio()));	
		this.informacoesEstado.put("taxa_distorcao_fundamental", "Quantidade de Distorééo da Idade(Fundamental): "+  dfPorcentagem.format( estado.getTaxaDistorcaoIdadeSerie()[estado.getTaxaDistorcaoIdadeSerie().length-1].getEnsinoFundamental()) );
		this.informacoesEstado.put("taxa_distorcao_medio", "Quantidade de Distorééo da Idade (Medio): "+  dfPorcentagem.format( estado.getTaxaDistorcaoIdadeSerie()[estado.getTaxaDistorcaoIdadeSerie().length-1].getEnsinoMedio()));	
		this.informacoesEstado.put("taxa_aprovacao_fundamental", "Taxa de Aprovaééo (Fundamental): "+  dfPorcentagem.format( estado.getTaxaDeAproveitamento()[estado.getTaxaDeAproveitamento().length-1].getEnsinoFundamental()) );
		this.informacoesEstado.put("taxa_aprovacao_medio", "Taxa de Aprovaééo (Medio): "+  dfPorcentagem.format( estado.getTaxaDeAproveitamento()[estado.getTaxaDeAproveitamento().length-1].getEnsinoMedio()));	
		this.informacoesEstado.put("taxa_abandono_fundamental", "Taxa de Abandono (Fundamental): "+  dfPorcentagem.format( estado.getTaxaDeAbandono()[estado.getTaxaDeAbandono().length-1].getEnsinoFundamental()) );
		this.informacoesEstado.put("taxa_abandono_medio", "Taxa de Abandono (Medio): "+  dfPorcentagem.format( estado.getTaxaDeAbandono()[estado.getTaxaDeAbandono().length-1].getEnsinoMedio()));	
		this.informacoesEstado.put("censo_anos_iniciais_fundamental", "Censo Anos Iniciais (Fundamental): "+  dfPorcentagem.format( estado.getCensos()[estado.getCensos().length-1].getAnosIniciaisFundamental()));	
		this.informacoesEstado.put("censo_anos_finais_fundamental", "Censo Anos Finais (Fundamental): "+  dfPorcentagem.format( estado.getCensos()[estado.getCensos().length-1].getAnosFinaisFundamental()));
		this.informacoesEstado.put("censo_ensino_medio", "Censo Ensino Médio: "+  dfPorcentagem.format( estado.getCensos()[estado.getCensos().length-1].getEnsinoMedio()));	
		this.informacoesEstado.put("censo_eja_fundamental", "Censo EJA (Fundamental): "+  dfPorcentagem.format( estado.getCensos()[estado.getCensos().length-1].getFundamentalEJA()));
		this.informacoesEstado.put("censo_eja_medio", "Censo EJA (Medio): "+  dfPorcentagem.format( estado.getCensos()[estado.getCensos().length-1].getMedioEJA()));	
		
	}

	private void PreencherNomeSiglaEPopulacao(Estado estado) {
		this.informacoesEstado.clear();
		
		this.informacoesEstado.put("sigla", estado.getSigla() );
		this.informacoesEstado.put("nome", estado.getNome() );;
		this.informacoesEstado.put("populacao", dfPopulacao.format( estado.getPopulacao() ) + " habitantes" );
	}

}
