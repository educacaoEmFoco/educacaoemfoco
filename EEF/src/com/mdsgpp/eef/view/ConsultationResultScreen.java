package com.mdsgpp.eef.view;

import java.io.IOException;
import java.util.HashMap;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.controller.StateController;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ConsultationResultScreen extends Activity {

	private TextView textViewAcronym1;
	private TextView textViewName1;
	private TextView textViewPopulation1;
	private TextView textViewPopulationValue1;
	private TextView textViewStateParticipationPIB1;
	private TextView textViewParticipationPIB1;
	private TextView textViewProjectsNumber1;
	private TextView textViewScienceTechnologyProjectsQuantity1;
	private TextView textViewScienceTechnologyProjectsValue1;
	private TextView textViewIdeb1;
	private TextView textViewIdebElementarySchool1;
	private TextView textViewIdebHighSchool1;
	private TextView textViewIdebEarlyYears1;
	private TextView textViewFirstProjectsProgram1;
	private TextView textViewFirstProjectsQuantity1;
	private TextView textViewFirstProjectsValue1;
	private TextView textViewResearchProjects1;
	private TextView textViewResearchQuantity1;
	private TextView textViewYoungResearchers1;
	private TextView textViewYoungResearchersQuantity1;
	private TextView textViewResearchValues1;
	private TextView textViewYoungResearchersValue;
	private TextView textViewInitiationProjects1;
	private TextView textViewInitiationProjectsQuantity1;
	private TextView textViewInitiationProjectsValue1;
	private TextView textViewCensus1;
	private TextView textViewCensusEarlyElementarySchool1;
	private TextView textViewCensusFinalElementarySchool1;
	private TextView textViewCensusHighSchool1;
	private TextView textViewCensusEjaElementarySchool1;
	private TextView textViewCensusEjaHighSchool1;
	private TextView textViewAverageClassSize1;
	private TextView textViewElementarySchoolAverageClassSize1;
	private TextView textViewHighSchoolAverageClassSize1;
	private TextView textViewAverageClassHours1;
	private TextView textViewElementarySchoolAverageClassHours1;
	private TextView textViewHighSchoolAverageClassHours1;
	private TextView textViewDistortionRate1;
	private TextView textViewElementarySchoolAgeSeriesDistortionRate1;
	private TextView textViewHighSchoolAgeSeriesDistortionRate1;
	private TextView textViewUtilizationRate1;
	private TextView textViewElementarySchoolUtilizationRate1;
	private TextView textViewHighSchoolUtilizationRate1;
	private TextView textViewDropoutRate1;
	private TextView textViewElementarySchoolDropoutRate1;
	private TextView textViewHighSchoolDropoutRate1;
	
	private TextView textViewAcronym2;
	private TextView textViewName2;
	private TextView textViewPopulation2;
	private TextView textViewPopulationValue2;
	private TextView textViewStateParticipationPIB2;
	private TextView textViewParticipationPIB2;
	private TextView textViewProjectsNumber2;
	private TextView textViewScienceTechnologyProjectsQuantity2;
	private TextView textViewScienceTechnologyProjectsValue2;
	private TextView textViewIdeb2;
	private TextView textViewIdebElementarySchool2;
	private TextView textViewIdebHighSchool2;
	private TextView textViewIdebEarlyYears2;
	private TextView textViewFirstProjectsProgram2;
	private TextView textViewFirstProjectsQuantity2;
	private TextView textViewFirstProjectsValue2;
	private TextView textViewResearchProjects2;
	private TextView textViewResearchQuantity2;
	private TextView textViewYoungResearchers2;
	private TextView textViewYoungResearchersQuantity2;
	private TextView textViewResearchValues2;
	private TextView textViewYoungResearchersValues2;
	private TextView textViewInitiationProjects2;
	private TextView textViewInitiationProjectsQuantity2;
	private TextView textViewInitiationProjectsValue2;
	private TextView textViewCensus2;
	private TextView textViewCensusEarlyElementarySchool2;
	private TextView textViewCensusFinalElementarySchool2;
	private TextView textViewCensusHighSchool2;
	private TextView textViewCensusEjaElementarySchool2;
	private TextView textViewCensusEjaHighSchool2;
	private TextView textViewAverageClassSize2;
	private TextView textViewElementarySchoolAverageClassSize2;
	private TextView textViewHighSchoolAverageClassSize2;
	private TextView textViewAverageClassHours2;
	private TextView textViewElementarySchoolAverageClassHours2;
	private TextView textViewHighSchoolAverageClassHours2;
	private TextView textViewDistortionRate2;
	private TextView textViewElementarySchoolAgeSeriesDistortionRate2;
	private TextView textViewHighSchoolAgeSeriesDistortionRate2;
	private TextView textViewUtilizationRate2;
	private TextView textViewElementarySchoolUtilizationRate2;
	private TextView textViewHighSchoolUtilizationRate2;
	private TextView textViewDropoutRate2;
	private TextView textViewElementarySchoolDropoutRate2;
	private TextView textViewHighSchoolDropoutRate2;
	
	private boolean  booleanCensus;
	private boolean  booleanClassSize;
	private boolean  booleanClassHours;
	private boolean  booleanDistortionRate;
	private boolean  booleanDropoutRate;
	private boolean  booleanAcceptance;
	private boolean  booleanIdeb;
	private boolean  booleanPIB;
	private boolean  booleanPopulation;
	private boolean  booleanFirstProjects;
	private boolean  booleanCnpqProjects;
	private boolean  booleanDiffusionProjects;
	private boolean  booleanInitiationProjects;
	private boolean  booleanYoungProjects;
	
	private ImageView imageViewStateFlag01; 
	private ImageView imageViewStateFlag02; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_compara_estados);
		
		startTextFields();
		catchInformation();
		hideTextFields();
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
	
	// Change the activity to TelaSobreComparacaoDeEstados activity.
	public void openAboutScreen() {
		Intent intent = new Intent(this, ComparisonBetweenStatesAboutScreen.class);
    	startActivity(intent);
		
	}
	
	// Takes the information from the previous activity to that.
	@SuppressWarnings("unchecked")
	private void catchInformation() {
		Intent intent = getIntent();
		
		int position1 = intent.getIntExtra("INDEX_ESTADO1_ESCOLHIDO",5);
		int position2 = intent.getIntExtra("INDEX_ESTADO2_ESCOLHIDO",0);
		
		catchStateFlags(position1, position2);
		
		booleanIdeb = intent.getBooleanExtra("CB_IDEB", false);
		booleanPIB = intent.getBooleanExtra("CB_PIB", false);
		booleanPopulation = intent.getBooleanExtra("CB_POPULACAO", false);
		booleanFirstProjects = intent.getBooleanExtra("CB_PRIMEIROS_PROJETOS", 
			false);
		booleanCnpqProjects = intent.getBooleanExtra("CB_PROJETOS_CNPQ", false);
		booleanDiffusionProjects = intent.getBooleanExtra("CB_PROJETOS_DIFUSAO", false);
		booleanInitiationProjects = intent.getBooleanExtra("CB_PROJETOS_INICIACAO",
			false);
		booleanYoungProjects = intent.getBooleanExtra("CB_PROJETOS_JOVENS", false);
		booleanCensus = intent.getBooleanExtra("CB_CENSO", false);
		booleanClassSize = intent.getBooleanExtra("CB_ALUNOS_TURMA", false);
		booleanClassHours = intent.getBooleanExtra("CB_HORAS_AULA", false);
		booleanDistortionRate = intent.getBooleanExtra("CB_TAXA_DISTORCAO", false);
		booleanDropoutRate = intent.getBooleanExtra("CB_TAXA_ABANDONO", false);
		booleanAcceptance = intent.getBooleanExtra("CB_APROVACAO", false);

		HashMap<String, String> stateInformation1 = new HashMap<String, 
			String>();
		HashMap<String, String> stateInformation2 = new HashMap<String,
			String>();

		try {
			stateInformation1 = (HashMap<String, String>) StateController
					.getInstance(this).readState(position1).clone();
			stateInformation2 = (HashMap<String, String>) StateController
					.getInstance(this).readState(position2).clone();

			fulfillTextFields(stateInformation1, stateInformation2);
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(),
				"Houve um erro no acesso �s informa��es.", 
			Toast.LENGTH_SHORT).show();
			Log.i("IOException - TelaComparaEstados",e.toString());
		}
	}

	// Fills the screen fields with the information received.
	private void fulfillTextFields(HashMap<String, String> information1,
			HashMap<String, String> information2) {

		textViewAcronym1.setText(information1.get("sigla"));
		if(textViewName1 != null) {
			textViewName1.setText(information1.get("nome"));
		}
		else {
			// Do nothing.
		}

		textViewPopulationValue1.setText(information1.get("populacao"));			
		textViewParticipationPIB1.setText(information1.get("percentual_participacao_pib"));
		textViewScienceTechnologyProjectsQuantity1.setText(information1.get
			("projetos_ciencia_tecnologia"));
		textViewScienceTechnologyProjectsValue1.setText(information1.get
			("valor_ciencia_tecnologia"));
		textViewIdebElementarySchool1.setText(information1.get
			("ideb_fundamental_final"));
		textViewIdebHighSchool1.setText(information1.get("ideb_ensino_medio"));
		textViewIdebEarlyYears1.setText(information1.get
			("ideb_fundamental_inicial"));
		textViewFirstProjectsQuantity1.setText(information1.get
			("quantidade_primeiros_projetos"));
		textViewFirstProjectsValue1.setText(information1.get
			("valor_primeiros_projetos"));
		textViewResearchQuantity1.setText(information1.get
			("quantidade_projeto_cnpq"));
		textViewResearchValues1.setText(information1.get
			("valor_projetos_cnpq"));
		textViewYoungResearchersQuantity1.setText(information1.get
			("quantidade_projeto_jovens_pesquisadores"));
		textViewYoungResearchersValue.setText(information1.get
			("valor_projetos_jovens_pesquisadores"));
		textViewInitiationProjectsQuantity1.setText(information1.get
			("quantidade_projetos_inct"));
		textViewInitiationProjectsValue1.setText(information1.get
			("valor_projetos_inct"));
		textViewCensusEarlyElementarySchool1.setText(information1.get
			("censo_anos_iniciais_fundamental"));
		textViewCensusFinalElementarySchool1.setText(information1.get
			("censo_anos_finais_fundamental"));
		textViewCensusHighSchool1.setText(information1.get("censo_ensino_medio"));
		textViewCensusEjaElementarySchool1.setText(information1.get
			("censo_eja_fundamental"));
		textViewCensusEjaHighSchool1.setText(information1.get("censo_eja_medio"));
		textViewElementarySchoolAverageClassSize1.setText(information1.get
			("alunos_por_turma_ensino_fundamental"));
		textViewHighSchoolAverageClassSize1.setText(information1.get
			("alunos_por_turma_ensino_medio"));
		textViewElementarySchoolAverageClassHours1.setText(information1.get
			("horas_aula_ensino_fundamental"));
		textViewHighSchoolAverageClassHours1.setText(information1.get
			("horas_aula_ensino_medio"));
		textViewElementarySchoolAgeSeriesDistortionRate1.setText(information1.get
			("taxa_distorcao_fundamental"));
		textViewHighSchoolAgeSeriesDistortionRate1.setText(information1.get
			("taxa_distorcao_medio"));
		textViewElementarySchoolUtilizationRate1.setText(information1.get
			("taxa_aprovacao_fundamental"));
		textViewHighSchoolUtilizationRate1.setText(information1.get
			("taxa_aprovacao_medio"));
		textViewElementarySchoolDropoutRate1.setText(information1.get
			("taxa_aprovacao_fundamental"));
		textViewHighSchoolDropoutRate1.setText(information1.get
			("taxa_aprovacao_medio"));

		textViewAcronym2.setText(information2.get("sigla"));
		if(textViewName2 != null) {
			textViewName2.setText(information2.get("nome"));
		}
		else {
			// Do nothing.
		}

		textViewPopulationValue2.setText(information2.get("populacao"));
		textViewParticipationPIB2.setText(information2.get
			("percentual_participacao_pib"));
		textViewScienceTechnologyProjectsQuantity2.setText(information2.get
			("projetos_ciencia_tecnologia").split(":")[1]);
		textViewScienceTechnologyProjectsValue2.setText(information2.get
			("valor_ciencia_tecnologia").split(":")[1]);
		textViewIdebElementarySchool2.setText(information2.get
			("ideb_fundamental_final").split(":")[1]);
		textViewIdebHighSchool2.setText(information2.get
			("ideb_ensino_medio").split(":")[1]);
		textViewIdebEarlyYears2.setText(information2.get
			("ideb_fundamental_inicial").split(":")[1]);
		textViewFirstProjectsQuantity2.setText(information2.get
			("quantidade_primeiros_projetos").split(":")[1]);
		textViewFirstProjectsValue2.setText(information2.get
			("valor_primeiros_projetos").split(":")[1]);
		textViewResearchQuantity2.setText(information2.get(
			"quantidade_projeto_cnpq").split(":")[1]);
		textViewResearchValues2.setText(information2.get
			("valor_projetos_cnpq").split(":")[1]);
		textViewYoungResearchersQuantity2.setText(information2.get
			("quantidade_projeto_jovens_pesquisadores").split(":")[1]);
		textViewYoungResearchersValues2.setText(information2.get
			("valor_projetos_jovens_pesquisadores").split(":")[1]);
		textViewInitiationProjectsQuantity2.setText(information2.get
			("quantidade_projetos_inct").split(":")[1]);
		textViewInitiationProjectsValue2.setText(information2.get
			("valor_projetos_inct").split(":")[1]);
		textViewCensusEarlyElementarySchool2.setText(information2.get
			("censo_anos_iniciais_fundamental").split(":")[1]);
		textViewCensusFinalElementarySchool2.setText(information2.get
			("censo_anos_finais_fundamental").split(":")[1]);
		textViewCensusHighSchool2.setText(information2.get
			("censo_ensino_medio").split(":")[1]);
		textViewCensusEjaElementarySchool2.setText(information2.get
			("censo_eja_fundamental").split(":")[1]);
		textViewCensusEjaHighSchool2.setText(information2.get
			("censo_eja_medio").split(":")[1]);
		textViewElementarySchoolAverageClassSize2.setText(information2.get
			("alunos_por_turma_ensino_fundamental").split(":")[1]);
		textViewHighSchoolAverageClassSize2.setText(information2.get
			("alunos_por_turma_ensino_medio").split(":")[1]);
		textViewElementarySchoolAverageClassHours2.setText(information2.get
			("horas_aula_ensino_fundamental").split(":")[1]);
		textViewHighSchoolAverageClassHours2.setText(information2.get
			("horas_aula_ensino_medio").split(":")[1]);
		textViewElementarySchoolAgeSeriesDistortionRate2.setText(information2.get
			("taxa_distorcao_fundamental").split(":")[1]);
		textViewHighSchoolAgeSeriesDistortionRate2.setText(information2.get
			("taxa_distorcao_medio").split(":")[1]);
		textViewElementarySchoolUtilizationRate2.setText(information2.get
			("taxa_aprovacao_fundamental").split(":")[1]);
		textViewHighSchoolUtilizationRate2.setText(information2.get
			("taxa_aprovacao_medio").split(":")[1]);
		textViewElementarySchoolDropoutRate2.setText(information2.get
			("taxa_aprovacao_fundamental").split(":")[1]);
		textViewHighSchoolDropoutRate2.setText(information2.get
			("taxa_aprovacao_medio").split(":")[1]);

	}
	
	// Assigns the class variables with the fields on the screen.
	private void startTextFields() {

		textViewAcronym1 = (TextView) findViewById(R.id.textView_sigla1);
		textViewName1 = (TextView) findViewById(R.id.textView_nome_estado1);		
		textViewPopulationValue1 = (TextView) 
			findViewById(R.id.textView_populacao_valor1);
		textViewPopulation1 = (TextView) findViewById(R.id.textView_populacao1);
		textViewStateParticipationPIB1 = (TextView) 
			findViewById(R.id.textView_participacao_estadual_pib1);
		textViewParticipationPIB1 = (TextView)
			findViewById(R.id.textView_participacao_pib_valor1);
		textViewProjectsNumber1 =  (TextView)
			findViewById(R.id.textView_numero_projetos1);
		textViewScienceTechnologyProjectsQuantity1 = (TextView)
			findViewById(R.id.textView_numero_projetos_quantidade1);
		textViewScienceTechnologyProjectsValue1 = (TextView)
			findViewById(R.id.textView_valor_investido_projetos1);
		textViewIdeb1 = (TextView) findViewById(R.id.textView_ideb1);
		textViewIdebElementarySchool1 = (TextView)
			findViewById(R.id.textView_ideb_fundamental1);
		textViewIdebHighSchool1 = (TextView) 
			findViewById(R.id.textView_ideb_ensinomedio1);
		textViewIdebEarlyYears1 = (TextView) 
			findViewById(R.id.textView_ideb_iniciais1);
		textViewFirstProjectsProgram1 = (TextView) 
			findViewById(R.id.textView_programa_primeiros_projetos1);
		textViewFirstProjectsQuantity1 = (TextView) 
			findViewById(R.id.textView_primeiros_projetos_quantidade1);
		textViewFirstProjectsValue1 = (TextView) 
			findViewById(R.id.textView_programa_primeiros_projetos_valor1);
		textViewResearchProjects1 = (TextView) 
			findViewById(R.id.textView_projetos_pesquisa1);
		textViewResearchQuantity1 = (TextView) 
			findViewById(R.id.textView_projetos_pesquisa_quantidade1);
		textViewResearchValues1 = (TextView) 
			findViewById(R.id.textView_valores_projeto_pesquisa1);
		textViewYoungResearchersQuantity1 = (TextView)
			findViewById(R.id.textView_jovens_pesquisadores_quantidade1);
		textViewYoungResearchers1 = (TextView) 
			findViewById(R.id.textView_jovens_pesquisadores1);
		textViewYoungResearchersValue = (TextView)
			findViewById(R.id.textView_jovens_pesquisadores_valor1);
		textViewInitiationProjects1 = (TextView) 
			findViewById(R.id.textView_projetos_iniciacao1);
		textViewInitiationProjectsQuantity1 = (TextView) 
			findViewById(R.id.textView_projetos_iniciacao_quantidade1);
		textViewInitiationProjectsValue1 = (TextView) 
			findViewById(R.id.textView_projetos_iniciacao_valor1);
		textViewDropoutRate1 = (TextView) 
			findViewById(R.id.textView_taxa_abandono1);
		textViewUtilizationRate1  = (TextView) 
			findViewById(R.id.textView_taxa_aprovacao1); 
		textViewCensus1  = (TextView) findViewById(R.id.textView_censo1);
		textViewAverageClassSize1  = (TextView) 
			findViewById(R.id.textView_media_alunos_por_turma1);
		textViewAverageClassHours1 = (TextView) 
			findViewById(R.id.textView_horas_aula_ensino1);
		textViewDistortionRate1 = (TextView) 
			findViewById(R.id.textView_taxa_distorcao1);
		textViewCensusEarlyElementarySchool1 = (TextView) 
			findViewById(R.id.textView_censo_iniciais_fundamental1);
		textViewCensusFinalElementarySchool1 = (TextView) 
			findViewById(R.id.textView_censo_finais_fundamental1);
		textViewCensusHighSchool1 = (TextView) 
			findViewById(R.id.textView_censo_medio1);
		textViewCensusEjaElementarySchool1 = (TextView) 
			findViewById(R.id.textView_censo_fundamental_eja1);
		textViewCensusEjaHighSchool1 = (TextView) 
			findViewById(R.id.textView_censo_medio_eja1);
		textViewElementarySchoolAverageClassSize1 = (TextView) 
			findViewById(R.id.textView_media_alunos_por_turma_fundamental1);
		textViewHighSchoolAverageClassSize1 = (TextView) 
			findViewById(R.id.textView_media_alunos_por_turma_medio1);
		textViewElementarySchoolAverageClassHours1 = (TextView) 
			findViewById(R.id.textView_horas_aula_ensino_fundamental1);
		textViewHighSchoolAverageClassHours1 = (TextView) 
			findViewById(R.id.textView_horas_aula_ensino_medio1);
		textViewElementarySchoolAgeSeriesDistortionRate1 = (TextView)
			findViewById(R.id.textView_taxa_distorcao_fundamental1);
		textViewHighSchoolAgeSeriesDistortionRate1 = (TextView)
			findViewById(R.id.textView_taxa_distorcao_medio1);
		textViewElementarySchoolUtilizationRate1 = (TextView) 
			findViewById(R.id.textView_taxa_aprovacao_fundamental1);
		textViewHighSchoolUtilizationRate1 = (TextView) 
			findViewById(R.id.textView_taxa_aprovacao_medio1);
		textViewElementarySchoolDropoutRate1 = (TextView) 
			findViewById(R.id.textView_taxa_abandono_fundamental1);
		textViewHighSchoolDropoutRate1 = (TextView) 
			findViewById(R.id.textView_taxa_abandono_medio1);
	
		textViewAcronym2 = (TextView) findViewById(R.id.textView_sigla2);
		textViewName2 = (TextView) findViewById(R.id.textView_nome_estado2);		
		textViewPopulationValue2 = (TextView) 
			findViewById(R.id.textView_populacao_valor2);
		textViewPopulation2 = (TextView) findViewById(R.id.textView_populacao2);
		textViewStateParticipationPIB2 = (TextView)
			findViewById(R.id.textView_participacao_estadual_pib2);
		textViewParticipationPIB2 = (TextView) 
			findViewById(R.id.textView_participacao_pib_valor2);
		textViewProjectsNumber2 =  (TextView) 
			findViewById(R.id.textView_numero_projetos2);
		textViewScienceTechnologyProjectsQuantity2 = (TextView) 
			findViewById(R.id.textView_numero_projetos_quantidade2);
		textViewScienceTechnologyProjectsValue2 = (TextView) 
			findViewById(R.id.textView_valor_investido_projetos2);
		textViewIdeb2 = (TextView) findViewById(R.id.textView_ideb2);
		textViewIdebElementarySchool2 = (TextView) 
			findViewById(R.id.textView_ideb_fundamental2);
		textViewIdebHighSchool2 = (TextView)
			findViewById(R.id.textView_ideb_ensinomedio2);
		textViewIdebEarlyYears2 = (TextView) 
			findViewById(R.id.textView_ideb_iniciais2);
		textViewFirstProjectsProgram2 = (TextView)
			findViewById(R.id.textView_programa_primeiros_projetos2);
		textViewFirstProjectsQuantity2 = (TextView) 
			findViewById(R.id.textView_primeiros_projetos_quantidade2);
		textViewFirstProjectsValue2 = (TextView) 
			findViewById(R.id.textView_programa_primeiros_projetos_valor2);
		textViewResearchProjects2 = (TextView) 
			findViewById(R.id.textView_projetos_pesquisa2);
		textViewResearchQuantity2 = (TextView) 
			findViewById(R.id.textView_projetos_pesquisa_quantidade2);
		textViewResearchValues2 = (TextView) 
			findViewById(R.id.textView_valores_projeto_pesquisa2);
		textViewYoungResearchers2 = (TextView)
			findViewById(R.id.textView_jovens_pesquisadores2);
		textViewYoungResearchersQuantity2 = (TextView) 
			findViewById(R.id.textView_jovens_pesquisadores_quantidade2);
		textViewYoungResearchersValues2 = (TextView) 
			findViewById(R.id.textView_jovens_pesquisadores_valor2);
		textViewInitiationProjects2 = (TextView) 
			findViewById(R.id.textView_projetos_iniciacao2);
		textViewInitiationProjectsQuantity2 = (TextView) 
			findViewById(R.id.textView_projetos_iniciacao_quantidade2);
		textViewInitiationProjectsValue2 = (TextView) 
			findViewById(R.id.textView_projetos_iniciacao_valor2);
		
		textViewDropoutRate2 = (TextView) 
			findViewById(R.id.textView_taxa_abandono2);
		textViewUtilizationRate2  = (TextView) 
			findViewById(R.id.textView_taxa_aprovacao2); 
		textViewCensus2  = (TextView) findViewById(R.id.textView_censo2);
		textViewAverageClassSize2  = (TextView) 
			findViewById(R.id.textView_media_alunos_por_turma2);
		textViewAverageClassHours2 = (TextView) 
			findViewById(R.id.textView_horas_aula_ensino2);
		textViewDistortionRate2 = (TextView)
			findViewById(R.id.textView_taxa_distorcao2);

		textViewCensusEarlyElementarySchool2 = (TextView) 
			findViewById(R.id.textView_censo_iniciais_fundamental2);
		textViewCensusFinalElementarySchool2 = (TextView) 
			findViewById(R.id.textView_censo_finais_fundamental2);
		textViewCensusHighSchool2 = (TextView) 
			findViewById(R.id.textView_censo_medio2);
		textViewCensusEjaElementarySchool2 = (TextView) 
			findViewById(R.id.textView_censo_fundamental_eja2);
		textViewCensusEjaHighSchool2 = (TextView) 
			findViewById(R.id.textView_censo_medio_eja2);
		textViewElementarySchoolAverageClassSize2 = (TextView) 
			findViewById(R.id.textView_media_alunos_por_turma_fundamental2);
		textViewHighSchoolAverageClassSize2 = (TextView) 
			findViewById(R.id.textView_media_alunos_por_turma_medio2);
		textViewElementarySchoolAverageClassHours2 = (TextView)
			findViewById(R.id.textView_horas_aula_ensino_fundamental2);
		textViewHighSchoolAverageClassHours2 = (TextView) 
			findViewById(R.id.textView_horas_aula_ensino_medio2);
		textViewElementarySchoolAgeSeriesDistortionRate2 = (TextView) 
			findViewById(R.id.textView_taxa_distorcao_fundamental2);
		textViewHighSchoolAgeSeriesDistortionRate2 = (TextView)
			findViewById(R.id.textView_taxa_distorcao_medio2);
		textViewElementarySchoolUtilizationRate2 = (TextView)
			findViewById(R.id.textView_taxa_aprovacao_fundamental2);
		textViewHighSchoolUtilizationRate2 = (TextView) 
			findViewById(R.id.textView_taxa_aprovacao_medio2);
		textViewElementarySchoolDropoutRate2 = (TextView)
			findViewById(R.id.textView_taxa_abandono_fundamental2);
		textViewHighSchoolDropoutRate2 = (TextView) 
			findViewById(R.id.textView_taxa_abandono_medio2);
	}
	
	// Changes the visibility of the text views on the screen.
	public void setVisibility(TextView txtView, boolean visibilidade) {
		int valorVisibilidade = (visibilidade) ? View.VISIBLE : View.GONE;
		txtView.setVisibility(valorVisibilidade);
	}
	
	/*
	 * Changes the visibility of the text views on the screen according to the
	 * value of the variable.
	 */
	public void hideTextFields() {
		setVisibility(textViewPopulation1, booleanPopulation);
		setVisibility(textViewPopulationValue1, booleanPopulation);
		setVisibility(textViewPopulationValue2, booleanPopulation);
		
		setVisibility(textViewIdeb1, booleanIdeb);
		setVisibility(textViewIdebElementarySchool1, booleanIdeb);
		setVisibility(textViewIdebHighSchool1, booleanIdeb);
		setVisibility(textViewIdebEarlyYears1, booleanIdeb);
		setVisibility(textViewIdebElementarySchool2, booleanIdeb);
		setVisibility(textViewIdebHighSchool2, booleanIdeb);
		setVisibility(textViewIdebEarlyYears2, booleanIdeb);

		setVisibility(textViewStateParticipationPIB1, booleanPIB);
		setVisibility(textViewParticipationPIB1, booleanPIB);
		setVisibility(textViewParticipationPIB2, booleanPIB);
		
		setVisibility(textViewFirstProjectsProgram1, booleanFirstProjects);
		setVisibility(textViewFirstProjectsQuantity1, booleanFirstProjects);
		setVisibility(textViewFirstProjectsValue1, booleanFirstProjects);
		setVisibility(textViewFirstProjectsQuantity2, booleanFirstProjects);
		setVisibility(textViewFirstProjectsValue2, booleanFirstProjects);
		
		setVisibility(textViewResearchProjects1, booleanCnpqProjects);
		setVisibility(textViewResearchQuantity1, booleanCnpqProjects);
		setVisibility(textViewResearchValues1, booleanCnpqProjects);
		setVisibility(textViewResearchQuantity2, booleanCnpqProjects);
		setVisibility(textViewResearchValues2, booleanCnpqProjects);

		setVisibility(textViewYoungResearchers1, booleanYoungProjects);
		setVisibility(textViewYoungResearchersQuantity1, booleanYoungProjects);
		setVisibility(textViewYoungResearchersValue, booleanYoungProjects);
		setVisibility(textViewYoungResearchersQuantity2, booleanYoungProjects);
		setVisibility(textViewYoungResearchersValues2, booleanYoungProjects);

		setVisibility(textViewInitiationProjects1, booleanInitiationProjects);
		setVisibility(textViewInitiationProjectsQuantity1, booleanInitiationProjects);
		setVisibility(textViewInitiationProjectsValue1, booleanInitiationProjects);
		setVisibility(textViewInitiationProjectsQuantity2, booleanInitiationProjects);
		setVisibility(textViewInitiationProjectsValue2, booleanInitiationProjects);

		setVisibility(textViewProjectsNumber1, booleanDiffusionProjects);
		setVisibility(textViewScienceTechnologyProjectsQuantity1,
			booleanDiffusionProjects);
		setVisibility(textViewScienceTechnologyProjectsValue1,
			booleanDiffusionProjects);
		setVisibility(textViewScienceTechnologyProjectsQuantity2,
			booleanDiffusionProjects);
		setVisibility(textViewScienceTechnologyProjectsValue2, 
			booleanDiffusionProjects);
		
		setVisibility(textViewCensus1, booleanCensus);
		setVisibility(textViewCensusEjaElementarySchool1, booleanCensus);
		setVisibility(textViewCensusEjaHighSchool1, booleanCensus);
		setVisibility(textViewCensusFinalElementarySchool1, booleanCensus);
		setVisibility(textViewCensusEarlyElementarySchool1, booleanCensus);
		setVisibility(textViewCensusHighSchool1, booleanCensus);
		setVisibility(textViewCensusEjaElementarySchool2, booleanCensus);
		setVisibility(textViewCensusEjaHighSchool2, booleanCensus);
		setVisibility(textViewCensusFinalElementarySchool2, booleanCensus);
		setVisibility(textViewCensusEarlyElementarySchool2, booleanCensus);
		setVisibility(textViewCensusHighSchool2, booleanCensus);
		
		setVisibility(textViewAverageClassSize1, booleanClassSize);
		setVisibility(textViewElementarySchoolAverageClassSize1, booleanClassSize);
		setVisibility(textViewHighSchoolAverageClassSize1, booleanClassSize);
		setVisibility(textViewElementarySchoolAverageClassSize2, booleanClassSize);
		setVisibility(textViewHighSchoolAverageClassSize2, booleanClassSize);
		
		setVisibility(textViewAverageClassHours1, booleanClassHours);
		setVisibility(textViewElementarySchoolAverageClassHours1, booleanClassHours);
		setVisibility(textViewHighSchoolAverageClassHours1, booleanClassHours);
		setVisibility(textViewElementarySchoolAverageClassHours2, booleanClassHours);
		setVisibility(textViewHighSchoolAverageClassHours2, booleanClassHours);
		
		setVisibility(textViewDistortionRate1, booleanDistortionRate);
		setVisibility(textViewElementarySchoolAgeSeriesDistortionRate1,
			booleanDistortionRate);
		setVisibility(textViewHighSchoolAgeSeriesDistortionRate1, booleanDistortionRate);
		setVisibility(textViewElementarySchoolAgeSeriesDistortionRate2,
			booleanDistortionRate);
		setVisibility(textViewHighSchoolAgeSeriesDistortionRate2, booleanDistortionRate);
		
		setVisibility(textViewDropoutRate1, booleanDropoutRate);
		setVisibility(textViewElementarySchoolDropoutRate1, booleanDropoutRate);
		setVisibility(textViewHighSchoolDropoutRate1, booleanDropoutRate);
		setVisibility(textViewElementarySchoolDropoutRate2, booleanDropoutRate);
		setVisibility(textViewHighSchoolDropoutRate2, booleanDropoutRate);
		
		setVisibility(textViewUtilizationRate1,booleanAcceptance);
		setVisibility(textViewElementarySchoolUtilizationRate1,booleanAcceptance);
		setVisibility(textViewHighSchoolUtilizationRate1,booleanAcceptance);
		setVisibility(textViewElementarySchoolUtilizationRate2,booleanAcceptance);
		setVisibility(textViewHighSchoolUtilizationRate2,booleanAcceptance);
		
		try {
			Log.i("teste visibility", "populacao");
			setVisibility(textViewPopulation2, booleanPopulation);
			Log.i("teste visibility", "ideb");
			setVisibility(textViewIdeb2, booleanIdeb);
			Log.i("teste visibility", "participacao");
			setVisibility(textViewStateParticipationPIB2, booleanPIB);
			Log.i("teste visibility", "primeiros projetos");
			setVisibility(textViewFirstProjectsProgram2,
				booleanFirstProjects);
			Log.i("teste visibility", "cnpq");
			setVisibility(textViewResearchProjects2, booleanCnpqProjects);
			Log.i("teste visibility", "jovens");
			setVisibility(textViewYoungResearchers2, booleanYoungProjects);
			Log.i("teste visibility", "inct");
			setVisibility(textViewInitiationProjects2, booleanInitiationProjects);
			setVisibility(textViewProjectsNumber2, booleanDiffusionProjects);
			setVisibility(textViewCensus2, booleanCensus);
			setVisibility(textViewAverageClassSize2, booleanClassSize);
			setVisibility(textViewAverageClassHours2, booleanClassHours);
			setVisibility(textViewDistortionRate2, booleanDistortionRate);
			setVisibility(textViewDropoutRate2, booleanDropoutRate);
			setVisibility(textViewUtilizationRate2,booleanAcceptance);
		} catch(NullPointerException npe) {
			Log.i("NullPointerException -layout portrait n�o possui estes id's",
				npe.toString());
		}
						
	}
	
	// Implements the action of button to generate the chart.
	public void clickGenerateChartButton(View view) {
		Intent intent = new Intent(this, ChooseIndicativeChartComparisonScreen.class);
		Intent intent1 = getIntent();

		int position1 = intent1.getIntExtra("INDEX_ESTADO1_ESCOLHIDO", 0);
		int position2 = intent1.getIntExtra("INDEX_ESTADO2_ESCOLHIDO", 0);

		intent.putExtra("CB_IDEB", booleanIdeb);
		intent.putExtra("CB_PIB", booleanPIB);
		intent.putExtra("CB_POPULACAO", booleanPopulation);
		intent.putExtra("CB_PRIMEIROS_PROJETOS", booleanFirstProjects);
		intent.putExtra("CB_PROJETOS_CNPQ", booleanCnpqProjects);
		intent.putExtra("CB_PROJETOS_DIFUSAO", booleanDiffusionProjects);
		intent.putExtra("CB_PROJETOS_INICIACAO", booleanInitiationProjects);
		intent.putExtra("CB_PROJETOS_JOVENS", booleanYoungProjects);
		intent.putExtra("CB_ALUNOS_TURMA", booleanClassSize);
		intent.putExtra("CB_APROVACAO",booleanAcceptance);
		intent.putExtra("CB_CENSO", booleanCensus);
		intent.putExtra("CB_HORAS_AULA", booleanClassHours);
		intent.putExtra("CB_TAXA_ABANDONO", booleanDropoutRate);
		intent.putExtra("CB_TAXA_DISTORCAO", booleanDistortionRate);
		
		intent.putExtra("INDEX_ESTADO1_ESCOLHIDO", position1);
		intent.putExtra("INDEX_ESTADO2_ESCOLHIDO", position2);

		startActivity(intent);
	}
	
	/*
	 * Select the image of the flag of the state in accordance with the chosen
	 * states.
	 */
	public void catchStateFlags(int statePosition1, int statePosition2) {
		String stateFlags[] = {"acre", "alagoas", "amapa", "amazonas", "bahia", 
			"ceara", "distritofederal", "espiritosanto", "goias", "maranhao",
			"matogrosso", "matogrossodosul", "minasgerais", "para", "paraiba",
			"parana", "pernambuco", "piaui", "riodejaneiro", "riograndedonorte",
			"riograndedosul", "rondonia", "roraima", "santacatarina", 
			"saopaulo", "sergipe", "tocantins"};	
		
		imageViewStateFlag01 = (ImageView) 
			findViewById(R.id.imageView_bandeiras1);
		int idStateFlag01 = getResources().getIdentifier
			(stateFlags[statePosition1], "drawable", getPackageName());
		imageViewStateFlag01.setImageResource(idStateFlag01);
	
		imageViewStateFlag02 = (ImageView) 
			findViewById(R.id.imageView_bandeiras2);
		int idStateFlag02 = getResources().getIdentifier
			(stateFlags[statePosition2], "drawable", getPackageName());
		imageViewStateFlag02.setImageResource(idStateFlag02);
	}
}

