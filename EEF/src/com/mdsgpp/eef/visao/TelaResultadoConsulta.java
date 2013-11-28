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
	
	private boolean  bCenso, bAlunosTurma, bHorasAula, bTaxaDistorcao, bTaxaAbandono, 
			bAprovacao, bIdeb, bPib, bPopulacao, bPrimeirosProjetos, bProjetosCnpq,
			bProjetosDifusao, bProjetosIniciacao, bProjetosJovens;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_compara_estados);
		
		InicializaCamposTexto();
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
		textViewParticipacaoPib1.setText(informacoes1.get("percentual_participacao_pib"));
		textViewQuantidadeProjetosCienciaTecnologia1.setText(informacoes1.get("projetos_ciencia_tecnologia"));
		textViewValorProjetosCienciaTecnologia1.setText(informacoes1.get("valor_ciencia_tecnologia"));
		textViewFundamentalIdeb1.setText(informacoes1.get("ideb_fundamental_final"));
		textViewEnsinoMedioIdeb1.setText(informacoes1.get("ideb_ensino_medio"));
		textViewIniciaisIdeb1.setText(informacoes1.get("ideb_fundamental_inicial"));
		textViewQuantidadePrimeirosProjetos1.setText(informacoes1.get("quantidade_primeiros_projetos"));
		textViewValorPrimeirosProjetos1.setText(informacoes1.get("valor_primeiros_projetos"));
		textViewQuantidadePesquisa1.setText(informacoes1.get("quantidade_projeto_cnpq"));
		textViewValoresPesquisa1.setText(informacoes1.get("valor_projetos_cnpq"));
		textViewQuantidadeJovensPesquisadores1.setText(informacoes1.get("quantidade_projeto_jovens_pesquisadores"));
		textViewValorJovensPesquisadores1.setText(informacoes1.get("valor_projetos_jovens_pesquisadores"));
		textViewQuantidadeProjetosIniciacao1.setText(informacoes1.get("quantidade_projetos_inct"));
		textViewValorProjetosIniciacao1.setText(informacoes1.get("valor_projetos_inct"));
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
		textViewParticipacaoPib2.setText(informacoes2.get("percentual_participacao_pib"));
		textViewQuantidadeProjetosCienciaTecnologia2.setText(informacoes2.get("projetos_ciencia_tecnologia").split(":")[1]);
		textViewValorProjetosCienciaTecnologia2.setText(informacoes2.get("valor_ciencia_tecnologia").split(":")[1]);
		textViewFundamentalIdeb2.setText(informacoes2.get("ideb_fundamental_final").split(":")[1]);
		textViewEnsinoMedioIdeb2.setText(informacoes2.get("ideb_ensino_medio").split(":")[1]);
		textViewIniciaisIdeb2.setText(informacoes2.get("ideb_fundamental_inicial").split(":")[1]);
		textViewQuantidadePrimeirosProjetos2.setText(informacoes2.get("quantidade_primeiros_projetos").split(":")[1]);
		textViewValorPrimeirosProjetos2.setText(informacoes2.get("valor_primeiros_projetos").split(":")[1]);
		textViewQuantidadePesquisa2.setText(informacoes2.get("quantidade_projeto_cnpq").split(":")[1]);
		textViewValoresPesquisa2.setText(informacoes2.get("valor_projetos_cnpq").split(":")[1]);
		textViewQuantidadeJovensPesquisadores2.setText(informacoes2.get("quantidade_projeto_jovens_pesquisadores").split(":")[1]);
		textViewValorJovensPesquisadores2.setText(informacoes2.get("valor_projetos_jovens_pesquisadores").split(":")[1]);
		textViewQuantidadeProjetosIniciacao2.setText(informacoes2.get("quantidade_projetos_inct").split(":")[1]);
		textViewValorProjetosIniciacao2.setText(informacoes2.get("valor_projetos_inct").split(":")[1]);
		textViewCensoIniciaisFundamental2.setText(informacoes2.get("censo_anos_iniciais_fundamental").split(":")[1]);
		textViewCensoFinaisFundamental2.setText(informacoes2.get("censo_anos_finais_fundamental").split(":")[1]);
		textViewCensoMedio2.setText(informacoes2.get("censo_ensino_medio").split(":")[1]);
		textViewCensoEjaFundamental2.setText(informacoes2.get("censo_eja_fundamental").split(":")[1]);
		textViewCensoEjaMedio2.setText(informacoes2.get("censo_eja_medio").split(":")[1]);
		textViewMediaAlunosPorTurmaFundamental2.setText(informacoes2.get("alunos_por_turma_ensino_fundamental").split(":")[1]);
		textViewMediaAlunosPorTurmaMedio2.setText(informacoes2.get("alunos_por_turma_ensino_medio").split(":")[1]);
		textViewMediaHorasAulaFundamental2.setText(informacoes2.get("horas_aula_ensino_fundamental").split(":")[1]);
		textViewMediaHorasAulaMedio2.setText(informacoes2.get("horas_aula_ensino_medio").split(":")[1]);
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
		textViewJovensPesquisadores2 = (TextView) findViewById(R.id.textView_jovens_pesquisadores2);
		textViewQuantidadeJovensPesquisadores2 = (TextView) findViewById(R.id.textView_jovens_pesquisadores_quantidade2);
		textViewValorJovensPesquisadores2 = (TextView) findViewById(R.id.textView_jovens_pesquisadores_valor2);
		textViewProjetosIniciacao2 = (TextView) findViewById(R.id.textView_projetos_iniciacao2);
		textViewQuantidadeProjetosIniciacao2 = (TextView) findViewById(R.id.textView_projetos_iniciacao_quantidade2);
		textViewValorProjetosIniciacao2 = (TextView) findViewById(R.id.textView_projetos_iniciacao_valor2);
		
		textViewTaxaDeAbandono2 = (TextView) findViewById(R.id.textView_taxa_abandono2);
		textViewTaxaDeAproveitamento2  = (TextView) findViewById(R.id.textView_taxa_aprovacao2); 
		textViewCenso2  = (TextView) findViewById(R.id.textView_censo2);
		textViewMediaAlunosPorTurma2  = (TextView) findViewById(R.id.textView_media_alunos_por_turma2);
		textViewMediaHorasAula2 = (TextView) findViewById(R.id.textView_horas_aula_ensino2);
		textViewTaxaDistorcao2 = (TextView) findViewById(R.id.textView_taxa_distorcao2);

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
	
	public void setVisibility(TextView txtView, boolean visibilidade) {
		int valorVisibilidade = (visibilidade) ? View.VISIBLE : View.GONE;
		txtView.setVisibility(valorVisibilidade);
	}
	
	public void escondeCamposDeTexto() {
		setVisibility(textViewPopulacao1, bPopulacao);
		setVisibility(textViewPopulacaoValor1, bPopulacao);
		setVisibility(textViewPopulacaoValor2, bPopulacao);
		
		setVisibility(textViewIdeb1, bIdeb);
		setVisibility(textViewFundamentalIdeb1, bIdeb);
		setVisibility(textViewEnsinoMedioIdeb1, bIdeb);
		setVisibility(textViewIniciaisIdeb1, bIdeb);
		setVisibility(textViewFundamentalIdeb2, bIdeb);
		setVisibility(textViewEnsinoMedioIdeb2, bIdeb);
		setVisibility(textViewIniciaisIdeb2, bIdeb);

		setVisibility(textViewParticipacaoEstadualPib1, bPib);
		setVisibility(textViewParticipacaoPib1, bPib);
		setVisibility(textViewParticipacaoPib2, bPib);
		
		setVisibility(textViewProgramaPrimeirosProjetos1, bPrimeirosProjetos);
		setVisibility(textViewQuantidadePrimeirosProjetos1, bPrimeirosProjetos);
		setVisibility(textViewValorPrimeirosProjetos1, bPrimeirosProjetos);
		setVisibility(textViewQuantidadePrimeirosProjetos2, bPrimeirosProjetos);
		setVisibility(textViewValorPrimeirosProjetos2, bPrimeirosProjetos);
		
		setVisibility(textViewProjetosPesquisa1, bProjetosCnpq);
		setVisibility(textViewQuantidadePesquisa1, bProjetosCnpq);
		setVisibility(textViewValoresPesquisa1, bProjetosCnpq);
		setVisibility(textViewQuantidadePesquisa2, bProjetosCnpq);
		setVisibility(textViewValoresPesquisa2, bProjetosCnpq);

		setVisibility(textViewJovensPesquisadores1, bProjetosJovens);
		setVisibility(textViewQuantidadeJovensPesquisadores1, bProjetosJovens);
		setVisibility(textViewValorJovensPesquisadores1, bProjetosJovens);
		setVisibility(textViewQuantidadeJovensPesquisadores2, bProjetosJovens);
		setVisibility(textViewValorJovensPesquisadores2, bProjetosJovens);

		setVisibility(textViewProjetosIniciacao1, bProjetosIniciacao);
		setVisibility(textViewQuantidadeProjetosIniciacao1, bProjetosIniciacao);
		setVisibility(textViewValorProjetosIniciacao1, bProjetosIniciacao);
		setVisibility(textViewQuantidadeProjetosIniciacao2, bProjetosIniciacao);
		setVisibility(textViewValorProjetosIniciacao2, bProjetosIniciacao);

		setVisibility(textViewNumeroProjetos1, bProjetosDifusao);
		setVisibility(textViewQuantidadeProjetosCienciaTecnologia1, bProjetosDifusao);
		setVisibility(textViewValorProjetosCienciaTecnologia1, bProjetosDifusao);
		setVisibility(textViewQuantidadeProjetosCienciaTecnologia2, bProjetosDifusao);
		setVisibility(textViewValorProjetosCienciaTecnologia2, bProjetosDifusao);
		
		setVisibility(textViewCenso1, bCenso);
		setVisibility(textViewCensoEjaFundamental1, bCenso);
		setVisibility(textViewCensoEjaMedio1, bCenso);
		setVisibility(textViewCensoFinaisFundamental1, bCenso);
		setVisibility(textViewCensoIniciaisFundamental1, bCenso);
		setVisibility(textViewCensoMedio1, bCenso);
		setVisibility(textViewCensoEjaFundamental2, bCenso);
		setVisibility(textViewCensoEjaMedio2, bCenso);
		setVisibility(textViewCensoFinaisFundamental2, bCenso);
		setVisibility(textViewCensoIniciaisFundamental2, bCenso);
		setVisibility(textViewCensoMedio2, bCenso);
		
		setVisibility(textViewMediaAlunosPorTurma1, bAlunosTurma);
		setVisibility(textViewMediaAlunosPorTurmaFundamental1, bAlunosTurma);
		setVisibility(textViewMediaAlunosPorTurmaMedio1, bAlunosTurma);
		setVisibility(textViewMediaAlunosPorTurmaFundamental2, bAlunosTurma);
		setVisibility(textViewMediaAlunosPorTurmaMedio2, bAlunosTurma);
		
		setVisibility(textViewMediaHorasAula1, bHorasAula);
		setVisibility(textViewMediaHorasAulaFundamental1, bHorasAula);
		setVisibility(textViewMediaHorasAulaMedio1, bHorasAula);
		setVisibility(textViewMediaHorasAulaFundamental2, bHorasAula);
		setVisibility(textViewMediaHorasAulaMedio2, bHorasAula);
		
		setVisibility(textViewTaxaDistorcao1, bTaxaDistorcao);
		setVisibility(textViewTaxaDistorcaoIdadeSerieFundamental1, bTaxaDistorcao);
		setVisibility(textViewTaxaDistorcaoIdadeSerieMedio1, bTaxaDistorcao);
		setVisibility(textViewTaxaDistorcaoIdadeSerieFundamental2, bTaxaDistorcao);
		setVisibility(textViewTaxaDistorcaoIdadeSerieMedio2, bTaxaDistorcao);
		
		setVisibility(textViewTaxaDeAbandono1, bTaxaAbandono);
		setVisibility(textViewTaxaDeAbandonoFundamental1, bTaxaAbandono);
		setVisibility(textViewTaxaDeAbandonoMedio1, bTaxaAbandono);
		setVisibility(textViewTaxaDeAbandonoFundamental2, bTaxaAbandono);
		setVisibility(textViewTaxaDeAbandonoMedio2, bTaxaAbandono);
		
		setVisibility(textViewTaxaDeAproveitamento1, bAprovacao);
		setVisibility(textViewTaxaDeAproveitamentoFundamental1, bAprovacao);
		setVisibility(textViewTaxaDeAproveitamentoMedio1, bAprovacao);
		setVisibility(textViewTaxaDeAproveitamentoFundamental2, bAprovacao);
		setVisibility(textViewTaxaDeAproveitamentoMedio2, bAprovacao);
		
		try {
			Log.i("teste visibility", "populacao");
			setVisibility(textViewPopulacao2, bPopulacao);
			Log.i("teste visibility", "ideb");
			setVisibility(textViewIdeb2, bIdeb);
			Log.i("teste visibility", "participacao");
			setVisibility(textViewParticipacaoEstadualPib2, bPib);
			Log.i("teste visibility", "primeiros projetos");
			setVisibility(textViewProgramaPrimeirosProjetos2, bPrimeirosProjetos);
			Log.i("teste visibility", "cnpq");
			setVisibility(textViewProjetosPesquisa2, bProjetosCnpq);
			Log.i("teste visibility", "jovens");
			setVisibility(textViewJovensPesquisadores2, bProjetosJovens);
			Log.i("teste visibility", "inct");
			setVisibility(textViewProjetosIniciacao2, bProjetosIniciacao);
			setVisibility(textViewNumeroProjetos2, bProjetosDifusao);
			setVisibility(textViewCenso2, bCenso);
			setVisibility(textViewMediaAlunosPorTurma2, bAlunosTurma);
			setVisibility(textViewMediaHorasAula2, bHorasAula);
			setVisibility(textViewTaxaDistorcao2, bTaxaDistorcao);
			setVisibility(textViewTaxaDeAbandono2, bTaxaAbandono);
			setVisibility(textViewTaxaDeAproveitamento2, bAprovacao);
		} catch(NullPointerException npe) {
			Log.i("NullPointerException - layout portrait não possui estes id's",npe.toString());
		}
						
	}
	
	public void clickBotaoGeraGrafico(View view) {
		Intent intent = new Intent(this, TelaEscolheIndicativoGrafico.class);
		Intent intent1 = getIntent();

		int posicao1 = intent1.getIntExtra("INDEX_ESTADO1_ESCOLHIDO", 0);
		int posicao2 = intent1.getIntExtra("INDEX_ESTADO2_ESCOLHIDO", 0);

		intent.putExtra("CB_IDEB", bIdeb);
		intent.putExtra("CB_PIB", bPib);
		intent.putExtra("CB_POPULACAO", bPopulacao);
		intent.putExtra("CB_PRIMEIROS_PROJETOS", bPrimeirosProjetos);
		intent.putExtra("CB_PROJETOS_CNPQ", bProjetosCnpq);
		intent.putExtra("CB_PROJETOS_DIFUSAO", bProjetosDifusao);
		intent.putExtra("CB_PROJETOS_INICIACAO", bProjetosIniciacao);
		intent.putExtra("CB_PROJETOS_JOVENS", bProjetosJovens);
		intent.putExtra("CB_ALUNOS_TURMA", bAlunosTurma);
		intent.putExtra("CB_APROVACAO", bAprovacao);
		intent.putExtra("CB_CENSO", bCenso);
		intent.putExtra("CB_HORAS_AULA", bHorasAula);
		intent.putExtra("CB_TAXA_ABANDONO", bTaxaAbandono);
		intent.putExtra("CB_TAXA_DISTORCAO", bTaxaDistorcao);
		
		intent.putExtra("INDEX_ESTADO1_ESCOLHIDO", posicao1);
		intent.putExtra("INDEX_ESTADO2_ESCOLHIDO", posicao2);

		startActivity(intent);
	}	
}

