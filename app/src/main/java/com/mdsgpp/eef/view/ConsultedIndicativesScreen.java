package com.mdsgpp.eef.view;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

public class ConsultedIndicativesScreen extends Activity {

	CheckBox checkboxIdeb;
	CheckBox checkboxPIB;
	CheckBox checkboxPopulation;
	CheckBox checkboxFirstProjects;
	CheckBox checkboxCnpqProjects;
	CheckBox checkboxDifussionProjects;
	CheckBox checkboxInitiationProjects;
	CheckBox checkboxYoungProjects;
	CheckBox checkboxCensus;
	CheckBox checkboxClassSize;
	CheckBox checkboxClassHours;
	CheckBox checkboxDistortionRate;
	CheckBox checkboxDropoutRate;
	CheckBox checkboxApproval;
	
	boolean booleanIdeb;
	boolean booleanPIB;
	boolean booleanPopulation;
	boolean booleanFirstProjects;
	boolean booleanCnpqProjetcts;
	boolean booleanDifussionProjects;
	boolean booleanInitiationProjects;
	boolean booleanYoungProjects;
	boolean booleanCensus;
	boolean booleanClassSize;
	boolean booleanClassHours;
	boolean booleanDistortionRate;
	boolean booleanDropoutRate;
	boolean booleanApproval;
	
	int position1;
	int position2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_indicativos_consultados);
		Intent assistentIntent = getIntent();

		startCheckbox();

		position1 = assistentIntent.getIntExtra("INDEX_ESTADO1_ESCOLHIDO", 0);
		position2 = assistentIntent.getIntExtra("INDEX_ESTADO2_ESCOLHIDO", 0);
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
	
	// Change the activity to TelaSobreEscolhaIndicativo activity.
	public void openAboutScreen() {
		Intent intent = new Intent(this, IndicativeChoosenAboutScreen.class);
		startActivity(intent);
	}
	
	// Assigns the class variables with the check box on the screen.
	private void startCheckbox() {
		checkboxIdeb = (CheckBox) findViewById(R.id.checkBox_ideb);
		checkboxPIB = (CheckBox) findViewById(R.id.checkBox_participacao_pib);
		checkboxPopulation = (CheckBox) findViewById(R.id.checkBox_populacao);
		checkboxFirstProjects = (CheckBox) findViewById
			(R.id.checkBox_primeiros_projeto);
		checkboxCnpqProjects = (CheckBox) findViewById(R.id.checkBox_projetos_cnpq);
		checkboxDifussionProjects = (CheckBox) findViewById
			(R.id.checkBox_projetos_difusao);
		checkboxInitiationProjects = (CheckBox) findViewById
			(R.id.checkBox_projetos_iniciacao);
		checkboxYoungProjects = (CheckBox) findViewById
			(R.id.checkBox_projetos_jovens);
		checkboxCensus = (CheckBox) findViewById(R.id.checkBox_censo);
		checkboxClassSize = (CheckBox) findViewById(R.id.checkBox_quantidade_aluno);
		checkboxClassHours = (CheckBox) findViewById(R.id.checkBox_horas_aula);
		checkboxDistortionRate = (CheckBox) findViewById(R.id.checkBox_taxa_distorcao);
		checkboxDropoutRate = (CheckBox) findViewById(R.id.checkBox_taxa_abandono);
		checkboxApproval = (CheckBox) findViewById(R.id.checkBox_taxa_aprovacao);
	}
	
	// Verify which checkbox are selected.
	private void catchValues() {
		booleanIdeb = checkboxIdeb.isChecked();
		booleanPIB = checkboxPIB.isChecked();
		booleanPopulation = checkboxPopulation.isChecked();
		booleanFirstProjects = checkboxFirstProjects.isChecked();
		booleanCnpqProjetcts = checkboxCnpqProjects.isChecked();
		booleanDifussionProjects = checkboxDifussionProjects.isChecked();
		booleanInitiationProjects = checkboxInitiationProjects.isChecked();
		booleanYoungProjects = checkboxYoungProjects.isChecked();
		booleanCensus = checkboxCensus.isChecked();
		booleanClassSize = checkboxClassSize.isChecked();
		booleanClassHours = checkboxClassHours.isChecked();
		booleanDistortionRate = checkboxDistortionRate.isChecked();
		booleanDropoutRate = checkboxDropoutRate.isChecked();
		booleanApproval = checkboxApproval.isChecked();
	}
	
	// Select or clear all check box.
	public void checkOrUncheckCheckbox(boolean choosenOption) {
		checkboxIdeb.setChecked(choosenOption);
		checkboxPIB.setChecked(choosenOption);
		checkboxPopulation.setChecked(choosenOption);
		checkboxFirstProjects.setChecked(choosenOption);
		checkboxCnpqProjects.setChecked(choosenOption);
		checkboxDifussionProjects.setChecked(choosenOption);
		checkboxInitiationProjects.setChecked(choosenOption);
		checkboxYoungProjects.setChecked(choosenOption);
		checkboxCensus.setChecked(choosenOption);
		checkboxClassSize.setChecked(choosenOption);
		checkboxClassHours.setChecked(choosenOption);
		checkboxDistortionRate.setChecked(choosenOption);
		checkboxDropoutRate.setChecked(choosenOption);
		checkboxApproval.setChecked(choosenOption);
	}
	
	// Select all check box.
	public void onRadioButtonCheckAllClick(View view) {
		checkOrUncheckCheckbox(true);
	}
	
	// Clear all check box.
	public void onRadioButtonUncheckAllClick(View view) {
		checkOrUncheckCheckbox(false);
	}
	
	/*
	 * Implements the action of button which leads to comparison screen between
	 * the states according to the chosen indicative.
	 */
	public void clickButtonAllIndicatives(View view) {
		catchValues();

		Intent intent = new Intent(this, ConsultationResultScreen.class);
		intent.putExtra("CB_IDEB", booleanIdeb);
		intent.putExtra("CB_PIB", booleanPIB);
		intent.putExtra("CB_POPULACAO", booleanPopulation);
		intent.putExtra("CB_PRIMEIROS_PROJETOS", booleanFirstProjects);
		intent.putExtra("CB_PROJETOS_CNPQ", booleanCnpqProjetcts);
		intent.putExtra("CB_PROJETOS_DIFUSAO", booleanDifussionProjects);
		intent.putExtra("CB_PROJETOS_INICIACAO", booleanInitiationProjects);
		intent.putExtra("CB_PROJETOS_JOVENS", booleanYoungProjects);
		intent.putExtra("CB_ALUNOS_TURMA", booleanClassSize);
		intent.putExtra("CB_APROVACAO", booleanApproval);
		intent.putExtra("CB_CENSO", booleanCensus);
		intent.putExtra("CB_HORAS_AULA", booleanClassHours);
		intent.putExtra("CB_TAXA_ABANDONO", booleanDropoutRate);
		intent.putExtra("CB_TAXA_DISTORCAO", booleanDistortionRate);

		intent.putExtra("INDEX_ESTADO1_ESCOLHIDO", position1);
		intent.putExtra("INDEX_ESTADO2_ESCOLHIDO", position2);

		startActivity(intent);
	}

}
