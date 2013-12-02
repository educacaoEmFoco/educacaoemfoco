package com.mdsgpp.eef.visao;

import java.io.IOException;
import java.util.ArrayList;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.controle.EstadoControle;
import com.mdsgpp.eef.modelo.Estado;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class TelaEscolheIndicativoGraficoLinha extends Activity{

	private Estado estado;
	private ArrayList<Float> historico = new ArrayList<Float>();

	private String titulo;
	private int posicaoHistorico;
	private Intent intentRecebida;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_escolhe_indicativo_grafico);
		
		intentRecebida = getIntent();
		posicaoHistorico = intentRecebida.getIntExtra("ESTADO", 0);

		estado = capturaInformacoesEstado();
		Log.i("posicao tela escolhe indicativo grafico", posicaoHistorico+"");
		
		// Populacao começa selecionada
		titulo = "População";
		historico.clear();
		historico.add((float) estado.getPopulacao());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_telas, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.sobre:
			abreTelaSobre();
			break;
		case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        break;
		default:
			break;
		}
		
    	return true;
	}
	
	public void abreTelaSobre() {
		Intent intent = new Intent(this, TelaSobreEscolheIndicativoGraficoComparacao.class);
    	startActivity(intent);
	}	

	public void onRadioButtonClicked(View view) {

		int max, tamanho;
		
		switch (view.getId()) {
		case R.id.radio_apoio_cnpq_investimento:
			titulo = "Projetos de Pesquisa Apoio CNPq (R$)";
			historico.clear();
			tamanho = estado.getProjetosApoioCnpq().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) estado.getProjetosApoioCnpq()[i].getValor());
			break;
			
		case R.id.radio_apoio_cnpq_qtd:
			titulo = "Projetos de Pesquisa Apoio CNPq (Qtd.)";
			historico.clear();
			tamanho = estado.getProjetosApoioCnpq().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) estado.getProjetosApoioCnpq()[i]
						.getQuantidade());
			break;
			
		case R.id.radio_difusao_tecnologica_investimento:
			titulo = "Projeto de Difusão Tecnológica (R$)";
			historico.clear();
			tamanho = estado.getProjetosCienciaTecnologia().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) estado.getProjetosCienciaTecnologia()[i]
						.getValor());
			break;
			
		case R.id.radio_difusao_tecnologica_qtd:
			titulo = "Projeto de Difusão Tecnológica (Qtd.)";
			historico.clear();
			tamanho = estado.getProjetosCienciaTecnologia().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) estado.getProjetosCienciaTecnologia()[i]
						.getQuantidade());
			break;
			
		case R.id.radio_ideb_fundamental_finais:
			titulo = "IDEB do Ensino Fundamental (Séries Finais)";
			historico.clear();
			for (int i = 0; i < estado.getIdebs().length; i++)
				historico.add((float) estado.getIdebs()[i].getFundamental());
			break;
			
		case R.id.radio_ideb_fundamental_iniciai:
			titulo = "IDEB do Ensino Fundamental (Séries Iniciais)";
			historico.clear();
			for (int i = 0; i < estado.getIdebs().length; i++)
				historico.add((float) estado.getIdebs()[i].getSeriesIniciais());
			break;
			
		case R.id.radio_ideb_medio:
			titulo = "IDEB do Ensino Médio";
			historico.clear();
			for (int i = 0; i < estado.getIdebs().length; i++)
				historico.add((float) estado.getIdebs()[i].getMedio());
			break;
			
		case R.id.radio_jovens_pesquisadores_investimento:
			titulo = "Jovens pesquisadores (R$)";
			historico.clear();
			tamanho = estado.getProjetoJovensPesquisadores().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) estado.getProjetoJovensPesquisadores()[i]
						.getValor());
			break;

		case R.id.radio_jovens_pesquisadores_qtd:
			titulo = "Jovens pesquisadores (Qtd.)";
			historico.clear();
			tamanho = estado.getProjetoJovensPesquisadores().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) estado.getProjetoJovensPesquisadores()[i]
						.getQuantidade());
			break;

		case R.id.radio_pib:
			titulo = "Participação Estadual no PIB (%)";
			historico.clear();
			for (int i = 0; i < estado.getParticipacaoPercentualPIB().length; i++)
				historico.add((float) estado.getParticipacaoPercentualPIB()[i]);
			break;

		case R.id.radio_populacao:
			titulo = "População";
			historico.clear();
			historico.add((float) estado.getPopulacao());
			Log.i("tamanho hsitorico", ""+historico.size());
			break;

		case R.id.radio_primeiros_projetos_investimento:
			titulo = "Programa Primeiros Projetos (R$)";
			historico.clear();
			tamanho = estado.getPrimeirosProjetos().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) estado.getPrimeirosProjetos()[i]
						.getValor());
			break;

		case R.id.radio_primeiros_projetos_qtd:
			titulo = "Programa Primeiros Projetos (Qtd.)";
			historico.clear();
			tamanho = estado.getPrimeirosProjetos().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) estado.getPrimeirosProjetos()[i]
						.getQuantidade());
			break;

		case R.id.radio_projetos_inct_investimento:
			titulo = "Projetos INCT (R$)";
			historico.clear();
			tamanho = estado.getProjetosInct().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) estado.getProjetosInct()[i].getValor());
			break;

		case R.id.radio_projetos_inct_qtd:
			titulo = "Projetos INCT (Qtd.)";
			historico.clear();
			tamanho = estado.getProjetosInct().length;
			max = tamanho == 1 ? tamanho : (tamanho - 1); 
			for (int i = 0; i < max; i++)
				historico.add((float) estado.getProjetosInct()[i]
						.getQuantidade());
			break;

		case R.id.radio_alunos_por_turma_fundamental:
			titulo = "Média de Alunos por Turma do Ensino Fundamental (Qtd.)";
			historico.clear();
			for (int i = 0; i < estado.getMediaAlunosPorTurma().length; i++)
				historico.add((float) estado.getMediaAlunosPorTurma()[i]
						.getEnsinoFundamental());
			break;

		case R.id.radio_alunos_por_turma_medio:
			titulo = "Média de Alunos por Turma do Ensino Médio (Qtd.)";
			historico.clear();
			for (int i = 0; i < estado.getMediaAlunosPorTurma().length; i++)
				historico.add((float) estado.getMediaAlunosPorTurma()[i]
						.getEnsinoMedio());
			break;

		case R.id.radio_horas_aula_fundamental:
			titulo = "Média de horas aula diárias do Ensino Fundamental";
			historico.clear();
			for (int i = 0; i < estado.getMediaHorasAula().length; i++)
				historico.add((float) estado.getMediaHorasAula()[i]
						.getEnsinoFundamental());
			break;

		case R.id.radio_horas_aula_medio:
			titulo = "Média de horas aula diárias do Ensino Médio";
			historico.clear();
			for (int i = 0; i < estado.getMediaHorasAula().length; i++)
				historico.add((float) estado.getMediaHorasAula()[i]
						.getEnsinoMedio());
			break;

		case R.id.radio_taxa_distorcao_fundamental:
			titulo = "Taxa de Distorção Idade/Série do Ensino Fundamental (%)";
			historico.clear();
			for (int i = 0; i < estado.getTaxaDistorcaoIdadeSerie().length; i++)
				historico.add((float) estado.getTaxaDistorcaoIdadeSerie()[i]
						.getEnsinoFundamental());
			break;

		case R.id.radio_taxa_distorcao_medio:
			titulo = "Taxa de Distorção Idade/Série do Ensino Médio (%)";
			historico.clear();
			for (int i = 0; i < estado.getTaxaDistorcaoIdadeSerie().length; i++)
				historico.add((float) estado.getTaxaDistorcaoIdadeSerie()[i]
						.getEnsinoMedio());
			break;

		case R.id.radio_taxa_aprovacao_fundamental:
			titulo = "Taxa de Aproveitamento do Ensino Fundamental (%)";
			historico.clear();
			for (int i = 0; i < estado.getTaxaDeAproveitamento().length; i++)
				historico.add((float) estado.getTaxaDeAproveitamento()[i]
						.getEnsinoFundamental());
			break;

		case R.id.radio_taxa_aprovacao_medio:
			titulo = "Taxa de Aproveitamento do Ensino Médio (%)";
			historico.clear();
			for (int i = 0; i < estado.getTaxaDeAproveitamento().length; i++)
				historico.add((float) estado.getTaxaDeAproveitamento()[i]
						.getEnsinoMedio());
			break;

		case R.id.radio_taxa_abandono_fundamental:
			titulo = "Taxa de Abandono do Ensino Fundamental (%)";
			historico.clear();
			for (int i = 0; i < estado.getTaxaDeAbandono().length; i++)
				historico.add((float) estado.getTaxaDeAbandono()[i]
						.getEnsinoFundamental());
			break;

		case R.id.radio_taxa_abandono_medio:
			titulo = "Taxa de Abandono do Ensino Médio (%)";
			historico.clear();
			for (int i = 0; i < estado.getTaxaDeAbandono().length; i++)
				historico.add((float) estado.getTaxaDeAbandono()[i]
						.getEnsinoMedio());
			break;

		case R.id.radio_censo_iniciais_fundamental:
			titulo = "Censo Escolar dos Anos Iniciais do Ensino Fundamental (Matriculados)";
			historico.clear();
			for (int i = 0; i < estado.getCensos().length; i++)
				historico.add((float) estado.getCensos()[i]
						.getAnosIniciaisFundamental());
			break;

		case R.id.radio_censo_finais_fundamental:
			titulo = "Censo Escolar dos Anos Finais do Ensino Fundamental (Matriculados)";
			historico.clear();
			for (int i = 0; i < estado.getCensos().length; i++)
				historico.add((float) estado.getCensos()[i]
						.getAnosFinaisFundamental());
			break;

		case R.id.radio_censo_ensino_medio:
			titulo = "Censo Escolar do Ensino Médio (Matriculados)";
			historico.clear();
			for (int i = 0; i < estado.getCensos().length; i++)
				historico.add((float) estado.getCensos()[i].getEnsinoMedio());
			break;

		case R.id.radio_censo_eja_fundamental:
			titulo = "Censo Escolar do EJA - Fundamental (Matriculados)";
			historico.clear();
			for (int i = 0; i < estado.getCensos().length; i++)
				historico
						.add((float) estado.getCensos()[i].getFundamentalEJA());
			break;

		case R.id.radio_censo_eja_medio:
			titulo = "Censo Escolar do EJA - Médio (Matriculados)";
			historico.clear();
			for (int i = 0; i < estado.getCensos().length; i++)
				historico.add((float) estado.getCensos()[i].getMedioEJA());
			break;

		}
	}


	private Estado capturaInformacoesEstado() {
		Estado estado1 = null;
		
		int posicao = posicaoHistorico;
		
		try {
			estado1 = (Estado) EstadoControle.getInstancia(this).obterEstado(posicao);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return estado1;
	}


	public void clickBotaoGrafico(View view) {
		Intent intent = new Intent(this, TelaGraficoLinha.class);
		ArrayList<String> temp = new ArrayList<String>();
		
		for(int i=0; i<historico.size(); i++)
			temp.add(historico.get(i)+"");
		
		intent.putStringArrayListExtra("HISTORICO", temp);
		intent.putExtra("TITULO", titulo);
		startActivity(intent);
	}
	
	public void clickBotaoSobreIndicativos(View view) {
		Intent intent = new Intent(this, TelaEscolheIndicativoGraficoComparacao.class);
		startActivity(intent);
	}

	
}
