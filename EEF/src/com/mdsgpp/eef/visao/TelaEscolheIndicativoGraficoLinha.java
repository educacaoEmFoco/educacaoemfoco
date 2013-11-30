package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;

import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;

public class TelaEscolheIndicativoGraficoLinha extends EscolheIndicativo {
	public void onRadioButtonClicked(View view) {

		boolean checked = ((RadioButton) view).isChecked();
		
		switch (view.getId()) {
		case R.id.radio_apoio_cnpq_investimento:
			if (checked)
				setIndicativo("valor_projetos_cnpq");
				setTitulo("Projetos de Pesquisa Apoio CNPq (R$)");
			break;
		case R.id.radio_apoio_cnpq_qtd:
			if (checked)
				setIndicativo("quantidade_projeto_cnpq");
				setTitulo("rojetos de Pesquisa Apoio CNPq (Qtd.)");
			break;
		case R.id.radio_difusao_tecnologica_investimento:
			if (checked)
				setIndicativo("valor_ciencia_tecnologia");
				setTitulo("Projeto de Difusï¿½o Tecnolï¿½gica (R$)");
			break;
		case R.id.radio_difusao_tecnologica_qtd:
			if (checked)
				setIndicativo("projetos_ciencia_tecnologia");
				setTitulo("Projeto de Difusï¿½o Tecnolï¿½gica (Qtd.)");
			break;
		case R.id.radio_ideb_fundamental_finais:
			if (checked)
				setIndicativo("ideb_fundamental_final");
				setTitulo("IDEB do Ensino Fundamental (Sï¿½ries Finais)");
			break;
		case R.id.radio_ideb_fundamental_iniciai:
			if (checked)
				setIndicativo("ideb_fundamental_inicial");
				setTitulo("IDEB do Ensino Fundamental (Sï¿½ries Iniciais)");
			break;
		case R.id.radio_ideb_medio:
			if (checked)
				setIndicativo("ideb_ensino_medio");
				setTitulo("IDEB do Ensino Mï¿½dio");
			break;
		case R.id.radio_jovens_pesquisadores_investimento:
			if (checked)
				setIndicativo("valor_projetos_jovens_pesquisadores");
				setTitulo("Jovens pesquisadores (R$)");
			break;

		case R.id.radio_jovens_pesquisadores_qtd:
			if (checked)
				setIndicativo("quantidade_projeto_jovens_pesquisadores");
				setTitulo("Jovens pesquisadores (Qtd.)");
			break;

		case R.id.radio_pib:
			if (checked)
				setIndicativo("percentual_participacao_pib");
				setTitulo("Participaï¿½ï¿½o Estadual no PIB (%)");
			break;

		case R.id.radio_populacao:
			if (checked)
				setIndicativo("populacao");
				setTitulo("Populaï¿½ï¿½o");
			break;

		case R.id.radio_primeiros_projetos_investimento:
			if (checked)
				setIndicativo("valor_primeiros_projetos");
				setTitulo("Programa Primeiros Projetos (R$)");
			break;

		case R.id.radio_primeiros_projetos_qtd:
			if (checked)
				setIndicativo("quantidade_primeiros_projetos");
				setTitulo("Programa Primeiros Projetos (Qtd.)");
			break;

		case R.id.radio_projetos_inct_investimento:
			if (checked)
				setIndicativo("valor_projetos_inct");
				setTitulo("Projetos INCT (R$)");
			break;

		case R.id.radio_projetos_inct_qtd:
			if (checked)
				setIndicativo("quantidade_projetos_inct");
				setTitulo("Projetos INCT (Qtd.)");
			break;

		case R.id.radio_alunos_por_turma_fundamental:
			if (checked)
				setIndicativo("alunos_por_turma_ensino_medio");
				setTitulo("Média de Alunos por Turma do Ensino Fundamental(Qtd.)");
			break;

		case R.id.radio_alunos_por_turma_medio:
			if (checked)
				setIndicativo("alunos_por_turma_ensino_medio");
				setTitulo("Média de Alunos por Turma do Ensino Médio(Qtd.)");
			break;

		case R.id.radio_horas_aula_fundamental:
			if (checked)
				setIndicativo("horas_aula_ensino_medio");
				setTitulo("Horas médias por aula do Ensino Fundamental");
			break;

		case R.id.radio_horas_aula_medio:
			if (checked)
				setIndicativo("horas_aula_ensino_medio");
				setTitulo("Horas médias por aula do Ensino Médio");
			break;

		case R.id.radio_taxa_distorcao_fundamental:
			if (checked)
				setIndicativo("taxa_distorcao");
				setTitulo("Taxa de Distorção por Idade do Ensino Fundamental (%)");
			break;

		case R.id.radio_taxa_distorcao_medio:
			if (checked)
				setIndicativo("taxa_distorcao");
				setTitulo("Taxa de Distorção por Idade do Ensino Médio (%)");
			break;

		case R.id.radio_taxa_aprovacao_fundamental:
			if (checked)
				setIndicativo("taxa_aprovacao");
				setTitulo("Taxa de Aprovação do Ensino Fundamental (%)");
			break;

		case R.id.radio_taxa_aprovacao_medio:
			if (checked)
				setIndicativo("taxa_aprovacao");
				setTitulo("Taxa de Aprovação do Ensino Médio (%)");
			break;

		case R.id.radio_taxa_abandono_fundamental:
			if (checked)
				setIndicativo("taxa_abandono");
				setTitulo("Taxa de Abandono do Ensino Fundamental (%)");
			break;

		case R.id.radio_taxa_abandono_medio:
			if (checked)
				setIndicativo("taxa_abandono");
				setTitulo("Taxa de Abandono do Ensino Médio (%)");
			break;

		case R.id.radio_censo_iniciais_fundamental:
			if (checked)
				setIndicativo("censo");
				setTitulo("Censo Escolar dos Anos Iniciais do Ensino Fundamental (%)");
			break;

		case R.id.radio_censo_finais_fundamental:
			if (checked)
				setIndicativo("censo");
				setTitulo("Censo Escolar dos Anos Finais do Ensino Fundamental (%)");
			break;

		case R.id.radio_censo_ensino_medio:
			if (checked)
				setIndicativo("censo");
				setTitulo("Censo Escolar do Ensino Médio (%)");
			break;

		case R.id.radio_censo_eja_fundamental:
			if (checked)
				setIndicativo("censo");
				setTitulo("Censo Escolar do EJA - Fundamental (%)");
			break;

		case R.id.radio_censo_eja_medio:
			if (checked)
				setIndicativo("censo");
				setTitulo("Censo Escolar do EJA - Médio (%)");
			break;

		}
	}

	public void clickBotaoGrafico(View view) {
		Intent intent = new Intent(this, TelaGraficoLinha.class);
		
		intent.putExtra("INDEX_ESTADO_ESCOLHIDO", getPosicao1());
		intent.putExtra("INDICATIVO", getIndicativo());
		intent.putExtra("TITULO", getTitulo());

		startActivity(intent);		
	}
}
