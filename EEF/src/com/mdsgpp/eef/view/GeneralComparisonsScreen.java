package com.mdsgpp.eef.view;

import com.mdsgpp.eef.R;

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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_telas, menu);
		return true;
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
				// Do nothing.
				break;
		}
		
    	return true;
    }
    
    // Open screen about.
    public void opensAboutScreen() {
    	Intent intent = new Intent(this, GeneralComparisonAboutScreen.class);
    	startActivity(intent);
    }
	
	// Implements action on button compararison.
	public void clickButtonComparison(View view) {
		Intent intent = new Intent(this, ComparisonScreen.class);
		startActivity(intent);
	}
	
	// Implements action on button indicatives.
	public void clickButtonIndicatives(View view) {
		Intent intent = new Intent(this, ConsultationByIndicativeResultScreen.class);
		startActivity(intent);
	}	
}