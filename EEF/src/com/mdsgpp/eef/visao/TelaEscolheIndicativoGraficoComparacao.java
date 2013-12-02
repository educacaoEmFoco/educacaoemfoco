package com.mdsgpp.eef.visao;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.mdsgpp.eef.R;

public class TelaEscolheIndicativoGraficoComparacao extends EscolheIndicativo {
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
			setValores("ideb_fundamental_inicial", "IDEB do Ensino Fundamental (Séries Iniciais)");
			break;
		case R.id.radio_ideb_medio:
			setValores("ideb_ensino_medio", "IDEB do Ensino Médio");
			break;
		case R.id.radio_jovens_pesquisadores_investimento:
			setValores("valor_projetos_jovens_pesquisadores", "Jovens pesquisadores (R$)");
			break;
		case R.id.radio_jovens_pesquisadores_qtd:
			setValores("quantidade_projeto_jovens_pesquisadores", "Jovens pesquisadores (Qtd.)");
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
			setValores("alunos_por_turma_ensino_fundamental", "Média de Alunos por Turma do Ensino Fundamental (Qtd.)");
			break;
		case R.id.radio_alunos_por_turma_medio:
			setValores("alunos_por_turma_ensino_medio", "Média de Alunos por Turma do Ensino Médio (Qtd.)");
			break;
		case R.id.radio_horas_aula_fundamental:
			setValores("horas_aula_ensino_fundamental", "Média de horas aula diárias do Ensino Fundamental");
			break;
		case R.id.radio_horas_aula_medio:
			setValores("horas_aula_ensino_medio", "Média de horas aula diárias do Ensino Médio");
			break;
		case R.id.radio_taxa_distorcao_fundamental:
			setValores("taxa_distorcao_fundamental", "Taxa de Distorção Idade/Série do Ensino Fundamental (%)");
			break;
		case R.id.radio_taxa_distorcao_medio:
			setValores("taxa_distorcao_medio", "Taxa de Distorção Idade/Série do Ensino Médio (%)");
			break;
		case R.id.radio_taxa_aprovacao_fundamental:
			setValores("taxa_aprovacao_fundamental", "Taxa de Aproveitamento do Ensino Fundamental (%)");
			break;
		case R.id.radio_taxa_aprovacao_medio:
			setValores("taxa_aprovacao_medio", "Taxa de Aproveitamento do Ensino Médio (%)");
			break;
		case R.id.radio_taxa_abandono_fundamental:
			setValores("taxa_abandono_fundamental", "Taxa de Abandono do Ensino Fundamental (%)");
			break;
		case R.id.radio_taxa_abandono_medio:
			setValores("taxa_abandono_medio", "Taxa de Abandono do Ensino Médio (%)");
			break;
		case R.id.radio_censo_iniciais_fundamental:
			Log.i("selecionado", "selecionado");
			setValores("censo_anos_iniciais_fundamental", "Censo Escolar dos Anos Iniciais do Ensino Fundamental (Matriculados)");
			break;
		case R.id.radio_censo_finais_fundamental:
			Log.i("selecionado", "selecionado");
			setValores("censo_anos_finais_fundamental", "Censo Escolar dos Anos Finais do Ensino Fundamental (Matriculados)");
			break;
		case R.id.radio_censo_ensino_medio:
			setValores("censo_ensino_medio", "Censo Escolar do Ensino Médio (Matriculados)");
			break;
		case R.id.radio_censo_eja_fundamental:
			setValores("censo_eja_fundamental", "Censo Escolar do EJA - Fundamental (Matriculados)");
			break;
		case R.id.radio_censo_eja_medio:
			setValores("censo_eja_medio", "Censo Escolar do EJA - Médio (Matriculados)");
			break;
		}
	}

	public void setValores(String indivativo, String titulo) {
		setIndicativo(indivativo);
		setTitulo(titulo);
	}
	
	public void clickBotaoGrafico(View view) {
		Intent intent = new Intent(this, TelaGrafico.class);
		
		intent.putExtra("INDEX_ESTADO1_ESCOLHIDO", getPosicao1());
		intent.putExtra("INDEX_ESTADO2_ESCOLHIDO", getPosicao2());
		intent.putExtra("INDICATIVO", getIndicativo());
		intent.putExtra("TITULO", getTitulo());

		startActivity(intent);		
	}
}
