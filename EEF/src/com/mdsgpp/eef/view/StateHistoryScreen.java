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

public class StateHistoryScreen extends Activity {
	HashMap<String, String> information;
	private TextView textViewAcronym;	
	private TextView textViewName;
	private TextView textViewPopulation;
	private TextView textViewParticipationPIB;
	private TextView textViewScienceTechnologyProjectsQuantity;
	private TextView textViewIdebs;
	private	TextView textViewFirstProjects;
	private TextView textViewResearchValues;
	private TextView textViewYoungResearchersValues;
	private TextView textViewInitiationProjectsValues;
	private ImageView imageViewStateFlags;	
	private TextView textViewCensusValue;
	private TextView textViewAverageClassSizeValue;
	private TextView textViewElementarySchoolAverageHoursClass;
	private TextView textViewHighSchoolAverageHoursClass;
	private TextView textViewAgeSeriesDistortionRateValue;
	private TextView textViewUtilizationRateValue;
	private TextView textViewDropoutRateValue;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_historico_estado);
		
		catchInformation();
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
	
	// Change the activity to TelaSobreHistoricoDeIndicativo activity.
	public void openAboutScreen() {
		Intent intent = new Intent(this, IndicativeHistoryAboutScreen.class);
    	startActivity(intent);	
	}
	
	// Takes the information from the previous activity to that.
	private void catchInformation() {
		Intent intent = getIntent();
		
		int position = intent.getIntExtra("ESTADO", 0);
		information = new HashMap <String, String>();
		
		startTextFields();
		
		try {
			information = StateController.getInstance(this).readFullState(position);
			fulfillTextFields(information);
			setImagem(position);
			
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(),
				"Houve um erro no acesso �s informa��es.",
				Toast.LENGTH_SHORT).show();
			Log.i("IOException - TelaHistoricoEstado", e.toString());
		}
	}
	
	// Assigns the class variables with the fields on the screen.
	private void startTextFields() {
		
		textViewAcronym = (TextView) findViewById(R.id.textView_sigla);
		textViewName = (TextView) findViewById(R.id.textView_nome_estado);
		textViewPopulation = (TextView)
			findViewById(R.id.textView_populacao_valor);
		textViewParticipationPIB = (TextView)
			findViewById(R.id.textView_participacao_pib_valor);
		textViewScienceTechnologyProjectsQuantity = (TextView) 
			findViewById(R.id.textView_numero_projetos_quantidade);
		textViewIdebs = (TextView) findViewById(R.id.textView_idebs);
		textViewFirstProjects = (TextView)
			findViewById(R.id.textView_primeiros_projetos);
		textViewResearchValues = (TextView) 
			findViewById(R.id.textView_valores_projeto_pesquisa);
		textViewYoungResearchersValues= (TextView)
			findViewById(R.id.textView_jovens_pesquisadores_valor);
		textViewInitiationProjectsValues = (TextView)
			findViewById(R.id.textView_projetos_iniciacao_valor);
		
		textViewCensusValue = (TextView)
			findViewById(R.id.textView_censo_medio_valor);
		textViewAverageClassSizeValue = (TextView) 
			findViewById(R.id.textView_media_alunos_por_turma_valor);
		textViewElementarySchoolAverageHoursClass = (TextView)
			findViewById(R.id.textView_horas_aula_ensino_fundamental);
		textViewHighSchoolAverageHoursClass = (TextView)
			findViewById(R.id.textView_horas_aula_ensino_medio);
		textViewAgeSeriesDistortionRateValue = (TextView)
			findViewById(R.id.textView_taxa_distorcao_valor);
		textViewUtilizationRateValue = (TextView)
			findViewById(R.id.textView_taxa_aprovacao_valor);
		textViewDropoutRateValue = (TextView) 
			findViewById(R.id.textView_taxa_abandono_valor);
	}
	
	// Fills the screen fields with the information received.
	private void fulfillTextFields(HashMap<String, String> information) {
		textViewAcronym.setText(information.get("sigla"));
		textViewName.setText(information.get("nome"));
		textViewPopulation.setText(information.get("populacao"));
		textViewParticipationPIB.setText(information.get("percentual_participacao_pib"));
		textViewScienceTechnologyProjectsQuantity.setText(information.get
			("projetos_ciencia_tecnologia"));
		textViewIdebs.setText(information.get("ideb"));
		textViewFirstProjects.setText(information.get("primeiros_projetos"));
		textViewResearchValues.setText(information.get("cnpq"));
		textViewYoungResearchersValues.setText(information.get("jovens_pesquisadores"));
		textViewInitiationProjectsValues.setText(information.get("projetos_inct"));
		
		textViewAverageClassSizeValue.setText(information.get("alunos_por_turma_ensino_medio"));
		textViewCensusValue.setText(information.get("censo"));
		textViewElementarySchoolAverageHoursClass.setText(information.get
			("horas_aula_ensino_fundamental"));
		textViewHighSchoolAverageHoursClass.setText(information.get("horas_aula_ensino_medio"));
		textViewAgeSeriesDistortionRateValue.setText(information.get("taxa_distorcao"));
		textViewUtilizationRateValue.setText(information.get("taxa_aprovacao"));
		textViewDropoutRateValue.setText(information.get("taxa_abandono"));
		
	}
	
	// Set the images of flags of Brazilian states on the screen.
	private void setImagem(int position) {
		String stateFlags[] = {"acre", "alagoas", "amapa", "amazonas", "bahia", 
			"ceara", "distritofederal", "espiritosanto", "goias", "maranhao",
			"matogrosso", "matogrossodosul", "minasgerais", "para", "paraiba",
			"parana", "pernambuco", "piaui", "riodejaneiro", "riograndedonorte",
			"riograndedosul", "rondonia", "roraima", "santacatarina",
			"saopaulo", "sergipe", "tocantins"};	
		
		imageViewStateFlags = (ImageView) findViewById(R.id.imageView_bandeiras);
		int idStateFlag = getResources().getIdentifier(stateFlags[position],
			"drawable", getPackageName());
		imageViewStateFlags.setImageResource(idStateFlag);
	}
	
	/*
	 * Implements the action of button to choose the indicative to generate the
	 * chart.
	 */
    public void clickChooseIndicativeToGenerateChartButton(View view) {
		Intent intent1 = getIntent();
		
		int position = intent1.getIntExtra("ESTADO", 0);
		
    	Intent intent = new Intent(this, ChooseIndicativeChartLineScreen.class);
    	intent.putExtra("ESTADO", position);
    	
		intent.putExtra("CB_IDEB", true);
		intent.putExtra("CB_PIB", true);
		intent.putExtra("CB_POPULACAO", true);
		intent.putExtra("CB_PRIMEIROS_PROJETOS", true);
		intent.putExtra("CB_PROJETOS_CNPQ", true);
		intent.putExtra("CB_PROJETOS_DIFUSAO", true);
		intent.putExtra("CB_PROJETOS_INICIACAO", true);
		intent.putExtra("CB_PROJETOS_JOVENS", true);
		intent.putExtra("CB_ALUNOS_TURMA", true);
		intent.putExtra("CB_APROVACAO",true);
		intent.putExtra("CB_CENSO", true);
		intent.putExtra("CB_HORAS_AULA", true);
		intent.putExtra("CB_TAXA_ABANDONO", true);
		intent.putExtra("CB_TAXA_DISTORCAO", true);
		
		startActivity(intent);
    }

}
