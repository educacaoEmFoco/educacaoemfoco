package com.mdsgpp.eef.visao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import com.mdsgpp.eef.R;
import com.mdsgpp.eef.controle.EstadoControle;
import com.mdsgpp.eef.modelo.Estado;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class TelaGraficoLinha extends Activity {

	private int posicao;
	private String titulo;
	private String indicativo;
	private TextView tituloGrafico;
	private float valorIndicativoEstado1;
	private Estado estado=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_grafico_historico);
		Intent intent = getIntent();
		int posicao = intent.getIntExtra("INDEX_ESTADO_ESCOLHIDO", 0);
		try {
			estado = (Estado) EstadoControle
					.getInstancia(this).obterEstado(posicao);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i=0; i<estado.getProjetosApoioCnpq().length; i++)
			Log.i("TESTE GRAFICO", ""+estado.getProjetosApoioCnpq()[i].getValor());
		capturaInformacoes();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_telas_sem_sobre, menu);
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
	
	@SuppressWarnings({"unchecked"})
	private void capturaInformacoes() {
		inicializaCamposTexto();
		
		// Captura o intent que abriu a activity
		Intent intent = getIntent();
		// Captura o valor transferido atravÃ©s da intent
		posicao = intent.getIntExtra("INDEX_ESTADO_ESCOLHIDO", 0);
		titulo = intent.getStringExtra("TITULO");
		indicativo = intent.getStringExtra("INDICATIVO");

		HashMap<String, String> informacoesEstado1 = new HashMap<String, String>();
		HashMap<String, String> informacoesEstado2 = new HashMap<String, String>();

		try {
			informacoesEstado1 = (HashMap<String, String>) EstadoControle
					.getInstancia(this).lerEstado(posicao).clone();
			
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(), "Houve um erro no acesso às informações.", Toast.LENGTH_SHORT).show();
			Log.i("IOException - TelaComparaEstados",e.toString());
		}
	}
	

	private void inicializaCamposTexto() {
		tituloGrafico = (TextView) findViewById(R.id.text_view_titulo_grafico_historico);		
	}
}
