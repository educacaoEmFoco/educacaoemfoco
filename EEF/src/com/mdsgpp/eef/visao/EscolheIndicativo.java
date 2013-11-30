package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

public abstract class EscolheIndicativo extends Activity{

	private String indicativo = "populacao";
	private String titulo = "Popula��o";

	private int posicao1, posicao2, posicaoHistorico;
	
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
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_escolhe_indicativo_grafico);
		
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
		Intent intentRecebida = getIntent();
		
		posicao1 = intentRecebida.getIntExtra("INDEX_ESTADO1_ESCOLHIDO", 0);
		posicao2 = intentRecebida.getIntExtra("INDEX_ESTADO2_ESCOLHIDO", 0);
		posicaoHistorico = intentRecebida.getIntExtra("ESTADO", 0);

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
	
	public abstract void onRadioButtonClicked(View view);

	public abstract void clickBotaoGrafico(View view);

	public void clickBotaoSobreIndicativos(View view) {
		Intent intent = new Intent(this, TelaEscolheIndicativoGraficoComparacao.class);
		startActivity(intent);
	}

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

	public int getPosicao1() {
		return posicao1;
	}

	public void setPosicao1(int posicao1) {
		this.posicao1 = posicao1;
	}

	public int getPosicao2() {
		return posicao2;
	}

	public void setPosicao2(int posicao2) {
		this.posicao2 = posicao2;
	}

	public int getPosicaoHistorico() {
		return posicaoHistorico;
	}

	public void setPosicaoHistorico(int posicaoHistorico) {
		this.posicaoHistorico = posicaoHistorico;
	}

	
}
