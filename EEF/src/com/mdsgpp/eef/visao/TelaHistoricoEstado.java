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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TelaHistoricoEstado extends Activity {
	HashMap<String, String> informacoes;
	private TextView textViewSigla;	
	private TextView textViewNome;
	private TextView textViewPopulacao;
	private TextView textViewParticipacaoPib;
	private TextView textViewQuantidadeProjetosCienciaTecnologia;
	private TextView textViewIdebs;
	private	TextView textViewPrimeirosProjetos;
	private TextView textViewValoresPesquisa;
	private TextView textViewValorJovensPesquisadores;
	private TextView textViewValorProjetosIniciacao;
	private ImageView imageViewBandeiras;	
	private TextView textViewCensoIniciaisFundamental;
	private TextView textViewCensoFinaisFundamental;
	private TextView textViewCensoMedio;
	private TextView textViewCensoEjaFundamental;
	private TextView textViewCensoEjaMedio;
	private TextView textViewMediaAlunosPorTurmaValor;
	private TextView textViewMediaHorasAulaFundamental;
	private TextView textViewMediaHorasAulaMedio;
	private TextView textViewTaxaDistorcaoIdadeSerieValor;
	private TextView textViewTaxaDeAproveitamentoValor;
	private TextView textViewTaxaDeAbandonoValor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_historico_estado);
		
		capturaInformacoes();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_historico_estado, menu);
		return true;
	}
	
	private void capturaInformacoes() {
		Intent intent = getIntent();
		
		int posicao = intent.getIntExtra("ESTADO", 0);
		informacoes = new HashMap <String, String>();
		
		inicializaCamposTexto();
		
		try {
			
			informacoes = EstadoControle.getInstancia(this).lerEstadoCompleto(posicao);
			preencheCamposTexto(informacoes);
			setImagem(posicao);
			
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(), "Houve um erro no acesso às informações.", Toast.LENGTH_SHORT).show();
			Log.i("IOException - TelaHistoricoEstado", e.toString());
		}
	}

	private void inicializaCamposTexto() {
		
		textViewSigla = (TextView) findViewById(R.id.textView_sigla);
		textViewNome = (TextView) findViewById(R.id.textView_nome_estado);
		textViewPopulacao = (TextView) findViewById(R.id.textView_populacao_valor);
		textViewParticipacaoPib = (TextView) findViewById(R.id.textView_participacao_pib_valor);
		textViewQuantidadeProjetosCienciaTecnologia = (TextView) findViewById(R.id.textView_numero_projetos_quantidade);
		textViewIdebs = (TextView) findViewById(R.id.textView_idebs);
		textViewPrimeirosProjetos = (TextView) findViewById(R.id.textView_primeiros_projetos);
		textViewValoresPesquisa = (TextView) findViewById(R.id.textView_valores_projeto_pesquisa);
		textViewValorJovensPesquisadores= (TextView) findViewById(R.id.textView_jovens_pesquisadores_valor);
		textViewValorProjetosIniciacao = (TextView) findViewById(R.id.textView_projetos_iniciacao_valor);
		
		textViewCensoIniciaisFundamental = (TextView) findViewById(R.id.textView_censo_iniciais_fundamental);
		textViewCensoFinaisFundamental = (TextView) findViewById(R.id.textView_censo_finais_fundamental);
		textViewCensoMedio = (TextView) findViewById(R.id.textView_censo_medio);
		textViewCensoEjaFundamental = (TextView) findViewById(R.id.textView_censo_fundamental_eja);
		textViewCensoEjaMedio = (TextView) findViewById(R.id.textView_censo_medio_eja);
		textViewMediaAlunosPorTurmaValor = (TextView) findViewById(R.id.textView_media_alunos_por_turma_valor);
		textViewMediaHorasAulaFundamental = (TextView) findViewById(R.id.textView_horas_aula_ensino_fundamental);
		textViewMediaHorasAulaMedio = (TextView) findViewById(R.id.textView_horas_aula_ensino_medio);
		textViewTaxaDistorcaoIdadeSerieValor = (TextView) findViewById(R.id.textView_taxa_distorcao_valor);
		textViewTaxaDeAproveitamentoValor = (TextView) findViewById(R.id.textView_taxa_aprovacao_valor);
		textViewTaxaDeAbandonoValor = (TextView) findViewById(R.id.textView_taxa_abandono_valor);
	}
	
	private void preencheCamposTexto(HashMap<String, String> informacoes) {
		textViewSigla.setText(informacoes.get("sigla"));
		textViewNome.setText(informacoes.get("nome"));
		textViewPopulacao.setText(informacoes.get("populacao"));
		textViewParticipacaoPib.setText(informacoes.get("percentual_participacao_pib"));
		textViewQuantidadeProjetosCienciaTecnologia.setText(informacoes.get("projetos_ciencia_tecnologia"));
		textViewIdebs.setText(informacoes.get("ideb"));
		textViewPrimeirosProjetos.setText(informacoes.get("primeiros_projetos"));
		textViewValoresPesquisa.setText(informacoes.get("cnpq"));
		textViewValorJovensPesquisadores.setText(informacoes.get("jovens_pesquisadores"));
		textViewValorProjetosIniciacao.setText(informacoes.get("projetos_inct"));
		
		textViewMediaAlunosPorTurmaValor.setText(informacoes.get("alunos_por_turma_ensino_medio"));
		textViewCensoIniciaisFundamental.setText(informacoes.get("censo_anos_iniciais_fundamental"));
		textViewCensoFinaisFundamental.setText(informacoes.get("censo_anos_finais_fundamental"));
		textViewCensoMedio.setText(informacoes.get("censo_ensino_medio"));
		textViewCensoEjaFundamental.setText(informacoes.get("censo_eja_fundamental"));
		textViewCensoEjaMedio.setText(informacoes.get("censo_eja_medio"));
		textViewMediaHorasAulaFundamental.setText(informacoes.get("horas_aula_ensino_fundamental"));
		textViewMediaHorasAulaMedio.setText(informacoes.get("horas_aula_ensino_medio"));
		textViewTaxaDistorcaoIdadeSerieValor.setText(informacoes.get("taxa_distorcao"));
		textViewTaxaDeAproveitamentoValor.setText(informacoes.get("taxa_aprovacao"));
		textViewTaxaDeAbandonoValor.setText(informacoes.get("taxa_abandono"));
		
	}
	
	private void setImagem(int posicao) {
		// O nome das bandeiras tá sem acento
		// A slução que eu acho mais simples é ter um array com os nomes dos estados sem acento, e pegar o nome certo pela posicao
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

}
