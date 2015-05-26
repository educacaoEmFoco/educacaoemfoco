/*******************************************************
 * File: GeneralComparisonsScreen.java
 *
 * Purpose: Handle what type of comparison will be done.
 *******************************************************/

package com.mdsgpp.eef.view;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.debug.Debug;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class GeneralComparisonsScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_comparacoes_gerais);
	}

	// If the actionbar is present adds options buttons to it.
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Debug.log("GeneralComparisonsScreen - onCreateOptionsMenu", 
			"adding buttons to the action bar", Debug.INFO);

		getMenuInflater().inflate(R.menu.menu_telas, menu);

		return true;
	}
	
    public boolean onOptionsItemSelected(MenuItem item) {
    	Debug.log("GeneralComparisonsScreen - onOptionsItemSelected", "item selected in action bar",
    		Debug.INFO);

		switch(item.getItemId()) {
			case R.id.sobre:
				Debug.log("GeneralComparisonsScreen - onOptionsItemSelected", 
					"About Button clicked, openning about screen", Debug.INFO);

				opensAboutScreen();
				break;
			case android.R.id.home:
				Debug.log("GeneralComparisonsScreen - onOptionsItemSelected",
					"Home Button clicked, going back to previous activity", Debug.DEBUG);

		        NavUtils.navigateUpFromSameTask(this);
		        break;
			default:
				// Do nothing.
				break;
		}
		
    	return true;
    }
    
    // Open screen about.
    public void opensAboutScreen() {
    	Debug.log("GeneralComparisonsScreen - opensAboutScreen", "openning about screen", 
    		Debug.DEBUG);

    	Intent intent = new Intent(this, GeneralComparisonAboutScreen.class);
    	startActivity(intent);
    }
	
	// Implements action on button compararison.
	public void clickButtonComparison(View view) {
		Debug.log("GeneralComparisonsScreen - clickButtonComparison", "openning comparison screen", 
    		Debug.DEBUG);

		Intent intent = new Intent(this, ComparisonScreen.class);
		startActivity(intent);
	}
	
	// Implements action on button indicatives.
	public void clickButtonIndicatives(View view) {
		Debug.log("GeneralComparisonsScreen - clickButtonIndicatives", "openning indicative screen", 
    		Debug.DEBUG);

		Intent intent = new Intent(this, ConsultationByIndicativeResultScreen.class);
		startActivity(intent);
	}	
}