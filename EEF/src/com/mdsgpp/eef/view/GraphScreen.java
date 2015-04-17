package com.mdsgpp.eef.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import com.echo.holographlibrary.Bar;
import com.echo.holographlibrary.BarGraph;
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
import android.widget.Toast;

public class GraphScreen extends Activity {

	private int state1;
	private int state2;
	private String title;
	private String indicative;
	private TextView graphTitle;
	private float stateIndicativeValue1;
	private float stateIndicativeValue2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_grafico);
		
		capturesInformations();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_telas, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {		
		switch(item.getItemId()) {
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
	
	// This method start the intent that leads to the ChartAboutScreen screen.
	public void opensAboutScreen() {
		Intent intent = new Intent(this, ChartAboutScreen.class);
    	startActivity(intent);
	}
	
	// This method takes the information from the previous Activity.
	@SuppressWarnings({"unchecked"})
	private void capturesInformations() {
		initializesTextFields();
		
		Intent intent = getIntent();

		state1 = intent.getIntExtra("INDEX_ESTADO1_ESCOLHIDO", 0);
		state2 = intent.getIntExtra("INDEX_ESTADO2_ESCOLHIDO", 0);
		title = intent.getStringExtra("TITULO");
		indicative = intent.getStringExtra("INDICATIVO");

		HashMap<String, String> state1Informations = new HashMap<String, String>();
		HashMap<String, String> state2Informations = new HashMap<String, String>();

		try {
			state1Informations = (HashMap<String, String>) 
				StateController.getInstance(this).readState(estado1).clone();
			state2Informations = (HashMap<String, String>) 
				StateController.getInstance(this).readState(estado2).clone();
			
			convertData(state1Informations, state2Informations);
			generatesGraph(state1Informations, state2Informations);
			
		} catch(IOException e) {
			Toast.makeText(getApplicationContext(), "Houve um erro no acesso às informações.",
				Toast.LENGTH_SHORT).show();
			Log.i("IOException - TelaComparaEstados",e.toString());
		}
	}
	
	// This method generates the chart.
	private void generatesGraph(HashMap<String, String> state1Informations,
		HashMap<String, String> state2Informations) {
		
        Bar state1Bar = new Bar();
        state1Bar.setColor(Color.parseColor("#4682B4"));
        state1Bar.setName(state1Informations.get("nome"));
		state1Bar.setValue(stateIndicativeValue1);
        
        Bar state2Bar = new Bar();       
        state2Bar.setColor(Color.parseColor("#191970"));
        state2Bar.setName(state2Informations.get("nome"));
        state2Bar.setValue(stateIndicativeValue2); 

		ArrayList<Bar> bars = new ArrayList<Bar>();     
        bars.add(state1Bar);
        bars.add(state2Bar);

        graphTitle.setText(title);
        
        BarGraph graph = (BarGraph)findViewById(R.id.graph); 
        
        graph.setBars(bars);
	}
	
	// This method converts the data.
	private void convertData(HashMap<String, String> state1Informations,
			HashMap<String, String> state2Informations) {
		
		String state1IndicativeString = state1Informations.get(indicative);
		String state2IndicativeString = state2Informations.get(indicative);
	
				
		state1IndicativeString = state1IndicativeString.replaceAll("[^\\d,]", "");																	 
		state2IndicativeString = state2IndicativeString.replaceAll("[^\\d,]", "");
		
		state1IndicativeString = state1IndicativeString.replaceAll(",", ".");
		state2IndicativeString = state2IndicativeString.replaceAll(",", ".");
		
		stateIndicativeValue1 = Float.parseFloat(state1IndicativeString);
		stateIndicativeValue2 = Float.parseFloat(state2IndicativeString);
	}
	
	// This method starts the TextView graphTitle.
	private void initializesTextFields() {
		graphTitle = (TextView) findViewById(R.id.text_view_titulo_grafico);		
	}
}
