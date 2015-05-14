package com.mdsgpp.eef.view;

import com.mdsgpp.eef.R;

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
    			openAboutScreen();
    			break;
    		default:
    			break;
		}
		
    	return true;
    }
    
    // Open the screen about.
    public void openAboutScreen() {
    	Intent intent = new Intent(this, AboutScreen.class);
    	startActivity(intent);
    }

    // Implements the action on button general comparison.
    public void clickGeneralComparisonButton(View view) {
    	Intent intent = new Intent(this, GeneralComparisonsScreen.class);
		startActivity(intent);
    }
    
    // Implements the action on button general consultation.
    public void clickGeneralConsultButton(View view) {
    	Intent intent = new Intent(this, StateListScreen.class);
    	startActivity(intent);
    }
    
    // Implements the action on button feed.
    public void clickFeedButton(View view) {
    	Intent intent = new Intent(this, FeedScreen.class);
    	startActivity(intent);
    }

    // Implements the action on button consultation by indicative.
    public void clickConsultByIndicativeButton(View view) {
    	Intent intent = new Intent(this, ConsultationByIndicativeScreen.class);
    	startActivity(intent);
    }
}