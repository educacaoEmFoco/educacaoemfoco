package com.mdsgpp.eef;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mdsgpp.eef.controle.EstadoControle;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class TelaEstado extends Activity {

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_estado);
		
		// Captura o intent que abriu a activity
		Intent intent = getIntent();
		// Captura o valor transferido através da intent
		int posicao = intent.getIntExtra("INDEX_ESTADO_ESCOLHIDO", 0);
		
		TextView textViewSigla = (TextView) findViewById(R.id.textView_sigla);
		TextView textViewNome = (TextView) findViewById(R.id.textView_nome_estado);
		TextView textViewPopulacao = (TextView) findViewById(R.id.textView_populacao_valor);
		TextView textViewParticipacaoPib = (TextView) findViewById(R.id.textView_participacao_pib_valor);
		TextView textViewQuantidadeProjetos = (TextView) findViewById(R.id.textView_numero_projetos_quantidade);
		TextView textViewValorProjetos = (TextView) findViewById(R.id.textView_valor_investido_projetos);
		TextView textViewFundamentalIdeb = (TextView) findViewById(R.id.textView_ideb_fundamental);
		TextView textViewEnsinoMedioIdeb = (TextView) findViewById(R.id.textView_ideb_ensinomedio);
		TextView textViewIniciaisIdeb = (TextView) findViewById(R.id.textView_ideb_iniciais);
		TextView textViewQuantidadePrimeirosProjetos = (TextView) findViewById(R.id.textView_primeiros_projetos_quantidade);
		TextView textViewValorPrimeirosProjetos = (TextView) findViewById(R.id.textView_programa_primeiros_projetos_valor);
		TextView textViewQuantidadePesquisa = (TextView) findViewById(R.id.textView_projetos_pesquisa_quantidade);
		TextView textViewValoresPesquisa = (TextView) findViewById(R.id.textView_valores_projeto_pesquisa);
		TextView textViewQuantidadeJovensPesquisadores = (TextView) findViewById(R.id.textView_jovens_pesquisadores_quantidade);
		TextView textViewValorJovensPesquisadores= (TextView) findViewById(R.id.textView_jovens_pesquisadores_valor);
		TextView textViewQuantidadeProjetosIniciacao = (TextView) findViewById(R.id.textView_projetos_iniciacao_quantidade);
		TextView textViewValorProjetosIniciacao = (TextView) findViewById(R.id.textView_projetos_iniciacao_valor);
		
		
		

	    HashMap<String, String> informacoes = new HashMap <String, String>();
			
	    textViewSigla.setText(informacoes.get("sigla"));
		textViewNome.setText(informacoes.get("nome"));
		textViewPopulacao.setText(informacoes.get("populacao"));
		textViewParticipacaoPib.setText(informacoes.get("percentrual_participacao_pib"));
		textViewQuantidadeProjetos.setText(informacoes.get("quantidade_primeiros_projetos"));
		textViewValorProjetos.setText(informacoes.get("valor_primeiros_projetos"));
		textViewFundamentalIdeb.setText(informacoes.get("ideb_fundamental_final"));
		textViewEnsinoMedioIdeb.setText(informacoes.get("ideb_ensino_medio"));
		textViewIniciaisIdeb.setText(informacoes.get("ideb_fundamental_inicial"));
		textViewQuantidadePrimeirosProjetos.setText(informacoes.get("quantidade_primeiro_projetos"));
		textViewValorPrimeirosProjetos.setText(informacoes.get("valor_primeiros_projetos"));
	    textViewQuantidadePesquisa.setText(informacoes.get("quantidade_pesquisa"));
		textViewValoresPesquisa.setText(informacoes.get("valor_pesquisa"));
		textViewQuantidadeJovensPesquisadores.setText(informacoes.get("quantidade_jovens_pesquisadores"));
		textViewValorJovensPesquisadores.setText(informacoes.get("valor_projetos_jovens_pesquisadores"));
		textViewQuantidadeProjetosIniciacao.setText(informacoes.get("quantidade_projetos_iniciacao_cientifica"));
		textViewValorProjetosIniciacao.setText(informacoes.get("valor_projetos_iniciacao_cientifica"));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_estado, menu);
		return true;
	}

}
