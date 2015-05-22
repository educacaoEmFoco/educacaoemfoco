/***********************************************
 * File: ChoosesIndicative.java
 * 
 * Purpose: General class of choose indicatives.
 ***********************************************/

package com.mdsgpp.eef.view;

import com.mdsgpp.eef.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mdsgpp.eef.debug.Debug;

public abstract class ChoosesIndicative extends Activity {
	
	private String indicative = "populacao";
	private String title = "População";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_escolhe_indicativo_grafico);
	}

	// Inflate the menu, this adds items to the action bar if it is present.
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Debug.log("Chooses Indicative - onCreateOptionsMenu()", "Creating menu", Debug.DEBUG);
		getMenuInflater().inflate(R.menu.menu_telas, menu);
		return true;
	}
	
	// Get the option selected on menu.
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {		
		switch(item.getItemId()) {
			case R.id.sobre:
				Debug.log("Chooses Indicative - onOptionsItemSelected", 
					"click detected in About Button!", Debug.INFO);
				opensAboutScreen();
				break;
			case android.R.id.home:
				Debug.log("Chooses Indicative - onOptionsItemSelected", 
					"click detected in Home Button!", Debug.INFO);
	        	NavUtils.navigateUpFromSameTask(this);
	       		break;
			default:
				break;
		}
		
    	return true;
	}
	
	// Open the screen about.
	public abstract void opensAboutScreen();
	
	// Get the radioButton clicked to refresh information.
	public void onRadioButtonClicked(View view) {
		Debug.log("Chooses Indicative - onRadioButtonClicked", 
			"click detected on radio button indicative", Debug.INFO);

		switch(view.getId()) {
			case R.id.radio_apoio_cnpq_investimento:
				setValues("valor_projetos_cnpq", "Projetos de Pesquisa Apoio CNPq (R$)");
				break;
			case R.id.radio_apoio_cnpq_qtd:
				setValues("quantidade_projeto_cnpq", "rojetos de Pesquisa Apoio CNPq (Qtd.)");
				break;
			case R.id.radio_difusao_tecnologica_investimento:
				setValues("valor_ciencia_tecnologia", "Projeto de Difusão Tecnológica (R$)");
				break;
			case R.id.radio_difusao_tecnologica_qtd:
				setValues("projetos_ciencia_tecnologia", "Projeto de Difusão Tecnológica (Qtd.)");
				break;
			case R.id.radio_ideb_fundamental_finais:
				setValues("ideb_fundamental_final", "IDEB do Ensino Fundamental (Séries Finais)");
				break;
			case R.id.radio_ideb_fundamental_iniciai:
				setValues("ideb_fundamental_inicial", 
					"IDEB do Ensino Fundamental (Séries Iniciais)");
				break;
			case R.id.radio_ideb_medio:
				setValues("ideb_ensino_medio", "IDEB do Ensino Médio");
				break;
			case R.id.radio_jovens_pesquisadores_investimento:
				setValues("valor_projetos_jovens_pesquisadores", "Jovens pesquisadores (R$)");
				break;
			case R.id.radio_jovens_pesquisadores_qtd:
				setValues("quantidade_projeto_jovens_pesquisadores", 
					"Jovens pesquisadores (Qtd.)");
				break;
			case R.id.radio_pib:
				setValues("percentual_participacao_pib", "Participação Estadual no PIB (%)");
				break;
			case R.id.radio_populacao:
				setValues("populacao", "População");
				break;
			case R.id.radio_primeiros_projetos_investimento:
				setValues("valor_primeiros_projetos", "Programa Primeiros Projetos (R$)");
				break;
			case R.id.radio_primeiros_projetos_qtd:
				setValues("quantidade_primeiros_projetos", "Programa Primeiros Projetos (Qtd.)");
				break;
			case R.id.radio_projetos_inct_investimento:
				setValues("valor_projetos_inct", "Projetos INCT (R$)");
				break;
			case R.id.radio_projetos_inct_qtd:
				setValues("quantidade_projetos_inct", "Projetos INCT (Qtd.)");
				break;
			case R.id.radio_alunos_por_turma_fundamental:
				setValues("alunos_por_turma_ensino_fundamental", 
					"Média de Alunos por Turma do Ensino Fundamental (Qtd.)");
				break;
			case R.id.radio_alunos_por_turma_medio:
				setValues("alunos_por_turma_ensino_medio", 
					"Média de Alunos por Turma do Ensino Médio (Qtd.)");
				break;
			case R.id.radio_horas_aula_fundamental:
				setValues("horas_aula_ensino_fundamental", 
					"Média de horas aula diárias do Ensino Fundamental");
				break;
			case R.id.radio_horas_aula_medio:
				setValues("horas_aula_ensino_medio", 
					"Média de horas aula diárias do Ensino Mï¿½dio");
				break;
			case R.id.radio_taxa_distorcao_fundamental:
				setValues("taxa_distorcao_fundamental", 
					"Taxa de Distorção Idade/Série do Ensino Fundamental (%)");
				break;
			case R.id.radio_taxa_distorcao_medio:
				setValues("taxa_distorcao_medio", 
					"Taxa de Distorção Idade/Série do Ensino Médio (%)");
				break;
			case R.id.radio_taxa_aprovacao_fundamental:
				setValues("taxa_aprovacao_fundamental", 
					"Taxa de Aproveitamento do Ensino Fundamental (%)");
				break;
			case R.id.radio_taxa_aprovacao_medio:
				setValues("taxa_aprovacao_medio", "Taxa de Aproveitamento do Ensino Médio (%)");
				break;
			case R.id.radio_taxa_abandono_fundamental:
				setValues("taxa_abandono_fundamental", 
					"Taxa de Abandono do Ensino Fundamental (%)");
				break;
			case R.id.radio_taxa_abandono_medio:
				setValues("taxa_abandono_medio", "Taxa de Abandono do Ensino Médio (%)");
				break;
			case R.id.radio_censo_iniciais_fundamental:
				setValues("censo_anos_iniciais_fundamental", 
					"Censo Escolar dos Anos Iniciais do Ensino Fundamental (Matriculados)");
				break;
			case R.id.radio_censo_finais_fundamental:
				setValues("censo_anos_finais_fundamental", 
					"Censo Escolar dos Anos Finais do Ensino Fundamental (Matriculados)");
				break;
			case R.id.radio_censo_ensino_medio:
				setValues("censo_ensino_medio", "Censo Escolar do Ensino Médio (Matriculados)");
				break;
			case R.id.radio_censo_eja_fundamental:
				setValues("censo_eja_fundamental", 
					"Censo Escolar do EJA - Fundamental (Matriculados)");
				break;
			case R.id.radio_censo_eja_medio:
				setValues("censo_eja_medio", "Censo Escolar do EJA - Médio (Matriculados)");
				break;
			default:
				// Nothing to do.
		}
	}

	public void setValues(String indicative, String title) {
		setIndicative(indicative);
		setTitle(title);
	}

	// Implements the action on next button.
	public abstract void clickForwardButton(View view);

	public String getIndicative() {
		return indicative;
	}

	public void setIndicative(String indicative) {
		this.indicative = indicative;
	}
	
	public String getIndicativeTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}	
}