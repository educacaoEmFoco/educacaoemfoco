package com.mdsgpp.eef;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class TelaComparaEstados extends Activity {
	private TextView textViewSigla1;	
	private TextView textViewNome1;
	private TextView textViewPopulacao1;
	private TextView textViewParticipacaoPib1;
	private TextView textViewQuantidadeProjetosCienciaTecnologia1;
	private TextView textViewValorProjetosCienciaTecnologia1;
	private TextView textViewFundamentalIdeb1;
	private TextView textViewEnsinoMedioIdeb1;
	private TextView textViewIniciaisIdeb1;
	private	TextView textViewQuantidadePrimeirosProjetos1;
	private TextView textViewValorPrimeirosProjetos1;
	private TextView textViewQuantidadePesquisa1;
	private TextView textViewQuantidadeJovensPesquisadores1;
	private TextView textViewValoresPesquisa1;
	private TextView textViewValorJovensPesquisadores1;
	private TextView textViewQuantidadeProjetosIniciacao1;
	private TextView textViewValorProjetosIniciacao1;
	
	private TextView textViewSigla2;	
	private TextView textViewNome2;
	private TextView textViewPopulacao2;
	private TextView textViewParticipacaoPib2;
	private TextView textViewQuantidadeProjetosCienciaTecnologia2;
	private TextView textViewValorProjetosCienciaTecnologia2;
	private TextView textViewFundamentalIdeb2;
	private TextView textViewEnsinoMedioIdeb2;
	private TextView textViewIniciaisIdeb2;
	private	TextView textViewQuantidadePrimeirosProjetos2;
	private TextView textViewValorPrimeirosProjetos2;
	private TextView textViewQuantidadePesquisa2;
	private TextView textViewQuantidadeJovensPesquisadores2;
	private TextView textViewValoresPesquisa2;
	private TextView textViewValorJovensPesquisadores2;
	private TextView textViewQuantidadeProjetosIniciacao2;
	private TextView textViewValorProjetosIniciacao2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_compara_estados);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_compara_estados, menu);
		return true;
	}

	private void InicializaCamposTexto() {

		textViewSigla1 = (TextView) findViewById(R.id.textView_sigla1);
		textViewNome1 = (TextView) findViewById(R.id.textView_nome_estado1);
		textViewPopulacao1 = (TextView) findViewById(R.id.textView_populacao_valor1);
		textViewParticipacaoPib1 = (TextView) findViewById(R.id.textView_participacao_pib_valor1);
		textViewQuantidadeProjetosCienciaTecnologia1 = (TextView) findViewById(R.id.textView_numero_projetos_quantidade1);
		textViewValorProjetosCienciaTecnologia1 = (TextView) findViewById(R.id.textView_valor_investido_projetos1);
		textViewFundamentalIdeb1 = (TextView) findViewById(R.id.textView_ideb_fundamental1);
		textViewEnsinoMedioIdeb1 = (TextView) findViewById(R.id.textView_ideb_ensinomedio1);
		textViewIniciaisIdeb1 = (TextView) findViewById(R.id.textView_ideb_iniciais1);
		textViewQuantidadePrimeirosProjetos1 = (TextView) findViewById(R.id.textView_primeiros_projetos_quantidade1);
		textViewValorPrimeirosProjetos1 = (TextView) findViewById(R.id.textView_programa_primeiros_projetos_valor1);
		textViewQuantidadePesquisa1 = (TextView) findViewById(R.id.textView_projetos_pesquisa_quantidade1);
		textViewValoresPesquisa1 = (TextView) findViewById(R.id.textView_valores_projeto_pesquisa1);
		textViewQuantidadeJovensPesquisadores1 = (TextView) findViewById(R.id.textView_jovens_pesquisadores_quantidade1);
		textViewValorJovensPesquisadores1 = (TextView) findViewById(R.id.textView_jovens_pesquisadores_valor1);
		textViewQuantidadeProjetosIniciacao1 = (TextView) findViewById(R.id.textView_projetos_iniciacao_quantidade1);
		textViewValorProjetosIniciacao1 = (TextView) findViewById(R.id.textView_projetos_iniciacao_valor1);
		

		textViewSigla2 = (TextView) findViewById(R.id.textView_sigla2);
		textViewNome2 = (TextView) findViewById(R.id.textView_nome_estado2);
		textViewPopulacao2 = (TextView) findViewById(R.id.textView_populacao_valor2);
		textViewParticipacaoPib2 = (TextView) findViewById(R.id.textView_participacao_pib_valor2);
		textViewQuantidadeProjetosCienciaTecnologia2 = (TextView) findViewById(R.id.textView_numero_projetos_quantidade2);
		textViewValorProjetosCienciaTecnologia2 = (TextView) findViewById(R.id.textView_valor_investido_projetos2);
		textViewFundamentalIdeb2 = (TextView) findViewById(R.id.textView_ideb_fundamental2);
		textViewEnsinoMedioIdeb2 = (TextView) findViewById(R.id.textView_ideb_ensinomedio2);
		textViewIniciaisIdeb2 = (TextView) findViewById(R.id.textView_ideb_iniciais2);
		textViewQuantidadePrimeirosProjetos2 = (TextView) findViewById(R.id.textView_primeiros_projetos_quantidade2);
		textViewValorPrimeirosProjetos2 = (TextView) findViewById(R.id.textView_programa_primeiros_projetos_valor2);
		textViewQuantidadePesquisa2 = (TextView) findViewById(R.id.textView_projetos_pesquisa_quantidade2);
		textViewValoresPesquisa2 = (TextView) findViewById(R.id.textView_valores_projeto_pesquisa2);
		textViewQuantidadeJovensPesquisadores2 = (TextView) findViewById(R.id.textView_jovens_pesquisadores_quantidade2);
		textViewValorJovensPesquisadores2 = (TextView) findViewById(R.id.textView_jovens_pesquisadores_valor2);
		textViewQuantidadeProjetosIniciacao2 = (TextView) findViewById(R.id.textView_projetos_iniciacao_quantidade2);
		textViewValorProjetosIniciacao2 = (TextView) findViewById(R.id.textView_projetos_iniciacao_valor2);
		
		
	}
}
