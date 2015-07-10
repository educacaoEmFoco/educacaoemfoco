package com.mdsgpp.eef.view;

import java.io.IOException;
import java.util.HashMap;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.controller.StateController;
import com.mdsgpp.eef.debug.Debug;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class StateScreen extends Activity {

	private TextView textViewAcronym;	
	private TextView textViewName;
	private TextView textViewPopulation;
	private TextView textViewPibParticipation;
	private TextView textViewTecnologyScienceProjectsQuantity;
	private TextView textViewTecnologyScienceProjectsValue;
	private TextView textViewElementaryIdeb;
	private TextView textViewHighSchoolIdeb;
	private TextView textViewPrimaryIdeb;
	private	TextView textViewFirstProjectsQuantity;
	private TextView textViewFirstProjectsValue;
	private TextView textViewSearchQuantity;
	private TextView textViewYoungSearchersQuantity;
	private TextView textViewSearchValues;
	private TextView textViewYoungSearchersValue;
	private TextView textViewQuantityProjectInitiation;
	private TextView textViewValueProjectInitiation;	
	private TextView textViewCensusPrimaryElementary;
	private TextView textViewCensusFinaisElementary;
	private TextView textViewCensusHighSchool;
	private TextView textViewCensusEjaElementary;
	private TextView textViewCensusEjaHighSchool;
	private TextView textViewAverageStudentsByClassElementary;
	private TextView textViewAverageStudentsByClassHighSchool;
	private TextView textViewAverageHoursClassElementary;
	private TextView textViewAverageHoursClassHighSchool;
	private TextView textViewTaxDistortionIdadeSerieElementary;
	private TextView textViewTaxDistortionIdadeSerieHighSchool;
	private TextView textViewTaxRatingElementary;
	private TextView textViewTaxRatingHighSchool;
	private TextView textViewTaxAbandonmentElementary;
	private TextView textViewTaxAbandonmentHighSchool;
	
	private ImageView imageViewFlags;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_estado);
		
		captureInformations();
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
				openStateAboutScreen();
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
	    
	// Change the activity to TelaSobreEstado activity.
	public void openStateAboutScreen() {
		Debug.log("StateScreen - openStateAboutScreen()", "opening stateAboutScreen", Debug.DEBUG);
		
	    Intent intent = new Intent(this, StateAboutScreen.class);
	    startActivity(intent);
	}
	
	// Takes the information from the previous activity to that.
	private void captureInformations() {
		Intent intent = getIntent();
		int position = intent.getIntExtra("INDEX_ESTADO_ESCOLHIDO", 0);	
		
		Debug.log("StateScreen - captureInformations()", "position = " + position, Debug.INFO);
		
		initializeTextViews();
		
	    HashMap<String, String> informations = new HashMap <String, String>();
	    
	    try {
			informations = StateController.getInstance(this).readState(position);
			fillTextViews(informations);
			setImage(position);
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(), "Houve um erro no acesso �s informa��es.",
				Toast.LENGTH_SHORT).show();
			Debug.log("StateScreen - captureInformations()",
				"an error has ocurred acessing the state informations", Debug.ERROR);
		}
	}
	
	// Assigns the class variables with the fields on the screen.
	private void initializeTextViews() {
		Debug.log("StateScreen - initializeTextViews()", "initializing text views of the screen",
			Debug.DEBUG);
		
		textViewAcronym = (TextView) findViewById(R.id.textView_sigla);
		textViewName = (TextView) findViewById(R.id.textView_nome_estado);
		textViewPopulation = (TextView)
			findViewById(R.id.textView_populacao_valor);
		textViewPibParticipation = (TextView)
			findViewById(R.id.textView_participacao_pib_valor);
		textViewTecnologyScienceProjectsQuantity = (TextView) 
			findViewById(R.id.textView_numero_projetos_quantidade);
		textViewTecnologyScienceProjectsValue = (TextView)
			findViewById(R.id.textView_valor_investido_projetos);
		textViewElementaryIdeb = (TextView)
			findViewById(R.id.textView_ideb_fundamental);
		textViewHighSchoolIdeb = (TextView)
			findViewById(R.id.textView_ideb_ensinomedio);
		textViewPrimaryIdeb = (TextView)
			findViewById(R.id.textView_ideb_iniciais);
		textViewFirstProjectsQuantity = (TextView)
			findViewById(R.id.textView_primeiros_projetos_quantidade);
		textViewFirstProjectsValue = (TextView) 
			findViewById(R.id.textView_programa_primeiros_projetos_valor);
		textViewSearchQuantity = (TextView)
			findViewById(R.id.textView_projetos_pesquisa_quantidade);
		textViewSearchValues = (TextView)
			findViewById(R.id.textView_valores_projeto_pesquisa);
		textViewYoungSearchersQuantity = (TextView) 
			findViewById(R.id.textView_jovens_pesquisadores_quantidade);
		textViewYoungSearchersValue= (TextView)
			findViewById(R.id.textView_jovens_pesquisadores_valor);
		textViewQuantityProjectInitiation = (TextView)
			findViewById(R.id.textView_projetos_iniciacao_quantidade);
		textViewValueProjectInitiation = (TextView)
			findViewById(R.id.textView_projetos_iniciacao_valor);
		
		textViewCensusPrimaryElementary = (TextView)
			findViewById(R.id.textView_censo_iniciais_fundamental);
		textViewCensusFinaisElementary = (TextView)
			findViewById(R.id.textView_censo_finais_fundamental);
		textViewCensusHighSchool = (TextView) 
			findViewById(R.id.textView_censo_medio);
		textViewCensusEjaElementary = (TextView)
			findViewById(R.id.textView_censo_fundamental_eja);
		textViewCensusEjaHighSchool = (TextView) 
			findViewById(R.id.textView_censo_medio_eja);
		textViewAverageStudentsByClassElementary = (TextView)
			findViewById(R.id.textView_media_alunos_por_turma_fundamental);
		textViewAverageStudentsByClassHighSchool = (TextView) 
			findViewById(R.id.textView_media_alunos_por_turma_medio);
		textViewAverageHoursClassElementary = (TextView)
			findViewById(R.id.textView_horas_aula_ensino_fundamental);
		textViewAverageHoursClassHighSchool = (TextView)
			findViewById(R.id.textView_horas_aula_ensino_medio);
		textViewTaxDistortionIdadeSerieElementary = (TextView)
			findViewById(R.id.textView_taxa_distorcao_fundamental);
		textViewTaxDistortionIdadeSerieHighSchool = (TextView)
			findViewById(R.id.textView_taxa_distorcao_medio);
		textViewTaxRatingElementary = (TextView) 
			findViewById(R.id.textView_taxa_aprovacao_fundamental);
		textViewTaxRatingHighSchool = (TextView)
			findViewById(R.id.textView_taxa_aprovacao_medio);
		textViewTaxAbandonmentElementary = (TextView)
			findViewById(R.id.textView_taxa_abandono_fundamental);
		textViewTaxAbandonmentHighSchool = (TextView)
			findViewById(R.id.textView_taxa_abandono_medio);
	}
	
	// Fills the screen fields with the information received.
	private void fillTextViews(HashMap<String, String> informations) {
		Debug.log("StateScreen - fillTextViews()", "fulfilling the state text views", Debug.DEBUG);
		
		textViewAcronym.setText(informations.get("sigla"));
		textViewName.setText(informations.get("nome"));
		textViewPopulation.setText(informations.get("populacao"));
		textViewPibParticipation.setText(informations.get
			("percentual_participacao_pib"));
		textViewTecnologyScienceProjectsQuantity.setText(informations.get
			("projetos_ciencia_tecnologia"));
		textViewTecnologyScienceProjectsValue.setText(informations.get
			("valor_ciencia_tecnologia"));
		textViewElementaryIdeb.setText(informations.get
			("ideb_fundamental_final"));
		textViewHighSchoolIdeb.setText(informations.get("ideb_ensino_medio"));
		textViewPrimaryIdeb.setText(informations.get
			("ideb_fundamental_inicial"));
		textViewFirstProjectsQuantity.setText(informations.get
			("quantidade_primeiros_projetos"));
		textViewFirstProjectsValue.setText(informations.get
			("valor_primeiros_projetos"));
	    textViewSearchQuantity.setText(informations.get
	    	("quantidade_projeto_cnpq"));
		textViewSearchValues.setText(informations.get("valor_projetos_cnpq"));
		textViewYoungSearchersQuantity.setText(informations.get
			("quantidade_projeto_jovens_pesquisadores"));
		textViewYoungSearchersValue.setText(informations.get
			("valor_projetos_jovens_pesquisadores"));
		textViewQuantityProjectInitiation.setText(informations.get
			("quantidade_projetos_inct"));
		textViewValueProjectInitiation.setText(informations.get
			("valor_projetos_inct"));
		
		textViewCensusPrimaryElementary.setText(informations.get
			("censo_anos_iniciais_fundamental"));
		textViewCensusFinaisElementary.setText(informations.get
			("censo_anos_finais_fundamental"));
		textViewCensusHighSchool.setText(informations.get
			("censo_ensino_medio"));
		textViewCensusEjaElementary.setText(informations.get
			("censo_eja_fundamental"));
		textViewCensusEjaHighSchool.setText(informations.get("censo_eja_medio"));
		textViewAverageStudentsByClassElementary.setText(informations.get
			("alunos_por_turma_ensino_fundamental"));
		textViewAverageStudentsByClassHighSchool.setText(informations.get
			("alunos_por_turma_ensino_medio"));
		textViewAverageHoursClassElementary.setText(informations.get
			("horas_aula_ensino_fundamental"));
		textViewAverageHoursClassHighSchool.setText(informations.get
			("horas_aula_ensino_medio"));
		textViewTaxDistortionIdadeSerieElementary.setText(informations.get
			("taxa_distorcao_fundamental"));
		textViewTaxDistortionIdadeSerieHighSchool.setText(informations.get
			("taxa_distorcao_medio"));
		textViewTaxRatingElementary.setText(informations.get
			("taxa_aprovacao_fundamental"));
		textViewTaxRatingHighSchool.setText(informations.get
			("taxa_aprovacao_medio"));
		textViewTaxAbandonmentElementary.setText(informations.get
			("taxa_aprovacao_fundamental"));
		textViewTaxAbandonmentHighSchool.setText(informations.get
			("taxa_aprovacao_medio"));
		
	}
	
	// Set the images of flags of Brazilian states on the screen.
	private void setImage (int position) {
		Debug.log("StateScreen - setImage()", "setting state flags images", Debug.DEBUG);
		
		String flags[] = {"acre", "alagoas", "amapa", "amazonas", "bahia", 
			"ceara", "distritofederal", "espiritosanto", "goias","maranhao",
			"matogrosso", "matogrossodosul", "minasgerais","para", "paraiba",
			"parana", "pernambuco", "piaui", "riodejaneiro", "riograndedonorte",
			"riograndedosul", "rondonia", "roraima", "santacatarina",
			"saopaulo", "sergipe", "tocantins"};	
		
		imageViewFlags = (ImageView) findViewById(R.id.imageView_bandeiras);
		int flagId = getResources().getIdentifier(flags[position],
			"drawable", getPackageName());
		imageViewFlags.setImageResource(flagId);
	}
	
	// Implements the action of button to see the history of the state.
	public void clickStateHistoryButton (View view) {
		Debug.log("StateScreen - clickStateHistoryButton", "State History Button Clicked!",
			Debug.INFO);
		Debug.log("StateScreen - clickStateHistoryButton", "creating intent", Debug.DEBUG);
		
		Intent intentAux = getIntent();
		int position = intentAux.getIntExtra("INDEX_ESTADO_ESCOLHIDO", 0);
		
		Intent intent = new Intent(this, StateHistoryScreen.class);
		intent.putExtra("ESTADO", position);
		
		Debug.log("StateScreen - clickStateHistoryButton", "starting activity", Debug.DEBUG);
		
		startActivity(intent);
	}

}
