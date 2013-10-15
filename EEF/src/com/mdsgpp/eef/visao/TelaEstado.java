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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_estado);
		
		capturaInformacoes();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_estado, menu);
		return true;
	}
	
	private void capturaInformacoes() {
		Intent intent = getIntent();
		int posicao = intent.getIntExtra("INDEX_ESTADO_ESCOLHIDO", 0);	
		
		InicializaCamposTexto();
		
	    HashMap<String, String> informacoes = new HashMap <String, String>();
	    
	    try {
			informacoes = EstadoControle.getInstancia(this).getInformacoesEstado(posicao);
			preencheCamposTexto(informacoes);
			setImagem(posicao);
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(), "Houve um erro no acesso às informações.", Toast.LENGTH_SHORT).show();
			Log.i("IOException - TelaEstado", e.toString());
		}
	}
	
	private void InicializaCamposTexto() {
		
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
