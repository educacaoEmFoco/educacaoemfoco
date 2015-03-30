package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public abstract class EscolheIndicativo extends Activity {
	
	private String indicativo = "populacao";
	private String titulo = "População";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_escolhe_indicativo_grafico);
	}

	// Inflate the menu, this adds items to the action bar if it is present.
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
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
				break;
		}
		
    	return true;
	}
	
	public abstract void abreTelaSobre();
	
	public void onRadioButtonClicked(View view) {

		switch (view.getId()) {
			case R.id.radio_apoio_cnpq_investimento:
				setValores("valor_projetos_cnpq", "Projetos de Pesquisa Apoio CNPq (R$)");
				break;
			case R.id.radio_apoio_cnpq_qtd:
				setValores("quantidade_projeto_cnpq", "rojetos de Pesquisa Apoio CNPq (Qtd.)");
				break;
			case R.id.radio_difusao_tecnologica_investimento:
				setValores("valor_ciencia_tecnologia", "Projeto de Difusão Tecnológica (R$)");
				break;
			case R.id.radio_difusao_tecnologica_qtd:
				setValores("projetos_ciencia_tecnologia", "Projeto de Difusãoo Tecnológica (Qtd.)");
				break;
			case R.id.radio_ideb_fundamental_finais:
				setValores("ideb_fundamental_final", "IDEB do Ensino Fundamental (Séries Finais)");
				break;
			case R.id.radio_ideb_fundamental_iniciai:
				setValores("ideb_fundamental_inicial", 
					"IDEB do Ensino Fundamental (Séries Iniciais)");
				break;
			case R.id.radio_ideb_medio:
				setValores("ideb_ensino_medio", "IDEB do Ensino Médio");
				break;
			case R.id.radio_jovens_pesquisadores_investimento:
				setValores("valor_projetos_jovens_pesquisadores", "Jovens pesquisadores (R$)");
				break;
			case R.id.radio_jovens_pesquisadores_qtd:
				setValores("quantidade_projeto_jovens_pesquisadores", 
					"Jovens pesquisadores (Qtd.)");
				break;
			case R.id.radio_pib:
				setValores("percentual_participacao_pib", "Participação Estadual no PIB (%)");
				break;
			case R.id.radio_populacao:
				setValores("populacao", "População");
				break;
			case R.id.radio_primeiros_projetos_investimento:
				setValores("valor_primeiros_projetos", "Programa Primeiros Projetos (R$)");
				break;
			case R.id.radio_primeiros_projetos_qtd:
				setValores("quantidade_primeiros_projetos", "Programa Primeiros Projetos (Qtd.)");
				break;
			case R.id.radio_projetos_inct_investimento:
				setValores("valor_projetos_inct", "Projetos INCT (R$)");
				break;
			case R.id.radio_projetos_inct_qtd:
				setValores("quantidade_projetos_inct", "Projetos INCT (Qtd.)");
				break;
			case R.id.radio_alunos_por_turma_fundamental:
				setValores("alunos_por_turma_ensino_fundamental", 
					"Média de Alunos por Turma do Ensino Fundamental (Qtd.)");
				break;
			case R.id.radio_alunos_por_turma_medio:
				setValores("alunos_por_turma_ensino_medio", 
					"Média de Alunos por Turma do Ensino Médio (Qtd.)");
				break;
			case R.id.radio_horas_aula_fundamental:
				setValores("horas_aula_ensino_fundamental", 
					"Média de horas aula diárias do Ensino Fundamental");
				break;
			case R.id.radio_horas_aula_medio:
				setValores("horas_aula_ensino_medio", 
					"Média de horas aula diárias do Ensino Médio");
				break;
			case R.id.radio_taxa_distorcao_fundamental:
				setValores("taxa_distorcao_fundamental", 
					"Taxa de Distorção Idade/Série do Ensino Fundamental (%)");
				break;
			case R.id.radio_taxa_distorcao_medio:
				setValores("taxa_distorcao_medio", 
					"Taxa de Distorção Idade/Série do Ensino Médio (%)");
				break;
			case R.id.radio_taxa_aprovacao_fundamental:
				setValores("taxa_aprovacao_fundamental", 
					"Taxa de Aproveitamento do Ensino Fundamental (%)");
				break;
			case R.id.radio_taxa_aprovacao_medio:
				setValores("taxa_aprovacao_medio", "Taxa de Aproveitamento do Ensino Médio (%)");
				break;
			case R.id.radio_taxa_abandono_fundamental:
				setValores("taxa_abandono_fundamental", 
					"Taxa de Abandono do Ensino Fundamental (%)");
				break;
			case R.id.radio_taxa_abandono_medio:
				setValores("taxa_abandono_medio", "Taxa de Abandono do Ensino Médio (%)");
				break;
			case R.id.radio_censo_iniciais_fundamental:
				setValores("censo_anos_iniciais_fundamental", 
					"Censo Escolar dos Anos Iniciais do Ensino Fundamental (Matriculados)");
				break;
			case R.id.radio_censo_finais_fundamental:
				setValores("censo_anos_finais_fundamental", 
					"Censo Escolar dos Anos Finais do Ensino Fundamental (Matriculados)");
				break;
			case R.id.radio_censo_ensino_medio:
				setValores("censo_ensino_medio", "Censo Escolar do Ensino Médio (Matriculados)");
				break;
			case R.id.radio_censo_eja_fundamental:
				setValores("censo_eja_fundamental", 
					"Censo Escolar do EJA - Fundamental (Matriculados)");
				break;
			case R.id.radio_censo_eja_medio:
				setValores("censo_eja_medio", "Censo Escolar do EJA - Médio (Matriculados)");
				break;
			case default:
				// Nothing to do.
		}
	}

	public void setValores(String indivativo, String titulo) {
		setIndicativo(indivativo);
		setTitulo(titulo);
	}

	public abstract void clickBotaoAvancar(View view);

	public String getIndicativo() {
		return indicativo;
	}

	public void setIndicativo(String indicativo) {
		this.indicativo = indicativo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}	
}