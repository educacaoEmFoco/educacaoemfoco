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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class TelaGraficoLinha extends Activity {

	private TextView tituloGrafico;
	private ArrayList<Float> historico = new ArrayList<Float>();
	private ArrayList<String> temp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_grafico_historico);
		inicializaCamposTexto();
		
		Intent intent = getIntent();
		temp = intent.getStringArrayListExtra("HISTORICO");
		
		Log.i("Tamanho temp", temp.size()+"");
		for(int i=0; i<temp.size(); i++)
			historico.add(Float.parseFloat(temp.get(i)));
		Log.i("Tamanho historico", historico.size()+"");
			
		plotarGrafico();
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_telas_sem_sobre, menu);
		return true;
	}
	

	private void inicializaCamposTexto() {
		tituloGrafico = (TextView) findViewById(R.id.text_view_titulo_grafico_historico);		
	}
	
	private void plotarGrafico() {
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
		yMaximo = calculaMaximo(yMaximo);
		
		li.setRangeY(0, yMaximo);
		li.setLineToFill(0);
	}



	private float calculaMaximo(float maximo) {
		for(int i=0; i<historico.size(); i++){
			if(historico.get(i) > maximo)
				maximo = (float) (historico.get(i) + historico.get(i) * 0.1);  
		}
		return maximo;
	}
}
