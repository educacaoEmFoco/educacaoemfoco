package com.mdsgpp.eef.visao;

import java.io.IOException;
import java.util.ArrayList;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.controle.EstadoControle;
import com.mdsgpp.eef.modelo.Estado;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

public class TelaEscolheIndicativoGraficoLinha extends EscolheIndicativo {


	private Estado estado = capturaInformacoesEstado();
	private ArrayList<Float> historico = new ArrayList<Float>();


	public void onRadioButtonClicked(View view) {

		boolean checked = ((RadioButton) view).isChecked();

		switch (view.getId()) {
		case R.id.radio_apoio_cnpq_investimento:
			if (checked)
			setIndicativo("valor_projetos_cnpq");
			setTitulo("Projetos de Pesquisa Apoio CNPq (R$)");
			historico.clear();
			for (int i = 0; i < estado.getProjetosApoioCnpq().length - 1; i++)
				historico.add((float) estado.getProjetosApoioCnpq()[i]
						.getValor());
			break;
		case R.id.radio_apoio_cnpq_qtd:
			if (checked)
			setIndicativo("quantidade_projeto_cnpq");
			setTitulo("rojetos de Pesquisa Apoio CNPq (Qtd.)");
			historico.clear();
			for (int i = 0; i < estado.getProjetosApoioCnpq().length - 1; i++)
				historico.add((float) estado.getProjetosApoioCnpq()[i]
						.getQuantidade());
			break;
		case R.id.radio_difusao_tecnologica_investimento:
			if (checked)
				 
			setIndicativo("valor_ciencia_tecnologia");
			setTitulo("Projeto de Difusï¿½o Tecnolï¿½gica (R$)");
			historico.clear();
			for (int i = 0; i < estado.getProjetosCienciaTecnologia().length - 1; i++)
				historico.add((float) estado.getProjetosCienciaTecnologia()[i]
						.getValor());

			break;
		case R.id.radio_difusao_tecnologica_qtd:
			if (checked)
				 
			setIndicativo("projetos_ciencia_tecnologia");
			setTitulo("Projeto de Difusï¿½o Tecnolï¿½gica (Qtd.)");
			historico.clear();
			for (int i = 0; i < estado.getProjetosCienciaTecnologia().length - 1; i++)
				historico.add((float) estado.getProjetosCienciaTecnologia()[i]
						.getQuantidade());
			break;
		case R.id.radio_ideb_fundamental_finais:
			if (checked)
				 
			setIndicativo("ideb_fundamental_final");
			setTitulo("IDEB do Ensino Fundamental (Sï¿½ries Finais)");
			historico.clear();
			for (int i = 0; i < estado.getIdebs().length - 1; i++)
				historico.add((float) estado.getIdebs()[i].getFundamental());
			break;
		case R.id.radio_ideb_fundamental_iniciai:
			if (checked)
				 
			setIndicativo("ideb_fundamental_inicial");
			setTitulo("IDEB do Ensino Fundamental (Sï¿½ries Iniciais)");
			historico.clear();
			for (int i = 0; i < estado.getIdebs().length - 1; i++)
				historico.add((float) estado.getIdebs()[i].getSeriesIniciais());
			break;
		case R.id.radio_ideb_medio:
			if (checked)
				 
			setIndicativo("ideb_ensino_medio");
			setTitulo("IDEB do Ensino Mï¿½dio");
			historico.clear();
			for (int i = 0; i < estado.getIdebs().length - 1; i++)
				historico.add((float) estado.getIdebs()[i].getMedio());
			break;
		case R.id.radio_jovens_pesquisadores_investimento:
			if (checked)
				 
			setIndicativo("valor_projetos_jovens_pesquisadores");
			setTitulo("Jovens pesquisadores (R$)");
			historico.clear();
			for (int i = 0; i < estado.getProjetoJovensPesquisadores().length - 1; i++)
				historico.add((float) estado.getProjetoJovensPesquisadores()[i]
						.getValor());
			break;

		case R.id.radio_jovens_pesquisadores_qtd:
			if (checked)
				 
			setIndicativo("quantidade_projeto_jovens_pesquisadores");
			setTitulo("Jovens pesquisadores (Qtd.)");
			historico.clear();
			for (int i = 0; i < estado.getProjetoJovensPesquisadores().length - 1; i++)
				historico.add((float) estado.getProjetoJovensPesquisadores()[i]
						.getQuantidade());
			break;

		case R.id.radio_pib:
			if (checked)
				 
			setIndicativo("percentual_participacao_pib");
			setTitulo("Participaï¿½ï¿½o Estadual no PIB (%)");
			historico.clear();
			for (int i = 0; i < estado.getParticipacaoPercentualPIB().length - 1; i++)
				historico.add((float) estado.getParticipacaoPercentualPIB()[i]);
			break;

		case R.id.radio_populacao:
			if (checked)
				 
			setIndicativo("populacao");
			setTitulo("Populaï¿½ï¿½o");
			historico.clear();
			historico.add((float) estado.getPopulacao());
			break;

		case R.id.radio_primeiros_projetos_investimento:
			if (checked)
				 
			setIndicativo("valor_primeiros_projetos");
			setTitulo("Programa Primeiros Projetos (R$)");
			historico.clear();
			for (int i = 0; i < estado.getPrimeirosProjetos().length - 1; i++)
				historico.add((float) estado.getPrimeirosProjetos()[i]
						.getValor());
			break;

		case R.id.radio_primeiros_projetos_qtd:
			if (checked)
				 
			setIndicativo("quantidade_primeiros_projetos");
			setTitulo("Programa Primeiros Projetos (Qtd.)");
			historico.clear();
			for (int i = 0; i < estado.getPrimeirosProjetos().length - 1; i++)
				historico.add((float) estado.getPrimeirosProjetos()[i]
						.getQuantidade());
			break;

		case R.id.radio_projetos_inct_investimento:
			if (checked)
				 
			setIndicativo("valor_projetos_inct");
			setTitulo("Projetos INCT (R$)");
			historico.clear();
			Log.i("estado.getProjetosInct().lenght", estado.getProjetosInct().length+"");
			Log.i("estado", estado.getNome());
			for (int i = 0; i < estado.getProjetosInct().length - 1; i++)
				historico.add((float) estado.getProjetosInct()[i].getValor());
			break;

		case R.id.radio_projetos_inct_qtd:
			if (checked)
				 
			setIndicativo("quantidade_projetos_inct");
			setTitulo("Projetos INCT (Qtd.)");
			historico.clear();
			for (int i = 0; i < estado.getProjetosInct().length - 1; i++)
				historico.add((float) estado.getProjetosInct()[i]
						.getQuantidade());
			break;

		case R.id.radio_alunos_por_turma_fundamental:
			if (checked)
				 
			setIndicativo("alunos_por_turma_ensino_medio");
			setTitulo("Média de Alunos por Turma do Ensino Fundamental(Qtd.)");
			historico.clear();
			for (int i = 0; i < estado.getMediaAlunosPorTurma().length - 1; i++)
				historico.add((float) estado.getMediaAlunosPorTurma()[i]
						.getEnsinoFundamental());
			break;

		case R.id.radio_alunos_por_turma_medio:
			if (checked)
				 
			setIndicativo("alunos_por_turma_ensino_medio");
			setTitulo("Média de Alunos por Turma do Ensino Médio(Qtd.)");
			historico.clear();
			for (int i = 0; i < estado.getMediaAlunosPorTurma().length - 1; i++)
				historico.add((float) estado.getMediaAlunosPorTurma()[i]
						.getEnsinoMedio());
			break;

		case R.id.radio_horas_aula_fundamental:
			if (checked)
				 
			setIndicativo("horas_aula_ensino_medio");
			setTitulo("Horas médias por aula do Ensino Fundamental");
			historico.clear();
			for (int i = 0; i < estado.getMediaHorasAula().length - 1; i++)
				historico.add((float) estado.getMediaHorasAula()[i]
						.getEnsinoFundamental());
			break;

		case R.id.radio_horas_aula_medio:
			if (checked)
				 
			setIndicativo("horas_aula_ensino_medio");
			setTitulo("Horas médias por aula do Ensino Médio");
			historico.clear();
			for (int i = 0; i < estado.getMediaHorasAula().length - 1; i++)
				historico.add((float) estado.getMediaHorasAula()[i]
						.getEnsinoMedio());
			break;

		case R.id.radio_taxa_distorcao_fundamental:
			if (checked)
				 
			setIndicativo("taxa_distorcao");
			setTitulo("Taxa de Distorção por Idade do Ensino Fundamental (%)");
			historico.clear();
			for (int i = 0; i < estado.getTaxaDistorcaoIdadeSerie().length - 1; i++)
				historico.add((float) estado.getTaxaDistorcaoIdadeSerie()[i]
						.getEnsinoFundamental());
			break;

		case R.id.radio_taxa_distorcao_medio:
			if (checked)
				 
			setIndicativo("taxa_distorcao");
			setTitulo("Taxa de Distorção por Idade do Ensino Médio (%)");
			historico.clear();
			for (int i = 0; i < estado.getTaxaDistorcaoIdadeSerie().length - 1; i++)
				historico.add((float) estado.getTaxaDistorcaoIdadeSerie()[i]
						.getEnsinoMedio());
			break;

		case R.id.radio_taxa_aprovacao_fundamental:
			if (checked)
				 
			setIndicativo("taxa_aprovacao");
			setTitulo("Taxa de Aprovação do Ensino Fundamental (%)");
			historico.clear();
			for (int i = 0; i < estado.getTaxaDeAproveitamento().length - 1; i++)
				historico.add((float) estado.getTaxaDeAproveitamento()[i]
						.getEnsinoFundamental());
			break;

		case R.id.radio_taxa_aprovacao_medio:
			if (checked)
				 
			setIndicativo("taxa_aprovacao");
			setTitulo("Taxa de Aprovação do Ensino Médio (%)");
			historico.clear();
			for (int i = 0; i < estado.getTaxaDeAproveitamento().length - 1; i++)
				historico.add((float) estado.getTaxaDeAproveitamento()[i]
						.getEnsinoMedio());
			break;

		case R.id.radio_taxa_abandono_fundamental:
			if (checked)
				 
			setIndicativo("taxa_abandono");
			setTitulo("Taxa de Abandono do Ensino Fundamental (%)");
			historico.clear();
			for (int i = 0; i < estado.getTaxaDeAbandono().length - 1; i++)
				historico.add((float) estado.getTaxaDeAbandono()[i]
						.getEnsinoFundamental());
			break;

		case R.id.radio_taxa_abandono_medio:
			if (checked)
				 
			setIndicativo("taxa_abandono");
			setTitulo("Taxa de Abandono do Ensino Médio (%)");
			historico.clear();
			for (int i = 0; i < estado.getTaxaDeAbandono().length - 1; i++)
				historico.add((float) estado.getTaxaDeAbandono()[i]
						.getEnsinoMedio());
			break;

		case R.id.radio_censo_iniciais_fundamental:
			if (checked)
				 
			setIndicativo("censo");
			setTitulo("Censo Escolar dos Anos Iniciais do Ensino Fundamental (%)");
			historico.clear();
			for (int i = 0; i < estado.getCensos().length - 1; i++)
				historico.add((float) estado.getCensos()[i]
						.getAnosIniciaisFundamental());
			break;

		case R.id.radio_censo_finais_fundamental:
			if (checked)
				 
			setIndicativo("censo");
			setTitulo("Censo Escolar dos Anos Finais do Ensino Fundamental (%)");
			historico.clear();
			for (int i = 0; i < estado.getCensos().length - 1; i++)
				historico.add((float) estado.getCensos()[i]
						.getAnosFinaisFundamental());
			break;

		case R.id.radio_censo_ensino_medio:
			if (checked)
				 
			setIndicativo("censo");
			setTitulo("Censo Escolar do Ensino Médio (%)");
			historico.clear();
			for (int i = 0; i < estado.getCensos().length - 1; i++)
				historico.add((float) estado.getCensos()[i].getEnsinoMedio());
			break;

		case R.id.radio_censo_eja_fundamental:
			if (checked)
				 
			setIndicativo("censo");
			setTitulo("Censo Escolar do EJA - Fundamental (%)");
			historico.clear();
			for (int i = 0; i < estado.getCensos().length - 1; i++)
				historico
						.add((float) estado.getCensos()[i].getFundamentalEJA());
			break;

		case R.id.radio_censo_eja_medio:
			if (checked)
				 
			setIndicativo("censo");
			setTitulo("Censo Escolar do EJA - Médio (%)");
			historico.clear();
			for (int i = 0; i < estado.getCensos().length - 1; i++)
				historico.add((float) estado.getCensos()[i].getMedioEJA());
			break;

		}
	}


	private Estado capturaInformacoesEstado() {
		Estado estado1 = null;
		
		int posicao = getPosicaoHistorico();
		
		Log.i("posicao", getPosicaoHistorico()+"");
		try {
			estado1 = (Estado) EstadoControle.getInstancia(this).obterEstado(
					posicao);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return estado1;
	}


	public void clickBotaoGrafico(View view) {
		Intent intent = new Intent(this, TelaGraficoLinha.class);
		ArrayList<String> temp = new ArrayList<String>();
		
		for(int i=0; i<historico.size(); i++)
			temp.add(historico.get(i)+"");
			
		intent.putExtra("HISTORICO", temp);
		intent.putExtra("TITULO", getTitulo());
		startActivity(intent);
	}
	
}
