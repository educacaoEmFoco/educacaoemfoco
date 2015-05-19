/**************************************************************************
 * File: GraphLineScreen.java
 *
 * Purpose: Generate a line graph based on the history of indicative values
 **************************************************************************/

package com.mdsgpp.eef.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.echo.holographlibrary.Line;
import com.echo.holographlibrary.LineGraph;
import com.echo.holographlibrary.LinePoint;
import com.mdsgpp.eef.R;
import com.mdsgpp.eef.controller.StateController;
import com.mdsgpp.eef.debug.Debug;

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

	private TextView textViewGraphTitle;
	private TextView textViewHistory;
	private ArrayList<Float> history = new ArrayList<Float>();
	private ArrayList<String> indicativeList = null;
	private HashMap<String, String> informations;
	private String title = null;
	private String indicative = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_grafico_historico);

		initializeTextFields();
		captureInformation();
		fillTextFields();

		generateGraph();
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
				Debug.log("GraphLineScreen - onOptionsItemSelected()", "item click detected!",
					Debug.INFO);
				
				openAboutScreen();
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
	* Array history with them.
	*/
	private void captureInformation() {
		int position = 0;
		Intent intent;

		informations = new HashMap<String, String>();

		intent = getIntent();
		this.indicativeList = intent.getStringArrayListExtra("HISTORICO");
		this.title = intent.getStringExtra("TITULO");
		this.indicative = intent.getStringExtra("INDICATIVO_GRAFICO");
		position = intent.getIntExtra("POSICAO_ESTADO", 0);
		
		Debug.log("GraphLineScreen - captureInformation()", "position value: " + position,
			Debug.INFO);
		Debug.log("GraphLineScreen - captureInformation()",
			"before for interation that fills the history", Debug.DEBUG);
		
		for(int index = 0; index < indicativeList.size(); index++) {
			history.add(Float.parseFloat(indicativeList.get(index)));
		}
		
		Debug.log("GraphLineScreen - captureInformation()",
				"after for interation that fills the history", Debug.DEBUG);
		
		try {
			informations = StateController.getInstance(this).readFullState(position);
		} catch(IOException e) {
			Debug.log("GraphLineScreen - captureInformation()",
				"Error trying to read state informations", Debug.ERROR);
			
			e.printStackTrace();
		}
	}

	// Change the activity to AboutGraphScreen activity.
	public void openAboutScreen() {
		Debug.log("GraphLineScreen - openAboutScreen()", "opening about screen", Debug.DEBUG);
		
		Intent intent = new Intent(this, ChartAboutScreen.class);
    	startActivity(intent);
	}

	// Assigns the class variables with the fields on the screen.
	private void initializeTextFields() {
		Debug.log("GraphLineScreen - initializeTextFields()", "initializing text fields",
			Debug.DEBUG);
		
		textViewGraphTitle = (TextView) findViewById(R.id.text_view_titulo_grafico_historico);
		textViewHistory = (TextView) findViewById(R.id.text_view_grafico_historico);
	}

	// Fills the screen fields with the information received.
	private void fillTextFields() {
		textViewGraphTitle.setText(title);
		Debug.log("GraohLineScreen - fillTextFields", "fulfilling text fields", Debug.DEBUG);
		Debug.log("GraphLineScreen - fillTextFields", "indicative value:" + indicative, Debug.INFO);
		
		textViewHistory.setText(informations.get(indicative));
	}

	// Draw the chart on the screen.
	private void generateGraph() {
		Line curve = new Line();
		
		Debug.log("GraphLineScreen - generateGraph()", "Generating chart", Debug.DEBUG);
		Debug.log("GraphLineScreen - generateGraph()", "before for interation", Debug.DEBUG);
		
		for(int index = 0, graphInterval = 10; index < history.size(); index++,
				graphInterval += 10) {
			LinePoint point = new LinePoint();
			point.setX(graphInterval);
			point.setY(history.get(index));

			curve.addPoint(point);
		}
		
		Debug.log("GraphLineScreen - generateGraph()", "after for interation", Debug.DEBUG);
		
		curve.setColor(Color.parseColor("#4682B4"));
		LineGraph lineGraph = (LineGraph) findViewById(R.id.graph);
		lineGraph.addLine(curve);

		float yLimit = 0;
		yLimit = calculatesHistoryMaxValue(yLimit);
		
		Debug.log("GraphLineScreen - generateGraph()", "yLimit value: " + yLimit, Debug.INFO);
		
		lineGraph.setRangeY(0, yLimit);
		lineGraph.setLineToFill(0);
	}

	// Calculate historical maximum value.
	private float calculatesHistoryMaxValue(float maximum) {
		Debug.log("GraphLineScreen - calculatesHistoryMaxValue()", "Calculating history max value",
			Debug.DEBUG);
		Debug.log("GraphLineScreen - calculatesHistoryMaxValue()", "before for interation",
			Debug.DEBUG);
		
		for(int i = 0; i < history.size(); i++) {
			if(history.get(i) >= maximum) {
				Debug.log("GraphLineScreen - calculatesHistoryMaxValue()",
						"entered in if: " + maximum, Debug.DEBUG);
				maximum = (float) history.get(i);
				Debug.log("GraphLineScreen - calculatesHistoryMaxValue()",
					"new maximum value: " + maximum, Debug.INFO);
			}
			else {
				Debug.log("GraphLineScreen - calculatesHistoryMaxValue()",
						"entered in else: " + maximum, Debug.DEBUG);
			}
		}
		
		Debug.log("GraphLineScreen - calculatesHistoryMaxValue()", "after for interation",
				Debug.DEBUG);
		
		return (float) (1.1 * maximum);
	}
}
