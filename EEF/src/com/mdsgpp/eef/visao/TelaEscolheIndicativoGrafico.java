package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;

public class TelaEscolheIndicativoGrafico extends Activity {
	private String indicativo = "populacao";
	private String titulo = "Popula��o";

	private int posicao1, posicao2;
	
	private boolean bCenso, bAlunosTurma, bHorasAula, bTaxaDistorcao,
			bTaxaAbandono, bAprovacao, bIdeb, bPib, bPopulacao,
			bPrimeirosProjetos, bProjetosCnpq, bProjetosDifusao,
			bProjetosIniciacao, bProjetosJovens;

	private RadioButton rbIdebIniciais, rbIdebFinais, rbIdebMedio, rbPib, rbPopulacao, 
			rbPrimeirosProjetosQuantidade, rbPrimeirosProjetosValores,
			rbProjetosCnpqQuantidade, rbProjetosCnpqValores, rbProjetosDifusaoQuantidade, 
			rbProjetosDifusaoValores, rbProjetosIniciacaoQuantidade, rbProjetosIniciacaoValores, 
			rbProjetosJovensQuantidade, rbProjetosJovensValores;
	
	
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
		getMenuInflater().inflate(R.menu.tela_escolhe_indicativo_grafico, menu);
		return true;
	}

	public void capturaInformacoes() {
		Intent intentRecebida = getIntent();
		
		posicao1 = intentRecebida.getIntExtra("INDEX_ESTADO1_ESCOLHIDO", 0);
		posicao2 = intentRecebida.getIntExtra("INDEX_ESTADO2_ESCOLHIDO", 0);

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
	}
	
	public void onRadioButtonClicked(View view) {

		boolean checked = ((RadioButton) view).isChecked();
		
		switch (view.getId()) {
		case R.id.radio_apoio_cnpq_investimento:
			if (checked)
				indicativo = "valor_projetos_cnpq";
			titulo = "Projetos de Pesquisa Apoio CNPq (R$)";
			break;
		case R.id.radio_apoio_cnpq_qtd:
			if (checked)
				indicativo = "quantidade_projeto_cnpq";
			titulo = "Projetos de Pesquisa Apoio CNPq (Qtd.)";
			break;
		case R.id.radio_difusao_tecnologica_investimento:
			if (checked)
				indicativo = "valor_ciencia_tecnologia";
			titulo = "Projeto de Difus�o Tecnol�gica (R$)";
			break;
		case R.id.radio_difusao_tecnologica_qtd:
			if (checked)
				indicativo = "projetos_ciencia_tecnologia";
			titulo = "Projeto de Difus�o Tecnol�gica (Qtd.)";
			break;
		case R.id.radio_ideb_fundamental_finais:
			if (checked)
				indicativo = "ideb_fundamental_final";
			titulo = "IDEB do Ensino Fundamental (S�ries Finais)";
			break;
		case R.id.radio_ideb_fundamental_iniciai:
			if (checked)
				indicativo = "ideb_fundamental_inicial";
			titulo = "IDEB do Ensino Fundamental (S�ries Iniciais)";
			break;
		case R.id.radio_ideb_medio:
			if (checked)
				indicativo = "ideb_ensino_medio";
			titulo = "IDEB do Ensino M�dio";
			break;
		case R.id.radio_jovens_pesquisadores_investimento:
			if (checked)
				indicativo = "valor_projetos_jovens_pesquisadores";
			titulo = "Jovens pesquisadores (R$)";
			break;

		case R.id.radio_jovens_pesquisadores_qtd:
			if (checked)
				indicativo = "quantidade_projeto_jovens_pesquisadores";
			titulo = "Jovens pesquisadores (Qtd.)";
			break;

		case R.id.radio_pib:
			if (checked)
				indicativo = "percentual_participacao_pib";
			titulo = "Participa��o Estadual no PIB (%)";
			break;

		case R.id.radio_populacao:
			if (checked)
				indicativo = "populacao";
			titulo = "Popula��o";
			break;

		case R.id.radio_primeiros_projetos_investimento:
			if (checked)
				indicativo = "valor_primeiros_projetos";
			titulo = "Programa Primeiros Projetos (R$)";
			break;

		case R.id.radio_primeiros_projetos_qtd:
			if (checked)
				indicativo = "quantidade_primeiros_projetos";
			titulo = "Programa Primeiros Projetos (Qtd.)";
			break;

		case R.id.radio_projetos_inct_investimento:
			if (checked)
				indicativo = "valor_projetos_inct";
			titulo = "Projetos INCT (R$)";
			break;

		case R.id.radio_projetos_inct_qtd:
			if (checked)
				indicativo = "quantidade_projetos_inct";
			titulo = "Projetos INCT (Qtd.)";
			break;
		}
	}

	public void clickBotaoGrafico(View view) {
		Intent intent = new Intent(this, TelaGrafico.class);
		
		intent.putExtra("INDEX_ESTADO1_ESCOLHIDO", posicao1);
		intent.putExtra("INDEX_ESTADO2_ESCOLHIDO", posicao2);
		intent.putExtra("INDICATIVO", indicativo);
		intent.putExtra("TITULO", titulo);

		startActivity(intent);		
	}

	public void clickBotaoSobreIndicativos(View view) {
		Intent intent = new Intent(this, TelaSobreIndicativos.class);
		startActivity(intent);
	}

}
