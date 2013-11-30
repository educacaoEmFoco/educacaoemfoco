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
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TelaEstado extends Activity {

	private TextView textViewSigla;	
	private TextView textViewNome;
	private TextView textViewPopulacao;
	private TextView textViewParticipacaoPib;
	private TextView textViewQuantidadeProjetosCienciaTecnologia;
	private TextView textViewValorProjetosCienciaTecnologia;
	private TextView textViewFundamentalIdeb;
	private TextView textViewEnsinoMedioIdeb;
	private TextView textViewIniciaisIdeb;
	private	TextView textViewQuantidadePrimeirosProjetos;
	private TextView textViewValorPrimeirosProjetos;
	private TextView textViewQuantidadePesquisa;
	private TextView textViewQuantidadeJovensPesquisadores;
	private TextView textViewValoresPesquisa;
	private TextView textViewValorJovensPesquisadores;
	private TextView textViewQuantidadeProjetosIniciacao;
	private TextView textViewValorProjetosIniciacao;
	private ImageView imageViewBandeiras;	
	private TextView textViewCensoIniciaisFundamental;
	private TextView textViewCensoFinaisFundamental;
	private TextView textViewCensoMedio;
	private TextView textViewCensoEjaFundamental;
	private TextView textViewCensoEjaMedio;
	private TextView textViewMediaAlunosPorTurmaFundamental;
	private TextView textViewMediaAlunosPorTurmaMedio;
	private TextView textViewMediaHorasAulaFundamental;
	private TextView textViewMediaHorasAulaMedio;
	private TextView textViewTaxaDistorcaoIdadeSerieFundamental;
	private TextView textViewTaxaDistorcaoIdadeSerieMedio;
	private TextView textViewTaxaDeAproveitamentoFundamental;
	private TextView textViewTaxaDeAproveitamentoMedio;
	private TextView textViewTaxaDeAbandonoFundamental;
	private TextView textViewTaxaDeAbandonoMedio;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_estado);
		
		capturaInformacoes();
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
			default:
				break;
			}
			
	    	return true;
	    }
	    
	    public void abreTelaSobre() {
	    	Intent intent = new Intent(this, TelaSobreEstado.class);
	    	startActivity(intent);
	    }
	
	private void capturaInformacoes() {
		Intent intent = getIntent();
		int posicao = intent.getIntExtra("INDEX_ESTADO_ESCOLHIDO", 0);	
		
		inicializaCamposTexto();
		
	    HashMap<String, String> informacoes = new HashMap <String, String>();
	    
	    try {
			informacoes = EstadoControle.getInstancia(this).lerEstado(posicao);
			preencheCamposTexto(informacoes);
			setImagem(posicao);
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(), "Houve um erro no acesso às informações.", Toast.LENGTH_SHORT).show();
			Log.i("IOException - TelaEstado", e.toString());
		}
	}
	
	private void inicializaCamposTexto() {
		
		textViewSigla = (TextView) findViewById(R.id.textView_sigla);
		textViewNome = (TextView) findViewById(R.id.textView_nome_estado);
		textViewPopulacao = (TextView) findViewById(R.id.textView_populacao_valor);
		textViewParticipacaoPib = (TextView) findViewById(R.id.textView_participacao_pib_valor);
		textViewQuantidadeProjetosCienciaTecnologia = (TextView) findViewById(R.id.textView_numero_projetos_quantidade);
		textViewValorProjetosCienciaTecnologia = (TextView) findViewById(R.id.textView_valor_investido_projetos);
		textViewFundamentalIdeb = (TextView) findViewById(R.id.textView_ideb_fundamental);
		textViewEnsinoMedioIdeb = (TextView) findViewById(R.id.textView_ideb_ensinomedio);
		textViewIniciaisIdeb = (TextView) findViewById(R.id.textView_ideb_iniciais);
		textViewQuantidadePrimeirosProjetos = (TextView) findViewById(R.id.textView_primeiros_projetos_quantidade);
		textViewValorPrimeirosProjetos = (TextView) findViewById(R.id.textView_programa_primeiros_projetos_valor);
		textViewQuantidadePesquisa = (TextView) findViewById(R.id.textView_projetos_pesquisa_quantidade);
		textViewValoresPesquisa = (TextView) findViewById(R.id.textView_valores_projeto_pesquisa);
		textViewQuantidadeJovensPesquisadores = (TextView) findViewById(R.id.textView_jovens_pesquisadores_quantidade);
		textViewValorJovensPesquisadores= (TextView) findViewById(R.id.textView_jovens_pesquisadores_valor);
		textViewQuantidadeProjetosIniciacao = (TextView) findViewById(R.id.textView_projetos_iniciacao_quantidade);
		textViewValorProjetosIniciacao = (TextView) findViewById(R.id.textView_projetos_iniciacao_valor);
		
		textViewCensoIniciaisFundamental = (TextView) findViewById(R.id.textView_censo_iniciais_fundamental);
		textViewCensoFinaisFundamental = (TextView) findViewById(R.id.textView_censo_finais_fundamental);
		textViewCensoMedio = (TextView) findViewById(R.id.textView_censo_medio);
		textViewCensoEjaFundamental = (TextView) findViewById(R.id.textView_censo_fundamental_eja);
		textViewCensoEjaMedio = (TextView) findViewById(R.id.textView_censo_medio_eja);
		textViewMediaAlunosPorTurmaFundamental = (TextView) findViewById(R.id.textView_media_alunos_por_turma_fundamental);
		textViewMediaAlunosPorTurmaMedio = (TextView) findViewById(R.id.textView_media_alunos_por_turma_medio);
		textViewMediaHorasAulaFundamental = (TextView) findViewById(R.id.textView_horas_aula_ensino_fundamental);
		textViewMediaHorasAulaMedio = (TextView) findViewById(R.id.textView_horas_aula_ensino_medio);
		textViewTaxaDistorcaoIdadeSerieFundamental = (TextView) findViewById(R.id.textView_taxa_distorcao_fundamental);
		textViewTaxaDistorcaoIdadeSerieMedio = (TextView) findViewById(R.id.textView_taxa_distorcao_medio);
		textViewTaxaDeAproveitamentoFundamental = (TextView) findViewById(R.id.textView_taxa_aprovacao_fundamental);
		textViewTaxaDeAproveitamentoMedio = (TextView) findViewById(R.id.textView_taxa_aprovacao_medio);
		textViewTaxaDeAbandonoFundamental = (TextView) findViewById(R.id.textView_taxa_abandono_fundamental);
		textViewTaxaDeAbandonoMedio = (TextView) findViewById(R.id.textView_taxa_abandono_medio);
	}
	
	private void preencheCamposTexto(HashMap<String, String> informacoes) {
		textViewSigla.setText(informacoes.get("sigla"));
		textViewNome.setText(informacoes.get("nome"));
		textViewPopulacao.setText(informacoes.get("populacao"));
		textViewParticipacaoPib.setText(informacoes.get("percentual_participacao_pib"));
		textViewQuantidadeProjetosCienciaTecnologia.setText(informacoes.get("projetos_ciencia_tecnologia"));
		textViewValorProjetosCienciaTecnologia.setText(informacoes.get("valor_ciencia_tecnologia"));
		textViewFundamentalIdeb.setText(informacoes.get("ideb_fundamental_final"));
		textViewEnsinoMedioIdeb.setText(informacoes.get("ideb_ensino_medio"));
		textViewIniciaisIdeb.setText(informacoes.get("ideb_fundamental_inicial"));
		textViewQuantidadePrimeirosProjetos.setText(informacoes.get("quantidade_primeiros_projetos"));
		textViewValorPrimeirosProjetos.setText(informacoes.get("valor_primeiros_projetos"));
	    textViewQuantidadePesquisa.setText(informacoes.get("quantidade_projeto_cnpq"));
		textViewValoresPesquisa.setText(informacoes.get("valor_projetos_cnpq"));
		textViewQuantidadeJovensPesquisadores.setText(informacoes.get("quantidade_projeto_jovens_pesquisadores"));
		textViewValorJovensPesquisadores.setText(informacoes.get("valor_projetos_jovens_pesquisadores"));
		textViewQuantidadeProjetosIniciacao.setText(informacoes.get("quantidade_projetos_inct"));
		textViewValorProjetosIniciacao.setText(informacoes.get("valor_projetos_inct"));
		
		textViewCensoIniciaisFundamental.setText(informacoes.get("censo_anos_iniciais_fundamental"));
		textViewCensoFinaisFundamental.setText(informacoes.get("censo_anos_finais_fundamental"));
		textViewCensoMedio.setText(informacoes.get("censo_ensino_medio"));
		textViewCensoEjaFundamental.setText(informacoes.get("censo_eja_fundamental"));
		textViewCensoEjaMedio.setText(informacoes.get("censo_eja_medio"));
		textViewMediaAlunosPorTurmaFundamental.setText(informacoes.get("alunos_por_turma_ensino_fundamental"));
		textViewMediaAlunosPorTurmaMedio.setText(informacoes.get("alunos_por_turma_ensino_medio"));
		textViewMediaHorasAulaFundamental.setText(informacoes.get("horas_aula_ensino_fundamental"));
		textViewMediaHorasAulaMedio.setText(informacoes.get("horas_aula_ensino_medio"));
		textViewTaxaDistorcaoIdadeSerieFundamental.setText(informacoes.get("taxa_distorcao_fundamental"));
		textViewTaxaDistorcaoIdadeSerieMedio.setText(informacoes.get("taxa_distorcao_medio"));
		textViewTaxaDeAproveitamentoFundamental.setText(informacoes.get("taxa_aprovacao_fundamental"));
		textViewTaxaDeAproveitamentoMedio.setText(informacoes.get("taxa_aprovacao_medio"));
		textViewTaxaDeAbandonoFundamental.setText(informacoes.get("taxa_aprovacao_fundamental"));
		textViewTaxaDeAbandonoMedio.setText(informacoes.get("taxa_aprovacao_medio"));
		
	}
	
	private void setImagem(int posicao) {
		String bandeiras[] = {"acre", "alagoas", "amapa", "amazonas", "bahia", 
				"ceara", "distritofederal", "espiritosanto", "goias", "maranhao",
				"matogrosso", "matogrossodosul", "minasgerais", "para", "paraiba",
				"parana", "pernambuco", "piaui", "riodejaneiro", "riograndedonorte",
				"riograndedosul", "rondonia", "roraima", "santacatarina", "saopaulo",
				"sergipe", "tocantins"};	
		
		imageViewBandeiras = (ImageView) findViewById(R.id.imageView_bandeiras);
		int idBandeira = getResources().getIdentifier(bandeiras[posicao], "drawable", getPackageName());
		imageViewBandeiras.setImageResource(idBandeira);
	}
	
	public void clickBotaoHisticoEstado(View view) {
		Intent intentAux = getIntent();
		int posicao = intentAux.getIntExtra("INDEX_ESTADO_ESCOLHIDO", 0);
		
		Intent intent = new Intent(this, TelaHistoricoEstado.class);
		intent.putExtra("ESTADO", posicao);
		
		startActivity(intent);
	}

}
