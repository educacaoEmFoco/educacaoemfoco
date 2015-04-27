/************************************************************************************
 * File: AboutScreen.java
 * 
 * Purpose: Create the screen responsible to show informations about the application.
 ************************************************************************************/

package com.mdsgpp.eef.view;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

public class AboutScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_sobre);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_telas_sem_sobre, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
			case android.R.id.home:
		        NavUtils.navigateUpFromSameTask(this);
		        break;
			default:
				break;
		}

    	return true;
	}
}
