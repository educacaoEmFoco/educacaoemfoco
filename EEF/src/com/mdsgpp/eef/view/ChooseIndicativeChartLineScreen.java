/***********************************************************************************
 * File: ChooseIndicativeChartLineScreen.java
 * 
 * Purpose: Screen where the user will choose the indicatives to generate the chart.
 ***********************************************************************************/

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
	// ArrayList with the values of the indicatives used.
	private ArrayList<Float> history = new ArrayList<Float>(); 

	private String title;
	private String indicative;
	private int historyPosition;
	private Intent receivedIntent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_escolhe_indicativo_grafico);
		
		receivedIntent = getIntent();
		historyPosition = receivedIntent.getIntExtra("ESTADO", 0);

		state = catchStateInformation();
		Log.i("position tela escolhe indicative grafico", historyPosition + "");
		
		// Population begins selected.
		title = "Population";
		indicative = "populacao";
		history.clear();
		history.add((float) state.getPopulation());
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
				openAboutScreen();
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
	
	// Open the about screen of this screen.
	public void openAboutScreen() {
		Intent intent = new Intent(this, IndicativeChoosenChartComparsionAboutScreen.class);
    	startActivity(intent);
	}	
	
	/*
	 *  Fulfill the history with the values in "reais" (R$) of the investment in Cnpq support
	 *  Projects.
	 */
	private void fulfillHistoryWithCnpqSupportProjectsValues() {
		title = "Projetos de Pesquisa Apoio CNPq (R$)";
		indicative = "cnpq";
		history.clear();
		int size = this.state.getCnpqSupportProjects().length;
		int max = size == 1 ? size : (size - 1); 

		for(int index = 0; index < max; index++) {
			history.add((float) state.getCnpqSupportProjects()[index].getValue());
		}
	}
	
	// Fulfill the history with the quantity of Cnpq support Projects.
	private void fulfillHistoryWithCnpqSupportProjectsQuantity() {
		title = "Projetos de Pesquisa Apoio CNPq (Qtd.)";
		indicative = "cnpq";
		history.clear();
		int size = this.state.getCnpqSupportProjects().length;
		int max = size == 1 ? size : (size - 1);
	
		for(int index = 0; index < max; index++) {
			history.add((float) state.getCnpqSupportProjects()[index].getQuantity());
		}
	}
	
	/*
	 *  Fulfill the history with the values in "reais" (R$) of the investment in
	 *  Science and Technology projects.
	 */
	
	private void fulfillHistoryWithScienceTechnologyProjectsValues() {
		this.title = "Projeto de Difus�o Tecnol�gica (R$)";
		this.indicative = "projetos_ciencia_tecnologia";
		this.history.clear();
		int size = this.state.getScienceTechnologyProjects().length;
		int max = ((size == 1) ? size : (size - 1));
	
		for(int index = 0; index < max; index++) {
			history.add((float) state.getScienceTechnologyProjects()[index].getValue());
		}
	}
	
	// Fulfill the history with the quantity Science and Technology projects.
	private void fulfillHistoryWithScienceTechnologyProjectsQuantity() {
		title = "Projeto de Difus�o Tecnol�gica (Qtd.)";
		indicative = "projetos_ciencia_tecnologia";
		history.clear();
		int size = this.state.getScienceTechnologyProjects().length;
		int max = ((size == 1) ? size : (size - 1));

		for(int index = 0; index < max; index++) {
			history.add((float) state.getScienceTechnologyProjects()[index].getQuantity());
		}
	}
	
	// Fulfill the history with the values of the index related Elementary School.
	private void fulfillHistoryWithIdebElementarySchool() {
		title = "IDEB do Ensino Fundamental (S�ries Finais)";
		indicative = "ideb";
		history.clear();
		int size = this.state.getIdebs().length;
		int max = ((size == 1) ? size : (size -1));
	
		for(int index = 0; index < max; index++) {
			history.add((float) state.getIdebs()[index].getElementarySchool());
		}
	}
	
	// Fulfill the history with the values of the index related to Early Grades.
	private void fulfillHistoryWithIdebEarlyGrades() {
		title = "IDEB do Ensino Fundamental (S�ries Iniciais)";
		indicative = "ideb";
		history.clear();
		int size = this.state.getIdebs().length;
		int max = ((size == 1) ? size : (size - 1));
		
		for(int index = 0; index < max; index++) {
			history.add((float) state.getIdebs()[index].getEarlyGrades());
		}
	}
	
	// Fulfill the history with the values of the index related to High School.
	private void fulfillHistoryWithIdebHighSchool() {
		title = "IDEB do Ensino M�dio";
		indicative = "ideb";
		history.clear();
		int size = this.state.getIdebs().length;
		int max = ((size == 1) ? size : (size -1));
	
		for(int index = 0; index < max; index++) {
			history.add((float) state.getIdebs()[index].getHighSchool());
		}
	}
	
	/*
	 *  Fulfill the history with the values in "reais" (R$) of the investment in Young Research
	 *  Projects.
	 */
	private void fulfillHistoryWithYoungResearchersValues() {
		title = "Jovens pesquisadores (R$)";
		indicative = "jovens_pesquisadores";
		history.clear();
		int size = state.getYoungResearchersProject().length;
		int max = size == 1 ? size : (size - 1);
	
		for(int index = 0; index < max; index++) {
			history.add((float) state.getYoungResearchersProject()[index].getValue());
		}
	}
	
	// Fulfill the history with the quantity of Young Researchers projects.
	private void fulfillHistoryWithYoungResearchersQuantity() {
		title = "Jovens pesquisadores (Qtd.)";
		indicative = "jovens_pesquisadores";
		history.clear();
		int size = state.getYoungResearchersProject().length;
		int max = size == 1 ? size : (size - 1);

		for(int index = 0; index < max; index++) {
			history.add((float) 
				state.getYoungResearchersProject()[index].getQuantity());
		}
	}
	
	// Fulfill the history with the current state PIB Participation.
	private void fulfillHistoryWithStatePIBParticipation() {
		title = "Participa��o Estadual no PIB (%)";
		indicative = "percentual_participacao_pib";
		history.clear();
		int size = state.getPIBPercentParticipation().length;
		int max = size == 1 ? size : (size - 1);
		for(int index = 0; index < max ; index++) {
			history.add((float) state.getPIBPercentParticipation()[index]);
		}
	}
	
	// Fulfill the history with the current state population.
	private void fulfillHistoryWithPopulation() {
		title = "Popula��o";
		indicative = "populacao";
		history.clear();
		history.add((float) state.getPopulation());
		Log.i("size hsitorico", "" + history.size());
	}
	
	//  Fulfill the history with the values in "reais" (R$) of the investment in First Projects.
	private void fulfillHistoryWithFirstProjectsValues() {
		title = "Programa Primeiros Projetos (R$)";
		indicative = "primeiros_projetos";
		history.clear();
		int size = state.getFirstProjects().length;
		int max = size == 1 ? size : (size - 1);

		for(int index = 0; index < max; index++) {
			history.add((float) state.getFirstProjects()[index].getValue());
		}
	}
	
	// Fulfill the history with the quantity of First Projects.
	private void fulfillHistoryWithFirstProjectsQuantity() {
		title = "Programa Primeiros Projetos (Qtd.)";
		indicative = "primeiros_projetos";
		history.clear();
		int size = state.getFirstProjects().length;
		int max = size == 1 ? size : (size - 1);

		for(int i = 0; i < max; i++) {
			history.add((float) state.getFirstProjects()[i].getQuantity());
		}
	}
	
	// Fulfill the history with the values in "reais" (R$) of the investment in INCT Projects.
	private void fulfillHistoryWithInctProjectsValues() {
		
		title = "Projetos INCT (R$)";
		indicative = "projetos_inct";
		history.clear();
		int size = state.getInctProjects().length;
		int max = size == 1 ? size : (size - 1); 
		for(int index = 0; index < max; index++) {
			history.add((float) state.getInctProjects()[index].getValue());
		}
	}
	
	// Fulfill the history with the quantity of the INCT projects.
	private void fulfillHistoryWithInctProjectsQuantity() {
		title = "Projetos INCT (Qtd.)";
		indicative = "projetos_inct";
		history.clear();
		int size = state.getInctProjects().length;
		int max = size == 1 ? size : (size - 1);

		for(int index = 0; index < max; index++) {
			history.add((float) state.getInctProjects()[index].getQuantity());
		}
	}
	
	// Fulfill the history with the quantity of students in class of the elementary school.
	private void fulfillHistoryWithElementarySchoolAverageClassSize() {
		title = "M�dia de Alunos por Turma do Ensino Fundamental (Qtd.)";
		indicative = "alunos_por_turma_ensino_medio";
		history.clear();
		int size = state.getAverageClassSize().length;
		int max = size == 1 ? size : (size - 1);
	
		for(int index = 0; index < max; index++) {
			history.add((float) state.getAverageClassSize()[index].getElementarySchool());
		}
	}
	
	// Fulfill the history with the quantity of students in class of the high school.
	private void fulfillHistoryWithHighSchoolAverageClassSize() {
		title = "M�dia de Alunos por Turma do Ensino M�dio (Qtd.)";
		indicative = "alunos_por_turma_ensino_medio";
		history.clear();
		int size = state.getAverageClassSize().length;
		int max = size == 1 ? size : (size - 1);

		for(int index = 0; index < max; index++) {
			history.add((float) state.getAverageClassSize()[index].getHighSchool());
		}
	}
	
	// Fulfill the history with the average class hour per day of the elementary school.
	private void fulfillHistoryWithElementarySchoolAverageClassHours() {
		title = "M�dia de horas aula di�rias do Ensino Fundamental";
		indicative = "horas_aula_ensino_medio";
		history.clear();
		int size = state.getAverageClassHours().length;
		int max = size == 1 ? size : (size - 1);
		
		for(int index = 0; index < max; index++) {
			history.add((float) state.getAverageClassHours()[index].getElementarySchool());
		}
	}
	
	// Fulfill the history with the average class hour per day of the high school.
	private void fulfillHistoryWithHighSchoolAverageClassHours() {
		title = "M�dia de horas aula di�rias do Ensino M�dio";
		indicative = "horas_aula_ensino_medio";
		history.clear();
		int size = state.getAverageClassHours().length;
		int max = size == 1 ? size : (size - 1);
		
		for(int index = 0; index < max; index++) {
			history.add((float) state.getAverageClassHours()[index].getHighSchool());
		}
	}
	
	// Fulfill the history with the Age/Series distortion rate of the elementary schools.
	private void fulfillHistoryWithElementarySchoolAgeSeriesDistortionRate() {
		title = "Taxa de Distor��o Idade/S�rie do Ensino Fundamental (%)";
		indicative = "taxa_distorcao";
		history.clear();
		int size = state.getAgeSeriesDistortionRate().length;
		int max = size == 1 ? size : (size - 1);
		
		for(int index = 0; index < max; index++) {
			history.add((float) state.getAgeSeriesDistortionRate()[index].getElementarySchool());
		}
	}
	
	// Fulfill the history with the Age/Series distortion rate of the high school.
	private void fulfillHistoryWithHighSchoolAgeSeriesDistortionRate() {
		title = "Taxa de Distor��o Idade/S�rie do Ensino M�dio (%)";
		indicative = "taxa_distorcao";
		history.clear();
		int size = state.getAgeSeriesDistortionRate().length;
		int max = size == 1 ? size : (size - 1);
		
		for(int index = 0; index < max; index++) {
			history.add((float) state.getAgeSeriesDistortionRate()[index].getHighSchool());
		}
	}
	
	// Fulfill the history with the utilization rate of students on the elementary school.
	private void fulfillHistoryWithElementarySchoolUtilizationRate() {
		title = "Taxa de Aproveitamento do Ensino Fundamental (%)";
		indicative = "taxa_aprovacao";
		history.clear();
		int size = state.getUtilizationRate().length;
		int max = size == 1 ? size : (size - 1);
		
		for(int index = 0; index < max; index++) {
			history.add((float) 
				state.getUtilizationRate()[index].getElementarySchool());
		}
	}
	
	// Fulfill history with the utilization rate of students of the high school.
	private void fulfillHistoryWithHighSchoolUtilizationRate() {
		title = "Taxa de Aproveitamento do Ensino M�dio (%)";
		indicative = "taxa_aprovacao";
		history.clear();
		int size = state.getUtilizationRate().length;
		int max = size == 1 ? size : (size - 1);
		
		for(int index = 0; index < max; index++) {
			history.add((float) state.getUtilizationRate()[index].getHighSchool());
		}
	}
	
	// Fulfill the history with the dropout rate of students of the elementary school.
	private void fulfillHistoryWithElementarySchoolDropoutRate() {
		title = "Taxa de Abandono do Ensino Fundamental (%)";
		indicative = "taxa_abandono";
		history.clear();
		int size = state.getDropoutRate().length;
		int max = size == 1 ? size : (size - 1);
		
		for(int index = 0; index < max; index++) {
			history.add((float) state.getDropoutRate()[index].getElementarySchool());
		}
	}
	
	// Fulfill the history with the dropout rate of students of the high school.
	private void fulfillHistoryWithHighSchoolDropoutRate() {
		title = "Taxa de Abandono do Ensino M�dio (%)";
		indicative = "taxa_abandono";
		history.clear();
		int size = state.getDropoutRate().length;
		int max = size == 1 ? size : (size - 1);
		
		for(int index = 0; index < max; index++) {
			history.add((float) state.getDropoutRate()[index].getHighSchool());
		}
	}
	
	// Fulfill the history with the census of the early years of school.
	private void fulfillHistoryWithEarlyYearsCensus() {
		title = "Censo Escolar dos Anos Iniciais do Ensino Fundamental (Matriculados)";
		indicative = "censo";
		history.clear();
		int size = state.getCensus().length;
		int max = size == 1 ? size : (size - 1);
		
		for(int index = 0; index < max; index++) {
			history.add((float) state.getCensus()[index].getElementarySchoolEarlyYears());
		}
	}
	
	// Fulfill the history with the census of the final years of school.
	private void fulfillHistoryWithFinalYearsCensus() {
		title = "Censo Escolar dos Anos Finais do Ensino Fundamental (Matriculados)";
		indicative = "censo";
		history.clear();
		int size = state.getCensus().length;
		int max = size == 1 ? size : (size - 1);
		
		for(int index = 0; index < max; index++) {
			history.add((float) state.getCensus()[index].getElementarySchoolFinalYears());
		}
	}
	
	// Fulfill the history with the census of the high school.
	private void fulfillHistoryWithHighSchoolCensus() {
		title = "Censo Escolar do Ensino M�dio (Matriculados)";
		indicative = "censo";
		history.clear();
		int size = state.getCensus().length;
		int max = size == 1 ? size : (size - 1);
		
		for(int index = 0; index < max; index++) {
			history.add((float) state.getCensus()[index].getHighSchool());
		}
	}
	
	// Fulfill the history with the census of EJA elementary school.
	private void fulfillHistoryWithEJAElementarySchoolCensus() {
		title = "Censo Escolar do EJA - Fundamental (Matriculados)";
		indicative = "censo";
		history.clear();
		int size = state.getCensus().length;
		int max = size == 1 ? size : (size - 1);
		
		for(int index = 0; index < max; index++) {
			history.add((float) state.getCensus()[index].getEJAElementarySchool());
		}
	}
	
	// Fulfill the history with the census of EJA high school.
	private void fulfillHistoryWithEJAHighSchoolCensus() {
		title = "Censo Escolar do EJA - M�dio (Matriculados)";
		indicative = "censo";
		history.clear();
		int size = state.getCensus().length;
		int max = size == 1 ? size : (size - 1);
		
		for(int index = 0; index < max; index++) {
			history.add((float) state.getCensus()[index].getEJAHighSchool());
		}
	}
	/*
	 *  Get which option on radio button is selected and fulfill the history with the information
	 *  related to the chosen option.
	 */
	public void onRadioButtonClicked(View view) {
		switch (view.getId()) {
			case R.id.radio_apoio_cnpq_investimento:
				fulfillHistoryWithCnpqSupportProjectsValues();
				
				break;
			case R.id.radio_apoio_cnpq_qtd:
				fulfillHistoryWithCnpqSupportProjectsQuantity();
				
				break;
			case R.id.radio_difusao_tecnologica_investimento:
				fulfillHistoryWithScienceTechnologyProjectsValues();
				
				break;
			case R.id.radio_difusao_tecnologica_qtd:
				fulfillHistoryWithScienceTechnologyProjectsQuantity();
				
				break;
			case R.id.radio_ideb_fundamental_finais:
				fulfillHistoryWithIdebElementarySchool();
				
				break;
			case R.id.radio_ideb_fundamental_iniciai:
				fulfillHistoryWithIdebEarlyGrades();
				
				break;
			case R.id.radio_ideb_medio:
				fulfillHistoryWithIdebHighSchool();
	
				break;
			case R.id.radio_jovens_pesquisadores_investimento:
				fulfillHistoryWithYoungResearchersValues();
			
				break;
			case R.id.radio_jovens_pesquisadores_qtd:
				fulfillHistoryWithYoungResearchersQuantity();
			
				break;
			case R.id.radio_pib:
				fulfillHistoryWithStatePIBParticipation();
			
				break;
			case R.id.radio_populacao:
				fulfillHistoryWithPopulation();

				break;
			case R.id.radio_primeiros_projetos_investimento:
				fulfillHistoryWithFirstProjectsValues();
			
				break;
			case R.id.radio_primeiros_projetos_qtd:
				fulfillHistoryWithFirstProjectsQuantity();
				
				break;
			case R.id.radio_projetos_inct_investimento:
				fulfillHistoryWithInctProjectsValues();
			
				break;
			case R.id.radio_projetos_inct_qtd:
				fulfillHistoryWithInctProjectsQuantity();
				
				break;
			case R.id.radio_alunos_por_turma_fundamental:
				fulfillHistoryWithElementarySchoolAverageClassSize();
				
				break;
			case R.id.radio_alunos_por_turma_medio:
				fulfillHistoryWithHighSchoolAverageClassSize();
				
				break;
			case R.id.radio_horas_aula_fundamental:
				fulfillHistoryWithElementarySchoolAverageClassHours();
				
				break;
			case R.id.radio_horas_aula_medio:
				fulfillHistoryWithHighSchoolAverageClassHours();
				
				break;
			case R.id.radio_taxa_distorcao_fundamental:
				fulfillHistoryWithElementarySchoolAgeSeriesDistortionRate();
				
				break;
			case R.id.radio_taxa_distorcao_medio:
				fulfillHistoryWithHighSchoolAgeSeriesDistortionRate();
				
				break;
			case R.id.radio_taxa_aprovacao_fundamental:
				fulfillHistoryWithElementarySchoolUtilizationRate();

				break;
			case R.id.radio_taxa_aprovacao_medio:
				fulfillHistoryWithHighSchoolUtilizationRate();
				
				break;
			case R.id.radio_taxa_abandono_fundamental:
				fulfillHistoryWithElementarySchoolDropoutRate();
				
				break;
			case R.id.radio_taxa_abandono_medio:
				fulfillHistoryWithHighSchoolDropoutRate();
				
				break;
			case R.id.radio_censo_iniciais_fundamental:
				fulfillHistoryWithEarlyYearsCensus();
				
				break;
			case R.id.radio_censo_finais_fundamental:
				fulfillHistoryWithFinalYearsCensus();
				
				break;
			case R.id.radio_censo_ensino_medio:
				fulfillHistoryWithHighSchoolCensus();
				
				break;
			case R.id.radio_censo_eja_fundamental:
				fulfillHistoryWithEJAElementarySchoolCensus();
			
				break;

			case R.id.radio_censo_eja_medio:
				fulfillHistoryWithEJAHighSchoolCensus();
				
				break;
		}
	}

	// Get the informations about the selected state.
	private State catchStateInformation() {
		State state1 = null;
		
		int position = historyPosition;
		
		try {
			state1 = (State) StateController.getInstance(this).obtainState(position);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return state1;
	}

	// Implements the action on button next.
	public void clickNextButton(View view) {
		Intent intent = new Intent(this, GraphLineScreen.class);
		ArrayList<String> temp = new ArrayList<String>();
		
		for(int i = 0; i < history.size(); i++) {
			temp.add(history.get(i) + "");
		}
		
		intent.putStringArrayListExtra("HISTORICO", temp);
		intent.putExtra("TITULO", title);
		intent.putExtra("POSICAO_ESTADO", historyPosition);
		intent.putExtra("INDICATIVO_GRAFICO", indicative);
		startActivity(intent);
	}		
}