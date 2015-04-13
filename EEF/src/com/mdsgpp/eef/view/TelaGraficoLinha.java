package com.mdsgpp.eef.visao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.echo.holographlibrary.Line;
import com.echo.holographlibrary.LineGraph;
import com.echo.holographlibrary.LinePoint;
import com.mdsgpp.eef.R;
import com.mdsgpp.eef.controle.EstadoControle;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class TelaGraficoLinha extends Activity {

	private TextView txtviewTituloGrafico;
	private TextView txtviewHistorico;
	private ArrayList<Float> historico = new ArrayList<Float>();
	private ArrayList<String> temp;
	private HashMap<String, String> informacoes;
	private String titulo, indicativo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_grafico_historico);
		
		inicializaCamposTexto();
		capturaInformacoes();
		preencheCamposDeTexto();
			
		plotarGrafico();
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
			// Do nothing.
			break;
		}
		
    	return true;
	}
	
	/* 
	* Takes the information from the previous activity to that, and fills the
	* Array historico with them.
	*/
	private void capturaInformacoes() {
		int posicao;
		Intent intent;
		
		informacoes = new HashMap<String, String>();
		
		intent = getIntent();
		temp = intent.getStringArrayListExtra("HISTORICO");
		titulo = intent.getStringExtra("TITULO");
		indicativo = intent.getStringExtra("INDICATIVO_GRAFICO");
		posicao = intent.getIntExtra("POSICAO_ESTADO", 0);
		
		for(int i=0; i<temp.size(); i++) {
			historico.add(Float.parseFloat(temp.get(i)));
		}
		
		try {
			informacoes = EstadoControle.getInstancia(this).lerEstadoCompleto
				(posicao);
		} catch (IOException e) {
			Log.i("Erro - TelaGraficoLinha", 
				"Erro ao capturar as informacoes do estado.");
			e.printStackTrace();
		}	
	}
	
	// Change the activity to TelaSobreGrafico activity.
	public void abreTelaSobre() {
		Intent intent = new Intent(this, TelaSobreGrafico.class);
    	startActivity(intent);
	}
	
	// Assigns the class variables with the fields on the screen.
	private void inicializaCamposTexto() {
		txtviewTituloGrafico = (TextView)
			findViewById(R.id.text_view_titulo_grafico_historico);
		txtviewHistorico = (TextView)
			findViewById(R.id.text_view_grafico_historico);
	}
	
	// Fills the screen fields with the information received.
	private void preencheCamposDeTexto() {
		txtviewTituloGrafico.setText(titulo);
		Log.i("teste_indicativo", indicativo);
		Log.i("teste_indicativo", ""+informacoes.containsKey(indicativo));
		txtviewHistorico.setText(informacoes.get(indicativo));
	}
	
	// Draw the chart on the screen.
	private void plotarGrafico() {
		Line curva = new Line();
		
		for(int i=0, passo=10; i<historico.size(); i++,passo+=10) {
			LinePoint ponto = new LinePoint();
			ponto.setX(passo);
			ponto.setY(historico.get(i));
			curva.addPoint(ponto);
		}
		
		curva.setColor(Color.parseColor("#4682B4"));
		LineGraph li = (LineGraph)findViewById(R.id.graph);
		li.addLine(curva);
		
		float yMaximo = 0;
		yMaximo = calculaValorMaximoHistorico(yMaximo);
		
		li.setRangeY(0, yMaximo);
		li.setLineToFill(0);
	}
	
	// Calculate historical maximum value.
	private float calculaValorMaximoHistorico(float maximo) {
		for(int i=0; i<historico.size(); i++) {
			if(historico.get(i) >= maximo){
				maximo = (float) historico.get(i);  
			}
			else {
				// Do nothing.
			}
		}
		
		return (float)(1.1*maximo);
	}
}
