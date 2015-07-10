/******************************************************************************
= * File: ComparisonScreen.java
 * 
 * Purpose: Screen where the user will choose the states that will be compared.
 ******************************************************************************/

package com.mdsgpp.eef.view;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.debug.Debug;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;

public class ComparisonScreen extends Comparison {

	@Override
	public void clickButtonStatesComparison(View view) {
		Debug.log("ComparisonScreen - clickButtonStatesComparison()",
			"States Comparison button clicked!", Debug.INFO);
		
		Intent intent = new Intent(this, ConsultedIndicativesScreen.class);
		getStatesSpinner01().getSelectedItem().toString();
		getStatesSpinner().getSelectedItem().toString();

		int position1 = getAllStates().indexOf
			(getStatesSpinner01().getSelectedItem().toString());
		int position2 = getAllStates().indexOf
			(getStatesSpinner().getSelectedItem().toString());
		
		Debug.log("ComparisonScreen - clickButtonStatesComparison()", "position1: " + position1,
			Debug.INFO);
		Debug.log("ComparisonScreen - clickButtonStatesComparison()", "position2: " + position2,
				Debug.INFO);
		
		intent.putExtra("INDEX_ESTADO1_ESCOLHIDO", position1);
		intent.putExtra("INDEX_ESTADO2_ESCOLHIDO", position2);

		startActivity(intent);
	}
	
    public boolean onOptionsItemSelected(MenuItem item) {    	
		switch(item.getItemId()) {
			case R.id.sobre:
				opensAboutScreen();
				break;
			case android.R.id.home:
		        NavUtils.navigateUpFromSameTask(this);
		        break;
			default:
				break;
		}
		
    	return true;
    }
    
    // Open screen about.
    public void opensAboutScreen() {
    	Debug.log("ComparisonScrenn - opensAboutScreen()", "opening ComparisonAboutScreen",
    		Debug.DEBUG);
    	
    	Intent intent = new Intent(this, ComparisonAboutScreen.class);
    	startActivity(intent);
    }
	
}