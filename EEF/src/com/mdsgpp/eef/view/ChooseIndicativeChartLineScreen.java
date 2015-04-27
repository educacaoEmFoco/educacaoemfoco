package com.mdsgpp.eef.view;

import java.io.IOException;
import java.util.ArrayList;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.controller.StateController;
import com.mdsgpp.eef.model.State;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ChooseIndicativeChartLineScreen extends Activity {

	private State state;
	private ArrayList<Float> historico = new ArrayList<Float>();
	private String titulo;
	private String indicativo;
	private int posicaoHistorico;
	private Intent intentRecebida;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_escolhe_indicativo_grafico);

		intentRecebida = getIntent();
		posicaoHistorico = intentRecebida.getIntExtra("ESTADO", 0);

		state = capturaInformacoesState();
		Log.i("posicao tela escolhe indicativo grafico", posicaoHistorico + "");

		// Populacao begins selected.
		titulo = "Popula��o";
		indicativo = "populacao";
		historico.clear();
		historico.add((float) state.getPopulation());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_telas, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
			case R.id.sobre:
				abreTelaSobre();
				break;
			case android.R.id.home:
		        NavUtils.navigateUpFromSameTask(this);
		        break;
			default:
				// Do nothing.
				break;
		}

    	return true;
	}

	// Open the screen about.
	public void abreTelaSobre() {
		Intent intent = new Intent(this, TelaSobreEscolheIndicativoGraficoComparacao.class);
    	startActivity(intent);
	}

	// Get wich option on raddio button is selected.
	public void onRadioButtonClicked(View view) {
		int max;
		int tamanho;

		switch (view.getId()) {
			case R.id.radio_apoio_cnpq_investimento:
				titulo = "Projetos de Pesquisa Apoio CNPq (R$)";
				indicativo = "cnpq";
				historico.clear();
				tamanho = state.getProjetosApoioCnpq().length;
				max = tamanho == 1 ? tamanho : (tamanho - 1);

				for(int i = 0; i < max; i++) {
					historico.add((float) state.getProjetosApoioCnpq()[i].getValor());
				}

				break;
			case R.id.radio_apoio_cnpq_qtd:
				titulo = "Projetos de Pesquisa Apoio CNPq (Qtd.)";
				indicativo = "cnpq";
				historico.clear();
				tamanho = state.getProjetosApoioCnpq().length;
				max = tamanho == 1 ? tamanho : (tamanho - 1);

				for(int i = 0; i < max; i++) {
					historico.add((float) state.getProjetosApoioCnpq()[i].getQuantidade());
				}

				break;
			case R.id.radio_difusao_tecnologica_investimento:
				titulo = "Projeto de Difus�o Tecnol�gica (R$)";
				indicativo = "projetos_ciencia_tecnologia";
				historico.clear();
				tamanho = state.getProjetosCienciaTecnologia().length;
				max = tamanho == 1 ? tamanho : (tamanho - 1);

				for(int i = 0; i < max; i++) {
					historico.add((float) state.getProjetosCienciaTecnologia()[i].getValor());
				}

				break;
			case R.id.radio_difusao_tecnologica_qtd:
				titulo = "Projeto de Difus�o Tecnol�gica (Qtd.)";
				indicativo = "projetos_ciencia_tecnologia";
				historico.clear();
				tamanho = state.getProjetosCienciaTecnologia().length;
				max = tamanho == 1 ? tamanho : (tamanho - 1);

				for(int i = 0; i < max; i++) {
					historico.add((float) state.getProjetosCienciaTecnologia()[i].getQuantidade());
				}

				break;
			case R.id.radio_ideb_fundamental_finais:
				titulo = "IDEB do Ensino Fundamental (S�ries Finais)";
				indicativo = "ideb";
				historico.clear();

				for(int i = 0; i < state.getIdebs().length; i++) {
					historico.add((float) state.getIdebs()[i].getElementarySchool());
				}

				break;
			case R.id.radio_ideb_fundamental_iniciai:
				titulo = "IDEB do Ensino Fundamental (S�ries Iniciais)";
				indicativo = "ideb";
				historico.clear();

				for(int i = 0; i < state.getIdebs().length; i++) {
					historico.add((float) state.getIdebs()[i].getSeriesIniciais());
				}

				break;
			case R.id.radio_ideb_medio:
				titulo = "IDEB do Ensino M�dio";
				indicativo = "ideb";
				historico.clear();

				for(int i = 0; i < state.getIdebs().length; i++) {
					historico.add((float) state.getIdebs()[i].getMedio());
				}

				break;
			case R.id.radio_jovens_pesquisadores_investimento:
				titulo = "Jovens pesquisadores (R$)";
				indicativo = "jovens_pesquisadores";
				historico.clear();
				tamanho = state.getProjetoJovensPesquisadores().length;
				max = tamanho == 1 ? tamanho : (tamanho - 1);

				for(int i = 0; i < max; i++) {
					historico.add((float) state.getProjetoJovensPesquisadores()[i].getValor());
				}

				break;
			case R.id.radio_jovens_pesquisadores_qtd:
				titulo = "Jovens pesquisadores (Qtd.)";
				indicativo = "jovens_pesquisadores";
				historico.clear();
				tamanho = state.getProjetoJovensPesquisadores().length;
				max = tamanho == 1 ? tamanho : (tamanho - 1);

				for(int i = 0; i < max; i++) {
					historico.add((float) state.getProjetoJovensPesquisadores()[i].getQuantidade());
				}

				break;
			case R.id.radio_pib:
				titulo = "Participa��o Estadual no PIB (%)";
				indicativo = "percentual_participacao_pib";
				historico.clear();

				for(int i = 0; i < state.getParticipacaoPercentualPIB().length; i++) {
					historico.add((float) state.getParticipacaoPercentualPIB()[i]);
				}

				break;
			case R.id.radio_populacao:
				titulo = "Popula��o";
				indicativo = "populacao";
				historico.clear();
				historico.add((float) state.getPopulacao());
				Log.i("tamanho hsitorico", "" + historico.size());

				break;
			case R.id.radio_primeiros_projetos_investimento:
				titulo = "Programa Primeiros Projetos (R$)";
				indicativo = "primeiros_projetos";
				historico.clear();
				tamanho = state.getPrimeirosProjetos().length;
				max = tamanho == 1 ? tamanho : (tamanho - 1);

				for(int i = 0; i < max; i++) {
					historico.add((float) state.getPrimeirosProjetos()[i].getValor());
				}

				break;
			case R.id.radio_primeiros_projetos_qtd:
				titulo = "Programa Primeiros Projetos (Qtd.)";
				indicativo = "primeiros_projetos";
				historico.clear();
				tamanho = state.getPrimeirosProjetos().length;
				max = tamanho == 1 ? tamanho : (tamanho - 1);

				for(int i = 0; i < max; i++) {
					historico.add((float) state.getPrimeirosProjetos()[i].getQuantidade());
				}

				break;
			case R.id.radio_projetos_inct_investimento:
				titulo = "Projetos INCT (R$)";
				indicativo = "projetos_inct";
				historico.clear();
				tamanho = state.getProjetosInct().length;
				max = tamanho == 1 ? tamanho : (tamanho - 1);
				
				for(int i = 0; i < max; i++) {
					historico.add((float) state.getProjetosInct()[i].getValor());
				}

				break;
			case R.id.radio_projetos_inct_qtd:
				titulo = "Projetos INCT (Qtd.)";
				indicativo = "projetos_inct";
				historico.clear();
				tamanho = state.getProjetosInct().length;
				max = tamanho == 1 ? tamanho : (tamanho - 1);

				for(int i = 0; i < max; i++) {
					historico.add((float) state.getProjetosInct()[i].getQuantidade());
				}

				break;
			case R.id.radio_alunos_por_turma_fundamental:
				titulo = "M�dia de Alunos por Turma do Ensino Fundamental (Qtd.)";
				indicativo = "alunos_por_turma_ensino_medio";
				historico.clear();

				for(int i = 0; i < state.getMediaAlunosPorTurma().length; i++) {
					historico.add((float) state.getMediaAlunosPorTurma()[i].getEnsinoFundamental());
				}

				break;
			case R.id.radio_alunos_por_turma_medio:
				titulo = "M�dia de Alunos por Turma do Ensino M�dio (Qtd.)";
				indicativo = "alunos_por_turma_ensino_medio";
				historico.clear();

				for(int i = 0; i < state.getMediaAlunosPorTurma().length; i++) {
					historico.add((float) state.getMediaAlunosPorTurma()[i].getEnsinoMedio());
				}

				break;
			case R.id.radio_horas_aula_fundamental:
				titulo = "M�dia de horas aula di�rias do Ensino Fundamental";
				indicativo = "horas_aula_ensino_medio";
				historico.clear();

				for(int i = 0; i < state.getMediaHorasAula().length; i++) {
					historico.add((float) state.getMediaHorasAula()[i].getEnsinoFundamental());
				}

				break;
			case R.id.radio_horas_aula_medio:
				titulo = "M�dia de horas aula di�rias do Ensino M�dio";
				indicativo = "horas_aula_ensino_medio";
				historico.clear();

				for(int i = 0; i < state.getMediaHorasAula().length; i++) {
					historico.add((float) state.getMediaHorasAula()[i].getEnsinoMedio());
				}

				break;
			case R.id.radio_taxa_distorcao_fundamental:
				titulo = "Taxa de Distor��o Idade/S�rie do Ensino Fundamental (%)";
				indicativo = "taxa_distorcao";
				historico.clear();

				for(int i = 0; i < state.getTaxaDistorcaoIdadeSerie().length; i++) {
					historico.add((float)
							state.getTaxaDistorcaoIdadeSerie()[i].getEnsinoFundamental());
				}

				break;
			case R.id.radio_taxa_distorcao_medio:
				titulo = "Taxa de Distor��o Idade/S�rie do Ensino M�dio (%)";
				indicativo = "taxa_distorcao";
				historico.clear();

				for(int i = 0; i < state.getTaxaDistorcaoIdadeSerie().length; i++) {
					historico.add((float) state.getTaxaDistorcaoIdadeSerie()[i].getEnsinoMedio());
				}

				break;
			case R.id.radio_taxa_aprovacao_fundamental:
				titulo = "Taxa de Aproveitamento do Ensino Fundamental (%)";
				indicativo = "taxa_aprovacao";
				historico.clear();

				for(int i = 0; i < state.getTaxaDeAproveitamento().length; i++) {
					historico.add((float) 
							state.getTaxaDeAproveitamento()[i].getEnsinoFundamental());
				}

				break;
			case R.id.radio_taxa_aprovacao_medio:
				titulo = "Taxa de Aproveitamento do Ensino M�dio (%)";
				indicativo = "taxa_aprovacao";
				historico.clear();

				for(int i = 0; i < state.getTaxaDeAproveitamento().length; i++) {
					historico.add((float) state.getTaxaDeAproveitamento()[i].getEnsinoMedio());
				}

				break;
			case R.id.radio_taxa_abandono_fundamental:
				titulo = "Taxa de Abandono do Ensino Fundamental (%)";
				indicativo = "taxa_abandono";
				historico.clear();

				for(int i = 0; i < state.getTaxaDeAbandono().length; i++) {
					historico.add((float) state.getTaxaDeAbandono()[i].getEnsinoFundamental());
				}

				break;
			case R.id.radio_taxa_abandono_medio:
				titulo = "Taxa de Abandono do Ensino M�dio (%)";
				indicativo = "taxa_abandono";
				historico.clear();

				for(int i = 0; i < state.getTaxaDeAbandono().length; i++) {
					historico.add((float) state.getTaxaDeAbandono()[i].getEnsinoMedio());
				}

				break;
			case R.id.radio_censo_iniciais_fundamental:
				titulo = "Censo Escolar dos Anos Iniciais do Ensino Fundamental (Matriculados)";
				indicativo = "censo";
				historico.clear();

				for(int i = 0; i < state.getCensos().length; i++) {
					historico.add((float) state.getCensos()[i].getElementarySchoolEarlyYears());
				}

				break;
			case R.id.radio_censo_finais_fundamental:
				titulo = "Censo Escolar dos Anos Finais do Ensino Fundamental (Matriculados)";
				indicativo = "censo";
				historico.clear();

				for(int i = 0; i < state.getCensos().length; i++) {
					historico.add((float) state.getCensos()[i].getElementarySchoolFinalYears());
				}

				break;
			case R.id.radio_censo_ensino_medio:
				titulo = "Censo Escolar do Ensino M�dio (Matriculados)";
				indicativo = "censo";
				historico.clear();

				for(int i = 0; i < state.getCensos().length; i++) {
					historico.add((float) state.getCensos()[i].getHighSchool());
				}

				break;
			case R.id.radio_censo_eja_fundamental:
				titulo = "Censo Escolar do EJA - Fundamental (Matriculados)";
				indicativo = "censo";
				historico.clear();

				for(int i = 0; i < state.getCensos().length; i++) {
					historico.add((float) state.getCensos()[i].getEJAElementarySchool());
				}

				break;
			case R.id.radio_censo_eja_medio:
				titulo = "Censo Escolar do EJA - M�dio (Matriculados)";
				indicativo = "censo";
				historico.clear();

				for(int i = 0; i < state.getCensos().length; i++) {
					historico.add((float) state.getCensos()[i].getEJAHighSchool());
				}

				break;
		}
	}

	// Get the informations about the selected state.
	private State capturaInformacoesState() {
		State state1 = null;

		int posicao = posicaoHistorico;

		try {
			state1 = (State) StateController.getInstance(this).obtainState(posicao);
		} catch(IOException e) {
			e.printStackTrace();
		}

		return state1;
	}

	// Implements the action on button next.
	public void clickBotaoAvancar(View view) {
		Intent intent = new Intent(this, GraphLineScreen.class);
		ArrayList<String> temp = new ArrayList<String>();

		for(int i = 0; i < historico.size(); i++) {
			temp.add(historico.get(i) + "");
		}

		intent.putStringArrayListExtra("HISTORICO", temp);
		intent.putExtra("TITULO", titulo);
		intent.putExtra("POSICAO_ESTADO", posicaoHistorico);
		intent.putExtra("INDICATIVO_GRAFICO", indicativo);
		startActivity(intent);
	}
}
