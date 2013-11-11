package com.mdsgpp.eef.visao;

import java.io.IOException;
import java.util.HashMap;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.controle.EstadoControle;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TelaResultadoConsulta extends Activity {

	private TextView textViewSigla1;
	private TextView textViewNome1;
	private TextView textViewPopulacao1;
	private TextView textViewPopulacaoValor1;
	private TextView textViewParticipacaoEstadualPib1;
	private TextView textViewParticipacaoPib1;
	private TextView textViewNumeroProjetos1;
	private TextView textViewQuantidadeProjetosCienciaTecnologia1;
	private TextView textViewValorProjetosCienciaTecnologia1;
	private TextView textViewIdeb1;
	private TextView textViewFundamentalIdeb1;
	private TextView textViewEnsinoMedioIdeb1;
	private TextView textViewIniciaisIdeb1;
	private TextView textViewProgramaPrimeirosProjetos1;
	private TextView textViewQuantidadePrimeirosProjetos1;
	private TextView textViewValorPrimeirosProjetos1;
	private TextView textViewProjetosPesquisa1;
	private TextView textViewQuantidadePesquisa1;
	private TextView textViewJovensPesquisadores1;
	private TextView textViewQuantidadeJovensPesquisadores1;
	private TextView textViewValoresPesquisa1;
	private TextView textViewValorJovensPesquisadores1;
	private TextView textViewProjetosIniciacao1;
	private TextView textViewQuantidadeProjetosIniciacao1;
	private TextView textViewValorProjetosIniciacao1;
	

	private TextView textViewSigla2;
	private TextView textViewNome2;
	private TextView textViewPopulacaoValor2;
	private TextView textViewParticipacaoPib2;
	private TextView textViewQuantidadeProjetosCienciaTecnologia2;
	private TextView textViewValorProjetosCienciaTecnologia2;
	private TextView textViewFundamentalIdeb2;
	private TextView textViewEnsinoMedioIdeb2;
	private TextView textViewIniciaisIdeb2;
	private TextView textViewQuantidadePrimeirosProjetos2;
	private TextView textViewValorPrimeirosProjetos2;
	private TextView textViewQuantidadePesquisa2;
	private TextView textViewQuantidadeJovensPesquisadores2;
	private TextView textViewValoresPesquisa2;
	private TextView textViewValorJovensPesquisadores2;
	private TextView textViewQuantidadeProjetosIniciacao2;
	private TextView textViewValorProjetosIniciacao2;
	private boolean  bIdeb, bPib, bPopulacao, bPrimeirosProjetos, bProjetosCnpq,
					 bProjetosDifusao, bProjetosIniciacao, bProjetosJovens;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_compara_estados);
		capturaInformacoes();
		escondeCamposDeTexto();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_compara_estados, menu);
		return true;
		
	}
	
	@SuppressWarnings("unchecked")
	private void capturaInformacoes() {
		
		// Captura o intent que abriu a activity
		Intent intent = getIntent();
		// Captura o valor transferido através da intent
		
		int posicao1 = intent.getIntExtra("POSICAO_ESTADO_01",5);
		int posicao2 = intent.getIntExtra("POSICAO_ESTADO_02",0);
		
		bIdeb = intent.getBooleanExtra("CB_IDEB", false);
		bPib = intent.getBooleanExtra("CB_PIB", false);
		bPopulacao = intent.getBooleanExtra("CB_POPULACAO", false);
		bPrimeirosProjetos = intent.getBooleanExtra("CB_PRIMEIROS_PROJETOS", false);
		bProjetosCnpq = intent.getBooleanExtra("CB_PROJETOS_CNPQ", false);
		bProjetosDifusao = intent.getBooleanExtra("CB_PROJETOS_DIFUSAO", false);
		bProjetosIniciacao = intent.getBooleanExtra("CB_PROJETOS_INICIACAO", false);
		bProjetosJovens = intent.getBooleanExtra("CB_PROJETOS_JOVENS", false);
		
		InicializaCamposTexto();

		HashMap<String, String> informacoesEstado1 = new HashMap<String, String>();
		HashMap<String, String> informacoesEstado2 = new HashMap<String, String>();

		try {
			informacoesEstado1 = (HashMap<String, String>) EstadoControle
					.getInstancia(this).lerEstado(posicao1).clone();
			informacoesEstado2 = (HashMap<String, String>) EstadoControle
					.getInstancia(this).lerEstado(posicao2).clone();

			preencheCamposTexto(informacoesEstado1, informacoesEstado2);
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(), "Houve um erro no acesso às informações.", Toast.LENGTH_SHORT).show();
			Log.i("IOException - TelaComparaEstados",e.toString());
		}
	}

	private void preencheCamposTexto(HashMap<String, String> informacoes1,
			HashMap<String, String> informacoes2) {

		textViewSigla1.setText(informacoes1.get("sigla"));
		if (textViewNome1 != null)
			textViewNome1.setText(informacoes1.get("nome"));

		textViewPopulacaoValor1.setText(informacoes1.get("populacao"));			
		textViewParticipacaoPib1.setText(informacoes1
				.get("percentual_participacao_pib"));
		textViewQuantidadeProjetosCienciaTecnologia1.setText(informacoes1
				.get("projetos_ciencia_tecnologia"));
		textViewValorProjetosCienciaTecnologia1.setText(informacoes1
				.get("valor_ciencia_tecnologia"));
		textViewFundamentalIdeb1.setText(informacoes1
				.get("ideb_fundamental_final"));
		textViewEnsinoMedioIdeb1.setText(informacoes1.get("ideb_ensino_medio"));
		textViewIniciaisIdeb1.setText(informacoes1
				.get("ideb_fundamental_inicial"));
		textViewQuantidadePrimeirosProjetos1.setText(informacoes1
				.get("quantidade_primeiros_projetos"));
		textViewValorPrimeirosProjetos1.setText(informacoes1
				.get("valor_primeiros_projetos"));
		textViewQuantidadePesquisa1.setText(informacoes1
				.get("quantidade_projeto_cnpq"));
		textViewValoresPesquisa1.setText(informacoes1
				.get("valor_projetos_cnpq"));
		textViewQuantidadeJovensPesquisadores1.setText(informacoes1
				.get("quantidade_projeto_jovens_pesquisadores"));
		textViewValorJovensPesquisadores1.setText(informacoes1
				.get("valor_projetos_jovens_pesquisadores"));
		textViewQuantidadeProjetosIniciacao1.setText(informacoes1
				.get("quantidade_projetos_inct"));
		textViewValorProjetosIniciacao1.setText(informacoes1
				.get("valor_projetos_inct"));

		textViewSigla2.setText(informacoes2.get("sigla"));
		if (textViewNome2 != null)
			textViewNome2.setText(informacoes2.get("nome"));

		textViewPopulacaoValor2.setText(informacoes2.get("populacao"));
		textViewParticipacaoPib2.setText(informacoes2
				.get("percentual_participacao_pib"));
		textViewQuantidadeProjetosCienciaTecnologia2.setText(informacoes2.get(
				"projetos_ciencia_tecnologia").split(":")[1]);
		textViewValorProjetosCienciaTecnologia2.setText(informacoes2.get(
				"valor_ciencia_tecnologia").split(":")[1]);
		textViewFundamentalIdeb2.setText(informacoes2.get(
				"ideb_fundamental_final").split(":")[1]);
		textViewEnsinoMedioIdeb2.setText(informacoes2.get("ideb_ensino_medio")
				.split(":")[1]);
		textViewIniciaisIdeb2.setText(informacoes2.get(
				"ideb_fundamental_inicial").split(":")[1]);
		textViewQuantidadePrimeirosProjetos2.setText(informacoes2.get(
				"quantidade_primeiros_projetos").split(":")[1]);
		textViewValorPrimeirosProjetos2.setText(informacoes2.get(
				"valor_primeiros_projetos").split(":")[1]);
		textViewQuantidadePesquisa2.setText(informacoes2.get(
				"quantidade_projeto_cnpq").split(":")[1]);
		textViewValoresPesquisa2.setText(informacoes2
				.get("valor_projetos_cnpq").split(":")[1]);
		textViewQuantidadeJovensPesquisadores2.setText(informacoes2.get(
				"quantidade_projeto_jovens_pesquisadores").split(":")[1]);
		textViewValorJovensPesquisadores2.setText(informacoes2.get(
				"valor_projetos_jovens_pesquisadores").split(":")[1]);
		textViewQuantidadeProjetosIniciacao2.setText(informacoes2.get(
				"quantidade_projetos_inct").split(":")[1]);
		textViewValorProjetosIniciacao2.setText(informacoes2.get(
				"valor_projetos_inct").split(":")[1]);

	}

	private void InicializaCamposTexto() {

		textViewSigla1 = (TextView) findViewById(R.id.textView_sigla1);
		textViewNome1 = (TextView) findViewById(R.id.textView_nome_estado1);		
		textViewPopulacaoValor1 = (TextView) findViewById(R.id.textView_populacao_valor1);
		textViewPopulacao1 = (TextView) findViewById(R.id.textView_populacao1);
		textViewParticipacaoEstadualPib1 = (TextView) findViewById(R.id.textView_participacao_estadual_pib1);
		textViewParticipacaoPib1 = (TextView) findViewById(R.id.textView_participacao_pib_valor1);
		textViewNumeroProjetos1 =  (TextView) findViewById(R.id.textView_numero_projetos1);
		textViewQuantidadeProjetosCienciaTecnologia1 = (TextView) findViewById(R.id.textView_numero_projetos_quantidade1);
		textViewValorProjetosCienciaTecnologia1 = (TextView) findViewById(R.id.textView_valor_investido_projetos1);
		textViewIdeb1 = (TextView) findViewById(R.id.textView_ideb1);
		textViewFundamentalIdeb1 = (TextView) findViewById(R.id.textView_ideb_fundamental1);
		textViewEnsinoMedioIdeb1 = (TextView) findViewById(R.id.textView_ideb_ensinomedio1);
		textViewIniciaisIdeb1 = (TextView) findViewById(R.id.textView_ideb_iniciais1);
		textViewProgramaPrimeirosProjetos1 = (TextView) findViewById(R.id.textView_programa_primeiros_projetos1);
		textViewQuantidadePrimeirosProjetos1 = (TextView) findViewById(R.id.textView_primeiros_projetos_quantidade1);
		textViewValorPrimeirosProjetos1 = (TextView) findViewById(R.id.textView_programa_primeiros_projetos_valor1);
		textViewProjetosPesquisa1 = (TextView) findViewById(R.id.textView_projetos_pesquisa1);
		textViewQuantidadePesquisa1 = (TextView) findViewById(R.id.textView_projetos_pesquisa_quantidade1);
		textViewValoresPesquisa1 = (TextView) findViewById(R.id.textView_valores_projeto_pesquisa1);
		textViewQuantidadeJovensPesquisadores1 = (TextView) findViewById(R.id.textView_jovens_pesquisadores_quantidade1);
		textViewValorJovensPesquisadores1 = (TextView) findViewById(R.id.textView_jovens_pesquisadores_valor1);
		textViewProjetosIniciacao1 = (TextView) findViewById(R.id.textView_projetos_iniciacao1);
		textViewQuantidadeProjetosIniciacao1 = (TextView) findViewById(R.id.textView_projetos_iniciacao_quantidade1);
		textViewValorProjetosIniciacao1 = (TextView) findViewById(R.id.textView_projetos_iniciacao_valor1);
		
		
		textViewSigla2 = (TextView) findViewById(R.id.textView_sigla2);
		textViewNome2 = (TextView) findViewById(R.id.textView_nome_estado2);
		textViewPopulacaoValor2 = (TextView) findViewById(R.id.textView_populacao_valor2);
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
		textViewJovensPesquisadores1 = (TextView) findViewById(R.id.textView_jovens_pesquisadores1);
		textViewQuantidadeJovensPesquisadores2 = (TextView) findViewById(R.id.textView_jovens_pesquisadores_quantidade2);
		textViewValorJovensPesquisadores2 = (TextView) findViewById(R.id.textView_jovens_pesquisadores_valor2);
		textViewQuantidadeProjetosIniciacao2 = (TextView) findViewById(R.id.textView_projetos_iniciacao_quantidade2);
		textViewValorProjetosIniciacao2 = (TextView) findViewById(R.id.textView_projetos_iniciacao_valor2);

	}
	
	public void escondeCamposDeTexto() {
		int vPopulacao = (bPopulacao) ? View.VISIBLE : View.GONE;
		
			textViewPopulacao1.setVisibility(vPopulacao);
			textViewPopulacaoValor1.setVisibility(vPopulacao);
			textViewPopulacaoValor2.setVisibility(vPopulacao);
			
		int vIdeb = (bIdeb) ? View.VISIBLE : View.GONE;
		
			textViewIdeb1.setVisibility(vIdeb);
			textViewFundamentalIdeb1.setVisibility(vIdeb);
			textViewEnsinoMedioIdeb1.setVisibility(vIdeb);
			textViewIniciaisIdeb1.setVisibility(vIdeb);
			textViewFundamentalIdeb2.setVisibility(vIdeb);
			textViewEnsinoMedioIdeb2.setVisibility(vIdeb);
			textViewIniciaisIdeb2.setVisibility(vIdeb);
			
		 int vPib = (bPib) ? View.VISIBLE : View.GONE;	
		
		    textViewParticipacaoEstadualPib1.setVisibility(vPib);
		    textViewParticipacaoPib1.setVisibility(vPib);
			textViewParticipacaoPib2.setVisibility(vPib);
			
		int vPrimeirosProjetos = (bPrimeirosProjetos) ? View.VISIBLE : View.GONE;
			
			textViewProgramaPrimeirosProjetos1.setVisibility(vPrimeirosProjetos);
			textViewQuantidadePrimeirosProjetos1.setVisibility(vPrimeirosProjetos);
			textViewValorPrimeirosProjetos1.setVisibility(vPrimeirosProjetos);
			textViewQuantidadePrimeirosProjetos2.setVisibility(vPrimeirosProjetos);
			textViewValorPrimeirosProjetos2.setVisibility(vPrimeirosProjetos);
			
		int vProjetosCnpq = (bProjetosCnpq) ? View.VISIBLE : View.GONE;	
		
			textViewProjetosPesquisa1.setVisibility(vProjetosCnpq);
			textViewQuantidadePesquisa1.setVisibility(vProjetosCnpq);
			textViewValoresPesquisa1.setVisibility(vProjetosCnpq);
			textViewQuantidadePesquisa2.setVisibility(vProjetosCnpq);
			textViewValoresPesquisa2.setVisibility(vProjetosCnpq);
				
			
		int vProjetosJovens = (bProjetosJovens) ? View.VISIBLE : View.GONE;	
			
			
			textViewJovensPesquisadores1.setVisibility(vProjetosJovens);
			textViewQuantidadeJovensPesquisadores1.setVisibility(vProjetosJovens); 
			textViewValorJovensPesquisadores1.setVisibility(vProjetosJovens);
			textViewQuantidadeJovensPesquisadores2.setVisibility(vProjetosJovens); 
			textViewValorJovensPesquisadores2.setVisibility(vProjetosJovens);  
				
		int vProjetosIniciacao = (bProjetosIniciacao) ? View.VISIBLE : View.GONE;	
		
		
			textViewProjetosIniciacao1.setVisibility(vProjetosIniciacao); 
			textViewQuantidadeProjetosIniciacao1.setVisibility(vProjetosIniciacao); 
			textViewValorProjetosIniciacao1.setVisibility(vProjetosIniciacao );
			textViewQuantidadeProjetosIniciacao2.setVisibility(vProjetosIniciacao); 
			textViewValorProjetosIniciacao2.setVisibility(vProjetosIniciacao);
		
			
		int vProjetosDifusao = (bProjetosDifusao) ? View.VISIBLE : View.GONE;	
		
			textViewNumeroProjetos1.setVisibility(vProjetosDifusao);
			textViewQuantidadeProjetosCienciaTecnologia1.setVisibility(vProjetosDifusao);
			textViewValorProjetosCienciaTecnologia1.setVisibility(vProjetosDifusao);	
			textViewQuantidadeProjetosCienciaTecnologia2.setVisibility(vProjetosDifusao);
			textViewValorProjetosCienciaTecnologia2.setVisibility(vProjetosDifusao);
						
						
					
			
	}
}


