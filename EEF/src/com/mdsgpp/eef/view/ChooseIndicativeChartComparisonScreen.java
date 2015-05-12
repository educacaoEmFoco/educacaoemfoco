/*************************************************************************************************
 * File: ChooseIndicativeChartComparsionScreen.java
 * 
 * Purpose: Screen where the user will choose the indicatives to generate the chart of comparison.
 *************************************************************************************************/

package com.mdsgpp.eef.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.mdsgpp.eef.R;

public class ChooseIndicativeChartComparisonScreen extends ChoosesIndicative {
	
	private int position1;
	private int position2;
	
	private boolean radioButtonVisibilityCensus;
	private boolean radioButtonVisibilityClassSize;
	private boolean radioButtonVisibilityClassHours;
	private boolean radioButtonVisibilityDistortionRate;
	private boolean radioButtonVisibilityDropoutRate;
	private boolean radioButtonVisibilityAprovation;
	private boolean radioButtonVisibilityIdeb;
	private boolean radioButtonVisibilityPIB;
	private boolean radioButtonVisibilityPopulation;
	private boolean radioButtonVisibilityFirstProjects;
	private boolean radioButtonVisibilityCnpqProjects;
	private boolean radioButtonVisibilityDifusionProjects;
	private boolean radioButtonVisibilityInitiationProjects;
	private boolean radioButtonVisibilityYoungProjects;

