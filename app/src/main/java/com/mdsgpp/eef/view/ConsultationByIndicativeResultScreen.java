package com.mdsgpp.eef.view;


import com.mdsgpp.eef.R;
import com.mdsgpp.eef.view.IndicativeAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class ConsultationByIndicativeResultScreen extends Activity {
	private final Context context = this;
	private ListView statesList = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_resultado_consulta_por_indicativo);
		startViews();
		
		loadIndicativesOfStates();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(
				R.menu.menu_telas, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.sobre:
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
	
	// Change the activity to AboutResultOfConsultationScreen activity.
	public void openAboutScreen() {
		Intent intent = new Intent(this, AboutResultOfConsultationScreen.class);
    	startActivity(intent);
		
	}
	
	// Takes the indicatives information from the previous activity to that.
	private void loadIndicativesOfStates() {
		Intent intent = getIntent();
			
		String indicative = intent.getStringExtra("INDICATIVO");
		String title = intent.getStringExtra("TITULO");
			
		IndicativeAdapter adapter = new IndicativeAdapter(title, indicative, context);
			
		statesList.setAdapter(adapter);
	}
	
	/*
	 * Assigns the class variable statesList with the ListView on the
	 * screen.
	 */
	public void startViews(){
		statesList = (ListView) 
			findViewById(R.id.listview_tela_resultado_consulta_por_indicativo);
	}
	
	
}
