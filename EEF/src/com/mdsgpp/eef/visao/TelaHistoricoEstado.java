package com.mdsgpp.eef.visao;

import java.io.IOException;
import java.util.HashMap;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.controle.EstadoControle;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
	private TextView textViewCensoValor;
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
		
		textViewCensoValor = (TextView) findViewById(R.id.textView_censo_medio_valor);
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
		textViewCensoValor.setText(informacoes.get("censo"));
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
	
    public void clickBotaoEscolherIndicativoParaGerarGrafico(View view){
		Intent intent1 = getIntent();
		
		int posicao = intent1.getIntExtra("ESTADO", 0);
		
    	Intent intent = new Intent(this, TelaEscolheIndicativoGraficoLinha.class);
    	intent.putExtra("ESTADO", posicao);
    	
		intent.putExtra("CB_IDEB", true);
		intent.putExtra("CB_PIB", true);
		intent.putExtra("CB_POPULACAO", true);
		intent.putExtra("CB_PRIMEIROS_PROJETOS", true);
		intent.putExtra("CB_PROJETOS_CNPQ", true);
		intent.putExtra("CB_PROJETOS_DIFUSAO", true);
		intent.putExtra("CB_PROJETOS_INICIACAO", true);
		intent.putExtra("CB_PROJETOS_JOVENS", true);
		intent.putExtra("CB_ALUNOS_TURMA", true);
		intent.putExtra("CB_APROVACAO",true);
		intent.putExtra("CB_CENSO", true);
		intent.putExtra("CB_HORAS_AULA", true);
		intent.putExtra("CB_TAXA_ABANDONO", true);
		intent.putExtra("CB_TAXA_DISTORCAO", true);
		
		startActivity(intent);
    }

}
