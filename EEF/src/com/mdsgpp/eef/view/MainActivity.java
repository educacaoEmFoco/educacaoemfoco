package com.mdsgpp.eef.view;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.debug.Debug;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_telas, menu);
        
        return true;
    }	
        
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {    	
		switch(item.getItemId()) {
    		case R.id.sobre:
    			Debug.log("MainActivity - onOptionsItemSelected()", "Menu item clicked detected", 
    				Debug.DEBUG);
    			openAboutScreen();
    			break;
    		default:
    			break;
		}
		
    	return true;
    }
    
    // Open the screen about.
    public void openAboutScreen() {
    	Debug.log("MainActivity - openAboutScreen()", "opening AboutScreen", Debug.DEBUG);
    	
    	Intent intent = new Intent(this, AboutScreen.class);
    	startActivity(intent);
    }

    // Implements the action on button general comparison.
    public void clickGeneralComparisonButton(View view) {
    	Debug.log("MainActivity - clickGeneralComparisonButton()",
    		"click detected in General Comparison Button!", Debug.INFO);
    	Intent intent = new Intent(this, GeneralComparisonsScreen.class);
		startActivity(intent);
    }
    
    // Implements the action on button general consultation.
    public void clickGeneralConsultButton(View view) {
    	Debug.log("MainActivity - clickGeneralConsultButton()",
        		"click detected in General Consult Button!", Debug.INFO);
    	Intent intent = new Intent(this, StateListScreen.class);
    	startActivity(intent);
    }
    
    // Implements the action on button feed.
    public void clickFeedButton(View view) {
    	Debug.log("MainActivity - clickFeedButton()",
        		"click detected in Feed Button!", Debug.INFO);
    	Intent intent = new Intent(this, FeedScreen.class);
    	startActivity(intent);
    }

    // Implements the action on button consultation by indicative.
    public void clickConsultByIndicativeButton(View view) {
    	Debug.log("MainActivity - clickConsultByIndicativeButton()",
        		"click detected in Consult by Indicative Button!", Debug.INFO);
    	Intent intent = new Intent(this, ConsultationByIndicativeScreen.class);
    	startActivity(intent);
    }
}