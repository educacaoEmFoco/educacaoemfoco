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
	
	private boolean censusRadioVisibility;
	private boolean ClassStudentsRadioVisibility;
	private boolean bHorasAula;
	private boolean bTaxaDistorcao;
	private boolean bTaxaAbandono;
	private boolean bAprovacao;
	private boolean bIdeb;
	private boolean bPib;
	private boolean bPopulacao;
	private boolean bPrimeirosProjetos;
	private boolean bProjetosCnpq;
	private boolean bProjetosDifusao;
	private boolean bProjetosIniciacao;
	private boolean bProjetosJovens;

	private RadioButton rbIdebIniciais;
	private RadioButton rbIdebFinais;
	private RadioButton rbIdebMedio;
	private RadioButton rbPib;
	private RadioButton rbPopulacao;
	private RadioButton rbPrimeirosProjetosQuantidade;
	private RadioButton rbPrimeirosProjetosValores;
	private RadioButton rbProjetosCnpqQuantidade;
	private RadioButton rbProjetosCnpqValores;
	private RadioButton rbProjetosDifusaoQuantidade; 
	private RadioButton rbProjetosDifusaoValores;
	private RadioButton rbProjetosIniciacaoQuantidade;
	private RadioButton rbProjetosIniciacaoValores; 
	private RadioButton rbProjetosJovensQuantidade;
	private RadioButton rbProjetosJovensValores;
	private RadioButton rClassStudentsRadioVisibilityFundamental;
	private RadioButton rClassStudentsRadioVisibilityMedio;
	private RadioButton rbHorasAulaFundamental;
	private RadioButton rbHorasAulaMedio;
	private RadioButton rbTaxaDeDistorcaoFundamental;
	private RadioButton rbTaxaDeDistorcaoMedio;
	private RadioButton rbTaxaDeAprocaoFundamental;
	private RadioButton rbTaxaDeAprovacaoMedio;
	private RadioButton rbTaxaDeAbandonoFundamental;
	private RadioButton rbTaxaDeAbandonoMedio;
	private RadioButton rcensusRadioVisibilityAnosIniciaisFundamental;
	private RadioButton rcensusRadioVisibilityAnosFinaisFundamental;
	private RadioButton rcensusRadioVisibilityEsninoMedio;
	private RadioButton rcensusRadioVisibilityEJAFundamental;
	private RadioButton rcensusRadioVisibilityEJAMedio;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_escolhe_indicativo_grafico);
		
		inicializaRadioButtons();
		capturaInformacoes();
		escondeRadioButtons();
	}
	
	// Get information about the compared states.
	public void capturaInformacoes() {
		Intent intentRecebida = getIntent();
		
		position1 = intentRecebida.getIntExtra("INDEX_ESTADO1_ESCOLHIDO", 0);
		position2 = intentRecebida.getIntExtra("INDEX_ESTADO2_ESCOLHIDO", 0);

		bIdeb = intentRecebida.getBooleanExtra("CB_IDEB", false);
		bPib = intentRecebida.getBooleanExtra("CB_PIB", false);
		bPopulacao = intentRecebida.getBooleanExtra("CB_POPULACAO", false);
		bPrimeirosProjetos = intentRecebida.getBooleanExtra
			("CB_PRIMEIROS_PROJETOS", false);
		bProjetosCnpq = intentRecebida.getBooleanExtra("CB_PROJETOS_CNPQ",
			false);
		bProjetosDifusao = intentRecebida.getBooleanExtra("CB_PROJETOS_DIFUSAO",
			false);
		bProjetosIniciacao = intentRecebida.getBooleanExtra
			("CB_PROJETOS_INICIACAO", false);
		bProjetosJovens = intentRecebida.getBooleanExtra("CB_PROJETOS_JOVENS",
			false);
		censusRadioVisibility = intentRecebida.getBooleanExtra("CB_CENSO", false);
		ClassStudentsRadioVisibility = intentRecebida.getBooleanExtra("CB_ALUNOS_TURMA", false);
		bHorasAula = intentRecebida.getBooleanExtra("CB_HORAS_AULA", false);
		bTaxaDistorcao = intentRecebida.getBooleanExtra("CB_TAXA_DISTORCAO",
			false);
		bTaxaAbandono = intentRecebida.getBooleanExtra("CB_TAXA_ABANDONO",
			false);
		bAprovacao = intentRecebida.getBooleanExtra("CB_APROVACAO", false);
		
	}
	
	// Inicialize all radio buttons on screen.
	public void inicializaRadioButtons() {
		rbIdebIniciais = (RadioButton) findViewById
			(R.id.radio_ideb_fundamental_iniciai);
		rbIdebFinais = (RadioButton) findViewById
			(R.id.radio_ideb_fundamental_finais);
		rbIdebMedio = (RadioButton) findViewById(R.id.radio_ideb_medio);
		rbPopulacao = (RadioButton) findViewById(R.id.radio_populacao);
		rbPrimeirosProjetosQuantidade = (RadioButton) findViewById
			(R.id.radio_primeiros_projetos_qtd);
		rbPrimeirosProjetosValores = (RadioButton) findViewById
			(R.id.radio_primeiros_projetos_investimento);
		rbProjetosCnpqQuantidade = (RadioButton) findViewById
			(R.id.radio_apoio_cnpq_qtd);
		rbProjetosCnpqValores = (RadioButton) findViewById
			(R.id.radio_apoio_cnpq_investimento);
		rbProjetosDifusaoQuantidade = (RadioButton) findViewById
			(R.id.radio_difusao_tecnologica_qtd);
		rbProjetosDifusaoValores = (RadioButton) findViewById
			(R.id.radio_difusao_tecnologica_investimento);
		rbProjetosIniciacaoQuantidade = (RadioButton) findViewById
			(R.id.radio_projetos_inct_qtd);
		rbProjetosIniciacaoValores = (RadioButton) findViewById
			(R.id.radio_projetos_inct_investimento);
		rbProjetosJovensQuantidade = (RadioButton) findViewById
			(R.id.radio_jovens_pesquisadores_qtd);
		rbProjetosJovensValores = (RadioButton) findViewById
			(R.id.radio_jovens_pesquisadores_investimento);
		rClassStudentsRadioVisibilityFundamental = (RadioButton) findViewById
			(R.id.radio_alunos_por_turma_fundamental);
		rClassStudentsRadioVisibilityMedio = (RadioButton) findViewById
			(R.id.radio_alunos_por_turma_medio);
		rbHorasAulaFundamental = (RadioButton) findViewById
			(R.id.radio_horas_aula_fundamental);
		rbHorasAulaMedio = (RadioButton) findViewById
			(R.id.radio_horas_aula_medio);
		rbTaxaDeDistorcaoFundamental = (RadioButton) findViewById
			(R.id.radio_taxa_distorcao_fundamental);
		rbTaxaDeDistorcaoMedio = (RadioButton) findViewById
			(R.id.radio_taxa_distorcao_medio);
		rbTaxaDeAprocaoFundamental = (RadioButton) findViewById
			(R.id.radio_taxa_aprovacao_fundamental);
		rbTaxaDeAprovacaoMedio = (RadioButton) findViewById
			(R.id.radio_taxa_aprovacao_medio);
		rbTaxaDeAbandonoFundamental = (RadioButton) findViewById
			(R.id.radio_taxa_abandono_fundamental);
		rbTaxaDeAbandonoMedio = (RadioButton) findViewById
			(R.id.radio_taxa_abandono_medio);
		rcensusRadioVisibilityAnosIniciaisFundamental = (RadioButton) findViewById
			(R.id.radio_censo_iniciais_fundamental);
		rcensusRadioVisibilityAnosFinaisFundamental = (RadioButton) findViewById
			(R.id.radio_censo_finais_fundamental);
		rcensusRadioVisibilityEsninoMedio = (RadioButton) findViewById
			(R.id.radio_censo_ensino_medio);
		rcensusRadioVisibilityEJAFundamental = (RadioButton) findViewById
			(R.id.radio_censo_eja_fundamental);
		rcensusRadioVisibilityEJAMedio = (RadioButton) findViewById
			(R.id.radio_censo_eja_medio);
		
	}
	
	// Allow the buttons to be viewed or not.
	public void setVisibility(RadioButton radioButton, boolean visibilidade) {
		int valorVisibilidade = (visibilidade) ? View.VISIBLE : View.GONE;
		radioButton.setVisibility(valorVisibilidade);
	}
	
	// Hide radio buttons when the information is not available.
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
		setVisibility(rClassStudentsRadioVisibilityFundamental, ClassStudentsRadioVisibility);
		setVisibility(rClassStudentsRadioVisibilityMedio, ClassStudentsRadioVisibility);
		setVisibility(rbHorasAulaFundamental, bHorasAula);
		setVisibility(rbHorasAulaMedio, bHorasAula);
		setVisibility(rbTaxaDeDistorcaoFundamental, bTaxaDistorcao);
		setVisibility(rbTaxaDeDistorcaoMedio, bTaxaDistorcao);
		setVisibility(rbTaxaDeAprocaoFundamental, bAprovacao);
		setVisibility(rbTaxaDeAprovacaoMedio, bAprovacao);
		setVisibility(rbTaxaDeAbandonoFundamental, bTaxaAbandono);
		setVisibility(rbTaxaDeAbandonoMedio, bTaxaAbandono);
		setVisibility(rcensusRadioVisibilityAnosIniciaisFundamental, censusRadioVisibility);
		setVisibility(rcensusRadioVisibilityAnosFinaisFundamental, censusRadioVisibility);
		setVisibility(rcensusRadioVisibilityEsninoMedio, censusRadioVisibility);
		setVisibility(rcensusRadioVisibilityEJAFundamental, censusRadioVisibility);
		setVisibility(rcensusRadioVisibilityEJAMedio, censusRadioVisibility);
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
