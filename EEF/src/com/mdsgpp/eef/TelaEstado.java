package com.mdsgpp.eef;

import java.io.IOException;
import java.util.ArrayList;

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
		
		
		
		try {
			ArrayList<String> informacoes;
			informacoes = EstadoControle.getInstancia().getInformacoesEstado(posicao, this);
			
			textViewSigla.setText(informacoes.get(0));
			textViewNome.setText(informacoes.get(1));
			textViewPopulacao.setText(informacoes.get(2));
			textViewParticipacaoPib.setText(informacoes.get(3));
			textViewQuantidadeProjetos.setText(informacoes.get(4));
			textViewValorProjetos.setText(informacoes.get(5));
			textViewFundamentalIdeb.setText(informacoes.get(6));
			textViewEnsinoMedioIdeb.setText(informacoes.get(7));
			textViewIniciaisIdeb.setText(informacoes.get(8));
			textViewQuantidadePrimeirosProjetos.setText(informacoes.get(9));
			textViewValorPrimeirosProjetos.setText(informacoes.get(10));
			textViewQuantidadePesquisa.setText(informacoes.get(11));
			textViewValoresPesquisa.setText(informacoes.get(12));
			textViewQuantidadeJovensPesquisadores.setText(informacoes.get(13));
			textViewValorJovensPesquisadores.setText(informacoes.get(14));
			textViewQuantidadeProjetosIniciacao.setText(informacoes.get(15));
			textViewValorProjetosIniciacao.setText(informacoes.get(16));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_estado, menu);
		return true;
	}

}
