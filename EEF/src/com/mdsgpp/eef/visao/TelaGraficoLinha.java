package com.mdsgpp.eef.visao;

import java.util.ArrayList;

import com.echo.holographlibrary.Line;
import com.echo.holographlibrary.LineGraph;
import com.echo.holographlibrary.LinePoint;
import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class TelaGraficoLinha extends Activity {

	private TextView tituloGrafico;
	private ArrayList<Float> historico = new ArrayList<Float>();
	private ArrayList<String> temp;
	private String titulo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_grafico_historico);
		
		inicializaCamposTexto();
		
		Intent intent = getIntent();
		temp = intent.getStringArrayListExtra("HISTORICO");
		titulo = intent.getStringExtra("TITULO");
		tituloGrafico.setText(titulo);
		
		for(int i=0; i<temp.size(); i++)
			historico.add(Float.parseFloat(temp.get(i)));
			
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
			break;
		}
		
    	return true;
	}
	
	public void abreTelaSobre() {
		Intent intent = new Intent(this, TelaSobreGrafico.class);
    	startActivity(intent);
	}
	

	private void inicializaCamposTexto() {
		tituloGrafico = (TextView) findViewById(R.id.text_view_titulo_grafico_historico);		
	}
	
	private void plotarGrafico() {
		tituloGrafico.setText(titulo);
		
		Line curva = new Line();
		
		for(int i=0, passo=10; i<historico.size(); i++,passo+=10){
			LinePoint ponto = new LinePoint();
			ponto.setX(passo);
			ponto.setY(historico.get(i));
			curva.addPoint(ponto);
		}
		curva.setColor(Color.parseColor("#4682B4"));
		LineGraph li = (LineGraph)findViewById(R.id.graph);
		li.addLine(curva);
		
		float yMaximo=0;
		yMaximo = calculaValorMaximoHistorico(yMaximo);
		
		li.setRangeY(0, yMaximo);
		li.setLineToFill(0);
	}



	private float calculaValorMaximoHistorico(float maximo) {
		for(int i=0; i<historico.size(); i++){
			if(historico.get(i) > maximo)
				maximo = (float) (historico.get(i) + historico.get(i) * 0.1);  
		}
		return maximo;
	}
}
