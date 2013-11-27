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
	private TextView textViewCenso1;
	private TextView textViewCensoIniciaisFundamental1;
	private TextView textViewCensoFinaisFundamental1;
	private TextView textViewCensoMedio1;
	private TextView textViewCensoEjaFundamental1;
	private TextView textViewCensoEjaMedio1;
	private TextView textViewMediaAlunosPorTurma1;
	private TextView textViewMediaAlunosPorTurmaFundamental1;
	private TextView textViewMediaAlunosPorTurmaMedio1;
	private TextView textViewMediaHorasAula1;
	private TextView textViewMediaHorasAulaFundamental1;
	private TextView textViewMediaHorasAulaMedio1;
	private TextView textViewTaxaDistorcao1;
	private TextView textViewTaxaDistorcaoIdadeSerieFundamental1;
	private TextView textViewTaxaDistorcaoIdadeSerieMedio1;
	private TextView textViewTaxaDeAproveitamento1;
	private TextView textViewTaxaDeAproveitamentoFundamental1;
	private TextView textViewTaxaDeAproveitamentoMedio1;
	private TextView textViewTaxaDeAbandono1;
	private TextView textViewTaxaDeAbandonoFundamental1;
	private TextView textViewTaxaDeAbandonoMedio1;
	
	private TextView textViewSigla2;
	private TextView textViewNome2;
	private TextView textViewPopulacao2;
	private TextView textViewPopulacaoValor2;
	private TextView textViewParticipacaoEstadualPib2;
	private TextView textViewParticipacaoPib2;
	private TextView textViewNumeroProjetos2;
	private TextView textViewQuantidadeProjetosCienciaTecnologia2;
	private TextView textViewValorProjetosCienciaTecnologia2;
	private TextView textViewIdeb2;
	private TextView textViewFundamentalIdeb2;
	private TextView textViewEnsinoMedioIdeb2;
	private TextView textViewIniciaisIdeb2;
	private TextView textViewProgramaPrimeirosProjetos2;
	private TextView textViewQuantidadePrimeirosProjetos2;
	private TextView textViewValorPrimeirosProjetos2;
	private TextView textViewProjetosPesquisa2;
	private TextView textViewQuantidadePesquisa2;
	private TextView textViewJovensPesquisadores2;
	private TextView textViewQuantidadeJovensPesquisadores2;
	private TextView textViewValoresPesquisa2;
	private TextView textViewValorJovensPesquisadores2;
	private TextView textViewProjetosIniciacao2;
	private TextView textViewQuantidadeProjetosIniciacao2;
	private TextView textViewValorProjetosIniciacao2;
	private TextView textViewCenso2;
	private TextView textViewCensoIniciaisFundamental2;
	private TextView textViewCensoFinaisFundamental2;
	private TextView textViewCensoMedio2;
	private TextView textViewCensoEjaFundamental2;
	private TextView textViewCensoEjaMedio2;
	private TextView textViewMediaAlunosPorTurma2;
	private TextView textViewMediaAlunosPorTurmaFundamental2;
	private TextView textViewMediaAlunosPorTurmaMedio2;
	private TextView textViewMediaHorasAula2;
	private TextView textViewMediaHorasAulaFundamental2;
	private TextView textViewMediaHorasAulaMedio2;
	private TextView textViewTaxaDistorcao2;
	private TextView textViewTaxaDistorcaoIdadeSerieFundamental2;
	private TextView textViewTaxaDistorcaoIdadeSerieMedio2;
	private TextView textViewTaxaDeAproveitamento2;
	private TextView textViewTaxaDeAproveitamentoFundamental2;
	private TextView textViewTaxaDeAproveitamentoMedio2;
	private TextView textViewTaxaDeAbandono2;
	private TextView textViewTaxaDeAbandonoFundamental2;
	private TextView textViewTaxaDeAbandonoMedio2;
	
	private boolean  bCenso, bAlunosTurma, bHorasAula, bTaxaDistorcao, bTaxaAbandono, bAprovacao, bIdeb, bPib, bPopulacao, bPrimeirosProjetos, bProjetosCnpq,
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
		// Captura o valor transferido atrav�s da intent
		
		int posicao1 = intent.getIntExtra("INDEX_ESTADO1_ESCOLHIDO",5);
		int posicao2 = intent.getIntExtra("INDEX_ESTADO2_ESCOLHIDO",0);
		
		bIdeb = intent.getBooleanExtra("CB_IDEB", false);
		bPib = intent.getBooleanExtra("CB_PIB", false);
		bPopulacao = intent.getBooleanExtra("CB_POPULACAO", false);
		bPrimeirosProjetos = intent.getBooleanExtra("CB_PRIMEIROS_PROJETOS", false);
		bProjetosCnpq = intent.getBooleanExtra("CB_PROJETOS_CNPQ", false);
		bProjetosDifusao = intent.getBooleanExtra("CB_PROJETOS_DIFUSAO", false);
		bProjetosIniciacao = intent.getBooleanExtra("CB_PROJETOS_INICIACAO", false);
		bProjetosJovens = intent.getBooleanExtra("CB_PROJETOS_JOVENS", false);
		
		bCenso = intent.getBooleanExtra("CB_CENSO", false);
		bAlunosTurma = intent.getBooleanExtra("CB_ALUNOS_TURMA", false);
		bHorasAula = intent.getBooleanExtra("CB_HORAS_AULA", false);
		bTaxaDistorcao = intent.getBooleanExtra("CB_TAXA_DISTORCAO", false);
		bTaxaAbandono = intent.getBooleanExtra("CB_TAXA_ABANDONO", false);
		bAprovacao = intent.getBooleanExtra("CB_APROVACAO", false);
		
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
			Toast.makeText(getApplicationContext(), "Houve um erro no acesso �s informa��es.", Toast.LENGTH_SHORT).show();
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
		textViewCensoIniciaisFundamental1.setText(informacoes1.get("censo_anos_iniciais_fundamental"));
		textViewCensoFinaisFundamental1.setText(informacoes1.get("censo_anos_finais_fundamental"));
		textViewCensoMedio1.setText(informacoes1.get("censo_ensino_medio"));
		textViewCensoEjaFundamental1.setText(informacoes1.get("censo_eja_fundamental"));
		textViewCensoEjaMedio1.setText(informacoes1.get("censo_eja_medio"));
		textViewMediaAlunosPorTurmaFundamental1.setText(informacoes1.get("alunos_por_turma_ensino_fundamental"));
		textViewMediaAlunosPorTurmaMedio1.setText(informacoes1.get("alunos_por_turma_ensino_medio"));
		textViewMediaHorasAulaFundamental1.setText(informacoes1.get("horas_aula_ensino_fundamental"));
		textViewMediaHorasAulaMedio1.setText(informacoes1.get("horas_aula_ensino_medio"));
		textViewTaxaDistorcaoIdadeSerieFundamental1.setText(informacoes1.get("taxa_distorcao_fundamental"));
		textViewTaxaDistorcaoIdadeSerieMedio1.setText(informacoes1.get("taxa_distorcao_medio"));
		textViewTaxaDeAproveitamentoFundamental1.setText(informacoes1.get("taxa_aprovacao_fundamental"));
		textViewTaxaDeAproveitamentoMedio1.setText(informacoes1.get("taxa_aprovacao_medio"));
		textViewTaxaDeAbandonoFundamental1.setText(informacoes1.get("taxa_aprovacao_fundamental"));
		textViewTaxaDeAbandonoMedio1.setText(informacoes1.get("taxa_aprovacao_medio"));

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
		textViewCensoIniciaisFundamental2.setText(informacoes2.get("censo_anos_iniciais_fundamental").split(":")[1]);
		textViewCensoFinaisFundamental2.setText(informacoes2.get("censo_anos_finais_fundamental").split(":")[1]);
		textViewCensoMedio2.setText(informacoes2.get("censo_ensino_medio").split(":")[1]);
		textViewCensoEjaFundamental2.setText(informacoes2.get("censo_eja_fundamental").split(":")[1]);
		textViewCensoEjaMedio2.setText(informacoes2.get("censo_eja_medio").split(":")[1]);
		textViewMediaAlunosPorTurmaFundamental2.setText(informacoes2.get("alunos_por_turma_ensino_fundamental").split(":")[1]);
		textViewMediaAlunosPorTurmaMedio2.setText(informacoes2.get("alunos_por_turma_ensino_medio").split(":")[1]);
		textViewMediaHorasAulaFundamental2.setText(informacoes2.get("horas_aula_ensino_fundamental").split(":")[1]);
		textViewMediaHorasAulaMedio2.setText(informacoes2.get("horas_aula_ensino_medio"));
		textViewTaxaDistorcaoIdadeSerieFundamental2.setText(informacoes2.get("taxa_distorcao_fundamental").split(":")[1]);
		textViewTaxaDistorcaoIdadeSerieMedio2.setText(informacoes2.get("taxa_distorcao_medio").split(":")[1]);
		textViewTaxaDeAproveitamentoFundamental2.setText(informacoes2.get("taxa_aprovacao_fundamental").split(":")[1]);
		textViewTaxaDeAproveitamentoMedio2.setText(informacoes2.get("taxa_aprovacao_medio").split(":")[1]);
		textViewTaxaDeAbandonoFundamental2.setText(informacoes2.get("taxa_aprovacao_fundamental").split(":")[1]);
		textViewTaxaDeAbandonoMedio2.setText(informacoes2.get("taxa_aprovacao_medio").split(":")[1]);

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
		textViewJovensPesquisadores1 = (TextView) findViewById(R.id.textView_jovens_pesquisadores1);
		textViewValorJovensPesquisadores1 = (TextView) findViewById(R.id.textView_jovens_pesquisadores_valor1);
		textViewProjetosIniciacao1 = (TextView) findViewById(R.id.textView_projetos_iniciacao1);
		textViewQuantidadeProjetosIniciacao1 = (TextView) findViewById(R.id.textView_projetos_iniciacao_quantidade1);
		textViewValorProjetosIniciacao1 = (TextView) findViewById(R.id.textView_projetos_iniciacao_valor1);
		textViewTaxaDeAbandono1 = (TextView) findViewById(R.id.textView_taxa_abandono1);
		textViewTaxaDeAproveitamento1  = (TextView) findViewById(R.id.textView_taxa_aprovacao1); 
		textViewCenso1  = (TextView) findViewById(R.id.textView_censo1);
		textViewMediaAlunosPorTurma1  = (TextView) findViewById(R.id.textView_media_alunos_por_turma1);
		textViewMediaHorasAula1 = (TextView) findViewById(R.id.textView_horas_aula_ensino1);
		textViewTaxaDistorcao1 = (TextView) findViewById(R.id.textView_taxa_distorcao1);
		
		textViewCensoIniciaisFundamental1 = (TextView) findViewById(R.id.textView_censo_iniciais_fundamental1);
		textViewCensoFinaisFundamental1 = (TextView) findViewById(R.id.textView_censo_finais_fundamental1);
		textViewCensoMedio1 = (TextView) findViewById(R.id.textView_censo_medio1);
		textViewCensoEjaFundamental1 = (TextView) findViewById(R.id.textView_censo_fundamental_eja1);
		textViewCensoEjaMedio1 = (TextView) findViewById(R.id.textView_censo_medio_eja1);
		textViewMediaAlunosPorTurmaFundamental1 = (TextView) findViewById(R.id.textView_media_alunos_por_turma_fundamental1);
		textViewMediaAlunosPorTurmaMedio1 = (TextView) findViewById(R.id.textView_media_alunos_por_turma_medio1);
		textViewMediaHorasAulaFundamental1 = (TextView) findViewById(R.id.textView_horas_aula_ensino_fundamental1);
		textViewMediaHorasAulaMedio1 = (TextView) findViewById(R.id.textView_horas_aula_ensino_medio1);
		textViewTaxaDistorcaoIdadeSerieFundamental1 = (TextView) findViewById(R.id.textView_taxa_distorcao_fundamental1);
		textViewTaxaDistorcaoIdadeSerieMedio1 = (TextView) findViewById(R.id.textView_taxa_distorcao_medio1);
		textViewTaxaDeAproveitamentoFundamental1 = (TextView) findViewById(R.id.textView_taxa_aprovacao_fundamental1);
		textViewTaxaDeAproveitamentoMedio1 = (TextView) findViewById(R.id.textView_taxa_aprovacao_medio1);
		textViewTaxaDeAbandonoFundamental1 = (TextView) findViewById(R.id.textView_taxa_abandono_fundamental1);
		textViewTaxaDeAbandonoMedio1 = (TextView) findViewById(R.id.textView_taxa_abandono_medio1);
		
		textViewSigla2 = (TextView) findViewById(R.id.textView_sigla2);
		textViewNome2 = (TextView) findViewById(R.id.textView_nome_estado2);		
		textViewPopulacaoValor2 = (TextView) findViewById(R.id.textView_populacao_valor2);
		textViewPopulacao2 = (TextView) findViewById(R.id.textView_populacao2);
		textViewParticipacaoEstadualPib2 = (TextView) findViewById(R.id.textView_participacao_estadual_pib2);
		textViewParticipacaoPib2 = (TextView) findViewById(R.id.textView_participacao_pib_valor2);
		textViewNumeroProjetos2 =  (TextView) findViewById(R.id.textView_numero_projetos2);
		textViewQuantidadeProjetosCienciaTecnologia2 = (TextView) findViewById(R.id.textView_numero_projetos_quantidade2);
		textViewValorProjetosCienciaTecnologia2 = (TextView) findViewById(R.id.textView_valor_investido_projetos2);
		textViewIdeb2 = (TextView) findViewById(R.id.textView_ideb2);
		textViewFundamentalIdeb2 = (TextView) findViewById(R.id.textView_ideb_fundamental2);
		textViewEnsinoMedioIdeb2 = (TextView) findViewById(R.id.textView_ideb_ensinomedio2);
		textViewIniciaisIdeb2 = (TextView) findViewById(R.id.textView_ideb_iniciais2);
		textViewProgramaPrimeirosProjetos2 = (TextView) findViewById(R.id.textView_programa_primeiros_projetos2);
		textViewQuantidadePrimeirosProjetos2 = (TextView) findViewById(R.id.textView_primeiros_projetos_quantidade2);
		textViewValorPrimeirosProjetos2 = (TextView) findViewById(R.id.textView_programa_primeiros_projetos_valor2);
		textViewProjetosPesquisa2 = (TextView) findViewById(R.id.textView_projetos_pesquisa2);
		textViewQuantidadePesquisa2 = (TextView) findViewById(R.id.textView_projetos_pesquisa_quantidade2);
		textViewValoresPesquisa2 = (TextView) findViewById(R.id.textView_valores_projeto_pesquisa2);
		textViewQuantidadeJovensPesquisadores2 = (TextView) findViewById(R.id.textView_jovens_pesquisadores_quantidade2);
		textViewValorJovensPesquisadores2 = (TextView) findViewById(R.id.textView_jovens_pesquisadores_valor2);
		textViewProjetosIniciacao2 = (TextView) findViewById(R.id.textView_projetos_iniciacao2);
		textViewQuantidadeProjetosIniciacao2 = (TextView) findViewById(R.id.textView_projetos_iniciacao_quantidade2);
		textViewValorProjetosIniciacao2 = (TextView) findViewById(R.id.textView_projetos_iniciacao_valor2);
		
		textViewTaxaDeAbandono2 = (TextView) findViewById(R.id.textView_taxa_abandono);
		textViewTaxaDeAproveitamento2  = (TextView) findViewById(R.id.textView_taxa_aprovacao); 
		textViewCenso2  = (TextView) findViewById(R.id.textView_censo);
		textViewMediaAlunosPorTurma2  = (TextView) findViewById(R.id.textView_media_alunos_por_turma);
		textViewMediaHorasAula2 = (TextView) findViewById(R.id.textView_horas_aula_ensino);
		textViewTaxaDistorcao2 = (TextView) findViewById(R.id.textView_taxa_distorcao);

		textViewCensoIniciaisFundamental2 = (TextView) findViewById(R.id.textView_censo_iniciais_fundamental2);
		textViewCensoFinaisFundamental2 = (TextView) findViewById(R.id.textView_censo_finais_fundamental2);
		textViewCensoMedio2 = (TextView) findViewById(R.id.textView_censo_medio2);
		textViewCensoEjaFundamental2 = (TextView) findViewById(R.id.textView_censo_fundamental_eja2);
		textViewCensoEjaMedio2 = (TextView) findViewById(R.id.textView_censo_medio_eja2);
		textViewMediaAlunosPorTurmaFundamental2 = (TextView) findViewById(R.id.textView_media_alunos_por_turma_fundamental2);
		textViewMediaAlunosPorTurmaMedio2 = (TextView) findViewById(R.id.textView_media_alunos_por_turma_medio2);
		textViewMediaHorasAulaFundamental2 = (TextView) findViewById(R.id.textView_horas_aula_ensino_fundamental2);
		textViewMediaHorasAulaMedio2 = (TextView) findViewById(R.id.textView_horas_aula_ensino_medio2);
		textViewTaxaDistorcaoIdadeSerieFundamental2 = (TextView) findViewById(R.id.textView_taxa_distorcao_fundamental2);
		textViewTaxaDistorcaoIdadeSerieMedio2 = (TextView) findViewById(R.id.textView_taxa_distorcao_medio2);
		textViewTaxaDeAproveitamentoFundamental2 = (TextView) findViewById(R.id.textView_taxa_aprovacao_fundamental2);
		textViewTaxaDeAproveitamentoMedio2 = (TextView) findViewById(R.id.textView_taxa_aprovacao_medio2);
		textViewTaxaDeAbandonoFundamental2 = (TextView) findViewById(R.id.textView_taxa_abandono_fundamental2);
		textViewTaxaDeAbandonoMedio2 = (TextView) findViewById(R.id.textView_taxa_abandono_medio2);
	}
	
	public void escondeCamposDeTexto() {
		int vPopulacao = (bPopulacao) ? View.VISIBLE : View.GONE;
		textViewPopulacao1.setVisibility(vPopulacao);
		
		try{
			textViewPopulacao2.setVisibility(vPopulacao);
		}catch(NullPointerException npe){
			Log.i("NullPointerException - textViewPopulacao2",npe.toString());
		}
		
		textViewPopulacaoValor1.setVisibility(vPopulacao);
		textViewPopulacaoValor2.setVisibility(vPopulacao);

		int vIdeb = (bIdeb) ? View.VISIBLE : View.GONE;
		textViewIdeb1.setVisibility(vIdeb);
		try{
			textViewIdeb2.setVisibility(vIdeb);
		}catch(NullPointerException npe){
			Log.i("NullPointerException - textViewIdeb2",npe.toString());
		}
		textViewFundamentalIdeb1.setVisibility(vIdeb);
		textViewEnsinoMedioIdeb1.setVisibility(vIdeb);
		textViewIniciaisIdeb1.setVisibility(vIdeb);
		textViewFundamentalIdeb2.setVisibility(vIdeb);
		textViewEnsinoMedioIdeb2.setVisibility(vIdeb);
		textViewIniciaisIdeb2.setVisibility(vIdeb);

		int vPib = (bPib) ? View.VISIBLE : View.GONE;
		textViewParticipacaoEstadualPib1.setVisibility(vPib);
		try{
			textViewParticipacaoEstadualPib2.setVisibility(vPib);
		}catch(NullPointerException npe){
			Log.i("NullPointerException - textViewIdeb2",npe.toString());
		}
		textViewParticipacaoPib1.setVisibility(vPib);
		textViewParticipacaoPib2.setVisibility(vPib);

		int vPrimeirosProjetos = (bPrimeirosProjetos) ? View.VISIBLE : View.GONE;
		textViewProgramaPrimeirosProjetos1.setVisibility(vPrimeirosProjetos);
		try{
			textViewProgramaPrimeirosProjetos2.setVisibility(vPrimeirosProjetos);
		}catch(NullPointerException npe){
			Log.i("NullPointerException - textViewProgramaPrimeirosProjetos2",npe.toString());
		}
		textViewQuantidadePrimeirosProjetos1.setVisibility(vPrimeirosProjetos);
		textViewValorPrimeirosProjetos1.setVisibility(vPrimeirosProjetos);
		textViewQuantidadePrimeirosProjetos2.setVisibility(vPrimeirosProjetos);
		textViewValorPrimeirosProjetos2.setVisibility(vPrimeirosProjetos);

		int vProjetosCnpq = (bProjetosCnpq) ? View.VISIBLE : View.GONE;
		textViewProjetosPesquisa1.setVisibility(vProjetosCnpq);
		try{
			textViewProjetosPesquisa2.setVisibility(vProjetosCnpq);
		}catch(NullPointerException npe){
			Log.i("NullPointerException - textViewProjetosPesquisa2",npe.toString());
		}
		textViewQuantidadePesquisa1.setVisibility(vProjetosCnpq);
		textViewValoresPesquisa1.setVisibility(vProjetosCnpq);
		textViewQuantidadePesquisa2.setVisibility(vProjetosCnpq);
		textViewValoresPesquisa2.setVisibility(vProjetosCnpq);

		int vProjetosJovens = (bProjetosJovens) ? View.VISIBLE : View.GONE;
		textViewJovensPesquisadores1.setVisibility(vProjetosJovens);
		try{
			textViewJovensPesquisadores2.setVisibility(vProjetosJovens);
		}catch(NullPointerException npe){
			Log.i("NullPointerException - textViewJovensPesquisadores2",npe.toString());
		}
		textViewQuantidadeJovensPesquisadores1.setVisibility(vProjetosJovens);
		textViewValorJovensPesquisadores1.setVisibility(vProjetosJovens);
		textViewQuantidadeJovensPesquisadores2.setVisibility(vProjetosJovens);
		textViewValorJovensPesquisadores2.setVisibility(vProjetosJovens);

		int vProjetosIniciacao = (bProjetosIniciacao) ? View.VISIBLE : View.GONE;
		textViewProjetosIniciacao1.setVisibility(vProjetosIniciacao);
		try{
			textViewProjetosIniciacao2.setVisibility(vProjetosIniciacao);
		}catch(NullPointerException npe){
			Log.i("NullPointerException - textViewProjetosIniciacao2",npe.toString());
		}	
		textViewQuantidadeProjetosIniciacao1.setVisibility(vProjetosIniciacao);
		textViewValorProjetosIniciacao1.setVisibility(vProjetosIniciacao);
		textViewQuantidadeProjetosIniciacao2.setVisibility(vProjetosIniciacao);
		textViewValorProjetosIniciacao2.setVisibility(vProjetosIniciacao);

		int vProjetosDifusao = (bProjetosDifusao) ? View.VISIBLE : View.GONE;
		textViewNumeroProjetos1.setVisibility(vProjetosDifusao);
		try{
			textViewNumeroProjetos2.setVisibility(vProjetosDifusao);
		}catch(NullPointerException npe){
			Log.i("NullPointerException - textViewNumeroProjetos2",npe.toString());
		}
		textViewQuantidadeProjetosCienciaTecnologia1.setVisibility(vProjetosDifusao);
		textViewValorProjetosCienciaTecnologia1.setVisibility(vProjetosDifusao);
		textViewQuantidadeProjetosCienciaTecnologia2.setVisibility(vProjetosDifusao);
		textViewValorProjetosCienciaTecnologia2.setVisibility(vProjetosDifusao);
		
		
		
		int vCenso = (bCenso) ? View.VISIBLE : View.GONE;
		textViewCenso1.setVisibility(vCenso);
		try{
			textViewCenso2.setVisibility(vCenso);
		}catch(NullPointerException npe){
			Log.i("NullPointerException - textViewCenso2",npe.toString());
		}
		textViewCensoEjaFundamental1.setVisibility(vCenso);
		textViewCensoEjaMedio1.setVisibility(vCenso);
		textViewCensoFinaisFundamental1.setVisibility(vCenso);
		textViewCensoIniciaisFundamental1.setVisibility(vCenso);
		textViewCensoMedio1.setVisibility(vCenso);
		textViewCensoEjaFundamental2.setVisibility(vCenso);
		textViewCensoEjaMedio2.setVisibility(vCenso);
		textViewCensoFinaisFundamental2.setVisibility(vCenso);
		textViewCensoIniciaisFundamental2.setVisibility(vCenso);
		textViewCensoMedio2.setVisibility(vCenso);
		
		int vAlunosTurma = (bAlunosTurma) ? View.VISIBLE : View.GONE;
		textViewMediaAlunosPorTurma1.setVisibility(vAlunosTurma);
		try{
			textViewMediaAlunosPorTurma2.setVisibility(vAlunosTurma);
		}catch(NullPointerException npe){
			Log.i("NullPointerException - textViewMediaAlunosPorTurma2",npe.toString());
		}
		textViewMediaAlunosPorTurmaFundamental1.setVisibility(vAlunosTurma);
		textViewMediaAlunosPorTurmaMedio1.setVisibility(vAlunosTurma);
		textViewMediaAlunosPorTurmaFundamental2.setVisibility(vAlunosTurma);
		textViewMediaAlunosPorTurmaMedio2.setVisibility(vAlunosTurma);
		
		
		int vHorasAula = (bHorasAula) ? View.VISIBLE : View.GONE;
		textViewMediaHorasAula1.setVisibility(vHorasAula);
		try{
			textViewMediaHorasAula2.setVisibility(vHorasAula);
		}catch(NullPointerException npe){
			Log.i("NullPointerException - textViewMediaHorasAula2",npe.toString());
		}
		textViewMediaHorasAulaFundamental1.setVisibility(vHorasAula);
		textViewMediaHorasAulaMedio1.setVisibility(vHorasAula);
		textViewMediaHorasAulaFundamental2.setVisibility(vHorasAula);
		textViewMediaHorasAulaMedio2.setVisibility(vHorasAula);
		
		
		int vTaxaDistorcao = (bTaxaDistorcao) ? View.VISIBLE : View.GONE;
		textViewTaxaDistorcao1.setVisibility(vTaxaDistorcao);
		try{
			textViewTaxaDistorcao2.setVisibility(vTaxaDistorcao);
		}catch(NullPointerException npe){
			Log.i("NullPointerException - textViewTaxaDistorcao2",npe.toString());
		}
		textViewTaxaDistorcaoIdadeSerieFundamental1.setVisibility(vTaxaDistorcao);
		textViewTaxaDistorcaoIdadeSerieMedio1.setVisibility(vTaxaDistorcao);
		textViewTaxaDistorcaoIdadeSerieFundamental2.setVisibility(vTaxaDistorcao);
		textViewTaxaDistorcaoIdadeSerieMedio2.setVisibility(vTaxaDistorcao);
		
		
		int vTaxaAbandono = (bTaxaAbandono) ? View.VISIBLE : View.GONE;
		textViewTaxaDeAbandono1.setVisibility(vTaxaAbandono);
		try{
			textViewTaxaDeAbandono2.setVisibility(vTaxaAbandono);
		}catch(NullPointerException npe){
			Log.i("NullPointerException - textViewTaxaDeAbandono2",npe.toString());
		}
		textViewTaxaDeAbandonoFundamental1.setVisibility(vTaxaAbandono);
		textViewTaxaDeAbandonoMedio1.setVisibility(vTaxaAbandono);
		textViewTaxaDeAbandonoFundamental2.setVisibility(vTaxaAbandono);
		textViewTaxaDeAbandonoMedio2.setVisibility(vTaxaAbandono);
		
		
		int vAprovacao = (bAprovacao) ? View.VISIBLE : View.GONE;
		textViewTaxaDeAproveitamento1.setVisibility(vAprovacao);
		try{
			textViewTaxaDeAproveitamento2.setVisibility(vAprovacao);
		}catch(NullPointerException npe){
			Log.i("NullPointerException - textViewTaxaDeAproveitamento2",npe.toString());
		}
		textViewTaxaDeAproveitamentoFundamental1.setVisibility(vAprovacao);
		textViewTaxaDeAproveitamentoMedio1.setVisibility(vAprovacao);
		textViewTaxaDeAproveitamentoFundamental2.setVisibility(vAprovacao);
		textViewTaxaDeAproveitamentoMedio2.setVisibility(vAprovacao);
						
	}
	
	public void clickBotaoGeraGrafico(View view) {
		Intent intent = new Intent(this, TelaEscolheIndicativoGrafico.class);
		Intent intent1 = getIntent();

		int posicao1 = intent1.getIntExtra("INDEX_ESTADO1_ESCOLHIDO", 0);
		int posicao2 = intent1.getIntExtra("INDEX_ESTADO2_ESCOLHIDO", 0);

		intent.putExtra("INDEX_ESTADO1_ESCOLHIDO", posicao1);
		intent.putExtra("INDEX_ESTADO2_ESCOLHIDO", posicao2);

		startActivity(intent);
	}	
}