	private RadioButton radioButtonEarlyYearsIdeb;
	private RadioButton radioButtonFinalYearsIdeb;
	private RadioButton radioButtonHighSchoolIdeb;
	private RadioButton radioButtonPIB;
	private RadioButton radioButtonPopulation;
	private RadioButton radioButtonFirstProjectsQuantity;
	private RadioButton radioButtonFirstProjectsValues;
	private RadioButton radioButtonCnpqProjectsQuantity;
	private RadioButton radioButtonCnpqProjectsValues;
	private RadioButton radioButtonDifusionProjectsQuantity; 
	private RadioButton radioButtonDifusionProjectsValues;
	private RadioButton radioButtonInitiationProjectsQuantity;
	private RadioButton radioButtonInitiationProjectsValues; 
	private RadioButton radioButtonYoungProjectsQuantity;
	private RadioButton radioButtonYoungProjectsValues;
	private RadioButton radioButtonClassAverageSizeElementarySchool;
	private RadioButton radioButtonClassAverageSizeHighSchool;
	private RadioButton radioButtonClassHoursElementarySchool;
	private RadioButton radioButtonClassHoursHighSchool;
	private RadioButton radioButtonDistortionRateElementarySchool;
	private RadioButton radioButtonDistortionRateHighSchool;
	private RadioButton radioButtonUtilizationRateElementarySchool;
	private RadioButton radioButtonUtilizationRateHighSchool;
	private RadioButton radioButtonDropoutRateElementarySchool;
	private RadioButton radioButtonDropoutRateHighSchool;
	private RadioButton radioButtonEarlyYearsElementarySchoolCensus;
	private RadioButton radioButtonFinalYearsElementarySchoolCensus;
	private RadioButton radioButtonHighSchoolCensus;
	private RadioButton radioButtonEJAElementarySchoolCensus;
	private RadioButton radioButtonEJAHighSchoolCensus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_escolhe_indicativo_grafico);
		
		radioButtonsStart();
		catchInformation();
		hideRadionButton();
	}
	
	// Get information about the compared states.
	public void catchInformation() {
		Intent receivedIntent = getIntent();
		
		position1 = receivedIntent.getIntExtra("INDEX_ESTADO1_ESCOLHIDO", 0);
		position2 = receivedIntent.getIntExtra("INDEX_ESTADO2_ESCOLHIDO", 0);

		radioButtonVisibilityIdeb = receivedIntent.getBooleanExtra("CB_IDEB", false);
		radioButtonVisibilityPIB = receivedIntent.getBooleanExtra("CB_PIB", false);
		radioButtonVisibilityPopulation = receivedIntent.getBooleanExtra("CB_POPULACAO", false);
		radioButtonVisibilityFirstProjects = receivedIntent.getBooleanExtra
			("CB_PRIMEIROS_PROJETOS", false);
		radioButtonVisibilityCnpqProjects = receivedIntent.getBooleanExtra("CB_PROJETOS_CNPQ",
			false);
		radioButtonVisibilityDifusionProjects = receivedIntent.getBooleanExtra("CB_PROJETOS_DIFUSAO",
			false);
		radioButtonVisibilityInitiationProjects = receivedIntent.getBooleanExtra
			("CB_PROJETOS_INICIACAO", false);
		radioButtonVisibilityYoungProjects = receivedIntent.getBooleanExtra("CB_PROJETOS_JOVENS",
			false);
		radioButtonVisibilityCensus = receivedIntent.getBooleanExtra("CB_CENSO", false);
		radioButtonVisibilityClassSize = receivedIntent.getBooleanExtra("CB_ALUNOS_TURMA", false);
		radioButtonVisibilityClassHours = receivedIntent.getBooleanExtra("CB_HORAS_AULA", false);
		radioButtonVisibilityDistortionRate = receivedIntent.getBooleanExtra("CB_TAXA_DISTORCAO",
			false);
		radioButtonVisibilityDropoutRate = receivedIntent.getBooleanExtra("CB_TAXA_ABANDONO",
			false);
		radioButtonVisibilityAprovation = receivedIntent.getBooleanExtra("CB_APROVACAO", false);
		
	}
	
	// Start all radio buttons on screen.
	public void radioButtonsStart() {
		radioButtonEarlyYearsIdeb = (RadioButton) findViewById
			(R.id.radio_ideb_fundamental_iniciai);
		radioButtonFinalYearsIdeb = (RadioButton) findViewById
			(R.id.radio_ideb_fundamental_finais);
		radioButtonHighSchoolIdeb = (RadioButton) findViewById(R.id.radio_ideb_medio);
		radioButtonPopulation = (RadioButton) findViewById(R.id.radio_populacao);
		radioButtonFirstProjectsQuantity = (RadioButton) findViewById
			(R.id.radio_primeiros_projetos_qtd);
		radioButtonFirstProjectsValues = (RadioButton) findViewById
			(R.id.radio_primeiros_projetos_investimento);
		radioButtonCnpqProjectsQuantity = (RadioButton) findViewById
			(R.id.radio_apoio_cnpq_qtd);
		radioButtonCnpqProjectsValues = (RadioButton) findViewById
			(R.id.radio_apoio_cnpq_investimento);
		radioButtonDifusionProjectsQuantity = (RadioButton) findViewById
			(R.id.radio_difusao_tecnologica_qtd);
		radioButtonDifusionProjectsValues = (RadioButton) findViewById
			(R.id.radio_difusao_tecnologica_investimento);
		radioButtonInitiationProjectsQuantity = (RadioButton) findViewById
			(R.id.radio_projetos_inct_qtd);
		radioButtonInitiationProjectsValues = (RadioButton) findViewById
			(R.id.radio_projetos_inct_investimento);
		radioButtonYoungProjectsQuantity = (RadioButton) findViewById
			(R.id.radio_jovens_pesquisadores_qtd);
		radioButtonYoungProjectsValues = (RadioButton) findViewById
			(R.id.radio_jovens_pesquisadores_investimento);
		radioButtonClassAverageSizeElementarySchool = (RadioButton) findViewById
			(R.id.radio_alunos_por_turma_fundamental);
		radioButtonClassAverageSizeHighSchool = (RadioButton) findViewById
			(R.id.radio_alunos_por_turma_medio);
		radioButtonClassHoursElementarySchool = (RadioButton) findViewById
			(R.id.radio_horas_aula_fundamental);
		radioButtonClassHoursHighSchool = (RadioButton) findViewById
			(R.id.radio_horas_aula_medio);
		radioButtonDistortionRateElementarySchool = (RadioButton) findViewById
			(R.id.radio_taxa_distorcao_fundamental);
		radioButtonDistortionRateHighSchool = (RadioButton) findViewById
			(R.id.radio_taxa_distorcao_medio);
		radioButtonUtilizationRateElementarySchool = (RadioButton) findViewById
			(R.id.radio_taxa_aprovacao_fundamental);
		radioButtonUtilizationRateHighSchool = (RadioButton) findViewById
			(R.id.radio_taxa_aprovacao_medio);
		radioButtonDropoutRateElementarySchool = (RadioButton) findViewById
			(R.id.radio_taxa_abandono_fundamental);
		radioButtonDropoutRateHighSchool = (RadioButton) findViewById
			(R.id.radio_taxa_abandono_medio);
		radioButtonEarlyYearsElementarySchoolCensus = (RadioButton) findViewById
			(R.id.radio_censo_iniciais_fundamental);
		radioButtonFinalYearsElementarySchoolCensus = (RadioButton) findViewById
			(R.id.radio_censo_finais_fundamental);
		radioButtonHighSchoolCensus = (RadioButton) findViewById
			(R.id.radio_censo_ensino_medio);
		radioButtonEJAElementarySchoolCensus = (RadioButton) findViewById
			(R.id.radio_censo_eja_fundamental);
		radioButtonEJAHighSchoolCensus = (RadioButton) findViewById
			(R.id.radio_censo_eja_medio);
		
	}
	
	// Allow the buttons to be viewed or not.
	public void setVisibility(RadioButton radioButton, boolean visibility) {
		int visibilityValue = (visibility) ? View.VISIBLE : View.GONE;
		radioButton.setVisibility(visibilityValue);
	}
	
	// Hide radio buttons when the information is not available.
	public void hideRadionButton() {
		setVisibility(radioButtonEarlyYearsIdeb, radioButtonVisibilityIdeb);
		setVisibility(radioButtonFinalYearsIdeb, radioButtonVisibilityIdeb);
		setVisibility(radioButtonHighSchoolIdeb, radioButtonVisibilityIdeb);
		setVisibility(radioButtonPIB, radioButtonVisibilityPIB);
		setVisibility(radioButtonPopulation, radioButtonVisibilityPopulation);
		setVisibility(radioButtonFirstProjectsQuantity, radioButtonVisibilityFirstProjects);
		setVisibility(radioButtonFirstProjectsValues, radioButtonVisibilityFirstProjects);
		setVisibility(radioButtonCnpqProjectsQuantity, radioButtonVisibilityCnpqProjects);
		setVisibility(radioButtonCnpqProjectsValues, radioButtonVisibilityCnpqProjects);
		setVisibility(radioButtonDifusionProjectsQuantity, radioButtonVisibilityDifusionProjects);
		setVisibility(radioButtonDifusionProjectsValues, radioButtonVisibilityDifusionProjects);
		setVisibility(radioButtonInitiationProjectsQuantity, radioButtonVisibilityInitiationProjects);
		setVisibility(radioButtonInitiationProjectsValues, radioButtonVisibilityInitiationProjects);
		setVisibility(radioButtonYoungProjectsQuantity, radioButtonVisibilityYoungProjects);
		setVisibility(radioButtonYoungProjectsValues, radioButtonVisibilityYoungProjects);
		setVisibility(radioButtonClassAverageSizeElementarySchool, radioButtonVisibilityClassSize);
		setVisibility(radioButtonClassAverageSizeHighSchool, radioButtonVisibilityClassSize);
		setVisibility(radioButtonClassHoursElementarySchool, radioButtonVisibilityClassHours);
		setVisibility(radioButtonClassHoursHighSchool, radioButtonVisibilityClassHours);
		setVisibility(radioButtonDistortionRateElementarySchool, radioButtonVisibilityDistortionRate);
		setVisibility(radioButtonDistortionRateHighSchool, radioButtonVisibilityDistortionRate);
		setVisibility(radioButtonUtilizationRateElementarySchool, radioButtonVisibilityAprovation);
		setVisibility(radioButtonUtilizationRateHighSchool, radioButtonVisibilityAprovation);
		setVisibility(radioButtonDropoutRateElementarySchool, radioButtonVisibilityDropoutRate);
		setVisibility(radioButtonDropoutRateHighSchool, radioButtonVisibilityDropoutRate);
		setVisibility(radioButtonEarlyYearsElementarySchoolCensus, radioButtonVisibilityCensus);
		setVisibility(radioButtonFinalYearsElementarySchoolCensus, radioButtonVisibilityCensus);
		setVisibility(radioButtonHighSchoolCensus, radioButtonVisibilityCensus);
		setVisibility(radioButtonEJAElementarySchoolCensus, radioButtonVisibilityCensus);
		setVisibility(radioButtonEJAHighSchoolCensus, radioButtonVisibilityCensus);
	}
	
	// Implements the action on button next.
	public void clickForwardButton(View view) {
		Intent intent = new Intent(this, GraphScreen.class);
		
		intent.putExtra("INDEX_ESTADO1_ESCOLHIDO", position1);
		intent.putExtra("INDEX_ESTADO2_ESCOLHIDO", position2);
		intent.putExtra("INDICATIVO", getIndicative());
		intent.putExtra("TITULO", getTitle());

		startActivity(intent);		
	}
    
    // Open the screen about.
    public void opensAboutScreen() {
    	Intent intent = new Intent(this, 
    		IndicativeChoosenChartComparsionAboutScreen.class);
    	startActivity(intent);
    }
}
