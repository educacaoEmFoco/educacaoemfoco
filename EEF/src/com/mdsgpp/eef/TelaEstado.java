package com.mdsgpp.eef;

import java.io.IOException;

import com.mdsgpp.eef.modelo.Estado;
import com.mdsgpp.eef.parse.DadosParse;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class TelaEstado extends Activity {

	String estados[] = {"Acre", "Alagoas", "Amapa", "Amazonas", "Bahia", 
			"Ceara", "Distrito Federal","Espirito Santo","Goias", "Maranhao",
			"Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Para", "Paraiba",
			"Parana", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte",
			"Rio Grande do Sul", "Rondonia", "Roraima", "Sao Paulo", "Santa Catarina",
			"Sergipe", "Tocantins"};
	
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
		
		DadosParse parser = new DadosParse(this);
		
		try {
			Estado estado = parser.getEstado(estados[posicao]);
			textViewSigla.setText(estado.getSigla());
			textViewNome.setText(estado.getNome());
			textViewPopulacao.setText(estado.getPopulacao()+"");
			textViewParticipacaoPib.setText(estado.getParticipacaoPercentualPIB()[estado.getParticipacaoPercentualPIB().length-1]+"%");
			textViewQuantidadeProjetos.setText(estado.getNumeroDeProjetosCienciaTecnologia()[estado.getNumeroDeProjetosCienciaTecnologia().length-1]+"");
			textViewValorProjetos.setText(estado.getValorInvestidoCienciaTecnologia()[estado.getValorInvestidoCienciaTecnologia().length-1]+"");
			textViewFundamentalIdeb.setText(estado.getIdebs()[estado.getIdebs().length-1].getFundamental()+"");
			textViewEnsinoMedioIdeb.setText(estado.getIdebs()[estado.getIdebs().length-1].getMedio()+"");
			textViewIniciaisIdeb.setText(estado.getIdebs()[estado.getIdebs().length-1].getSeriesIniciais()+"");
			textViewQuantidadePrimeirosProjetos.setText(estado.getPrimProj()[estado.getPrimProj().length-1].getQuantidade()+"");
			textViewValorPrimeirosProjetos.setText(estado.getPrimProj()[estado.getPrimProj().length-1].getValor()+"");
			textViewQuantidadePesquisa.setText(estado.getCnpq()[estado.getCnpq().length-1].getQuantidade()+"");
			textViewValoresPesquisa.setText(estado.getCnpq()[estado.getCnpq().length-1].getValor()+"");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
