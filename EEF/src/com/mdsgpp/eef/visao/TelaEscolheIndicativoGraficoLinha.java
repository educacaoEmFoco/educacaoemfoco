package com.mdsgpp.eef.visao;

import java.io.IOException;
import java.util.ArrayList;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.controle.EstadoControle;
import com.mdsgpp.eef.modelo.Estado;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

public class TelaEscolheIndicativoGraficoLinha extends Activity{


	private Estado estado;
	private ArrayList<Float> historico = new ArrayList<Float>();


	private String indicativo = "populacao";
	private String titulo = "Populaï¿½ï¿½o";

	private int posicaoHistorico;
	
	private boolean bCenso, bAlunosTurma, bHorasAula, bTaxaDistorcao,
			bTaxaAbandono, bAprovacao, bIdeb, bPib, bPopulacao,
			bPrimeirosProjetos, bProjetosCnpq, bProjetosDifusao,
			bProjetosIniciacao, bProjetosJovens;

	private RadioButton rbIdebIniciais, rbIdebFinais, rbIdebMedio, rbPib, rbPopulacao, 
			rbPrimeirosProjetosQuantidade, rbPrimeirosProjetosValores,
			rbProjetosCnpqQuantidade, rbProjetosCnpqValores, rbProjetosDifusaoQuantidade, 
			rbProjetosDifusaoValores, rbProjetosIniciacaoQuantidade, rbProjetosIniciacaoValores, 
			rbProjetosJovensQuantidade, rbProjetosJovensValores, rbAlunosTurmaFundamental, rbAlunosTurmaMedio,
			rbHorasAulaFundamental, rbHorasAulaMedio, rbTaxaDeDistorcaoFundamental, rbTaxaDeDistorcaoMedio,
			rbTaxaDeAprocaoFundamental, rbTaxaDeAprovacaoMedio, rbTaxaDeAbandonoFundamental, rbTaxaDeAbandonoMedio,
			rbCensoAnosIniciaisFundamental, rbCensoAnosFinaisFundamental, rbCensoEsninoMedio, rbCensoEJAFundamental, rbCensoEJAMedio;
	private Intent intentRecebida;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_escolhe_indicativo_grafico);
		intentRecebida = getIntent();
		posicaoHistorico = intentRecebida.getIntExtra("ESTADO", 0);

		estado = capturaInformacoesEstado();
		Log.i("posicao tela escolhe indicativo grafico", posicaoHistorico+"");
		
		inicializaRadioButtons();
		capturaInformacoes();
		escondeRadioButtons();
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
	
	public void abreTelaSobre() {
		Intent intent = new Intent(this, TelaEscolheIndicativoGraficoComparacao.class);
		startActivity(intent);
	}

	public void capturaInformacoes() {

		bIdeb = intentRecebida.getBooleanExtra("CB_IDEB", false);
		bPib = intentRecebida.getBooleanExtra("CB_PIB", false);
		bPopulacao = intentRecebida.getBooleanExtra("CB_POPULACAO", false);
		bPrimeirosProjetos = intentRecebida.getBooleanExtra("CB_PRIMEIROS_PROJETOS", false);
		bProjetosCnpq = intentRecebida.getBooleanExtra("CB_PROJETOS_CNPQ", false);
		bProjetosDifusao = intentRecebida.getBooleanExtra("CB_PROJETOS_DIFUSAO", false);
		bProjetosIniciacao = intentRecebida.getBooleanExtra("CB_PROJETOS_INICIACAO", false);
		bProjetosJovens = intentRecebida.getBooleanExtra("CB_PROJETOS_JOVENS", false);
		bCenso = intentRecebida.getBooleanExtra("CB_CENSO", false);
		bAlunosTurma = intentRecebida.getBooleanExtra("CB_ALUNOS_TURMA", false);
		bHorasAula = intentRecebida.getBooleanExtra("CB_HORAS_AULA", false);
		bTaxaDistorcao = intentRecebida.getBooleanExtra("CB_TAXA_DISTORCAO", false);
		bTaxaAbandono = intentRecebida.getBooleanExtra("CB_TAXA_ABANDONO", false);
		bAprovacao = intentRecebida.getBooleanExtra("CB_APROVACAO", false);
		
	}
	
	public void inicializaRadioButtons() {
		rbIdebIniciais = (RadioButton) findViewById(R.id.radio_ideb_fundamental_iniciai);
		rbIdebFinais = (RadioButton) findViewById(R.id.radio_ideb_fundamental_finais);
		rbIdebMedio = (RadioButton) findViewById(R.id.radio_ideb_medio);
		
		rbPib = (RadioButton) findViewById(R.id.radio_pib);
		
		rbPopulacao = (RadioButton) findViewById(R.id.radio_populacao);
		
		rbPrimeirosProjetosQuantidade = (RadioButton) findViewById(R.id.radio_primeiros_projetos_qtd);
		rbPrimeirosProjetosValores = (RadioButton) findViewById(R.id.radio_primeiros_projetos_investimento);
		
		rbProjetosCnpqQuantidade = (RadioButton) findViewById(R.id.radio_apoio_cnpq_qtd);
		rbProjetosCnpqValores = (RadioButton) findViewById(R.id.radio_apoio_cnpq_investimento);
		
		rbProjetosDifusaoQuantidade = (RadioButton) findViewById(R.id.radio_difusao_tecnologica_qtd);
		rbProjetosDifusaoValores = (RadioButton) findViewById(R.id.radio_difusao_tecnologica_investimento);
		
		rbProjetosIniciacaoQuantidade = (RadioButton) findViewById(R.id.radio_projetos_inct_qtd);
		rbProjetosIniciacaoValores = (RadioButton) findViewById(R.id.radio_projetos_inct_investimento);
		
		rbProjetosJovensQuantidade = (RadioButton) findViewById(R.id.radio_jovens_pesquisadores_qtd);
		rbProjetosJovensValores = (RadioButton) findViewById(R.id.radio_jovens_pesquisadores_investimento);

		rbAlunosTurmaFundamental = (RadioButton) findViewById(R.id.radio_alunos_por_turma_fundamental);
		rbAlunosTurmaMedio = (RadioButton) findViewById(R.id.radio_alunos_por_turma_medio);
		
		rbHorasAulaFundamental = (RadioButton) findViewById(R.id.radio_horas_aula_fundamental);
		rbHorasAulaMedio = (RadioButton) findViewById(R.id.radio_horas_aula_medio);

		rbTaxaDeDistorcaoFundamental = (RadioButton) findViewById(R.id.radio_taxa_distorcao_fundamental);
		rbTaxaDeDistorcaoMedio = (RadioButton) findViewById(R.id.radio_taxa_distorcao_medio);
		
		rbTaxaDeAprocaoFundamental = (RadioButton) findViewById(R.id.radio_taxa_aprovacao_fundamental);
		rbTaxaDeAprovacaoMedio = (RadioButton) findViewById(R.id.radio_taxa_aprovacao_medio);
		
		rbTaxaDeAbandonoFundamental = (RadioButton) findViewById(R.id.radio_taxa_abandono_fundamental);
		rbTaxaDeAbandonoMedio = (RadioButton) findViewById(R.id.radio_taxa_abandono_medio);
		
		rbCensoAnosIniciaisFundamental= (RadioButton) findViewById(R.id.radio_censo_iniciais_fundamental);
		rbCensoAnosFinaisFundamental= (RadioButton) findViewById(R.id.radio_censo_finais_fundamental);
		rbCensoEsninoMedio= (RadioButton) findViewById(R.id.radio_censo_ensino_medio);
		rbCensoEJAFundamental= (RadioButton) findViewById(R.id.radio_censo_eja_fundamental);
		rbCensoEJAMedio= (RadioButton) findViewById(R.id.radio_censo_eja_medio);
		
	}
	
	public void setVisibility(RadioButton radioButton, boolean visibilidade) {
		int valorVisibilidade = (visibilidade) ? View.VISIBLE : View.GONE;
		radioButton.setVisibility(valorVisibilidade);
	}
	
	public void escondeRadioButtons() {
		setVisibility(rbIdebIniciais, bIdeb);
		setVisibility(rbIdebFinais, bIdeb);
		setVisibility(rbIdebMedio, bIdeb);
		setVisibility(rbPib, bPib);
		setVisibility(rbPopulacao, bPopulacao);
		setVisibility(rbPrimeirosProjetosQuantidade, bPrimeirosProjetos);
		setVisibility(rbPrimeirosProjetosValores, bPrimeirosProjetos);
		setVisibility(rbProjetosCnpqQuantidade, bProjetosCnpq);
		setVisibility(rbProjetosCnpqValores, bProjetosCnpq);
		setVisibility(rbProjetosDifusaoQuantidade, bProjetosDifusao);
		setVisibility(rbProjetosDifusaoValores, bProjetosDifusao);
		setVisibility(rbProjetosIniciacaoQuantidade, bProjetosIniciacao);
		setVisibility(rbProjetosIniciacaoValores, bProjetosIniciacao);
		setVisibility(rbProjetosJovensQuantidade, bProjetosJovens);
		setVisibility(rbProjetosJovensValores, bProjetosJovens);
		setVisibility(rbAlunosTurmaFundamental, bAlunosTurma);
		setVisibility(rbAlunosTurmaMedio, bAlunosTurma);
		setVisibility(rbHorasAulaFundamental, bHorasAula);
		setVisibility(rbHorasAulaMedio, bHorasAula);
		setVisibility(rbTaxaDeDistorcaoFundamental, bTaxaDistorcao);
		setVisibility(rbTaxaDeDistorcaoMedio, bTaxaDistorcao);
		setVisibility(rbTaxaDeAprocaoFundamental, bAprovacao);
		setVisibility(rbTaxaDeAprovacaoMedio, bAprovacao);
		setVisibility(rbTaxaDeAbandonoFundamental, bTaxaAbandono);
		setVisibility(rbTaxaDeAbandonoMedio, bTaxaAbandono);
		setVisibility(rbCensoAnosIniciaisFundamental, bCenso);
		setVisibility(rbCensoAnosFinaisFundamental, bCenso);
		setVisibility(rbCensoEsninoMedio, bCenso);
		setVisibility(rbCensoEJAFundamental, bCenso);
		setVisibility(rbCensoEJAMedio, bCenso);
	}

	public void onRadioButtonClicked(View view) {

		boolean checked = ((RadioButton) view).isChecked();

		switch (view.getId()) {
		case R.id.radio_apoio_cnpq_investimento:
			if (checked)
			indicativo = "valor_projetos_cnpq";
			titulo = "Projetos de Pesquisa Apoio CNPq (R$)";
			historico.clear();
			for (int i = 0; i < estado.getProjetosApoioCnpq().length - 1; i++)
				historico.add((float) estado.getProjetosApoioCnpq()[i]
						.getValor());
			break;
		case R.id.radio_apoio_cnpq_qtd:
			if (checked)
			indicativo = "quantidade_projeto_cnpq";
			titulo = "rojetos de Pesquisa Apoio CNPq (Qtd.)";
			historico.clear();
			for (int i = 0; i < estado.getProjetosApoioCnpq().length - 1; i++)
				historico.add((float) estado.getProjetosApoioCnpq()[i]
						.getQuantidade());
			break;
		case R.id.radio_difusao_tecnologica_investimento:
			if (checked)
				 
			indicativo = "valor_ciencia_tecnologia";
			titulo = "Projeto de Difusï¿½o Tecnolï¿½gica (R$)";
			historico.clear();
			for (int i = 0; i < estado.getProjetosCienciaTecnologia().length - 1; i++)
				historico.add((float) estado.getProjetosCienciaTecnologia()[i]
						.getValor());

			break;
		case R.id.radio_difusao_tecnologica_qtd:
			if (checked)
				 
			indicativo = "projetos_ciencia_tecnologia";
			titulo = "Projeto de Difusï¿½o Tecnolï¿½gica (Qtd.)";
			historico.clear();
			for (int i = 0; i < estado.getProjetosCienciaTecnologia().length - 1; i++)
				historico.add((float) estado.getProjetosCienciaTecnologia()[i]
						.getQuantidade());
			break;
		case R.id.radio_ideb_fundamental_finais:
			if (checked)
				 
			indicativo = "ideb_fundamental_final";
			titulo = "IDEB do Ensino Fundamental (Sï¿½ries Finais)";
			historico.clear();
			for (int i = 0; i < estado.getIdebs().length - 1; i++)
				historico.add((float) estado.getIdebs()[i].getFundamental());
			break;
		case R.id.radio_ideb_fundamental_iniciai:
			if (checked)
				 
			indicativo = "ideb_fundamental_inicial";
			titulo = "IDEB do Ensino Fundamental (Sï¿½ries Iniciais)";
			historico.clear();
			for (int i = 0; i < estado.getIdebs().length - 1; i++)
				historico.add((float) estado.getIdebs()[i].getSeriesIniciais());
			break;
		case R.id.radio_ideb_medio:
			if (checked)
				 
			indicativo = "ideb_ensino_medio";
			titulo = "IDEB do Ensino Mï¿½dio";
			historico.clear();
			for (int i = 0; i < estado.getIdebs().length - 1; i++)
				historico.add((float) estado.getIdebs()[i].getMedio());
			break;
		case R.id.radio_jovens_pesquisadores_investimento:
			if (checked)
				 
			indicativo = "valor_projetos_jovens_pesquisadores";
			titulo = "Jovens pesquisadores (R$)";
			historico.clear();
			for (int i = 0; i < estado.getProjetoJovensPesquisadores().length - 1; i++)
				historico.add((float) estado.getProjetoJovensPesquisadores()[i]
						.getValor());
			break;

		case R.id.radio_jovens_pesquisadores_qtd:
			if (checked)
				 
			indicativo = "quantidade_projeto_jovens_pesquisadores";
			titulo = "Jovens pesquisadores (Qtd.)";
			historico.clear();
			for (int i = 0; i < estado.getProjetoJovensPesquisadores().length - 1; i++)
				historico.add((float) estado.getProjetoJovensPesquisadores()[i]
						.getQuantidade());
			break;

		case R.id.radio_pib:
			if (checked)
				 
			indicativo = "percentual_participacao_pib";
			titulo = "Participaï¿½ï¿½o Estadual no PIB (%)";
			historico.clear();
			for (int i = 0; i < estado.getParticipacaoPercentualPIB().length - 1; i++)
				historico.add((float) estado.getParticipacaoPercentualPIB()[i]);
			break;

		case R.id.radio_populacao:
			if (checked)
				 
			indicativo = "populacao";
			titulo = "Populaï¿½ï¿½o";
			historico.clear();
			historico.add((float) estado.getPopulacao());
			break;

		case R.id.radio_primeiros_projetos_investimento:
			if (checked)
				 
			indicativo = "valor_primeiros_projetos";
			titulo = "Programa Primeiros Projetos (R$)";
			historico.clear();
			for (int i = 0; i < estado.getPrimeirosProjetos().length - 1; i++)
				historico.add((float) estado.getPrimeirosProjetos()[i]
						.getValor());
			break;

		case R.id.radio_primeiros_projetos_qtd:
			if (checked)
				 
			indicativo = "quantidade_primeiros_projetos";
			titulo = "Programa Primeiros Projetos (Qtd.)";
			historico.clear();
			for (int i = 0; i < estado.getPrimeirosProjetos().length - 1; i++)
				historico.add((float) estado.getPrimeirosProjetos()[i]
						.getQuantidade());
			break;

		case R.id.radio_projetos_inct_investimento:
			if (checked)
				 
			indicativo = "valor_projetos_inct";
			titulo = "Projetos INCT (R$)";
			historico.clear();
			Log.i("estado.getProjetosInct().lenght", estado.getProjetosInct().length+"");
			Log.i("estado", estado.getNome());
			for (int i = 0; i < estado.getProjetosInct().length - 1; i++)
				historico.add((float) estado.getProjetosInct()[i].getValor());
			break;

		case R.id.radio_projetos_inct_qtd:
			if (checked)
				 
			indicativo = "quantidade_projetos_inct";
			titulo = "Projetos INCT (Qtd.)";
			historico.clear();
			for (int i = 0; i < estado.getProjetosInct().length - 1; i++)
				historico.add((float) estado.getProjetosInct()[i]
						.getQuantidade());
			break;

		case R.id.radio_alunos_por_turma_fundamental:
			if (checked)
				 
			indicativo = "alunos_por_turma_ensino_medio";
			titulo = "Média de Alunos por Turma do Ensino Fundamental(Qtd.)";
			historico.clear();
			for (int i = 0; i < estado.getMediaAlunosPorTurma().length - 1; i++)
				historico.add((float) estado.getMediaAlunosPorTurma()[i]
						.getEnsinoFundamental());
			break;

		case R.id.radio_alunos_por_turma_medio:
			if (checked)
				 
			indicativo = "alunos_por_turma_ensino_medio";
			titulo = "Média de Alunos por Turma do Ensino Médio(Qtd.)";
			historico.clear();
			for (int i = 0; i < estado.getMediaAlunosPorTurma().length - 1; i++)
				historico.add((float) estado.getMediaAlunosPorTurma()[i]
						.getEnsinoMedio());
			break;

		case R.id.radio_horas_aula_fundamental:
			if (checked)
				 
			indicativo = "horas_aula_ensino_medio";
			titulo = "Horas médias por aula do Ensino Fundamental";
			historico.clear();
			for (int i = 0; i < estado.getMediaHorasAula().length - 1; i++)
				historico.add((float) estado.getMediaHorasAula()[i]
						.getEnsinoFundamental());
			break;

		case R.id.radio_horas_aula_medio:
			if (checked)
				 
			indicativo = "horas_aula_ensino_medio";
			titulo = "Horas médias por aula do Ensino Médio";
			historico.clear();
			for (int i = 0; i < estado.getMediaHorasAula().length - 1; i++)
				historico.add((float) estado.getMediaHorasAula()[i]
						.getEnsinoMedio());
			break;

		case R.id.radio_taxa_distorcao_fundamental:
			if (checked)
				 
			indicativo = "taxa_distorcao";
			titulo = "Taxa de Distorção por Idade do Ensino Fundamental (%)";
			historico.clear();
			for (int i = 0; i < estado.getTaxaDistorcaoIdadeSerie().length - 1; i++)
				historico.add((float) estado.getTaxaDistorcaoIdadeSerie()[i]
						.getEnsinoFundamental());
			break;

		case R.id.radio_taxa_distorcao_medio:
			if (checked)
				 
			indicativo = "taxa_distorcao";
			titulo = "Taxa de Distorção por Idade do Ensino Médio (%)";
			historico.clear();
			for (int i = 0; i < estado.getTaxaDistorcaoIdadeSerie().length - 1; i++)
				historico.add((float) estado.getTaxaDistorcaoIdadeSerie()[i]
						.getEnsinoMedio());
			break;

		case R.id.radio_taxa_aprovacao_fundamental:
			if (checked)
				 
			indicativo = "taxa_aprovacao";
			titulo = "Taxa de Aprovação do Ensino Fundamental (%)";
			historico.clear();
			for (int i = 0; i < estado.getTaxaDeAproveitamento().length - 1; i++)
				historico.add((float) estado.getTaxaDeAproveitamento()[i]
						.getEnsinoFundamental());
			break;

		case R.id.radio_taxa_aprovacao_medio:
			if (checked)
				 
			indicativo = "taxa_aprovacao";
			titulo = "Taxa de Aprovação do Ensino Médio (%)";
			historico.clear();
			for (int i = 0; i < estado.getTaxaDeAproveitamento().length - 1; i++)
				historico.add((float) estado.getTaxaDeAproveitamento()[i]
						.getEnsinoMedio());
			break;

		case R.id.radio_taxa_abandono_fundamental:
			if (checked)
				 
			indicativo = "taxa_abandono";
			titulo = "Taxa de Abandono do Ensino Fundamental (%)";
			historico.clear();
			for (int i = 0; i < estado.getTaxaDeAbandono().length - 1; i++)
				historico.add((float) estado.getTaxaDeAbandono()[i]
						.getEnsinoFundamental());
			break;

		case R.id.radio_taxa_abandono_medio:
			if (checked)
				 
			indicativo = "taxa_abandono";
			titulo = "Taxa de Abandono do Ensino Médio (%)";
			historico.clear();
			for (int i = 0; i < estado.getTaxaDeAbandono().length - 1; i++)
				historico.add((float) estado.getTaxaDeAbandono()[i]
						.getEnsinoMedio());
			break;

		case R.id.radio_censo_iniciais_fundamental:
			if (checked)
				 
			indicativo = "censo";
			titulo = "Censo Escolar dos Anos Iniciais do Ensino Fundamental (%)";
			historico.clear();
			for (int i = 0; i < estado.getCensos().length - 1; i++)
				historico.add((float) estado.getCensos()[i]
						.getAnosIniciaisFundamental());
			break;

		case R.id.radio_censo_finais_fundamental:
			if (checked)
				 
			indicativo = "censo";
			titulo = "Censo Escolar dos Anos Finais do Ensino Fundamental (%)";
			historico.clear();
			for (int i = 0; i < estado.getCensos().length - 1; i++)
				historico.add((float) estado.getCensos()[i]
						.getAnosFinaisFundamental());
			break;

		case R.id.radio_censo_ensino_medio:
			if (checked)
				 
			indicativo = "censo";
			titulo = "Censo Escolar do Ensino Médio (%)";
			historico.clear();
			for (int i = 0; i < estado.getCensos().length - 1; i++)
				historico.add((float) estado.getCensos()[i].getEnsinoMedio());
			break;

		case R.id.radio_censo_eja_fundamental:
			if (checked)
				 
			indicativo = "censo";
			titulo = "Censo Escolar do EJA - Fundamental (%)";
			historico.clear();
			for (int i = 0; i < estado.getCensos().length - 1; i++)
				historico
						.add((float) estado.getCensos()[i].getFundamentalEJA());
			break;

		case R.id.radio_censo_eja_medio:
			if (checked)
				 
			indicativo = "censo";
			titulo = "Censo Escolar do EJA - Médio (%)";
			historico.clear();
			for (int i = 0; i < estado.getCensos().length - 1; i++)
				historico.add((float) estado.getCensos()[i].getMedioEJA());
			break;

		}
	}


	private Estado capturaInformacoesEstado() {
		Estado estado1 = null;
		
		int posicao = posicaoHistorico;
		
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
		intent.putExtra("TITULO", titulo);
		startActivity(intent);
	}
	
	public void clickBotaoSobreIndicativos(View view) {
		Intent intent = new Intent(this, TelaEscolheIndicativoGraficoComparacao.class);
		startActivity(intent);
	}

	
}
