package com.mdsgpp.eef.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.echo.holographlibrary.Line;
import com.echo.holographlibrary.LineGraph;
import com.echo.holographlibrary.LinePoint;
import com.mdsgpp.eef.R;
import com.mdsgpp.eef.controller.StateController;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class GraphLineScreen extends Activity {

	private TextView tvGraphTitle;
	private TextView tvHistory;
	private ArrayList<Float> history = new ArrayList<Float>();
	private ArrayList<String> temp;
	private HashMap<String, String> informations;
	private String title, indicative;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_grafico_historico);
		
		initializesTextFields();
		capturesInformation();
		fillTextFields();
			
		generatesGraph();
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
				opensAboutScreen();
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
	private void capturesInformation() {
		int position;
		Intent intent;
		
		informations = new HashMap<String, String>();
		
		intent = getIntent();
		temp = intent.getStringArrayListExtra("HISTORICO");
		title = intent.getStringExtra("TITULO");
		indicative = intent.getStringExtra("INDICATIVO_GRAFICO");
		position = intent.getIntExtra("POSICAO_ESTADO", 0);
		
		for(int i = 0; i < temp.size(); i++) {
			history.add(Float.parseFloat(temp.get(i)));
		}
		
		try {
			informations = StateController.getInstance(this).readFullState(position);
		} catch(IOException e) {
			Log.i("Erro - TelaGraficoLinha", "Erro ao capturar as informacoes do estado.");
			e.printStackTrace();
		}	
	}
	
	// Change the activity to AboutGraphScreen activity.
	public void opensAboutScreen() {
		Intent intent = new Intent(this, ChartAboutScreen.class);
    	startActivity(intent);
	}
	
	// Assigns the class variables with the fields on the screen.
	private void initializesTextFields() {
		tvGraphTitle = (TextView) findViewById(R.id.text_view_titulo_grafico_historico);
		tvHistory = (TextView) findViewById(R.id.text_view_grafico_historico);
	}
	
	// Fills the screen fields with the information received.
	private void fillTextFields() {
		tvGraphTitle.setText(title);
		Log.i("teste_indicativo", indicative);
		Log.i("teste_indicativo", "" + informations.containsKey(indicative));
		tvHistory.setText(informations.get(indicative));
	}
	
	// Draw the chart on the screen.
	private void generatesGraph() {
		Line curve = new Line();
		
		for(int i = 0, step = 10; i < history.size(); i++, step += 10) {
			LinePoint point = new LinePoint();			
			point.setX(step);
			point.setY(history.get(i));

			curve.addPoint(point);
		}
		
		curve.setColor(Color.parseColor("#4682B4"));
		LineGraph li = (LineGraph) findViewById(R.id.graph);
		li.addLine(curve);
		
		float yLimit = 0;
		yLimit = calculatesHistoryMaxValue(yLimit);
		
		li.setRangeY(0, yLimit);
		li.setLineToFill(0);
	}
	
	// Calculate historical maximum value.
	private float calculatesHistoryMaxValue(float maximum) {
		for(int i = 0; i < history.size(); i++) {
			if(history.get(i) >= maximum) {
				maximum = (float) history.get(i);  
			}
			else {
				// Do nothing.
			}
		}
		
		return (float) (1.1 * maximum);
	}
}
