package com.mdsgpp.eef.view;

import com.mdsgpp.eef.R;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;

public class ComparisonScreen extends Comparison {

	@Override
	public void clickButtonComparisonStates(View view) {
		Intent intent = new Intent(this, TelaIndicativosConsultados.class);
		getStatesSpinner01().getSelectedItem().toString();
		getStatesSpinner().getSelectedItem().toString();

		int position1 = getAllStates().indexOf
			(getStatesSpinner01().getSelectedItem().toString());
		int position2 = getAllStates().indexOf
			(getStatesSpinner().getSelectedItem().toString());

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
    	Intent intent = new Intent(this, TelaSobreComparacao.class);
    	startActivity(intent);
    }
	
	// Implements action on button about compararison.
	public void clickButtonAboutComparison(View view) {
    	Intent intent = new Intent(this, TelaSobreComparacao.class);
    	startActivity(intent);
    }
}
